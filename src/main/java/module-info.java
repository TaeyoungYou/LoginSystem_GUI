module com.loginsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.loginsystem to javafx.fxml;
    exports com.loginsystem;
}