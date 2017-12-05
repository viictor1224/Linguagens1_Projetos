/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroaluno;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private ImageView imgPerfil;
    
    @FXML private TextField txtNome;
    @FXML private TextField txtIdade;
    @FXML private TextField txtEnd;
    @FXML private TextField txtRg;
    @FXML private TextField txtCpf;
    @FXML private TextField txtPesquisa;
    
    @FXML
    private Label fileSelected;
    
    private Person aluno;
    private Stage dialogStage;
    private String imageFile;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnEscolher;
    @FXML
    private MenuItem btnSaveAll;
    @FXML
    private Button btnAtualizar;
    @FXML
    private MenuItem btnLoad;
    @FXML
    private TableColumn<Person, String> cellNome;
    @FXML
    private TableColumn<Person, String> cellIdade;
    @FXML
    private TableColumn<Person, String> cellEnd;
    @FXML
    private TableColumn<Person, String> cellRg;
    @FXML
    private TableColumn<Person, String> cellCpf;
    @FXML
    private TableView<Person> tableAlunos;

    @FXML
    private void escolherButtonAction(ActionEvent event) throws MalformedURLException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Image File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif")); // limit fileChooser options to image files
        File selectedFile = fileChooser.showOpenDialog(fileSelected.getScene().getWindow());

        if (selectedFile != null) {

            imageFile = selectedFile.toURI().toURL().toString();

            Image image = new Image(imageFile);
            imgPerfil.setImage(image);
        } else {
            fileSelected.setText("Image file selection cancelled.");
        }

    }
    
    @FXML
    private void SalvarNoArquivo(ActionEvent event) {
        String fileName = null;
        Boolean salvado = false;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files","*.csv")); // limit fileChooser options
        File selectedFile = fileChooser.showSaveDialog(fileSelected.getScene().getWindow());

        if (selectedFile != null) {

            fileName = selectedFile.getPath();
        } else {
            fileSelected.setText("File selection cancelled.");
        }
        salvado = CsvFileWriter.writeCsvFile(fileName);
        if (salvado) {
            
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Salvo!");
            alert.setHeaderText("O arquivo foi salvo!");

            alert.showAndWait();
        } else {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Erro!");
            alert.setHeaderText("O arquivo não pôde ser salvo!");

            alert.showAndWait();
        
        }
    }
    
    @FXML
    private void LoadDoArquivo(ActionEvent event) {
        String fileName = null;
        Boolean loaded = false;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select .csv file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files","*.csv")); // limit fileChooser options
        File selectedFile = fileChooser.showOpenDialog(fileSelected.getScene().getWindow());

        if (selectedFile != null) {

            fileName = selectedFile.getPath();
        } else {
            fileSelected.setText("File selection cancelled.");
        }
        loaded = CsvFileWriter.readCsvFile(fileName);
        if (loaded) {
            
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Carregado!");
            alert.setHeaderText("O arquivo foi carregado com sucesso!");

            alert.showAndWait();
        } else {
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Erro!");
            alert.setHeaderText("O arquivo não pôde ser carregado!");

            alert.showAndWait();
        
        }
    }
    
    @FXML
    private void salvarButtonAction(ActionEvent event) {
        if(isInputValid()) {
            aluno = new Person();
            aluno.setNome(txtNome.getText());
            aluno.setIdade(txtIdade.getText());
            aluno.setEndereco(txtEnd.getText());
            aluno.setRg(txtRg.getText());
            aluno.setCpf(txtCpf.getText());
            
            CsvFileWriter.addToList(aluno);
            
            // Show the error message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Adicionado!");
            alert.setHeaderText("O aluno foi adicionado!");
            alert.setContentText("Lembre-se de salvar o arquivo!");
            alert.showAndWait();
            
            txtNome.setText("");
            txtIdade.setText("");
            txtEnd.setText("");
            txtRg.setText("");
            txtCpf.setText("");
        }
    }
    
    private boolean isInputValid() {
        String errorMessage = "";

        if (txtNome.getText() == null || txtNome.getText().length() == 0) {
            errorMessage += "Nome não é válido!\n"; 
        }
        if (txtIdade.getText() == null || txtIdade.getText().length() == 0) {
            errorMessage += "Idade não é válido!\n"; 
        }
        if (txtEnd.getText() == null || txtEnd.getText().length() == 0) {
            errorMessage += "Endereço não é válido!\n"; 
        }

        if (txtRg.getText() == null || txtRg.getText().length() == 0 || !txtRg.getText().matches("^[0-9]{2}(\\.[0-9]{3}){2}-([0-9]|X)$")) {
            errorMessage += "RG não é válido!\n"; 
        } 

        if (txtCpf.getText() == null || txtCpf.getText().length() == 0 || !txtCpf.getText().matches("^([0-9]{3}\\.){2}[0-9]{3}-[0-9]{2}$")) {
            errorMessage += "CPF não é válido!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();
            
            return false;
        }
    }
    
    @FXML
    private void atualizarButton(ActionEvent event) {
        List alnos = CsvFileWriter.getAlunos();
        personData.removeAll(alnos);
        for (int i = 0; i < alnos.size(); i++) {
            Person ps = new Person();
            ps = (Person) alnos.get(i);
            personData.add(ps);
        }
        // 1. Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Person> filteredData = new FilteredList<>(personData, p -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        txtPesquisa.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getNome().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                } else if (person.getIdade().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getEndereco().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getRg().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                } else if (person.getCpf().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Person> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tableAlunos.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableAlunos.setItems(sortedData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cellNome.setCellValueFactory(new PropertyValueFactory<Person, String>("Nome"));
        cellIdade.setCellValueFactory(new PropertyValueFactory<Person, String>("Idade"));
        cellEnd.setCellValueFactory(new PropertyValueFactory<Person, String>("Endereco"));
        cellRg.setCellValueFactory(new PropertyValueFactory<Person, String>("Rg"));
        cellCpf.setCellValueFactory(new PropertyValueFactory<Person, String>("Cpf"));
    }

}
