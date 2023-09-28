package com.example.happypets;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
public class DataBaseHandler extends Configs{
    static Connection dbConnection;

    public static Connection getDbConnection() throws
            ClassNotFoundException, SQLException{
        String connectionString="jdbc:mysql://"+dbHost+":"
                +dbPort+"/"+dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection =DriverManager.getConnection(connectionString,dbUser,dbPass);
        return dbConnection;
    }

    public void SignUpUser(Employees employees){
        String insert= "INSERT INTO HappyPets.employees"+"("+Const.EMPLOYEE_FIRSTNAME+","
                +Const.EMPLOYEE_LASTNAME+","+Const.EMPLOYEE_BIRTH+","+Const.EMPLOYEE_WORKFIELD+","
                +Const.EMPLOYEE_EXPERIENCE+","+Const.EMPLOYEE_MOBNUMBER+","+Const.EMPLOYEE_EMAIL+","
                +Const.EMPLOYEE_PASSWORD+")"+"VALUES(?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1,employees.getFirst_name());
            preparedStatement.setString(2, employees.getLast_name());
            preparedStatement.setString(3, employees.getBirth_date());
            preparedStatement.setString(4, employees.getWorking_field());
            preparedStatement.setString(5, employees.getWork_expirience());
            preparedStatement.setString(6, employees.getMob_number());
            preparedStatement.setString(7, employees.getEmail());
            preparedStatement.setString(8, employees.getPassword());
            //preparedStatement.setString(9,employees.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet getEmployee(Employees employees){
        ResultSet resultSet=null;
        String select = "SELECT * FROM HappyPets.employees" + " WHERE " +
                Const.EMPLOYEE_FIRSTNAME + "=? AND " + Const.EMPLOYEE_PASSWORD + "=?";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(select);
            preparedStatement.setString(1,employees.getFirst_name());
            preparedStatement.setString(2, employees.getPassword());
            resultSet=preparedStatement.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return resultSet;
    }

    public static ObservableList<Employees> getData() throws SQLException, ClassNotFoundException {

            Connection connection= getDbConnection();
            ObservableList<Employees> list= FXCollections.observableArrayList();

            PreparedStatement preparedStatement=connection.prepareStatement("select *from employees");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                list.add(new Employees(
                        resultSet.getString(Const.EMPLOYEE_FIRSTNAME),resultSet.getString(Const.EMPLOYEE_LASTNAME),
                        resultSet.getString(Const.EMPLOYEE_BIRTH),resultSet.getString(Const.EMPLOYEE_WORKFIELD),
                        resultSet.getString(Const.EMPLOYEE_EXPERIENCE), resultSet.getString(Const.EMPLOYEE_MOBNUMBER),
                        resultSet.getString(Const.EMPLOYEE_EMAIL),resultSet.getString(Const.EMPLOYEE_PASSWORD)));
                        //resultSet.getString(Const.EMPLOYEE_ID)));
            }
        return list;
    }




    public void SignUpPatient(Patients patients){
        String insert= "INSERT INTO HappyPets.patients"+"("+Const.PATIENT_ID+","
                +Const.PATIENT_NAME+","+Const.PATIENT_KIND+","+Const.PATIENT_BREED+","
                +Const.PATIENT_AGE+","+Const.PATIENT_GENDER+","+Const.PATIENT_VACCINATION+","
                +Const.PATIENT_HEALTH+","+Const.PATIENT_OWNER+","+Const.PATIENT_ADRESS+","
                +Const.PATIENT_PHONE+")"+"VALUES(?,?,?,?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, String.valueOf(patients.getId()));
            preparedStatement.setString(2, patients.getName_patient());
            preparedStatement.setString(3, patients.getKind());
            preparedStatement.setString(4, patients.getBreed_patient());
            preparedStatement.setString(5, patients.getAge_patient());
            preparedStatement.setString(6, patients.getGender_patient());
            preparedStatement.setString(7, patients.getVaccination_patient());
            preparedStatement.setString(8, patients.getHealth_patient());
            preparedStatement.setString(9,patients.getName_owner());
            preparedStatement.setString(10,patients.getAdress_owner());
            preparedStatement.setString(11,patients.getPhone_owner());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Patients> getPatientData() throws SQLException, ClassNotFoundException {

        Connection con= getDbConnection();
        ObservableList<Patients> listPatient= FXCollections.observableArrayList();

        PreparedStatement ps=con.prepareStatement("select *from patients");
        ResultSet rs=ps.executeQuery();

        while (rs.next()){
            listPatient.add(new Patients(
                    rs.getInt(Const.PATIENT_ID),rs.getString(Const.PATIENT_NAME),rs.getString(Const.PATIENT_KIND),
                    rs.getString(Const.PATIENT_BREED),rs.getString(Const.PATIENT_AGE),rs.getString(Const.PATIENT_GENDER),
                    rs.getString(Const.PATIENT_VACCINATION),rs.getString(Const.PATIENT_HEALTH),rs.getString(Const.PATIENT_OWNER),
                    rs.getString(Const.PATIENT_ADRESS),rs.getString(Const.PATIENT_PHONE)));

        }
        return listPatient;
    }


    public void fillInCatalog(Catalog catalog){
        String insert= "INSERT INTO HappyPets.catalog"+"("+Const.CATALOG_ID+","+Const.CATALOG_SERVICE+
                ","+Const.CATALOG_TYPE+","+Const.CATALOG_PRICE+","+Const.CATALOG_INFO+")"+"VALUES (?,?,?,?,?)";

        try {
            PreparedStatement preparedStatement = getDbConnection().prepareStatement(insert);
            preparedStatement.setString(1, String.valueOf(catalog.getService_id()));
            preparedStatement.setString(2, catalog.getTitle());
            preparedStatement.setString(3, catalog.getType());
            preparedStatement.setString(4, catalog.getPrice());
            preparedStatement.setString(5, catalog.getInfo());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<Catalog> getCatalogData() throws SQLException, ClassNotFoundException {

        Connection connect= getDbConnection();
        ObservableList<Catalog> catalogList= FXCollections.observableArrayList();

        PreparedStatement ps=connect.prepareStatement("select *from catalog");
        ResultSet rs2=ps.executeQuery();

        while (rs2.next()){
            catalogList.add(new Catalog(
                    rs2.getInt(Const.CATALOG_ID),rs2.getString(Const.CATALOG_SERVICE),
                    rs2.getString(Const.CATALOG_TYPE),rs2.getString(Const.CATALOG_PRICE),
                    rs2.getString(Const.CATALOG_INFO)));
        }
        return catalogList;
    }
}
