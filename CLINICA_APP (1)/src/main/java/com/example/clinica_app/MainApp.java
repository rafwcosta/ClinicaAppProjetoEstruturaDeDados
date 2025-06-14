package com.example.clinica_app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Classe principal que inicia a aplicação JavaFX.
 * É o ponto de entrada do programa.
 */
public class MainApp extends Application {
    /**
     * O método principal de entrada para todas as aplicações JavaFX.
     * Este método é chamado após o método init() ter retornado e irá
     * carregar a tela inicial (menu-inicial.fxml).
     *
     * @param stage O stage principal (janela) para esta aplicação.
     * @throws Exception se o arquivo FXML não puder ser carregado.
     */
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/view/menu-inicial.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Agendamento de Consultas Médicas");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * O ponto de entrada principal do programa.
     * @param args Argumentos de linha de comando (não utilizados nesta aplicação).
     */
    public static void main(String[] args) {
        launch();
    }
}