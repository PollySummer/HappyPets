package com.example.happypets;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PatientsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField owner_name_field;

    @FXML
    private TextField health_field;

    @FXML
    private TableColumn<Patients, String> health_column;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Patients, String> name_column;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Patients, Integer> id_column;

    @FXML
    private TableColumn<Patients, String> adress_column;

    @FXML
    private TextField kind_field;

    @FXML
    private Button edit_button;

    @FXML
    private TextField name_field;

    @FXML
    private TextField breed_field;

    @FXML
    private TableColumn<Patients, String> vaccination_column;

    @FXML
    private TableView<Patients> patients_table;

    @FXML
    private Button delete_button;

    @FXML
    private TableColumn<Patients, String> kind_column;

    @FXML
    private TableColumn<Patients, String> gender_column;

    @FXML
    private TextField id_field;

    @FXML
    private TextField adress_field;

    @FXML
    private TableColumn<Patients, String> own_phone_column;

    @FXML
    private TableColumn<Patients, String> age_column;

    @FXML
    private TableColumn<Patients, String> breed_column;

    @FXML
    private TextField phone_field;

    @FXML
    private TableColumn<Patients, String> owner_column;

    @FXML
    private TextField gender_field;

    @FXML
    private TextField age_field;

    @FXML
    private TextField vaccination_field;
    @FXML
    private TextField search_field;
    int index=-1;
    ObservableList<Patients> listP;
    ObservableList<Patients> dataList;
    Connection connection=null;
    ResultSet rs=null;
    PreparedStatement ps=null;

    @FXML
    void getSelected(MouseEvent mouseEvent){
        index=patients_table.getSelectionModel().getSelectedIndex();
        id_field.setText(id_column.getCellData(index).toString());
        name_field.setText(name_column.getCellData(index));
        kind_field.setText(kind_column.getCellData(index));
        breed_field.setText(breed_column.getCellData(index));
        age_field.setText(age_column.getCellData(index));
        gender_field.setText(gender_column.getCellData(index));
        vaccination_field.setText(vaccination_column.getCellData(index));
        health_field.setText(health_column.getCellData(index));
        owner_name_field.setText(owner_column.getCellData(index));
        adress_field.setText(adress_column.getCellData(index));
        phone_field.setText(own_phone_column.getCellData(index));

    }

    @FXML
    private void EditPatientData() throws SQLException, ClassNotFoundException {
        connection=DataBaseHandler.getDbConnection();
        String val1=id_field.getText();
        String val2=name_field.getText();
        String val3=kind_field.getText();
        String val4=breed_field.getText();
        String val5=age_field.getText();
        String val6=gender_field.getText();
        String val7=vaccination_field.getText();
        String val8=health_field.getText();
        String val9=owner_name_field.getText();
        String val10=adress_field.getText();
        String val11=phone_field.getText();

        String sql="update patients set id_patient= '"+val1+"',  patient_name= '"+val2+"',  animal_kind= '"+val3+"', breed= '"+
                val4+"',  age= '"+val5+"',  gender= '"+val6+"',  vaccination= '"+val7+"',  health_status= '"+val8+"', owner_name='"+
                val9+"',owner_adress='"+val10+"',owner_phone='"+val11+"' where id_patient='"+val1+"'";

        ps=connection.prepareStatement(sql);
        ps.execute();
        System.out.println("button pressed");


    }
    @FXML
    void search_patient() throws SQLException, ClassNotFoundException {

        dataList=DataBaseHandler.getPatientData();
        patients_table.setItems(dataList);
        FilteredList<Patients> filterData= new FilteredList<>(dataList,e->true);
        search_field.textProperty().addListener((observable,oldVal,newVal)->{
            filterData.setPredicate(patient->{
                if(newVal==null||newVal.isEmpty()){
                    return true;
                }
                String lowCaseFilter=newVal.toLowerCase();

                if(patient.getName_patient().toLowerCase().contains(lowCaseFilter)){
                    return true;
                } else return patient.getName_owner().toLowerCase().contains(lowCaseFilter);
            });
        });
        SortedList<Patients> sortedList=new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(patients_table.comparatorProperty());
        patients_table.setItems(sortedList);
    }
    public void Delete() throws SQLException, ClassNotFoundException {
        connection=DataBaseHandler.getDbConnection();
        String sql="delete from patients where id_patient=?";
        ps=connection.prepareStatement(sql);
        ps.setString(1,id_field.getText());
        ps.execute();
        System.out.println("pressed");

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        id_column.setCellValueFactory(new PropertyValueFactory<Patients,Integer>("id"));
        name_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("name_patient"));
        kind_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("kind"));
        breed_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("breed_patient"));
        age_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("age_patient"));
        gender_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("gender_patient"));
        vaccination_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("vaccination_patient"));
        health_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("health_patient"));
        owner_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("name_owner"));
        adress_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("adress_owner"));
        own_phone_column.setCellValueFactory(new PropertyValueFactory<Patients,String>("phone_owner"));

        listP=DataBaseHandler.getPatientData();
        patients_table.setItems(listP);

        ScenesController sc=new ScenesController();
        add_button.setOnAction(actionEvent -> {
            System.out.println("dsf");
            sc.openNewScene("add-patients.fxml",add_button);
        });
        search_patient();
        Delete();
    }
}
