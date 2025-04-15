/* doesn't work with source level 1.8:
module mychat.mychatfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens mychat.mychatfx to javafx.fxml;
    exports mychat.mychatfx;
}
*/
