package com.example.clinica_app;

/**
 * Representa um médico no sistema.
 * Esta classe armazena as informações básicas de um médico, como ID (CRM),
 * nome e especialidade.
 */
public class Medico {
    private String idMedico;
    private String nome;
    private String especialidade;

    /**
     * Construtor para criar uma nova instância de Medico.
     *
     * @param idMedico      O identificador único do médico (geralmente o CRM).
     * @param nome          O nome completo do médico.
     * @param especialidade A especialidade médica.
     */
    public Medico(String idMedico, String nome, String especialidade) {
        this.idMedico = idMedico;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    /**
     * @return O ID (CRM) do médico.
     */
    public String getIdMedico() { return idMedico; }

    /**
     * @return O nome do médico.
     */
    public String getNome() { return nome; }

    /**
     * @return A especialidade do médico.
     */
    public String getEspecialidade() { return especialidade; }
}