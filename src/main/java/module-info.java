module com.example.happypets {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.example.happypets to javafx.fxml;
    exports com.example.happypets;
}