/* doesn't work with source level 1.8:
module com.mycompany.concurrency {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.concurrency to javafx.fxml;
    exports com.mycompany.concurrency;
}
*/
