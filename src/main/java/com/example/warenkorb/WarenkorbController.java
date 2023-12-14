package com.example.warenkorb;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WarenkorbController {
    @FXML
    private ComboBox<String> comboBoxProducts;

    @FXML
    private TextField textFieldMenge;

    @FXML
    private Label LabelFehlermeldung;

    @FXML
    private Hyperlink WarenkorbLink;

    private List<OrderItem> orderItems;

    @FXML
    public void initialize() {
        orderItems = new ArrayList<>();
        WarenkorbLink.setOnAction(event -> navigateToBezahlenView());
        fillComboBox();
    }

    private void navigateToBezahlenView() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WarenkorbBezahlen-view.fxml"));
            Parent root = loader.load();

            WarenkorbBezahlenController bezahlenController = loader.getController();
            bezahlenController.setOrderItems(orderItems);

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void fillComboBox() {
        String connectionString = "jdbc:sqlserver://mssql1.webland.ch;encrypt=true;databaseName=d041e_blj;user=d041e_blj;password=BljDbPw_01";

        try (Connection connection = DriverManager.getConnection(connectionString)) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT product_name, price FROM products");

            while (rs.next()) {
                String productName = rs.getString("product_name");
                int productPrice = rs.getInt("price");

                String displayText = productName + " - " + productPrice + " CHF";
                comboBoxProducts.getItems().add(displayText);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void warenkorbHinzufügen() {
        String selectedProduct = comboBoxProducts.getValue();
        String mengeText = textFieldMenge.getText();

        try {
            int menge = Integer.parseInt(mengeText);
            if (menge >= 0) {
                OrderItem newItem = new OrderItem();
                newItem.setProductName(selectedProduct);
                newItem.setQuantity(menge);
                orderItems.add(newItem);

                LabelFehlermeldung.setText(menge + " " + selectedProduct + " wurde dem Warenkorb hinzugefügt!");
            } else if (menge <= 0) {
                LabelFehlermeldung.setText("Die eingegebene Menge darf nicht unter Null sein!");
            }
        } catch (NumberFormatException e) {
            LabelFehlermeldung.setText("Ungültige Eingabe für Menge!");
        }
    }
}
