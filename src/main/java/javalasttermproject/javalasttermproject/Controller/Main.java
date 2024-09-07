package javalasttermproject.javalasttermproject.Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 700);
        stage.setTitle("Đăng nhập - Hệ thống quản lí thi tốt nghiệp THPTQG");
        stage.setScene(scene);
        scene.getStylesheets().add(getClass().getResource("/javalasttermproject/javalasttermproject/Controller/login.css").toExternalForm());
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
