package com.example.warenkorb;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class WarenkorbController {
    OrderItem i = new OrderItem();
    @FXML
    private ComboBox<String> comboBoxProducts;

    @FXML
    public void initialize() {
        fillComboBox();
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
}