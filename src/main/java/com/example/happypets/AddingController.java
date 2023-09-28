package com.example.happypets;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField animal_gender_field;

    @FXML
    private TextField animail_breede_field;

    @FXML
    private TextField animal_id_field;

    @FXML
    private TextField animal_owner_field;

    @FXML
    private TextField animal_age_field;

    @FXML
    private Button SignUpPatientButton;

    @FXML
    private TextField animal_health_field;

    @FXML
    private TextField animal_name_field;

    @FXML
    private TextField animal_vaccin_field;

    @FXML
    private TextField animal_kind_field;

    @FXML
    private TextField owners_phone;

    @FXML
    private TextField animal_adress;

    @FXML
    void initialize() {
        SignUpPatientButton.setOnAction(actionEvent -> {
            System.out.println("Button pressed");
            signUpNewPatient();
        });
    }

    private void signUpNewPatient() {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        Integer patient_id = Integer.valueOf(animal_id_field.getText());
        String patient_name = animal_name_field.getText();
        String patient_kind = animal_kind_field.getText();
        String patient_breed = animail_breede_field.getText();
        String patient_age = animal_age_field.getText();
        String patient_gender = animal_gender_field.getText();
        String patient_vaccination = animal_vaccin_field.getText();
        String patient_health = animal_health_field.getText();
        String patient_owner = animal_owner_field.getText();
        String patient_adress = animal_adress.getText();
        String phone_num = owners_phone.getText();

        Patients patients=new Patients(patient_id,patient_name,patient_kind,patient_breed,patient_age,
                patient_gender,patient_vaccination,patient_health,patient_owner,patient_adress,phone_num);
        dataBaseHandler.SignUpPatient(patients);
    }
}
