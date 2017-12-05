/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package celular;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Contato> tableContato;
    @FXML
    private TableColumn<Contato, String> columnNome;
    @FXML
    private TableColumn<Contato, String> columnNumero;
    @FXML
    private TextField txtPesquisar;
    @FXML
    private TextField txtAdicionar;
    @FXML
    private TextField txtRemover;
    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnRemover;
    @FXML
    private TextField txtNumero;
    private final ListaDeContatos listaCompleta = new ListaDeContatos();
    private final ObservableList<Contato> contatoData = FXCollections.observableArrayList();
    private Stage dialogStage;

    public void ButtonAdd(ActionEvent event) {
        this.Adicionar();
    }

    public void ButtonRemover(ActionEvent event) {
        this.Remover();
    }

    public void Adicionar() {
        if (txtNumero.getText().equalsIgnoreCase("") || txtAdicionar.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos Inválidos");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            listaCompleta.AddNaLista(txtAdicionar.getText(), txtNumero.getText());
            txtAdicionar.setText("");
            txtNumero.setText("");
            List lst = listaCompleta.getLista();
            contatoData.clear();
            for (int i = 0; i < lst.size(); i++) {
                Contato ct = (Contato) lst.get(i);
                contatoData.add(ct);
            }
            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Contato> filteredData = new FilteredList<>(contatoData, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(contato -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (contato.getNome().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (contato.getNumero().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Contato> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(tableContato.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableContato.setItems(sortedData);
        }
    }

    public void Remover() {
        if (txtRemover.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos Inválidos");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            listaCompleta.Remover(txtRemover.getText());
            txtRemover.setText("");
            List lst = listaCompleta.getLista();
            contatoData.clear();
            for (int i = 0; i < lst.size(); i++) {
                Contato ct = (Contato) lst.get(i);
                contatoData.add(ct);
            }

            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Contato> filteredData = new FilteredList<>(contatoData, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(contato -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (contato.getNome().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (contato.getNumero().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Contato> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(tableContato.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableContato.setItems(sortedData);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnNome.setCellValueFactory(new PropertyValueFactory<Contato, String>("nome"));
        columnNumero.setCellValueFactory(new PropertyValueFactory<Contato, String>("numero"));
        txtNumero.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // do what is to do
                this.Adicionar();
            }
        });
        txtRemover.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // do what is to do
                this.Remover();
            }
        });
    }

}
