package test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class SampleController implements Initializable {

    @FXML private TableView tview;
    @FXML private TableColumn colUsername;
    @FXML private TableColumn colPassword;


    public void showList(){
        ObservableList<User> list = FXCollections.observableArrayList();
        User user = new User();//构建值对象
        user.setUsername("小六");
        user.setPassword("123");

        colUsername.setCellValueFactory(new PropertyValueFactory("username"));//映射
        colPassword.setCellValueFactory(new PropertyValueFactory("password"));

        list.add(user);        //list添加值对象
        tview.setItems(list); //tableview添加list
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showList();
    }
}