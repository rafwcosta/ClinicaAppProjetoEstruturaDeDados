package com.example.clinica_app;

/**
 * Fornece um contexto global para a aplicação.
 * Esta classe armazena dados que precisam ser acessíveis em diferentes partes da aplicação,
 * como a instância única do sistema de agendamento e o ID do usuário atualmente logado.
 * O uso de campos estáticos garante que haja apenas uma instância desses dados em toda a aplicação.
 */
public class AppContext {
    /**
     * Instância única e compartilhada do sistema de agendamento, contendo toda a lógica de negócio.
     * É final para garantir que a mesma instância seja usada durante todo o ciclo de vida da aplicação.
     */
    public static final SistemaAgendamento sistema = new SistemaAgendamento();

    /**
     * Armazena o ID (CPF/CRM) do usuário (paciente ou médico) que está logado no sistema.
     * É nulo se nenhum usuário estiver logado. Este campo é atualizado durante o processo de login.
     */
    public static String usuarioLogadoId = null;
}