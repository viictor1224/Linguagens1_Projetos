/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.thomazerlach.compraecommerce;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author thomazerlach
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Pane paneLogin;
    @FXML
    private TextField txtEmailLogin;
    @FXML
    private PasswordField txtSenhaLogin;
    @FXML
    private Pane paneCriar;
    @FXML
    private TextField txtNomeCriar;
    @FXML
    private TextField txtEmailCriar;
    @FXML
    private PasswordField txtSenhaCriar;
    @FXML
    private TextField txtCpfCriar;
    @FXML
    private TextField txtCepCriar;
    @FXML
    private TextField txtEnderecoCriar;
    @FXML
    private Pane panePrincipal;
    @FXML
    private Label lblNomeAtual;
    @FXML
    private TableView<Produtos> tbViewProdutos;
    @FXML
    private TableColumn<Produtos, Integer> tbcIdProdutos;
    @FXML
    private TableColumn<Produtos, String> tbcNomeProdutos;
    @FXML
    private TableColumn<Produtos, String> tbcDescProdutos;
    @FXML
    private TableColumn<Produtos, String> tbcMarcaProdutos;
    @FXML
    private TableColumn<Produtos, Double> tbcPrecoProdutos;
    @FXML
    private TableColumn<Produtos, Integer> tbcQuantidadeProdutos;
    @FXML
    private TextField txtIdProdutos;
    @FXML
    private TextField txtQuantidadeProdutos;
    @FXML
    private Label lblTotalCarrinho;
    @FXML
    private TableView<Carrinho> tbViewCarrinho;
    @FXML
    private TableColumn<Carrinho, Integer> tcIdCarrinho;
    @FXML
    private TableColumn<Carrinho, String> tcNomeCarrinho;
    @FXML
    private TableColumn<Carrinho, Integer> tcQuantidadeCarrinho;
    @FXML
    private TableColumn<Carrinho, Double> tcPrecoCarrinho;
    @FXML
    private TableColumn<Carrinho, Double> tcTotalCarrinho;
    @FXML
    private TextField txtIdCarrinho;
    @FXML
    private TextField txtQuantidadeCarrinho;
    @FXML
    private TableView<Pedidos> tbViewPedidos;
    @FXML
    private TableColumn<Pedidos, Integer> tcIdPedidos;
    @FXML
    private TableColumn<Pedidos, String> tcDataPedidos;
    @FXML
    private TableColumn<Pedidos, Double> tcTotalPedidos;
    @FXML
    private TableColumn<Pedidos, String> tcStatusPedidos;
    @FXML
    private TextField txtIdPedidos;
    @FXML
    private TableView<Detalhes> tbViewDetalhes;
    @FXML
    private TableColumn<Detalhes, Integer> tcIdDetalhes;
    @FXML
    private TableColumn<Detalhes, String> tcNomeDetalhes;
    @FXML
    private TableColumn<Detalhes, Integer> tcQuantidadeDetalhes;
    @FXML
    private TableColumn<Detalhes, Double> tcPrecoDetalhes;
    @FXML
    private TableColumn<Detalhes, Double> tcTotalDetalhes;
    @FXML
    private Label lbTotalPedidos;

    private Stage dialogStage;
    private ObservableList<Produtos> produtosData = FXCollections.observableArrayList();
    private ObservableList<Carrinho> carrinhoData = FXCollections.observableArrayList();
    private ObservableList<Pedidos> pedidosData = FXCollections.observableArrayList();
    private ObservableList<Detalhes> detalhesData = FXCollections.observableArrayList();
    private Connection conexao;

    private int idUsuarioAtual;
    private double totalCarrinho;

    private boolean isInputValidLogin() {
        String errorMessage = "";

        if (txtEmailLogin.getText() == null || txtEmailLogin.getText().length() == 0 || !txtEmailLogin.getText().matches("^[0-9a-zA-Z\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$")) {
            errorMessage += "Email não é válido!\n";
        }

        if (txtSenhaLogin.getText() == null || txtSenhaLogin.getText().length() == 0) {
            errorMessage += "Digite uma senha!\n";
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
    private void LoginCriarButtonAction(ActionEvent event) {
        paneLogin.setVisible(false);
        txtEmailLogin.setText("");
        txtSenhaLogin.setText("");
        paneCriar.setVisible(true);
    }

    @FXML
    private void LoginButtonAction(ActionEvent event) {
        if (isInputValidLogin()) {
            conexao = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM tblUsuarios";
            PreparedStatement ps;
            Boolean found = false;
            try {
                ps = conexao.prepareStatement(sql);
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    int id = resultadoQuery.getInt("idusuarios");
                    String nome = resultadoQuery.getString("nome");
                    String email = resultadoQuery.getString("email");
                    String senha = resultadoQuery.getString("senha");

                    if (txtEmailLogin.getText().equals(email) && txtSenhaLogin.getText().equals(senha)) {
                        paneLogin.setVisible(false);
                        idUsuarioAtual = id;
                        lblNomeAtual.setText("Olá, " + nome + "!");
                        txtEmailLogin.setText("");
                        txtSenhaLogin.setText("");
                        panePrincipal.setVisible(true);
                        found = true;
                        break;
                    }
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!found) {
                // Show the error message.
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(dialogStage);
                alert.setTitle("Failed");
                alert.setHeaderText("Please correct invalid fields");
                alert.setContentText("Email or password incorrect/not found!");

                alert.showAndWait();
            }
        }
    }

    @FXML
    private void CancelarCriarButtonAction(ActionEvent event) {
        paneCriar.setVisible(false);
        txtNomeCriar.setText("");
        txtEmailCriar.setText("");
        txtSenhaCriar.setText("");
        txtCpfCriar.setText("");
        txtCepCriar.setText("");
        txtEnderecoCriar.setText("");
        paneLogin.setVisible(true);
    }

    private boolean isInputValidCriar() {
        String errorMessage = "";

        if (txtNomeCriar.getText() == null || txtNomeCriar.getText().length() == 0) {
            errorMessage += "Digite um nome!\n";
        }

        if (txtEmailCriar.getText() == null || txtEmailCriar.getText().length() == 0 || !txtEmailCriar.getText().matches("^[0-9a-zA-Z\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$")) {
            errorMessage += "Email não é válido!\n";
        }

        if (txtSenhaCriar.getText() == null || txtSenhaCriar.getText().length() == 0 || !txtSenhaCriar.getText().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).{4,}$")) {
            errorMessage += "A senha deve conter maiusculas, minusculas, digito e simbolos!\n";
        }

        if (txtCpfCriar.getText() == null || txtCpfCriar.getText().length() == 0 || !txtCpfCriar.getText().matches("^([0-9]{3}\\.){2}[0-9]{3}-[0-9]{2}$")) {
            errorMessage += "CPF não é válido!\n";
        }

        if (txtCepCriar.getText() == null || txtCepCriar.getText().length() == 0 || !txtCepCriar.getText().matches("^[0-9]{5}-[0-9]{3}$")) {
            errorMessage += "CEP não é válido!\n";
        }

        if (txtEnderecoCriar.getText() == null || txtEnderecoCriar.getText().length() == 0) {
            errorMessage += "Endereço não é válido!\n";
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
    private void CriarContaButtonAction(ActionEvent event) {
        if (isInputValidCriar()) {
            conexao = ConnectionFactory.getConnection();

            String sql = "SELECT * FROM tblUsuarios";
            PreparedStatement ps;
            Boolean found = false;
            try {
                ps = conexao.prepareStatement(sql);
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    String email = resultadoQuery.getString("email");
                    String cpf = resultadoQuery.getString("cpf");

                    if (txtEmailCriar.getText().equals(email) || txtCpfCriar.getText().equals(cpf)) {
                        found = true;
                        // Show the error message.
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.initOwner(dialogStage);
                        alert.setTitle("Failed");
                        alert.setHeaderText("Please correct invalid fields");
                        alert.setContentText("Email ou cpf já cadastrados!");

                        alert.showAndWait();
                        break;
                    }
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (!found) {
                conexao = ConnectionFactory.getConnection();

                sql = "INSERT INTO tblUsuarios (`nome`, `email`, `senha`, `cpf`, `cep`, `endereco`) VALUE (?, ?, ?, ?, ?, ?)";

                try {
                    ps = conexao.prepareStatement(sql);
                    ps.setString(1, txtNomeCriar.getText());
                    ps.setString(2, txtEmailCriar.getText());
                    ps.setString(3, txtSenhaCriar.getText());
                    ps.setString(4, txtCpfCriar.getText());
                    ps.setString(5, txtCepCriar.getText());
                    ps.setString(6, txtEnderecoCriar.getText());
                    ps.execute();
                    ps.close();
                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                paneCriar.setVisible(false);
                txtNomeCriar.setText("");
                txtEmailCriar.setText("");
                txtSenhaCriar.setText("");
                txtCpfCriar.setText("");
                txtCepCriar.setText("");
                txtEnderecoCriar.setText("");
                paneLogin.setVisible(true);

                // Show the error message.
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.initOwner(dialogStage);
                alert.setTitle("Sucess!");
                alert.setHeaderText("Account created!");
                alert.setContentText("Conta criada com sucesso!");

                alert.showAndWait();
            }
        }
    }

    @FXML
    private void SairButtonAction(ActionEvent event) {
        panePrincipal.setVisible(false);
        lblNomeAtual.setText("Olá, visitante!");
        carrinhoData.removeAll(carrinhoData);
        tbViewCarrinho.setItems(carrinhoData);
        totalCarrinho = 0;
        lblTotalCarrinho.setText("Total do Carrinho: " + totalCarrinho);
        idUsuarioAtual = 0;
        paneLogin.setVisible(true);
    }

    @FXML
    private void AtualizarProdutosButtonAction(ActionEvent event) {
        produtosData.removeAll(produtosData);

        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT p.idproduto, p.nome, p.desc, p.marca, p.preco, e.quantidade FROM tblProdutos AS p JOIN tblEstoque AS e ON p.idestoque = e.idestoque";
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
                int quant = resultadoQuery.getInt("quantidade");

                Produtos produto = new Produtos(id, nome, desc, marca, preco, quant);
                produtosData.add(produto);
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tbViewProdutos.setItems(produtosData);
    }

    private boolean isInputValidAdd() {
        String errorMessage = "";

        if (txtIdProdutos.getText() == null || txtIdProdutos.getText().length() == 0 || !txtIdProdutos.getText().matches("^[0-9]+$")) {
            errorMessage += "Id não é válido!\n";
        }

        if (txtQuantidadeProdutos.getText() == null || txtQuantidadeProdutos.getText().length() == 0 || !txtQuantidadeProdutos.getText().matches("^[0-9]+$")) {
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

    @FXML
    private void AddCarinhoButtonAction(ActionEvent event) {
        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT p.idproduto, p.nome, p.preco, e.quantidade FROM tblProdutos AS p JOIN tblEstoque AS e ON p.idestoque = e.idestoque WHERE p.idproduto=?";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtIdProdutos.getText()));
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                int id = resultadoQuery.getInt("idproduto");
                String nome = resultadoQuery.getString("nome");
                double preco = resultadoQuery.getDouble("preco");
                int quant = resultadoQuery.getInt("quantidade");

                if (quant >= Integer.parseInt(txtQuantidadeProdutos.getText())) {
                    double total = preco * Integer.parseInt(txtQuantidadeProdutos.getText());

                    Carrinho carrinho = new Carrinho(id, nome, Integer.parseInt(txtQuantidadeProdutos.getText()), preco, total);

                    boolean exist = false;

                    for (Carrinho next : carrinhoData) {
                        if (next.getId() == carrinho.getId()) {
                            exist = true;
                        }
                    }

                    if (exist) {
                        // Show the error message.
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.initOwner(dialogStage);
                        alert.setTitle("Invalid Fields");
                        alert.setHeaderText("Please correct invalid fields");
                        alert.setContentText("Item já existente!");

                        alert.showAndWait();
                        break;
                    } else {
                        totalCarrinho += total;
                        lblTotalCarrinho.setText(String.format("Total do Carrinho: %.2f", totalCarrinho));
                        txtIdProdutos.setText("");
                        txtQuantidadeProdutos.setText("");
                        carrinhoData.add(carrinho);
                        tbViewCarrinho.setItems(carrinhoData);
                        // Show the error message.
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(dialogStage);
                        alert.setTitle("Sucess!");
                        alert.setHeaderText("The item was added to the cart!");
                        alert.setContentText("Produto adicionado no carrinho!");

                        alert.showAndWait();
                    }
                } else {
                    // Show the error message.
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Invalid Fields");
                    alert.setHeaderText("Please correct invalid fields");
                    alert.setContentText("Quantidade maior que o estoque!");

                    alert.showAndWait();
                    break;
                }
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private boolean isInputValidRemove() {
        String errorMessage = "";

        if (txtIdCarrinho.getText() == null || txtIdCarrinho.getText().length() == 0 || !txtIdCarrinho.getText().matches("^[0-9]+$")) {
            errorMessage += "Id não é válido!\n";
        }

        if (txtQuantidadeCarrinho.getText() == null || txtQuantidadeCarrinho.getText().length() == 0 || !txtQuantidadeCarrinho.getText().matches("^[0-9]+$")) {
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

    @FXML
    private void RemoverCarrinhoButtonAction(ActionEvent event) {
        if (isInputValidRemove()) {
            for (Carrinho next : carrinhoData) {
                if (next.getId() == Integer.parseInt(txtIdCarrinho.getText())) {
                    int newQuant = next.getQuant() - Integer.parseInt(txtQuantidadeCarrinho.getText());
                    if (newQuant <= 0) {
                        totalCarrinho -= next.getTotal();
                        lblTotalCarrinho.setText(String.format("Total do Carrinho: %.2f", totalCarrinho));
                        txtIdCarrinho.setText("");
                        txtQuantidadeCarrinho.setText("");
                        // Show the error message.
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(dialogStage);
                        alert.setTitle("Sucess!");
                        alert.setHeaderText("The item was removed!");
                        alert.setContentText("O item foi removido!");

                        alert.showAndWait();
                        carrinhoData.remove(next);
                    } else {
                        int indexCarrinho = carrinhoData.indexOf(next);
                        totalCarrinho -= next.getTotal();
                        double newTotal = next.getPreco() * newQuant;
                        totalCarrinho += newTotal;
                        lblTotalCarrinho.setText(String.format("Total do Carrinho: %.2f", totalCarrinho));
                        next.setQuant(newQuant);
                        next.setTotal(newTotal);
                        carrinhoData.set(indexCarrinho, next);
                    }
                    tbViewCarrinho.setItems(carrinhoData);
                    txtIdCarrinho.setText("");
                    txtQuantidadeCarrinho.setText("");
                    // Show the error message.
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.initOwner(dialogStage);
                    alert.setTitle("Sucess!");
                    alert.setHeaderText("The item was removed!");
                    alert.setContentText("O item foi removido!");

                    alert.showAndWait();
                }
            }
        }
    }

    @FXML
    private void RemoverTudoCarrinhoButtonAction(ActionEvent event) {
        carrinhoData.removeAll(carrinhoData);
        totalCarrinho = 0;
        lblTotalCarrinho.setText(String.format("Total do Carrinho: %.2f", totalCarrinho));
        tbViewCarrinho.setItems(carrinhoData);
        // Show the error message.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Sucess!");
        alert.setHeaderText("The cart is empty!");
        alert.setContentText("O carrinho está vazio!");

        alert.showAndWait();
    }

    @FXML
    private void FinalizarCompraButtonAction(ActionEvent event) {
        conexao = ConnectionFactory.getConnection();

        String sql = "INSERT INTO tblPedidos (`idusuario`, `data`, `total`, `status`) VALUE (?, ?, ?, ?)";

        PreparedStatement ps;
        String dataDoPedido = ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, idUsuarioAtual);
            ps.setString(2, dataDoPedido);
            ps.setDouble(3, totalCarrinho);
            ps.setString(4, "Finalizado");
            ps.execute();
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexao = ConnectionFactory.getConnection();

        sql = "SELECT idpedido FROM ecommerce.tblPedidos WHERE `data` IN (?)";
        int id = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, dataDoPedido);
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                id = resultadoQuery.getInt("idpedido");
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Carrinho next : carrinhoData) {
            conexao = ConnectionFactory.getConnection();

            sql = "INSERT INTO tbl_Pedido_Produto (`idpedido`, `idproduto`, `quant`, `preco_unit`, `total`) VALUE (?, ?, ?, ?, ?)";

            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, next.getId());
                ps.setInt(3, next.getQuant());
                ps.setDouble(4, next.getPreco());
                ps.setDouble(5, next.getTotal());
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            conexao = ConnectionFactory.getConnection();

            sql = "SELECT quantidade FROM ecommerce.tblEstoque WHERE `idproduto` IN (?);";

            int quantAtual = 0;
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, next.getId());
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    quantAtual = resultadoQuery.getInt("quantidade");
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            quantAtual -= next.getQuant();

            conexao = ConnectionFactory.getConnection();

            sql = "UPDATE ecommerce.tblEstoque SET `quantidade`=? WHERE `idproduto`=?";

            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, quantAtual);
                ps.setInt(2, next.getId());
                ps.execute();
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        carrinhoData.removeAll(carrinhoData);
        totalCarrinho = 0;
        lblTotalCarrinho.setText(String.format("Total do Carrinho: %.2f", totalCarrinho));
        tbViewCarrinho.setItems(carrinhoData);
        // Show the confirmation message.
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.initOwner(dialogStage);
        alert.setTitle("Finalizado!");
        alert.setHeaderText("O pedido foi finalizado!");
        alert.setContentText("Para ver todos os pedidos, atualize a tabela de pedidos!");
        alert.showAndWait();
    }

    @FXML
    private void AtualizarPedidosButtonAction(ActionEvent event) {
        pedidosData.removeAll(pedidosData);

        conexao = ConnectionFactory.getConnection();

        String sql = "SELECT * FROM tblPedidos WHERE `idusuario` IN (?)";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, idUsuarioAtual);
            ResultSet resultadoQuery = ps.executeQuery();

            while (resultadoQuery.next()) {
                int id = resultadoQuery.getInt("idpedido");
                String data = resultadoQuery.getString("data");
                double total = resultadoQuery.getDouble("total");
                String status = resultadoQuery.getString("status");

                Pedidos pedido = new Pedidos(id, data, total, status);
                pedidosData.add(pedido);
            }
            ps.close();
            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

        tbViewPedidos.setItems(pedidosData);
    }

    private boolean isInputValidPedido() {
        String errorMessage = "";

        if (txtIdPedidos.getText() == null || txtIdPedidos.getText().length() == 0 || !txtIdPedidos.getText().matches("^[0-9]+$")) {
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
    private void VisualizarPedidosButtonAction(ActionEvent event) {
        if (isInputValidPedido()) {
            detalhesData.removeAll(detalhesData);

            conexao = ConnectionFactory.getConnection();

            String sql = "SELECT pp.idproduto, p.nome, pp.quant, pp.preco_unit, pp.total FROM ecommerce.tbl_Pedido_Produto AS pp JOIN tblProdutos AS p ON p.idproduto = pp.idproduto WHERE `idpedido` IN (?)";
            PreparedStatement ps;
            double totalPedido = 0;
            try {
                ps = conexao.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(txtIdPedidos.getText()));
                ResultSet resultadoQuery = ps.executeQuery();

                while (resultadoQuery.next()) {
                    int id = resultadoQuery.getInt("idproduto");
                    String nome = resultadoQuery.getString("nome");
                    int quant = resultadoQuery.getInt("quant");
                    double preco = resultadoQuery.getDouble("preco_unit");
                    double total = resultadoQuery.getDouble("total");
                    
                    totalPedido += total;
                    Detalhes detalhe = new Detalhes(id, nome, quant, preco, total);
                    detalhesData.add(detalhe);
                }
                ps.close();
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            lbTotalPedidos.setText(String.format("Total do Pedido: %.2f", totalPedido));
            txtIdPedidos.setText("");
            tbViewDetalhes.setItems(detalhesData);
        }
    }

    @FXML
    private void GerarNotaButtonAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Produtos
        tbcIdProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, Integer>("id"));
        tbcNomeProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, String>("nome"));
        tbcDescProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, String>("desc"));
        tbcMarcaProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, String>("marca"));
        tbcPrecoProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, Double>("preco"));
        tbcQuantidadeProdutos.setCellValueFactory(new PropertyValueFactory<Produtos, Integer>("quant"));
        //Carrinho
        tcIdCarrinho.setCellValueFactory(new PropertyValueFactory<Carrinho, Integer>("id"));
        tcNomeCarrinho.setCellValueFactory(new PropertyValueFactory<Carrinho, String>("nome"));
        tcQuantidadeCarrinho.setCellValueFactory(new PropertyValueFactory<Carrinho, Integer>("quant"));
        tcPrecoCarrinho.setCellValueFactory(new PropertyValueFactory<Carrinho, Double>("preco"));
        tcTotalCarrinho.setCellValueFactory(new PropertyValueFactory<Carrinho, Double>("total"));
        //Pedidos
        tcIdPedidos.setCellValueFactory(new PropertyValueFactory<Pedidos, Integer>("id"));
        tcDataPedidos.setCellValueFactory(new PropertyValueFactory<Pedidos, String>("data"));
        tcTotalPedidos.setCellValueFactory(new PropertyValueFactory<Pedidos, Double>("total"));
        tcStatusPedidos.setCellValueFactory(new PropertyValueFactory<Pedidos, String>("status"));
        //Detalhes
        tcIdDetalhes.setCellValueFactory(new PropertyValueFactory<Detalhes, Integer>("id"));
        tcNomeDetalhes.setCellValueFactory(new PropertyValueFactory<Detalhes, String>("nome"));
        tcQuantidadeDetalhes.setCellValueFactory(new PropertyValueFactory<Detalhes, Integer>("quant"));
        tcPrecoDetalhes.setCellValueFactory(new PropertyValueFactory<Detalhes, Double>("preco"));
        tcTotalDetalhes.setCellValueFactory(new PropertyValueFactory<Detalhes, Double>("total"));
    }

}
