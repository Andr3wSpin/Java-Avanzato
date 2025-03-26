package com.mycompany.concurrency;

import java.io.IOException;
import javafx.fxml.FXML;

public class MPController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
