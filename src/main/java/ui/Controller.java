package ui;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.DistributionCenter;
import model.Order;
import model.Resource;
import tasks.Flow;

import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public TextField timeROM;
    public TextField latDC;
    public TextField longDC;
    public TextField timeSC;
    public TextField sizeDC;
    public TextField timeSM;
    public TextField timeEM;
    public TextField timeEC;
    public TextField speed;
    public TextField sizeRes;
    public TextField timeEOC;
    public TextField timeEOM;
    public TextField timeSOM;
    public TextField timeSOC;
    public TextField timePOC;
    public TextField timeROC;
    public TextField longOrder;
    public TextField latOrder;
    public TextField sizeOrder;
    public Button createOrder;
    public TextArea textArea;
    public TextField timePOM;

    private DistributionCenter distributionCenter;
    private ArrayList<Order> orders = new ArrayList<>();
    private Resource resource;

    public void createDCandResurce(ActionEvent actionEvent) {
        this.distributionCenter = new DistributionCenter(Double.parseDouble(latDC.getText()), Double.parseDouble(longDC.getText()), Integer.parseInt(sizeDC.getText()), LocalTime.of(Integer.parseInt(timeSC.getText()), Integer.parseInt(timeSM.getText())), LocalTime.of(Integer.parseInt(timeEC.getText()), Integer.parseInt(timeEM.getText())));
        this.resource = new Resource(Integer.parseInt(sizeRes.getText()), Integer.parseInt(speed.getText()));
        textArea.setText(distributionCenter.toString() + "\n" + resource.toString());
    }

    public void createOrder(ActionEvent actionEvent) {
        Order order = new Order(Integer.parseInt(sizeOrder.getText()), Double.parseDouble(latOrder.getText()),
                Double.parseDouble(longOrder.getText()), LocalTime.of(Integer.parseInt(timeSOC.getText()),
                Integer.parseInt(timeSOM.getText())), LocalTime.of(Integer.parseInt(timeEOC.getText()),
                Integer.parseInt(timeEOM.getText())), LocalTime.of(Integer.parseInt(timePOC.getText()),
                Integer.parseInt(timePOM.getText())), LocalTime.of(Integer.parseInt(timeROC.getText()),
                Integer.parseInt(timeROM.getText())));
        orders.add(order);
        textArea.setText(textArea.getText() + "\n\n" + order.toString());
    }

    public void runFlow(ActionEvent actionEvent) {
        Flow flow = new Flow(distributionCenter, orders.toArray(new Order[orders.size()]), resource);
        textArea.setText(textArea.getText() + "\n\n" + flow.toString());
    }

    public void runFlowComposer(ActionEvent actionEvent) {
        textArea.setText("ERROR");
    }

    public void runSchedule(ActionEvent actionEvent) {
        textArea.setText("ERROR");
    }
}
