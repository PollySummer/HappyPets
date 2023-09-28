package com.example.happypets;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EmployeesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Employees> employees_table;

    @FXML
    private TableColumn<Employees, String> phone_column;

    @FXML
    private TableColumn<Employees, String> lastname_column;

    @FXML
    private Button delete_button;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Employees, String> work_column;

    @FXML
    private TableColumn<Employees, String> name_column;

    @FXML
    private TableColumn<Employees, String> password_column;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Employees, String> id_column;

    @FXML
    private TableColumn<Employees, String> email_column;

    @FXML
    private TableColumn<Employees, String> experience_column;

    @FXML
    private TableColumn<Employees, String> birth_column;

    @FXML
    private Button change_button;
    @FXML
    private TextField edit_name;
    @FXML
    private TextField edit_lastname;
    @FXML
    private TextField edit_birth;
    @FXML
    private TextField edit_work;
    @FXML
    private TextField edit_expirience;
    @FXML
    private TextField edit_phone;
    @FXML
    private TextField edit_email;
    @FXML
    private TextField edit_pass;

    @FXML
    private TextField edit_id;

    @FXML
    private TextField search_field;

    ObservableList<Employees> list;
    ObservableList<Employees> dataList;
    int index=-1;
    Connection connection=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;

    @FXML
    void toSelect(MouseEvent mouseEvent){

        index = employees_table.getSelectionModel().getSelectedIndex();
        edit_name.setText(name_column.getCellData (index));
        edit_lastname.setText(lastname_column.getCellData (index));
        edit_birth.setText(birth_column.getCellData (index));
        edit_work.setText(work_column.getCellData (index));
        edit_expirience.setText(experience_column.getCellData (index));
        edit_email.setText(email_column.getCellData (index));
        edit_phone.setText(phone_column.getCellData (index));
        edit_pass.setText(password_column.getCellData (index));
        //edit_id.setText(id_column.getCellData(index));
    }

    @FXML
    void editData(){
        try {
            connection=DataBaseHandler.getDbConnection();
            String v1=edit_name.getText();
            String v2=edit_lastname.getText();
            String v3=edit_birth.getText();
            String v4=edit_work.getText();
            String v5=edit_expirience.getText();
            String v6=edit_phone.getText();
            String v7=edit_email.getText();
            String v8=edit_pass.getText();
            //String v9=edit_id.getText();

            String sql="update employees set first_name= '"+v1+"',  last_name= '"+v2+"',  birth_date= '"+v3+"', work_field= '"+
                    v4+"',  work_expirience= '"+v5+"',  mob_number= '"+v6+"',  email= '"+v7+"',  password= '"+v8+"' where first_name='"+v1+"'";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.execute();
            System.out.println("dsfvb");


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void search_employee() throws SQLException, ClassNotFoundException {

        dataList=DataBaseHandler.getData();
        employees_table.setItems(dataList);
        FilteredList<Employees> filterData= new FilteredList<>(dataList, e->true);
        search_field.textProperty().addListener((observable,oldVal,newVal)->{
            filterData.setPredicate(patient->{
                if(newVal==null||newVal.isEmpty()){
                    return true;
                }
                String lowCaseFilter=newVal.toLowerCase();

                if(patient.getFirst_name().toLowerCase().contains(lowCaseFilter)){
                    return true;
                } else return patient.getLast_name().toLowerCase().contains(lowCaseFilter);
            });
        });
        SortedList<Employees> sortedList=new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(employees_table.comparatorProperty());
        employees_table.setItems(sortedList);
    }
    public void Delete() throws SQLException, ClassNotFoundException {
        connection=DataBaseHandler.getDbConnection();
        String sql="delete from employees where first_name=?";
        preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,edit_name.getText());
        preparedStatement.execute();
        System.out.println("delete pressed");

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        name_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("first_name"));
        lastname_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("last_name"));
        birth_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("birth_date"));
        work_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("working_field"));
        experience_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("work_expirience"));
        phone_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("mob_number"));
        email_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("email"));
        password_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("password"));
        //id_column.setCellValueFactory(new PropertyValueFactory<Employees,String>("id_employee"));

        list=DataBaseHandler.getData();
        employees_table.setItems(list);

        ScenesController sc=new ScenesController();
        add_button.setOnAction(actionEvent -> {
            System.out.println("dsf");
            sc.openNewScene("registration.fxml",add_button);
        });

        search_employee();

    }
}
