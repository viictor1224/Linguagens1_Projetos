/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastraraluno;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

/**
 *
 * @author Aluno 13
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private Tab tabCadastrarAluno;
    @FXML
    private Button btnSalvar;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtIdade;
    @FXML
    private TextField txtRg;
    @FXML
    private TextField txtEndereço;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label lblNome;
    @FXML
    private Label lblIdade;
    @FXML
    private Label lblEndereço;
    @FXML
    private Label lblRg;
    @FXML
    private Label lblCpf;
    @FXML
    private Tab tabPesquisar;
    private String nome;
    private String idade;
    private String endereco;
    private String rg;
    private String cpf;
    

    @FXML
    private void cliqueBotao(ActionEvent event) {
         nome = txtNome.getText();
         idade = txtIdade.getText();
         endereco = txtEndereço.getText();
         rg = txtRg.getText();
         cpf = txtCpf.getText();
    
    }

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
