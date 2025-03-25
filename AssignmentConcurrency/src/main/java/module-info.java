module com.mycompany.assignmentconcurrency {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.assignmentconcurrency to javafx.fxml;
    exports com.mycompany.assignmentconcurrency;
}
