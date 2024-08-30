package com.securelogin.controller;

import com.securelogin.service.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Label statusLabel;

    private LoginService loginService;
    private Stage stage;


    public loginController() {
        this.loginService = new LoginService();
    }

    @FXML
    private void initialize() {
        loginButton.setOnAction(event -> login());
    }

    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (loginService.login(username, password)) {
            statusLabel.setText("Login successful!");
        } else {
            statusLabel.setText("Login failed. Please try again");
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
