package com.example.happypets;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button employeeButton;

    @FXML
    private Button catalogButton;

    @FXML
    private Button patientsButton;

    @FXML
    private Button sheduleButton;

    @FXML
    void ffdca1(ActionEvent event) {

    }

    @FXML
    void d7a7d7(ActionEvent event) {

    }


    @FXML
    void initialize() {
        ScenesController sc=new ScenesController();

        employeeButton.setOnAction(actionEvent -> {
                sc.openNewScene("employees_table.fxml",employeeButton);
        });
        patientsButton.setOnAction(actionEvent ->{
            sc.openNewScene("patients_table.fxml",patientsButton);
        });

        catalogButton.setOnAction(actionEvent ->{
            sc.openNewScene("catalog_table.fxml",patientsButton);
        });
    }

}
