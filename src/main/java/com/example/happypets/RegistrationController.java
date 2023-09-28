package com.example.happypets;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    //@FXML
    //private TextField personalCode_field;

    @FXML
    private TextField password_field;

    @FXML
    private TextField experience_field;

    @FXML
    private TextField telephone_field;

    @FXML
    private Button SignUpButton;

    @FXML
    private TextField lastname_field;

    @FXML
    private TextField work_field;

    @FXML
    private TextField post_field;

    @FXML
    private TextField name_field;

    @FXML
    private TextField data_field;

    @FXML
    void f8d7a2(ActionEvent event) {

    }

    @FXML
    void f8f8f8(ActionEvent event) {

    }

    @FXML
    void d7a7d7(ActionEvent event) {

    }

    @FXML
    void initialize() {

        SignUpButton.setOnAction(actionEvent -> {
            System.out.println("Button pressed");
            signUpNewUser();
        });
    }

    private void signUpNewUser() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        String first_name = name_field.getText();
        String last_name = lastname_field.getText();
        String birth_date = data_field.getText();
        String working_field = work_field.getText();
        String work_expirience = experience_field.getText();
        String mob_number = telephone_field.getText();
        String email = post_field.getText();
        String password = password_field.getText();
        //String id_employee=personalCode_field.getText();

        Employees employees = new Employees(first_name, last_name, birth_date, working_field,
                work_expirience, mob_number, email, password/*id_employee*/);
        dataBaseHandler.SignUpUser(employees);
    }
}
