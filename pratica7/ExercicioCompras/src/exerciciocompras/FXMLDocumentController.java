/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerciciocompras;

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
    private TextField txtPesquisar;
    @FXML
    private Button btnAdd;
    @FXML
    private TableView<Compra> tableLista;
    @FXML
    private TableColumn<Compra, String> columnIndex;
    @FXML
    private TableColumn<Compra, String> columnLista;
    @FXML
    private TextField txtAdd;
    @FXML
    private TextField txtRemover;
    @FXML
    private Button btnRemover;
    @FXML
    private TextField txtModificar;
    @FXML
    private Button btnModificar;
    @FXML
    private TextField txtIndex;
    private final ListaDeCompras listaCompleta = new ListaDeCompras();
    private final ObservableList<Compra> compraData = FXCollections.observableArrayList();
    private Stage dialogStage;

    public void ButtonAdd(ActionEvent event) {
        this.Adicionar();
    }

    public void ButtonRemover(ActionEvent event) {
        this.Remover();
    }

    public void ButtonModify(ActionEvent event) {
        this.Modificar();
    }

    public void Adicionar() {
        if (txtAdd.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos Inválidos");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            listaCompleta.AddNaLista(txtAdd.getText());
            txtAdd.setText("");
            List lst = listaCompleta.getLista();
            compraData.removeAll(lst);
            for (int i = 0; i < lst.size(); i++) {
                Compra cp = (Compra) lst.get(i);
                compraData.add(cp);
            }
            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Compra> filteredData = new FilteredList<>(compraData, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(compra -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (compra.getItem().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (Integer.toString(compra.getIndice()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Compra> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(tableLista.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableLista.setItems(sortedData);
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
            compraData.clear();
            for (int i = 0; i < lst.size(); i++) {
                Compra cp = (Compra) lst.get(i);
                compraData.add(cp);
            }

            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Compra> filteredData = new FilteredList<>(compraData, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(compra -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (compra.getItem().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (Integer.toString(compra.getIndice()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Compra> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(tableLista.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableLista.setItems(sortedData);
        }
    }

    public void Modificar() {
        if (txtModificar.getText().equalsIgnoreCase("") || txtIndex.getText().equalsIgnoreCase("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Campos Inválidos");
            alert.setHeaderText("Preencha todos os campos!");
            alert.showAndWait();
        } else {
            listaCompleta.Modificar(txtModificar.getText(), Integer.valueOf(txtIndex.getText()));
            txtModificar.setText("");
            txtIndex.setText("");
            List lst = listaCompleta.getLista();
            compraData.clear();
            for (int i = 0; i < lst.size(); i++) {
                Compra cp = (Compra) lst.get(i);
                compraData.add(cp);
            }

            // 1. Wrap the ObservableList in a FilteredList (initially display all data).
            FilteredList<Compra> filteredData = new FilteredList<>(compraData, p -> true);

            // 2. Set the filter Predicate whenever the filter changes.
            txtPesquisar.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(compra -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();

                    if (compra.getItem().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    } else if (Integer.toString(compra.getIndice()).toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches last name.
                    }
                    return false; // Does not match.
                });
            });

            // 3. Wrap the FilteredList in a SortedList. 
            SortedList<Compra> sortedData = new SortedList<>(filteredData);

            // 4. Bind the SortedList comparator to the TableView comparator.
            sortedData.comparatorProperty().bind(tableLista.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tableLista.setItems(sortedData);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        columnIndex.setCellValueFactory(new PropertyValueFactory<Compra, String>("indice"));
        columnLista.setCellValueFactory(new PropertyValueFactory<Compra, String>("Item"));
        txtAdd.setOnKeyReleased(event -> {
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
        txtIndex.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                // do what is to do
                this.Modificar();
            }
        });
    }

}
