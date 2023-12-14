package com.example.warenkorb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.List;

public class WarenkorbBezahlenController {
    @FXML
    public TextArea textAreaOrderDetails;

    @FXML
    private Stage stage;

    @FXML
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private List<OrderItem> orderItems;

    @FXML
    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        displayOrderDetails();
    }
    @FXML
    private void displayOrderDetails() {
        if (orderItems != null) {
            StringBuilder details = new StringBuilder();
            for (OrderItem item : orderItems) {
                details.append(item.getProductName())
                        .append(" - ").append(item.getQuantity()).append(" Stück ")
                        .append("\n");
            }
            textAreaOrderDetails.setText(details.toString());
        }
    }

    @FXML
    public void Warenkorbschliesen(ActionEvent actionEvent) {
        if (stage != null) {
            stage.close();
        }
    }
}
