<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Documentação Completa - Clínica App</title>
    <style>
        body {
            font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            line-height: 1.6;
            background-color: #f4f4f9;
            color: #333;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
        }
        h1, h2, h3 {
            color: #0056b3;
            border-bottom: 2px solid #eef;
            padding-bottom: 10px;
            margin-top: 40px;
        }
        h1 { font-size: 2.5em; text-align: center; }
        h2 { font-size: 2em; }
        h3 { font-size: 1.5em; border-bottom: 1px solid #f0f0f0; }
        h4 { font-size: 1.2em; color: #333; }
        .class-doc { margin-bottom: 50px; }
        .method-block {
            background-color: #f9f9f9;
            border: 1px solid #e7e7e7;
            border-left: 5px solid #0056b3;
            padding: 20px;
            margin-top: 20px;
            border-radius: 5px;
        }
        code {
            background-color: #eef2fa;
            color: #3d3d3d;
            padding: 3px 6px;
            border-radius: 4px;
            font-family: "SFMono-Regular", Consolas, "Liberation Mono", Menlo, monospace;
            font-size: 0.95em;
        }
        .param-return strong { color: #d9534f; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Documentação Completa do Projeto: Clínica App</h1>
        <section class="class-doc" id="MainApp">
            <h2>Classe: <code>com.example.clinica_app.MainApp</code></h2>
            <p>Classe principal que inicia a aplicação JavaFX. É o ponto de entrada do programa.</p>
            <h3>Métodos</h3>
            <div class="method-block">
                <h4><code>public void start(Stage stage)</code></h4>
                <p>O método principal de entrada para aplicações JavaFX. Carrega a tela inicial.</p>
                <div class="param-return">
                    <p><strong>@param</strong> <code>stage</code>: O stage principal (janela) para esta aplicação.</p>
                    <p><strong>@throws</strong> <code>Exception</code>: se o arquivo FXML não puder ser carregado.</p>
                </div>
            </div>
            <div class="method-block">
                <h4><code>public static void main(String[] args)</code></h4>
                <p>O ponto de entrada principal do programa.</p>
                <div class="param-return"><p><strong>@param</strong> <code>args</code>: Argumentos de linha de comando.</p></div>
            </div>
        </section>
        <section class="class-doc" id="AppContext">
            <h2>Classe: <code>com.example.clinica_app.AppContext</code></h2>
            <p>Fornece um contexto global para a aplicação, armazenando dados compartilhados.</p>
            <h3>Campos Estáticos</h3>
            <div class="method-block">
                <h4><code>public static final SistemaAgendamento sistema</code></h4>
                <p>Instância única do sistema de agendamento, contendo toda a lógica de negócio.</p>
            </div>
            <div class="method-block">
                <h4><code>public static String usuarioLogadoId</code></h4>
                <p>Armazena o ID do usuário que está logado no sistema.</p>
            </div>
        </section>
        <section class="class-doc" id="SistemaAgendamento">
            <h2>Classe: <code>com.example.clinica_app.SistemaAgendamento</code></h2>
            <p>Classe central que gerencia toda a lógica de negócio do sistema de agendamento.</p>
            <h3>Métodos</h3>
            <div class="method-block"><h4><code>public boolean isPaciente(String id)</code></h4><p>Verifica se um ID corresponde a um paciente cadastrado.</p><div class="param-return"><p><strong>@return</strong> <code>true</code> se o paciente existe.</p></div></div>
            <div class="method-block"><h4><code>public boolean isMedico(String id)</code></h4><p>Verifica se um ID corresponde a um médico cadastrado.</p><div class="param-return"><p><strong>@return</strong> <code>true</code> se o médico existe.</p></div></div>
            <div class="method-block"><h4><code>public void registrarPaciente(Paciente paciente)</code></h4><p>Registra um novo paciente no sistema.</p></div>
            <div class="method-block"><h4><code>public void registrarMedico(Medico medico)</code></h4><p>Registra um novo médico no sistema e cria uma agenda vazia para ele.</p></div>
            <div class="method-block"><h4><code>public void cadastrarDisponibilidade(String idMedico, LocalDateTime inicio, LocalDateTime fim)</code></h4><p>Cadastra um período de disponibilidade na agenda de um médico.</p></div>
            <div class="method-block"><h4><code>public void agendarConsulta(String idPaciente, String idMedico, LocalDateTime inicio, LocalDateTime fim)</code></h4><p>Agenda uma consulta para um paciente em um horário disponível.</p></div>
            <div class="method-block"><h4><code>public void cancelarConsultaPorPaciente(Consulta consulta)</code></h4><p>Cancela uma consulta pelo paciente. A consulta volta a ser um horário disponível.</p></div>
            <div class="method-block"><h4><code>public boolean cancelarConsultaPorMedico(String idMedico, String idConsulta)</code></h4><p>Cancela uma consulta ou disponibilidade pelo médico.</p><div class="param-return"><p><strong>@return</strong> <code>true</code> se o cancelamento foi bem-sucedido.</p></div></div>
            <div class="method-block"><h4><code>public List&lt;Medico&gt; getTodosMedicos()</code></h4><p>Retorna uma lista com todos os médicos cadastrados.</p><div class="param-return"><p><strong>@return</strong> Uma lista de objetos <code>Medico</code>.</p></div></div>
            <div class="method-block"><h4><code>public List&lt;Consulta&gt; getConsultasPaciente(String idPaciente)</code></h4><p>Retorna todas as consultas associadas a um paciente.</p><div class="param-return"><p><strong>@return</strong> Uma lista de objetos <code>Consulta</code>.</p></div></div>
            <div class="method-block"><h4><code>public List&lt;Consulta&gt; getConsultas(String idMedico)</code></h4><p>Retorna todas as consultas e disponibilidades da agenda de um médico.</p><div class="param-return"><p><strong>@return</strong> Uma lista de objetos <code>Consulta</code>.</p></div></div>
            <div class="method-block"><h4><code>public List&lt;Consulta&gt; getTodasConsultasDisponiveis()</code></h4><p>Retorna todas as consultas com status "DISPONIVEL" de todos os médicos.</p><div class="param-return"><p><strong>@return</strong> Uma lista de objetos <code>Consulta</code>.</p></div></div>
        </section>
        <section class="class-doc" id="Medico">
            <h2>Classe: <code>com.example.clinica_app.Medico</code></h2>
            <p>Representa um médico no sistema.</p>
            <h3>Construtores</h3>
            <div class="method-block"><h4><code>public Medico(String idMedico, String nome, String especialidade)</code></h4><p>Cria uma nova instância de Medico.</p></div>
            <h3>Métodos</h3>
            <div class="method-block"><h4><code>public String getIdMedico()</code></h4><p><strong>@return</strong> O ID (CRM) do médico.</p></div>
            <div class="method-block"><h4><code>public String getNome()</code></h4><p><strong>@return</strong> O nome do médico.</p></div>
            <div class="method-block"><h4><code>public String getEspecialidade()</code></h4><p><strong>@return</strong> A especialidade do médico.</p></div>
        </section>
        <section class="class-doc" id="Paciente">
            <h2>Classe: <code>com.example.clinica_app.Paciente</code></h2>
            <p>Representa um paciente no sistema.</p>
            <h3>Construtores</h3>
            <div class="method-block"><h4><code>public Paciente(String idPaciente, String nome, int idade, String contato)</code></h4><p>Cria uma nova instância de Paciente.</p></div>
            <h3>Métodos</h3>
            <div class="method-block"><h4><code>public String getIdPaciente()</code></h4><p><strong>@return</strong> O ID (CPF) do paciente.</p></div>
            <div class="method-block"><h4><code>public String getNome()</code></h4><p><strong>@return</strong> O nome do paciente.</p></div>
            <div class="method-block"><h4><code>public String getContato()</code></h4><p><strong>@return</strong> O número de contato do paciente.</p></div>
            <div class="method-block"><h4><code>public List&lt;Consulta&gt; getHistorico()</code></h4><p><strong>@return</strong> Uma lista de todas as consultas no histórico do paciente.</p></div>
            <div class="method-block"><h4><code>public void adicionarConsultaAoHistorico(Consulta consulta)</code></h4><p>Adiciona uma consulta ao histórico do paciente.</p></div>
            <div class="method-block"><h4><code>public void removerConsultaDoHistorico(String idConsulta)</code></h4><p>Remove uma consulta do histórico do paciente pelo ID.</p></div>
        </section>
        <section class="class-doc" id="Consulta">
            <h2>Classe: <code>com.example.clinica_app.Consulta</code></h2>
            <p>Representa uma consulta médica ou um horário de disponibilidade na agenda.</p>
            <h3>Construtores</h3>
            <div class="method-block"><h4><code>public Consulta(String id, Paciente p, Medico m, LocalDateTime inicio, LocalDateTime fim)</code></h4><p>Cria uma consulta já agendada (status "AGENDADA").</p></div>
            <div class="method-block"><h4><code>public Consulta(String id, Medico m, LocalDateTime inicio, LocalDateTime fim)</code></h4><p>Cria um horário de disponibilidade (status "DISPONIVEL").</p></div>
            <h3>Métodos</h3>
            <div class="method-block"><h4><code>public void setPaciente(Paciente paciente)</code></h4><p>Define o paciente para a consulta.</p></div>
            <div class="method-block"><h4><code>public void setStatus(String status)</code></h4><p>Define o status da consulta.</p></div>
            <div class="method-block"><h4><code>public void setMotivoCancelamento(String motivo)</code></h4><p>Define o motivo do cancelamento.</p></div>
            <div class="method-block"><h4><code>public void cancelar()</code></h4><p>Altera o status para "CANCELADA".</p></div>
            <div class="method-block"><h4><code>public String toString()</code></h4><p><strong>@return</strong> Uma representação em texto do horário da consulta.</p></div>
        </section>
        <section class="class-doc" id="ClinicaController">
            <h2>Classe: <code>com.example.clinica_app.ClinicaController</code></h2>
            <p>Controlador principal da interface gráfica (GUI). Gerencia todas as interações do usuário.</p>
            <h3>Métodos Principais (Event Handlers)</h3>
            <div class="method-block"><h4><code>public void initialize()</code></h4><p>Configura os componentes da tela ao ser carregada (tabelas, listeners, etc.).</p></div>
            <div class="method-block"><h4><code>public void verificarUsuarioEAvancar(ActionEvent event)</code></h4><p>Valida o login e direciona para a tela do paciente ou médico.</p></div>
            <div class="method-block"><h4><code>public void onCadastrarPaciente()</code></h4><p>Processa o cadastro de um novo paciente a partir dos campos da interface.</p></div>
            <div class="method-block"><h4><code>public void onCadastrarMedico()</code></h4><p>Processa o cadastro de um novo médico a partir dos campos da interface.</p></div>
            <div class="method-block"><h4><code>public void onCadastrarDisponibilidade(ActionEvent event)</code></h4><p>Permite que um médico adicione um horário vago em sua agenda.</p></div>
            <div class="method-block"><h4><code>public void onAgendarConsultaPaciente(ActionEvent event)</code></h4><p>Permite que um paciente agende uma consulta a partir de um horário disponível.</p></div>
            <div class="method-block"><h4><code>public void onCancelarConsulta(ActionEvent event)</code></h4><p>Permite que um médico cancele uma consulta agendada (exige motivo).</p></div>
            <div class="method-block"><h4><code>public void onCancelarConsultaMinhasConsultas(ActionEvent event)</code></h4><p>Permite que um paciente cancele uma de suas consultas.</p></div>
            <div class="method-block"><h4><code>public void onRemoverConsultaMinhasConsultas(ActionEvent event)</code></h4><p>Permite que um paciente remova de sua visão uma consulta já cancelada.</p></div>
            <div class="method-block"><h4><code>public void abrirTelaAgendarConsulta(ActionEvent event)</code></h4><p>Navega para a tela de agendamento de consulta.</p></div>
            <div class="method-block"><h4><code>public void abrirTelaMinhasConsultas(ActionEvent event)</code></h4><p>Navega para a tela de "Minhas Consultas" do paciente.</p></div>
            <div class="method-block"><h4><code>public void onVoltarTelaInicial(ActionEvent event)</code></h4><p>Retorna para a tela de login inicial.</p></div>
            <div class="method-block"><h4><code>public void onVoltarTelaPaciente(ActionEvent event)</code></h4><p>Retorna para o menu principal do paciente.</p></div>
        </section>

</div>

</body>
</html>
