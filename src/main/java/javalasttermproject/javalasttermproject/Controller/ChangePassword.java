package javalasttermproject.javalasttermproject.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ChangePassword implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField againpass_field;

    @FXML
    private Button cancel_button;

    @FXML
    private Label changepass_label;

    @FXML
    private AnchorPane changepass_panel;

    @FXML
    private Line line;

    @FXML
    private Label newpass_again;

    @FXML
    private PasswordField newpass_field;

    @FXML
    private Label newpass_label;

    @FXML
    private PasswordField oldpass_field;

    @FXML
    private Label oldpass_label;

    @FXML
    private Button save_button;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainUtils.changePass_Main(event,oldpass_field.getText(),newpass_field.getText(),againpass_field.getText());
            }
        });
        cancel_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.close();
            }
        });
    }
}
