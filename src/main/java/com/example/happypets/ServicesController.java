package com.example.happypets;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

public class ServicesController {
    @FXML
    private Button delete_button;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField id_field;

    @FXML
    private TableColumn<Services, String> status_column;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Services, Integer> price_column;

    @FXML
    private TextField health_status_field;

    @FXML
    private TableColumn<Services, String> serv_type_column;

    @FXML
    private TextField price_field;

    @FXML
    private TableColumn<Services, String> medicine_column;

    @FXML
    private Button refresh_button;

    @FXML
    private TableColumn<Services, Integer> id_column;

    @FXML
    private TextField date_field;

    @FXML
    private TableColumn<Services, Integer> id_patient_column;

    @FXML
    private Button edit_button;

    @FXML
    private TextField doctor_field;

    @FXML
    private TableView<Services> services_table;

    @FXML
    private TableColumn<Services, String> date_column;

    @FXML
    private TextField type_field;

    @FXML
    private TableColumn<Services, String> doctor_column;

    @FXML
    private TextField medicine_field;

    @FXML
    private TextField patient_id_field;

    @FXML
    private TextField search_field;

    ObservableList<Services> list;
    ObservableList<Services> dataList;
    int index=-1;
    Connection connection=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;

    @FXML
    void getSelected(MouseEvent mouseEvent) {

        index = services_table.getSelectionModel().getSelectedIndex();
        id_field.setText(String.valueOf(id_column.getCellData (index)));
        patient_id_field.setText(String.valueOf(id_patient_column.getCellData (index)));
        type_field.setText(serv_type_column.getCellData (index));
        medicine_field.setText(medicine_column.getCellData (index));
        health_status_field.setText(status_column.getCellData (index));
        date_field.setText(date_column.getCellData (index));
        doctor_field.setText(doctor_column.getCellData (index));
        price_field.setText(String.valueOf(price_column.getCellData (index)));

    }

    @FXML
    void addService() {

        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        Integer id_service = Integer.valueOf(id_field.getText());
        Integer id_patient = Integer.valueOf(patient_id_field.getText());
        String type = type_field.getText();
        String medicine = medicine_field.getText();
        String status = health_status_field.getText();
        String date = date_field.getText();
        String doctor = doctor_field.getText();
        Integer price = Integer.valueOf(price_field.getText());


        Services services=new Services(id_service,id_patient,type,medicine,status,
                date,doctor,price);
        dataBaseHandler.addService(services);
    }

    @FXML
    void EditService() throws SQLException, ClassNotFoundException {
        try {
            connection=DataBaseHandler.getDbConnection();
            String v1=id_field.getText();
            String v2=patient_id_field.getText();
            String v3=type_field.getText();
            String v4=medicine_field.getText();
            String v5=health_status_field.getText();
            String v6=date_field.getText();
            String v7=doctor_field.getText();
            String v8=price_field.getText();

            String sql="update services set id_service= '"+v1+"',  patient_id= '"+v2+"',  type_service= '"+v3+"', medicine_name= '"+
                    v4+"',  patient_status= '"+v5+"',  provision_date= '"+v6+"',  doctor_name= '"+v7+"',  final_price= '"+v8+"' where id_service='"+v1+"'";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.execute();
            System.out.println("dsfvb");



        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public void Delete() throws SQLException, ClassNotFoundException {
        connection=DataBaseHandler.getDbConnection();
        String sql="delete from services where id_service=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,id_field.getText());
        preparedStatement.execute();
        System.out.println("delete pressed");

    }

    @FXML
    void search_service() throws SQLException, ClassNotFoundException {

        dataList=DataBaseHandler.getServices();
        services_table.setItems(dataList);

        FilteredList<Services> filterData= new FilteredList<>(dataList, e->true);
        search_field.textProperty().addListener((observable,oldVal,newVal)->{
            filterData.setPredicate(service->{
                if(newVal==null||newVal.isEmpty()){
                    return true;
                }
                String lowCaseFilter=newVal.toLowerCase();

                if(service.getServ_type().toLowerCase().contains(lowCaseFilter)){
                    return true;
                } else return service.getDoctor().toLowerCase().contains(lowCaseFilter);
            });
        });
        SortedList<Services> sortedList=new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(services_table.comparatorProperty());
        services_table.setItems(sortedList);

    }


    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        id_column.setCellValueFactory(new PropertyValueFactory<Services,Integer>("serv_id"));
        id_patient_column.setCellValueFactory(new PropertyValueFactory<Services,Integer>("pat_id"));
        serv_type_column.setCellValueFactory(new PropertyValueFactory<Services,String>("serv_type"));
        medicine_column.setCellValueFactory(new PropertyValueFactory<Services,String>("medicine"));
        status_column.setCellValueFactory(new PropertyValueFactory<Services,String>("pat_status"));
        date_column.setCellValueFactory(new PropertyValueFactory<Services,String>("date"));
        doctor_column.setCellValueFactory(new PropertyValueFactory<Services,String>("doctor"));
        price_column.setCellValueFactory(new PropertyValueFactory<Services,Integer>("price"));

        list=DataBaseHandler.getServices();
        services_table.setItems(list);
        search_service();
    }
}
