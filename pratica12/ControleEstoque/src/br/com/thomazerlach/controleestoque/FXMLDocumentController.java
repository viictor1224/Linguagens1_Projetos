/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.controleestoque;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtQuantidade;
    @FXML
    private TableView<Estoque> tbView;
    @FXML
    private TableColumn<Estoque, Integer> tbcId;
    @FXML
    private TableColumn<Estoque, String> tbcNome;
    @FXML
    private TableColumn<Estoque, String> tbcMarca;
    @FXML
    private TableColumn<Estoque, Integer> tbcQuantidade;

    private Stage dialogStage;
    private ObservableList<Estoque> estoqueData = FXCollections.observableArrayList();
    private Connection conexao;
    private int quantNova;

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtId.getText() == null || txtId.getText().length() == 0 || !txtId.getText().matches("^[0-9]+$")) {
            errorMessage += "Id não é válido!\n";
        }

        if (txtQuantidade.getText() == null || txtQuantidade.getText().length() == 0 || !txtQuantidade.getText().matches("^[0-9]+$")) {
            errorMessage += "Quantidade não é válida!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    private int getQuantidadeAtual() {
        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT quantidade FROM ecommerce.tblEstoque WHERE `idproduto` IN (?);";
        
        PreparedStatement ps;
        int quantAtual = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                quantAtual = resultadoQuery.getInt("quantidade");
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return quantAtual;
    }

    @FXML
    private void AddButtonAction(ActionEvent event) {
        if (isInputValid()){
            quantNova = getQuantidadeAtual();
            
            quantNova = quantNova + Integer.parseInt(txtQuantidade.getText());
            
            conexao = ConnectionFactory.getConnection();
            
            String sql = "UPDATE ecommerce.tblEstoque SET `quantidade`=? WHERE `idproduto`=?";
            
            PreparedStatement ps;
            
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, quantNova);
                ps.setInt(2, Integer.parseInt(txtId.getText()));
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Show the confirmation message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Adicionado!");
            alert.setHeaderText("A quantidade foi alterada!");
            alert.setContentText("Para ver todos os produtos, atualize a tabela!");
            alert.showAndWait();

            txtId.setText("");
            txtQuantidade.setText("");
        }
    }

    @FXML
    private void RemoveButtonAction(ActionEvent event) {
        if (isInputValid()){
            quantNova = getQuantidadeAtual();
            
            quantNova = quantNova - Integer.parseInt(txtQuantidade.getText());
            
            if (quantNova <= 0)
                quantNova = 0;
            
            conexao = ConnectionFactory.getConnection();
            
            String sql = "UPDATE ecommerce.tblEstoque SET `quantidade`=? WHERE `idproduto`=?";
            
            PreparedStatement ps;
            
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, quantNova);
                ps.setInt(2, Integer.parseInt(txtId.getText()));
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Show the confirmation message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Adicionado!");
            alert.setHeaderText("A quantidade foi alterada!");
            alert.setContentText("Para ver todos os produtos, atualize a tabela!");
            alert.showAndWait();

            txtId.setText("");
            txtQuantidade.setText("");
        }
    }

    @FXML
    private void UpdateButtonAction(ActionEvent event) {
        estoqueData.removeAll(estoqueData);

        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT p.idproduto, p.nome, p.marca, e.quantidade FROM tblProdutos AS p JOIN tblEstoque AS e ON p.idestoque = e.idestoque";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                int id = resultadoQuery.getInt("idproduto");
                String nome = resultadoQuery.getString("nome");
                String marca = resultadoQuery.getString("marca");
                int quant = resultadoQuery.getInt("quantidade");

                Estoque estoque = new Estoque(id, nome, marca, quant);
                estoqueData.add(estoque);
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tbView.setItems(estoqueData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcId.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("id"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<Estoque, String>("nome"));
        tbcMarca.setCellValueFactory(new PropertyValueFactory<Estoque, String>("marca"));
        tbcQuantidade.setCellValueFactory(new PropertyValueFactory<Estoque, Integer>("quant"));
    }

}
