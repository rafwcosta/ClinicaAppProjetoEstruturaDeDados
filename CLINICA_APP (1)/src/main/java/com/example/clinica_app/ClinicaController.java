package com.example.clinica_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Controlador principal da interface gráfica (GUI) da aplicação da clínica.
 * Esta classe gerencia todas as interações do usuário nas diferentes telas,
 * como login, cadastro, agendamento e cancelamento de consultas.
 * Ela atua como a ponte entre a visão (arquivos FXML) e o modelo (SistemaAgendamento).
 */
public class ClinicaController {

    //<editor-fold desc="CAMPOS FXML">
    // --- Campos do Menu Inicial ---
    @FXML private TextField campoNomeUsuario;

    // --- Campos de Cadastro de Paciente ---
    @FXML private TextField campoIdPaciente;
    @FXML private TextField campoNomePaciente;
    @FXML private TextField campoIdadePaciente;
    @FXML private TextField campoContatoPaciente;

    // --- Campos de Cadastro de Médico ---
    @FXML private TextField campoIdMedico;
    @FXML private TextField campoNomeMedico;
    @FXML private TextField campoEspecialidadeMedico;

    // --- Campos de Cadastro de Disponibilidade ---
    @FXML private DatePicker dataDisponibilidade;
    @FXML private TextField horaInicio;
    @FXML private TextField horaFim;
    @FXML private TableView<Consulta> tabelaDisponibilidades;
    @FXML private TableColumn<Consulta, LocalDateTime> colInicio;
    @FXML private TableColumn<Consulta, LocalDateTime> colFim;
    @FXML private TableColumn<Consulta, String> colStatus;

    // --- Campos para a tabela de disponibilidades (agenda) ---
    @FXML private TableView<Consulta> tabelaAgenda;
    @FXML private TableColumn<Consulta, String> colAgendaData;
    @FXML private TableColumn<Consulta, String> colAgendaHora;

    // --- Campos para a tabela de consultas agendadas ---
    @FXML private TableView<Consulta> tabelaConsultas;
    @FXML private TableColumn<Consulta, String> colConsultaData;
    @FXML private TableColumn<Consulta, String> colConsultaHora;
    @FXML private TableColumn<Consulta, String> colConsultaPaciente;
    @FXML private TableColumn<Consulta, String> colConsultaNumero;
    @FXML private TableColumn<Consulta, String> colConsultaStatus;
    @FXML private TextArea motivoCancelamento;

    // --- Campos para a tabela de "Minhas Consultas" ---
    @FXML private TableView<Consulta> tabelaMinhasConsultas;
    @FXML private TableColumn<Consulta, String> colMinhasConsultaData;
    @FXML private TableColumn<Consulta, String> colMinhasConsultaHora;
    @FXML private TableColumn<Consulta, String> colMinhasConsultaStatus;
    @FXML private TableColumn<Consulta, String> colMinhasConsultaMotivo;

    // --- Campos FXML da tela "Agendar Consultas" ---
    @FXML private ComboBox<String> comboEspecialidades;

    // --- Campos FXML genéricos para listas ---
    @FXML private ListView<Consulta> listaDisponibilidades;
    @FXML private ListView<Consulta> listaConsultas;
    @FXML private ListView<Consulta> listaMinhasConsultas;
    @FXML private ListView<Consulta> listaAgenda;
    //</editor-fold>

    /**
     * Referência à instância única do sistema de agendamento, obtida do AppContext.
     */
    private final SistemaAgendamento sistema = AppContext.sistema;


    /**
     * Método de inicialização executado pelo JavaFX após o carregamento do FXML.
     * Configura as colunas das tabelas, listeners de componentes (como ComboBox)
     * e carrega os dados iniciais nas visualizações apropriadas, dependendo da tela
     * que está sendo exibida.
     */
    @FXML
    public void initialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm");

        if (comboEspecialidades != null && listaDisponibilidades != null) {
            // Lógica para a tela "Agendar Consultas"
        }

        if (tabelaMinhasConsultas != null) {
            // Configuração da tabela de "Minhas Consultas" do paciente
        }

        if (tabelaAgenda != null) {
            // Configuração da tabela de agenda do médico
        }

        if (tabelaConsultas != null) {
            // Configuração da tabela de consultas agendadas do médico
        }

        if (listaMinhasConsultas != null) {
            atualizarListaMinhasConsultas();
        }

