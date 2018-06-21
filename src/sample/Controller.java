package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.Bean.Customer;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button add;
    @FXML
    TextField id;
    @FXML
    ChoiceBox degree;
    @FXML
    ChoiceBox area;
    @FXML
    ChoiceBox accountManager;
    @FXML
    ChoiceBox credit;
    @FXML
    ChoiceBox satisfaction;
    @FXML
    public void onAdd(){
        Customer c = new Customer();
        c.setArea((String) area.getValue());
        System.out.println(c.toString());
        System.out.println(credit.getValue());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> option1 =
                FXCollections.observableArrayList(
                        "北京",
                        "上海",
                        "天津",
                        "太原"
                );
        area.getItems().addAll(option1);
        area.setValue("北京");

        ObservableList<String> option2 =
                FXCollections.observableArrayList(
                       "战略合作伙伴"
                );
        degree.getItems().addAll(option2);
        degree.setValue("战略合作伙伴");

        ObservableList<String> option3 =
                FXCollections.observableArrayList(
                        "☆☆☆☆☆",
                        "☆☆☆☆",
                        "☆☆☆",
                        "☆☆",
                        "☆"
                );
        satisfaction.getItems().addAll(option3);
        satisfaction.setValue("☆☆☆");

        credit.getItems().addAll(option3);
        credit.setValue("☆☆☆");


        List<String> am = new ArrayList<>();
        am.add("123");
        am.add("23123");
        ObservableList<String> option4 =
                FXCollections.observableArrayList(
                );

    }
    public void convert(){

    }
}
