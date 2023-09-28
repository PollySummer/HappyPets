package com.example.happypets;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animations.Shake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class HelloController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SignInButton;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    void d7a7d7(ActionEvent event) {

    }
    ScenesController sc=new ScenesController();

    @FXML
    void initialize() {

        SignInButton.setOnAction(actionEvent -> {
            String loginText= login_field.getText().trim();
            String passwordText=password_field.getText().trim();

            if(!loginText.equals("") && !passwordText.equals("")){
                loginUser(loginText,passwordText);
            } else {
                System.out.println("Error. Login and password are empty.");
            }
        });
    }

    private void loginUser(String loginText, String passwordText) {
        DataBaseHandler dataBaseHandler=new DataBaseHandler();
        Employees employees=new Employees();
        employees.setFirst_name(loginText);
        employees.setPassword(passwordText);
       ResultSet resultSet= dataBaseHandler.getEmployee(employees);

       int counter=0;
       while (true){
           try {
               if (!resultSet.next()) break;
           } catch (SQLException e) {
               throw new RuntimeException(e);
           }
           counter++;
       }
       if(counter>=1){
           sc.openNewScene("login.fxml", SignInButton);
       } else {
           Shake loginNotFound=new Shake(login_field);
           Shake passNotFound=new Shake(password_field);
           loginNotFound.playAnimation();
           passNotFound.playAnimation();
       }
    }
}