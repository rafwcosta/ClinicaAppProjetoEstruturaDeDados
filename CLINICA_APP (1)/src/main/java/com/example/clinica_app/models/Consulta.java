package models;
package com.example.clinica_app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa uma consulta médica ou um horário de disponibilidade na agenda.
 * A classe armazena informações como o médico, o paciente (se agendada),
 * horários de início e fim, status, e outras informações relevantes como
 * motivo de cancelamento.
 */
public class Consulta {
    private String idConsulta;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status;
    private String notasMedico;
    private String motivoCancelamento;

    /**
     * Construtor para uma consulta já agendada, que inclui um paciente.
     * O status inicial é definido como "AGENDADA".
     *
     * @param idConsulta     Identificador único da consulta.
     * @param paciente       O objeto Paciente associado à consulta.
     * @param medico         O objeto Medico que realizará a consulta.
     * @param dataHoraInicio A data e hora de início da consulta.
     * @param dataHoraFim    A data e hora de término da consulta.
     */
    public Consulta(String idConsulta, Paciente paciente, Medico medico,
                    LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = "AGENDADA";
    }

    /**
     * Construtor para um horário de disponibilidade de um médico, sem paciente associado.
     * O status inicial é definido como "DISPONIVEL".
     *
     * @param idConsulta     Identificador único da disponibilidade.
     * @param medico         O objeto Medico ao qual a disponibilidade pertence.
     * @param dataHoraInicio A data e hora de início da disponibilidade.
     * @param dataHoraFim    A data e hora de término da disponibilidade.
     */
    public Consulta(String idConsulta, Medico medico,
                    LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.idConsulta = idConsulta;
        this.medico = medico;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = "DISPONIVEL";
    }

    //<editor-fold desc="Getters e Setters">

    /**
     * @return O ID único da consulta.
     */
    public String getIdConsulta() { return idConsulta; }

    /**
     * @return O paciente associado à consulta, ou null se for uma disponibilidade.
     */
    public Paciente getPaciente() { return paciente; }

    /**
     * @return O médico associado à consulta.
     */
    public Medico getMedico() { return medico; }

    /**
     * @return A data e hora de início da consulta.
     */
    public LocalDateTime getDataHoraInicio() { return dataHoraInicio; }

    /**
     * @return A data e hora de fim da consulta.
     */
    public LocalDateTime getDataHoraFim() {return dataHoraFim;}

    /**
     * @return O status atual da consulta (ex: "AGENDADA", "DISPONIVEL", "CANCELADA").
     */
    public String getStatus() { return status; }

    /**
     * @return O motivo do cancelamento, ou null se não aplicável.
     */
    public String getMotivoCancelamento() { return motivoCancelamento; }

    /**
     * Define o paciente para esta consulta, tipicamente ao agendar uma disponibilidade.
     * @param paciente O paciente a ser associado.
     */
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    /**
     * Define o status da consulta.
     * @param status O novo status.
     */
    public void setStatus(String status) { this.status = status; }

    /**
     * Define o motivo pelo qual a consulta foi cancelada.
     * @param motivoCancelamento A justificativa para o cancelamento.
     */
    public void setMotivoCancelamento(String motivoCancelamento) { this.motivoCancelamento = motivoCancelamento; }

    //</editor-fold>

    /**
     * Altera o status da consulta para "CANCELADA".
     * @throws IllegalStateException se a consulta já tiver sido realizada.
     */
    public void cancelar() {
        if (status.equals("REALIZADA")) {
            throw new IllegalStateException("Consulta já realizada");
        }
        status = "CANCELADA";
    }

    /**
     * Retorna uma representação em String do horário da consulta.
     * Formato: "dd/MM/yyyy HH:mm - HH:mm".
     * @return A String formatada representando o intervalo da consulta.
     */
    @Override
    public String toString() {
        return String.format("%s - %s",
            dataHoraInicio.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")),
            dataHoraFim.format(DateTimeFormatter.ofPattern("HH:mm"))
        );
    }
}