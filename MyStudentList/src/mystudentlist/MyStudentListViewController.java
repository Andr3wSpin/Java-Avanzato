/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystudentlist;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sun.xml.internal.ws.api.client.SelectOptimalEncodingFeature;
import javafx.application.Platform;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.ObjectBinding;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

/**
 *
 * @author lucagreco
 */
public class MyStudentListViewController implements Initializable {

    @FXML
    private MenuItem saveButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField codeField;
    @FXML
    private Button removeButton;
    @FXML
    private TableView<Studente> studentTable;
    @FXML
    private TableColumn<Studente, String> nameClm;
    @FXML
    private TableColumn<Studente, String> surnameClm;
    @FXML
    private TableColumn<Studente, String> codeClm;
    @FXML
    private TextField searchBar;
    
    private ObservableList<Studente> studenti;


    private FilteredList<Studente> listaFiltrata;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        nameClm.setCellValueFactory(new PropertyValueFactory("nome"));
        surnameClm.setCellValueFactory(new PropertyValueFactory("cognome"));
        codeClm.setCellValueFactory(new PropertyValueFactory("matricola"));
        
        nameClm.setCellFactory(TextFieldTableCell.forTableColumn());

        
       
        
        studenti = FXCollections.observableArrayList();
         

        studenti = FXCollections.observableArrayList();

        studentTable.setItems(studenti);

        // TODO
        listaFiltrata = new FilteredList<>(studenti);

        searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
            listaFiltrata.setPredicate(studente ->
                    studente.getNome().toLowerCase().startsWith(newValue.toLowerCase()) ||
                            studente.getCognome().toLowerCase().startsWith(newValue.toLowerCase()) ||
                            studente.getMatricola().toLowerCase().startsWith(newValue.toLowerCase()));
        });

        studentTable.setItems(listaFiltrata);
    }

    private void initItems() {

        studenti.add(new Studente("Mario", "Rossi", "06127001"));
        studenti.add(new Studente("Ernesto", "Rossi", "06127002"));
        studenti.add(new Studente("Davide", "Rossi", "06127003"));
    }

    @FXML
    private void openFile(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
    }

    @FXML
    private void saveFile(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        
        File file = fc.showSaveDialog(nameField.getParent().getScene().getWindow());
        
        if(file != null) {
        
            try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            
            
                for(Studente s : studenti) {
                    
                    pw.append(s.getNome() + ';');
                    pw.append(s.getCognome() + ';');
                    pw.append(s.getMatricola() + '\n');
                }
            } catch (IOException ex) {
                Logger.getLogger(MyStudentListViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void quitApp(ActionEvent event) {
        
        Platform.exit();
    }

    @FXML
    private void addStudent(ActionEvent event) {
    ObjectBinding<String> intBinding = Bindings.createObjectBinding(() -> {
    String matricola = codeField.getText();
    if(matricola != null && matricola.matches("\\d+"))
        return matricola;
    else
        return null;
    
    }
        ,codeField.textProperty()
    );
    
    if (nameField.getText() == null || surnameField.getText() == null) return;
    
        
    
        studenti.add(new Studente(nameField.getText(), surnameField.getText(),intBinding.getValue()));
    }

    @FXML
    private void removeStudent(ActionEvent event) {
        
        Studente s = studentTable.getSelectionModel().getSelectedItem();
        
        studenti.remove(s);
    }

    @FXML
    private void updateName(TableColumn.CellEditEvent<Studente, String> event) {
        
        Studente s = studentTable.getSelectionModel().getSelectedItem();
        
        s.setNome(event.getNewValue());
    }
}
