package com.example.clinica_app;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Classe central que gerencia toda a lógica de negócio do sistema de agendamento.
 * É responsável por armazenar e manipular os dados de pacientes, médicos e consultas.
 * Todas as operações como registrar, agendar e cancelar são orquestradas por esta classe.
 */
public class SistemaAgendamento {
    private final Map<String, Paciente> pacientes = new HashMap<>();
    private final Map<String, Medico> medicos = new HashMap<>();
    private final Map<String, TreeMap<LocalDateTime, Consulta>> agendas = new HashMap<>();

    /**
     * Verifica se um ID corresponde a um paciente cadastrado.
     * @param id O ID a ser verificado.
     * @return true se o paciente existe, false caso contrário.
     */
    public boolean isPaciente(String id) {
        return pacientes.containsKey(id);
    }

    /**
     * Verifica se um ID corresponde a um médico cadastrado.
     * @param id O ID a ser verificado.
     * @return true se o médico existe, false caso contrário.
     */
    public boolean isMedico(String id) {
        return medicos.containsKey(id);
    }

    /**
     * Registra um novo paciente no sistema.
     * @param paciente O objeto Paciente a ser adicionado.
     */
    public void registrarPaciente(Paciente paciente) {
        pacientes.put(paciente.getIdPaciente(), paciente);
    }

    /**
     * Registra um novo médico no sistema e cria uma agenda vazia para ele.
     * @param medico O objeto Medico a ser adicionado.
     */
    public void registrarMedico(Medico medico) {
        medicos.put(medico.getIdMedico(), medico);
        agendas.put(medico.getIdMedico(), new TreeMap<>());
    }

    /**
     * Cadastra um período de disponibilidade na agenda de um médico.
     * @param idMedico O ID do médico.
     * @param inicio A data e hora de início da disponibilidade.
     * @param fim A data e hora de fim da disponibilidade.
     * @throws IllegalArgumentException se o médico não for encontrado.
     * @throws IllegalStateException se o horário já estiver cadastrado.
     */
    public void cadastrarDisponibilidade(String idMedico, LocalDateTime inicio, LocalDateTime fim) {
        Medico medico = medicos.get(idMedico);
        if (medico == null) throw new IllegalArgumentException("Médico não encontrado.");
        TreeMap<LocalDateTime, Consulta> agenda = agendas.get(idMedico);
        if (agenda.containsKey(inicio)) throw new IllegalStateException("Horário já cadastrado");

        Consulta disponibilidade = new Consulta(UUID.randomUUID().toString(), medico, inicio, fim);
        agenda.put(inicio, disponibilidade);
    }

    /**
     * Agenda uma consulta para um paciente em um horário previamente disponível.
     * @param idPaciente O ID do paciente.
     * @param idMedico O ID do médico.
     * @param inicio A data e hora de início da consulta.
     * @param fim A data e hora de fim da consulta (usado para identificar a consulta).
     * @throws IllegalArgumentException se o paciente não for encontrado.
     * @throws IllegalStateException se o horário não estiver disponível.
     */
    public void agendarConsulta(String idPaciente, String idMedico, LocalDateTime inicio, LocalDateTime fim) {
        Paciente paciente = pacientes.get(idPaciente);
        if (paciente == null) throw new IllegalArgumentException("Paciente não encontrado.");
        TreeMap<LocalDateTime, Consulta> agenda = agendas.get(idMedico);
        Consulta consulta = agenda.get(inicio);

        if (consulta == null || !"DISPONIVEL".equals(consulta.getStatus()))
            throw new IllegalStateException("Horário não disponível para agendamento");

        consulta.setPaciente(paciente);
        consulta.setStatus("AGENDADA");
        paciente.adicionarConsultaAoHistorico(consulta);
    }

    /**
     * Cancela uma consulta pelo paciente. A consulta volta a ser um horário disponível.
     * @param consulta A consulta a ser cancelada.
     * @throws IllegalArgumentException se a consulta ou o médico forem nulos.
     */
    public void cancelarConsultaPorPaciente(Consulta consulta) {
        if (consulta == null || consulta.getMedico() == null) {
            throw new IllegalArgumentException("Consulta ou médico inválido.");
        }
        if (consulta.getPaciente() != null) {
            consulta.getPaciente().removerConsultaDoHistorico(consulta.getIdConsulta());
        }
        consulta.setStatus("DISPONIVEL");
        consulta.setPaciente(null);
    }

    /**
     * Cancela uma consulta ou disponibilidade pelo médico.
     * Se for uma consulta agendada, seu status é alterado para "CANCELADA".
     * Se for apenas uma disponibilidade, ela é removida da agenda.
     * @param idMedico O ID do médico que está cancelando.
     * @param idConsulta O ID da consulta/disponibilidade a ser cancelada.
     * @return true se o cancelamento foi bem-sucedido, false caso contrário.
     */
    public boolean cancelarConsultaPorMedico(String idMedico, String idConsulta) {
        TreeMap<LocalDateTime, Consulta> agenda = agendas.get(idMedico);
        if (agenda == null) return false;

        Optional<Consulta> consultaOpt = agenda.values().stream()
                .filter(c -> c.getIdConsulta().equals(idConsulta))
                .findFirst();

        if (consultaOpt.isPresent()) {
            Consulta consulta = consultaOpt.get();
            if (consulta.getPaciente() != null) {
                consulta.setStatus("CANCELADA");
            } else {
                agenda.remove(consulta.getDataHoraInicio());
            }
            return true;
        }
        return false;
    }

    /**
     * Retorna uma lista com todos os médicos cadastrados no sistema.
     * @return Uma lista de objetos Medico.
     */
    public List<Medico> getTodosMedicos() {
        return new ArrayList<>(medicos.values());
    }

    /**
     * Retorna todas as consultas associadas a um paciente específico.
     * @param idPaciente O ID do paciente.
     * @return Uma lista de objetos Consulta.
     */
    public List<Consulta> getConsultasPaciente(String idPaciente) {
        Paciente paciente = pacientes.get(idPaciente);
        if (paciente == null) return Collections.emptyList();
        return new ArrayList<>(paciente.getHistorico());
    }

    /**
     * Retorna todas as consultas e disponibilidades da agenda de um médico específico.
     * @param idMedico O ID do médico.
     * @return Uma lista de objetos Consulta.
     */
    public List<Consulta> getConsultas(String idMedico) {
        TreeMap<LocalDateTime, Consulta> agenda = agendas.get(idMedico);
        if (agenda == null) return Collections.emptyList();
        return new ArrayList<>(agenda.values());
    }

    /**
     * Retorna uma lista de todas as consultas com status "DISPONIVEL" de todos os médicos.
     * @return Uma lista de objetos Consulta que representam horários vagos.
     */
    public List<Consulta> getTodasConsultasDisponiveis() {
        return agendas.values().stream()
                .flatMap(agenda -> agenda.values().stream())
                .filter(consulta -> "DISPONIVEL".equals(consulta.getStatus()))
                .collect(Collectors.toList());
    }
}