        if (tabelaDisponibilidades != null) {
            // Configuração da tabela de disponibilidades do médico
        }
    }

    /**
     * Verifica o ID de usuário inserido na tela de login.
     * Se o ID pertencer a um paciente ou médico, redireciona para a tela correspondente.
     * Caso contrário, exibe um alerta de erro.
     * @param event O evento de ação que acionou o método (clique no botão).
     */
    @FXML
    private void verificarUsuarioEAvancar(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Abre a tela de cadastro de paciente.
     */
    @FXML
    private void onCadastrarPacienteButton() {
        abrirTela("/view/cadastro-paciente.fxml", "Cadastro de Paciente");
    }

    /**
     * Abre a tela de cadastro de médico.
     */
    @FXML
    private void onCadastrarMedicoButton() {
        abrirTela("/view/cadastro-medico.fxml", "Cadastro de Médico");
    }

    /**
     * Navega para o menu de cadastro (onde o usuário escolhe entre cadastrar paciente ou médico).
     * Fecha a tela de login atual.
     */
    @FXML
    private void irparaCadastro() {
        // Implementação do método
    }

    /**
     * Abre a tela para o paciente agendar uma nova consulta.
     * @param event O evento de ação que acionou o método.
     */
    @FXML
    public void abrirTelaAgendarConsulta(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Abre a tela para o paciente visualizar suas consultas agendadas e canceladas.
     * @param event O evento de ação que acionou o método.
     */
    @FXML
    public void abrirTelaMinhasConsultas(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Processa o formulário de cadastro de um novo paciente, valida os dados e,
     * se válidos, registra o paciente no sistema.
     */
    @FXML
    protected void onCadastrarPaciente() {
        // Implementação do método
    }

    /**
     * Processa o formulário de cadastro de um novo médico, valida os dados e,
     * se válidos, registra o médico no sistema.
     */
    @FXML
    protected void onCadastrarMedico() {
        // Implementação do método
    }
    
    /**
     * Cadastra uma nova disponibilidade (horário vago) para o médico logado.
     * Valida e converte as datas e horas inseridas.
     * @param actionEvent O evento de ação que acionou o método.
     */
    @FXML
    public void onCadastrarDisponibilidade(ActionEvent actionEvent) {
        // Implementação do método
    }
    
    /**
     * Cancela uma disponibilidade selecionada pelo médico na sua agenda.
     * A disponibilidade é removida do sistema.
     * @param actionEvent O evento de ação que acionou o método.
     */
    @FXML
    public void onCancelarDisponibilidade(ActionEvent actionEvent) {
        // Implementação do método
    }

    /**
     * Permite que um paciente agende uma consulta selecionando um horário disponível.
     * A disponibilidade selecionada é convertida em uma consulta agendada.
     * @param actionEvent O evento de ação que acionou o método.
     */
    @FXML
    public void onAgendarConsultaPaciente(ActionEvent actionEvent) {
        // Implementação do método
    }
    
    /**
     * Permite que um médico cancele uma consulta previamente agendada por um paciente.
     * Exige um motivo para o cancelamento.
     * @param event O evento de ação que acionou o método.
     */
    @FXML
    public void onCancelarConsulta(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Permite que um paciente cancele uma de suas consultas agendadas.
     * O horário da consulta volta a ficar disponível.
     * @param event O evento de ação que acionou o método.
     */
    @FXML
    public void onCancelarConsultaMinhasConsultas(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Remove uma consulta com status "CANCELADA" do histórico de visualização do paciente.
     * @param event O evento de ação que acionou o método.
     */
    @FXML
    public void onRemoverConsultaMinhasConsultas(ActionEvent event) {
        // Implementação do método
    }

    /**
     * Retorna o usuário para a tela inicial (login).
     * @param actionEvent O evento de ação que acionou o método.
     */
    @FXML
    public void onVoltarTelaInicial(ActionEvent actionEvent) {
        abrirTela("/view/menu-inicial.fxml", "Menu Inicial");
        Stage stageAtual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stageAtual.close();
    }

    /**
     * Retorna o usuário para a tela principal do paciente.
     * @param actionEvent O evento de ação que acionou o método.
     */
    @FXML
    public void onVoltarTelaPaciente(ActionEvent actionEvent) {
        abrirTela("/view/tela-paciente.fxml", "Tela Paciente");
        Stage stageAtual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stageAtual.close();
    }

    //<editor-fold desc="MÉTODOS AUXILIARES">
    /**
     * Abre uma nova janela (Stage) com base em um arquivo FXML.
     * @param caminhoFXML O caminho para o arquivo .fxml a ser carregado.
     * @param titulo O título a ser exibido na barra da janela.
     */
    private void abrirTela(String caminhoFXML, String titulo) {
        // Implementação do método
    }

    /**
     * Exibe uma caixa de diálogo de alerta para o usuário.
     * @param tipo O tipo de alerta (ex: INFORMATION, WARNING, ERROR).
     * @param msg A mensagem a ser exibida no alerta.
     */
    private void mostrarAlerta(Alert.AlertType tipo, String msg) {
        // Implementação do método
    }

    /**
     * Atualiza a tabela de agenda de disponibilidades do médico.
     * @param idMedico O ID do médico cuja agenda deve ser atualizada.
     */
    private void atualizarTabelaAgenda(String idMedico) {
        // Implementação do método
    }
    
    /**
     * Atualiza a tabela de consultas agendadas para o médico logado.
     * @param idMedico O ID do médico cujas consultas devem ser exibidas.
     */
    private void atualizarTabelaConsultasMedico(String idMedico) {
        // Implementação do método
    }
    
    /**
     * Atualiza a lista de horários disponíveis, filtrando por uma especialidade médica.
     * @param especialidade A especialidade selecionada para filtrar as disponibilidades.
     */
    private void atualizarListaDisponibilidadesPorEspecialidade(String especialidade) {
        // Implementação do método
    }

    /**
     * Atualiza a lista de "Minhas Consultas" para o paciente logado.
     */
    private void atualizarListaMinhasConsultas() {
        // Implementação do método
    }
    //</editor-fold>
}