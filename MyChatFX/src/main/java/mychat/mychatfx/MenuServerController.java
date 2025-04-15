package mychat.mychatfx;

import java.io.IOException;
import javafx.fxml.FXML;

public class MenuServerController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}