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

public class CatalogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button delete_button;

    @FXML
    private TextField id_field;

    @FXML
    private Button add_button;

    @FXML
    private TableColumn<Catalog, String> price_column;

    @FXML
    private TableColumn<Catalog, String> title_column;

    @FXML
    private TextField price_field;

    @FXML
    private Button back_button;

    @FXML
    private TableColumn<Catalog, Integer> id_column;

    @FXML
    private Button edit_button;

    @FXML
    private TextField title_field;

    @FXML
    private TextField info_field;

    @FXML
    private TableColumn<Catalog, String> type_column;

    @FXML
    private TableColumn<Catalog, String> info_column;

    @FXML
    private TextField type_field;

    @FXML
    private TableView<Catalog> catalog_table;

    @FXML
    private TextField search_field;
    int index=-1;
    ObservableList<Catalog> listC;
    ObservableList<Catalog> dataList;
    Connection connection=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    @FXML
    private void addNewService()  {
        DataBaseHandler dataBaseHandler = new DataBaseHandler();

        Integer id_service = Integer.valueOf(id_field.getText());
        String title = title_field.getText();
        String type = type_field.getText();
        String price = price_field.getText();
        String info = info_field.getText();

        Catalog catalog=new Catalog(id_service,title,type,price,info);
        dataBaseHandler.fillInCatalog(catalog);
    }

    @FXML
    void getSelected(MouseEvent mouseEvent) {
        index=catalog_table.getSelectionModel().getSelectedIndex();
        id_field.setText(id_column.getCellData(index).toString());
        title_field.setText(title_column.getCellData(index));
        type_field.setText(type_column.getCellData(index));
        price_field.setText(price_column.getCellData(index));
        info_field.setText(info_column.getCellData(index));
    }

    @FXML
    void Delete() throws SQLException, ClassNotFoundException {
        connection=DataBaseHandler.getDbConnection();
        String sql="delete from catalog where id_catalog=?";
        ps=connection.prepareStatement(sql);
        ps.setString(1,id_field.getText());
        ps.execute();
        System.out.println("pressed");

    }

    @FXML
    void EditCatalog() throws SQLException, ClassNotFoundException {

        connection=DataBaseHandler.getDbConnection();
        String val1=id_field.getText();
        String val2=title_field.getText();
        String val3=type_field.getText();
        String val4=price_field.getText();
        String val5=info_field.getText();

        String sql="update catalog set id_catalog= '"+val1+"',  service_title= '"+val2+"',  service_type= '"+val3+"', service_price= '"+
                val4+"',  add_info= '"+val5+"' where id_catalog='"+val1+"'";

        ps=connection.prepareStatement(sql);
        ps.execute();
        System.out.println("button pressed");
    }
    @FXML
    void search_service() throws SQLException, ClassNotFoundException {
        dataList=DataBaseHandler.getCatalogData();
        catalog_table.setItems(dataList);
        FilteredList<Catalog> filterData= new FilteredList<>(dataList, e->true);
        search_field.textProperty().addListener((observable,oldVal,newVal)->{
            filterData.setPredicate(service->{
                if(newVal==null||newVal.isEmpty()){
                    return true;
                }
                String lowCaseFilter=newVal.toLowerCase();

                if(service.getTitle().toLowerCase().contains(lowCaseFilter)){
                    return true;
                } else return service.getType().toLowerCase().contains(lowCaseFilter);
            });
        });
        SortedList<Catalog> sortedList=new SortedList<>(filterData);
        sortedList.comparatorProperty().bind(catalog_table.comparatorProperty());
        catalog_table.setItems(sortedList);

    }

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {
        id_column.setCellValueFactory(new PropertyValueFactory<Catalog,Integer>("service_id"));
        title_column.setCellValueFactory(new PropertyValueFactory<Catalog,String>("title"));
        type_column.setCellValueFactory(new PropertyValueFactory<Catalog,String>("type"));
        price_column.setCellValueFactory(new PropertyValueFactory<Catalog,String>("price"));
        info_column.setCellValueFactory(new PropertyValueFactory<Catalog,String>("info"));

        listC=DataBaseHandler.getCatalogData();
        catalog_table.setItems(listC);
        search_service();
    }
}
