package com.example.clinica_app;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um paciente no sistema.
 * Esta classe armazena as informações básicas de um paciente, como ID (CPF),
 * nome, idade, contato e um histórico de suas consultas.
 */
public class Paciente {
    private String idPaciente;
    private String nome;
    private int idade;
    private String contato;
    private List<Consulta> historicoConsultas;

    /**
     * Construtor para criar uma nova instância de Paciente.
     *
     * @param idPaciente O identificador único do paciente (geralmente o CPF).
     * @param nome       O nome completo do paciente.
     * @param idade      A idade do paciente.
     * @param contato    O número de contato do paciente (telefone).
     */
    public Paciente(String idPaciente, String nome, int idade, String contato) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.idade = idade;
        this.contato = contato;
        this.historicoConsultas = new ArrayList<>();
    }

    /**
     * @return O ID (CPF) do paciente.
     */
    public String getIdPaciente() {
        return idPaciente;
    }

    /**
     * @return O nome do paciente.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * @return O número de contato do paciente.
     */
    public String getContato() {
        return this.contato;
    }

    /**
     * @return Uma lista de todas as consultas no histórico do paciente.
     */
    public List<Consulta> getHistorico() {
        return historicoConsultas;
    }

    /**
     * Adiciona uma consulta ao histórico do paciente.
     *
     * @param consulta A consulta a ser adicionada.
     */
    public void adicionarConsultaAoHistorico(Consulta consulta) {
        historicoConsultas.add(consulta);
    }

    /**
     * Remove uma consulta do histórico do paciente com base no ID da consulta.
     *
     * @param idConsulta O ID da consulta a ser removida.
     */
    public void removerConsultaDoHistorico(String idConsulta) {
        historicoConsultas.removeIf(c -> c.getIdConsulta().equals(idConsulta));
    }
}