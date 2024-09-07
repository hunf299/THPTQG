package javalasttermproject.javalasttermproject.Controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javalasttermproject.javalasttermproject.Model.ConnectGmail;
import javalasttermproject.javalasttermproject.Model.Database;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;


public class LoginUtils {
    public static String tempUserName;

    public static void changeScene(ActionEvent event, String title, String url, int width, int height) {
        FXMLLoader fxmlLoader = new FXMLLoader(ChangePassword.class.getResource(url));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        scene.getStylesheets().add(LoginUtils.class.getResource("/javalasttermproject/javalasttermproject/Controller/maininterface.css").toExternalForm());
        stage.show();
    }

    public static void logInUser(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from users WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Người dùng không có trong cơ sở dữ liệu của hệ thống");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Thông tin xác thực được cung cấp không chính xác!");
                alert.show();
            } else {
                while (resultSet.next()) {
                    String receivedPassword = resultSet.getString("password");
                    String receivedUsername = resultSet.getString("username");
                    tempUserName = receivedUsername;
                    if (receivedPassword.equals(password) && receivedUsername.equals(username)) {
                        changeScene(event, "Giao diện chính - Hệ thống quản lí thi tốt nghiệp THPTQG", "maininterface-view.fxml", 900, 700);
                    } else {
                        System.out.println("Sai CCCD/CMND hoặc mã đăng nhập!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hộp thoại báo lỗi");
                        alert.setHeaderText("Lỗi");
                        alert.setContentText("Thông tin xác thực không đúng!");
                        alert.show();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void changePass_Login(ActionEvent event, String id, String newPass, String newPass2, Button button1, Button button2, AnchorPane panel1, AnchorPane panel2, StackPane panel3, Label label1, Label label2) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            if (!newPass.isBlank()) {
                if (newPass.equals(newPass2)) {
                    String sql = "UPDATE users SET password = ? WHERE username = ?";
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                    preparedStatement1.setString(1, newPass);
                    preparedStatement1.setString(2, id);
                    preparedStatement1.executeUpdate();
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Đổi mã đăng nhập thành công!\n" + "Bạn có muốn đăng nhập ngay bây giờ?", ButtonType.YES, ButtonType.NO);
                    alert.setTitle("Hộp thoại thông báo");
                    alert.setHeaderText("Xác nhận");
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.YES) {
                        TranslateTransition slider = new TranslateTransition();
                        slider.setNode(panel1);
                        slider.setToX(0);
                        slider.setDuration(Duration.seconds(.5));

                        slider.setOnFinished((ActionEvent e) -> {
                            panel3.setVisible(false);
                            panel2.setVisible(true);
                            button1.setVisible(true);
                            button2.setVisible(false);
                            label1.setVisible(false);
                            label2.setVisible(true);
                        });

                        slider.play();
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hộp thoại báo lỗi");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Nhập sai mật khẩu mới!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Nhập sai mật khẩu mới!");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void switchForm(ActionEvent event, Button button1, Button button2, AnchorPane panel1, AnchorPane panel2, StackPane panel3, Label label1, Label label2) {
        TranslateTransition slider = new TranslateTransition();

        if (event.getSource() == button1) {
            slider.setNode(panel1);
            slider.setToX(450);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                panel3.setVisible(true);
                panel2.setVisible(true);
                button1.setVisible(false);
                button2.setVisible(true);
                label1.setVisible(true);
                label2.setVisible(false);
            });

            slider.play();
        } else if (event.getSource() == button2) {
            slider.setNode(panel1);
            slider.setToX(0);
            slider.setDuration(Duration.seconds(.5));

            slider.setOnFinished((ActionEvent e) -> {
                panel3.setVisible(true);
                panel2.setVisible(true);
                button1.setVisible(true);
                button2.setVisible(false);
                label1.setVisible(false);
                label2.setVisible(true);
            });
            slider.play();
        }
    }
    public static void forgotPass(String cccd, AnchorPane panel1, AnchorPane panel2){
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int length = 10;
        if(!cccd.isBlank()){
            Connection connection ;
            String email = null;
            try {
                connection = Database.connectDB();
                String sqlCheck = "SELECT email FROM users WHERE username = ?";
                PreparedStatement prepCheck = connection.prepareStatement(sqlCheck);
                prepCheck.setString(1, cccd);
                ResultSet resultCheck = prepCheck.executeQuery();
                while (resultCheck.next()){
                    email=resultCheck.getString("email");
                }

                String randomString = "";
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(CHARACTERS.length());
                    randomString += CHARACTERS.charAt(index);
                }

                ConnectGmail connectGmail=new ConnectGmail();
                connectGmail.SendEmail(email,"Mã xác thực","Mã xác thực của bạn là: "+randomString);

                TextInputDialog requestOrder =  new TextInputDialog();
                requestOrder.setTitle("Nhập thông tin xác thực");
                requestOrder.getDialogPane().setContentText("Mã xác thực đã được gửi tới email của bạn!\n" + "Vui lòng nhập mã xác thực để tiếp tục");
                Optional<String> order = requestOrder.showAndWait();
                TextField num = requestOrder.getEditor();
                if (order.isPresent()) {
                    if (randomString.equals(num.getText())) {
                        panel1.setVisible(false);
                        panel2.setVisible(true);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Hộp thoại báo lỗi");
                        alert.setHeaderText("Lỗi");
                        alert.setContentText("Mã xác thực không đúng!\n" + "Vui lòng thử lại!");
                        Optional<ButtonType> option = alert.showAndWait();

                        if (option.isPresent() && option.get() == ButtonType.OK) {
                            TextInputDialog requestOrder1 =  new TextInputDialog();
                            requestOrder1.setTitle("Nhập thông tin xác thực");
                            requestOrder1.getDialogPane().setContentText("Vui lòng nhập lại mã xác thực để tiếp tục");
                            Optional<String> order1 = requestOrder1.showAndWait();
                            TextField num1 = requestOrder1.getEditor();
                            if (order1.isPresent()) {
                                if (randomString.equals(num1.getText())) {
                                    panel1.setVisible(false);
                                    panel2.setVisible(true);
                                } else {
                                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                                    alert1.setTitle("Hộp thoại báo lỗi");
                                    alert1.setHeaderText("Lỗi");
                                    alert1.setContentText("Mã xác thực không đúng!\n" + "Vui lòng thử lại sau!");
                                    alert1.show();
                                }
                            }
                        }
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hộp thoại báo lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Vui lòng nhập số căn cước công dân!");
            alert.show();
        }
    }
}
