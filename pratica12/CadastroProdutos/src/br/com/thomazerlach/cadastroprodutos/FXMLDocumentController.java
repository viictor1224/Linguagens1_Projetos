/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.cadastroprodutos;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TableView<Produto> tbview;
    @FXML
    private TableColumn<Produto, Integer> tbcId;
    @FXML
    private TableColumn<Produto, String> tbcNome;
    @FXML
    private TableColumn<Produto, String> tbcDesc;
    @FXML
    private TableColumn<Produto, String> tbcMarca;
    @FXML
    private TableColumn<Produto, Double> tbcPreco;
    @FXML
    private TableColumn<Produto, Integer> tbcIdEstoque;
    @FXML
    private TextField txtNome;
    @FXML
    private TextArea txtDesc;
    @FXML
    private TextField txtMarca;
    @FXML
    private TextField txtPreco;
    @FXML
    private TextField txtIdRemover;

    private Stage dialogStage;
    private ObservableList<Produto> produtoData = FXCollections.observableArrayList();
    private Connection conexao;

    private boolean isInputValid() {
        String errorMessage = "";

        if (txtNome.getText() == null || txtNome.getText().length() == 0) {
            errorMessage += "Nome não é válido!\n";
        }
        if (txtDesc.getText() == null || txtDesc.getText().length() == 0) {
            errorMessage += "Descrição não é válida!\n";
        }
        if (txtMarca.getText() == null || txtMarca.getText().length() == 0) {
            errorMessage += "Marca não é válida!\n";
        }

        if (txtPreco.getText() == null || txtPreco.getText().length() == 0 || !txtPreco.getText().matches("^[0-9]+((\\.)?[0-9])+$")) {
            errorMessage += "Preço não é válido!\n";
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

    private boolean isRemoveInputValid() {
        String errorMessage = "";

        if (txtIdRemover.getText() == null || txtIdRemover.getText().length() == 0 || !txtIdRemover.getText().matches("^[0-9]+$")) {
            errorMessage += "Id não é válido!\n";
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

    @FXML
    private void CadastrarButtonAction(ActionEvent event) {
        if (isInputValid()) {
            conexao = ConnectionFactory.getConnection();

            String sql = "INSERT INTO tblProdutos (`nome`, `desc`, `marca`, `preco`) VALUE (?, ?, ?, ?)";

            PreparedStatement ps;

            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, txtNome.getText());
                ps.setString(2, txtDesc.getText());
                ps.setString(3, txtMarca.getText());
                ps.setDouble(4, Double.parseDouble(txtPreco.getText()));
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            conexao = ConnectionFactory.getConnection();

            sql = "SELECT idproduto FROM ecommerce.tblProdutos WHERE `nome` IN (?)";
            int id = 0;
            try {
                ps = conexao.prepareStatement(sql);
                ps.setString(1, txtNome.getText());
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    id = resultadoQuery.getInt("idproduto");
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexao = ConnectionFactory.getConnection();
            
            sql = "INSERT INTO tblEstoque (`idproduto`, `quantidade`) VALUE (?, ?)";

            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, 0);
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexao = ConnectionFactory.getConnection();

            sql = "SELECT idestoque FROM ecommerce.tblEstoque WHERE `idproduto` IN (?)";
            int idestoque = 0;
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    idestoque = resultadoQuery.getInt("idestoque");
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexao = ConnectionFactory.getConnection();
            
            sql = "UPDATE ecommerce.tblProdutos SET `idestoque`=? WHERE `idproduto`=?";
            
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, idestoque);
                ps.setInt(2, id);
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
            alert.setHeaderText("O produto foi adicionado!");
            alert.setContentText("Para ver todos os produtos, atualize a tabela!");
            alert.showAndWait();

            txtNome.setText("");
            txtDesc.setText("");
            txtMarca.setText("");
            txtPreco.setText("");
        }
    }

    @FXML
    private void RemoverButtonAction(ActionEvent event) {
        if (isRemoveInputValid()) {
            conexao = ConnectionFactory.getConnection();
            
            String sql = "DELETE FROM ecommerce.tblProdutos WHERE `idproduto`=?";
            
            PreparedStatement ps;

            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtIdRemover.getText()));
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexao = ConnectionFactory.getConnection();
            
            sql = "SELECT idestoque FROM ecommerce.tblEstoque WHERE `idproduto` IN (?)";
            int idestoque = 0;
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtIdRemover.getText()));
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    idestoque = resultadoQuery.getInt("idestoque");
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            conexao = ConnectionFactory.getConnection();
            System.out.println(idestoque);
            sql = "DELETE FROM ecommerce.tblEstoque WHERE `idestoque`=?";

            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, idestoque);
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Show the confirmation message.
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(dialogStage);
            alert.setTitle("Removido!");
            alert.setHeaderText("O produto foi Removido!");
            alert.setContentText("Para ver todos os produtos, atualize a tabela!");
            alert.showAndWait();

            txtIdRemover.setText("");
        }
    }

    @FXML
    private void AtualizaButtonAction(ActionEvent event) {
        produtoData.removeAll(produtoData);

        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tblProdutos";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                int id = resultadoQuery.getInt("idproduto");
                String nome = resultadoQuery.getString("nome");
                String desc = resultadoQuery.getString("desc");
                String marca = resultadoQuery.getString("marca");
                double preco = resultadoQuery.getDouble("preco");
                int idestoque = resultadoQuery.getInt("idestoque");

                Produto produto = new Produto(id, nome, desc, marca, preco, idestoque);
                produtoData.add(produto);
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tbview.setItems(produtoData);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tbcId.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
        tbcNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
        tbcDesc.setCellValueFactory(new PropertyValueFactory<Produto, String>("desc"));
        tbcMarca.setCellValueFactory(new PropertyValueFactory<Produto, String>("marca"));
        tbcPreco.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
        tbcIdEstoque.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("idEstoque"));
    }

}
