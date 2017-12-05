/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.CadastroAluno;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @FXML
    private ImageView imgPerfil;

    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIdade;
    @FXML
    private TextField txtEnd;
    @FXML
    private TextField txtRg;
    @FXML
    private TextField txtCpf;
    @FXML
    private TextField txtPesquisa;

    @FXML
    private Label fileSelected;
    @FXML
    private Label lblStatus;

    private Person aluno;
    private Stage dialogStage;
    private String imageFile;
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    private Connection conexao;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnEscolher;
    @FXML
    private Button btnAtualizar;
    @FXML
    private Button btnLimpar;
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
    private void LimparButtonAction(ActionEvent event) {
        imageFile = "";
        Image image = new Image("file:/Users/thomazerlach/Documents/GitHub/Thomaz_15.03671-5/Linguagens1_projetos/pratica11/CadastroAluno/src/br/com/thomazerlach/CadastroAluno/DefaultUser.jpg");
        imgPerfil.setImage(image);
    }

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
    private void salvarButtonAction(ActionEvent event) {
        if (isInputValid()) {
            Connection conexao = ConnectionFactory.getConnection();

            //String sql = "INSERT INTO tblalunos (`nome`,`idade`,`ra`) VALUE ('Mario', 15, '0000031')";
            String sql = "INSERT INTO cadastro (`nome`,`idade`,`endereco`, `rg`, `cpf`, `foto`) VALUE (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps;

            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, txtNome.getText());
                ps.setInt(2, Integer.parseInt(txtIdade.getText()));
                ps.setString(3, txtEnd.getText());
                ps.setString(4, txtRg.getText());
                ps.setString(5, txtCpf.getText());
                ps.setString(6, imageFile);
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) { 
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            lblStatus.setText("Salvo!");
            // Show the confirmation message.
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Adicionado!");
            alert.setHeaderText("O aluno foi adicionado!");
            alert.setContentText("Para ver todos os alunos, atualize a tabela!");
            alert.showAndWait();

            txtNome.setText("");
            txtIdade.setText("");
            txtEnd.setText("");
            txtRg.setText("");
            txtCpf.setText("");
            imageFile = "";
            Image image = new Image("file:/Users/thomazerlach/Documents/GitHub/Thomaz_15.03671-5/Linguagens1_projetos/pratica11/CadastroAluno/src/br/com/thomazerlach/CadastroAluno/DefaultUser.jpg");
            imgPerfil.setImage(image);
        } else {
            lblStatus.setText("Corrija os campos");
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
        
        if (imageFile == null || imageFile.length() == 0) {
            errorMessage += "Adicione uma foto!";
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
        personData.removeAll(personData);
        lblStatus.setText("Atualizado!");
        
        // TODO code application logic here
        Connection conexao = ConnectionFactory.getConnection();
        
        //String sql = "INSERT INTO 'alunosTeste', 'tblalunos' (nome, idade, ra)"
        String sql = "SELECT * FROM cadastro";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();
            
            while (resultadoQuery.next()) {
                String nome = resultadoQuery.getString("nome");
                int idade = resultadoQuery.getInt("idade");
                String end = resultadoQuery.getString("endereco");
                String rg = resultadoQuery.getString("rg");
                String cpf = resultadoQuery.getString("cpf");
                
                Person person = new Person(nome, String.valueOf(idade), end, rg, cpf);
                personData.add(person);
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
