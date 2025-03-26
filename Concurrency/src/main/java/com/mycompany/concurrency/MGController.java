package com.mycompany.concurrency;

import java.io.IOException;
import javafx.fxml.FXML;

public class MGController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}