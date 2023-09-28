package com.example.happypets;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

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
    void getSelected(ActionEvent event) {

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void EditCatalog(ActionEvent event) {

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

    }
}
