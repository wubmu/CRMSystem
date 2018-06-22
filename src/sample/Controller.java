package sample;


import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import sample.Bean.Contact;
import sample.Bean.Customer;
import sample.Bean.CustomerEntity;
import sample.dao.CustomerDao;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    CustomerDao dao = new CustomerDao();
    @FXML
    Button add;
    @FXML
    TextField id;
    @FXML
    TextField name;
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
    Pane customerInfo;
    @FXML
    Button contacts;
    @FXML
    Pane contactsPane;
    @FXML
    StackPane parentStack;
    @FXML
    TextField customerno;//客户id
    @FXML
    TextField c_id;
    @FXML
    TextField c_name;


    @FXML
    TableView contactTable;
    ObservableList<Contact> data;

    public void onAdd(){
        CustomerEntity c = new CustomerEntity();
        c.setArea((String) area.getValue());
        c.setAccountManager((String) accountManager.getValue());
        c.setCredit((String) credit.getValue());
        c.setDegree((String) degree.getValue());
        c.setId(Integer.parseInt(id.getText()));
        c.setName(name.getText());
        System.out.println(c.toString());
       dao.updata(c);

    }
    @FXML
    public void findContacts(){
        customerInfo.setVisible(false);
        contactsPane.setVisible(true);
        int Id = Integer.parseInt(id.getText());
        List<Contact> list = dao.findContactById(Id);
        showContacts(list);
    }

    private void showContacts(List<Contact> list) {

        ObservableList<TableColumn> observableList = contactTable.getColumns();
        data = FXCollections.observableArrayList();
        for (Contact c: list)
            data.add(c);
        observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("sex"));
        observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("position"));
        observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("tel"));
        observableList.get(5).setCellValueFactory((Callback<TableColumn.CellDataFeatures<Contact, Boolean>, ObservableValue<Boolean>>) p -> new SimpleBooleanProperty(p.getValue() != null));
        observableList.get(5).setCellFactory((Callback<TableColumn<Contact, Boolean>, TableCell<Contact, Boolean>>) p -> new ButtonCell());
        contactTable.setItems(data);
    }

    private class ButtonCell extends TableCell<Contact, Boolean>{
        final Button cellButton = new Button("删除");
        ButtonCell(){
            cellButton.setOnAction(t-> {
                contactTable.getSelectionModel().select(getTableRow().getIndex());
                ObservableList<Contact> dele = contactTable.getItems();
                Contact c = dele.get(getTableRow().getIndex());
                System.out.println(c);
                int id = c.getId();
                System.out.println(id);
                dao.deleteContantById(id);
//                data.remove(c);
//                System.out.println(data);
//                contactTable.setItems(data);
                findContacts();
            });


        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if(!empty){
                setGraphic(cellButton);
            }
        }
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
        contactsPane = (Pane) parentStack.lookup("#contactsPane");
        contactTable= (TableView) contactsPane.lookup("#contactTable");
        customerInfo.setVisible(true);
        contactsPane.setVisible(false);

    }
    public void convert(){

    }
}
