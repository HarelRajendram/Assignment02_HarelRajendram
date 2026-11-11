module com.mycompany.assignment2_harelrajendram {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.assignment2_harelrajendram to javafx.fxml;
    exports com.mycompany.assignment2_harelrajendram;
}
