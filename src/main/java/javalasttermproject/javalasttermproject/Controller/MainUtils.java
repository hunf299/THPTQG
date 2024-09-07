package javalasttermproject.javalasttermproject.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javalasttermproject.javalasttermproject.Model.Database;

import java.io.IOException;
import java.sql.*;

public class MainUtils {
    public static String setLabel(String sqlQuery, String columnLabel, String columnObject) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String receivedResult = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, columnObject);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                receivedResult = resultSet.getString(columnLabel);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return receivedResult;
    }
    public static String countSubject(String sqlQuery, String columnLabel) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String receivedResult = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                receivedResult = resultSet.getString(columnLabel);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return receivedResult;
    }

    public static void changeStage(MouseEvent event, String title, String url, int width, int height) {
        FXMLLoader fxmlLoader;
        fxmlLoader = new FXMLLoader(ChangePassword.class.getResource(url));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),width,height);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.setResizable(false);
        stage.show();
    }
    public static String selectedOption(RadioButton radioButton, String option1, String option2) {
        if(radioButton.isSelected()) {
            return option1;
        }
        else {
            return option2;
        }
    }
    public static void transferInt(RadioButton radioButton, String receivedResult) {
        if (receivedResult.equals("1")) {
            radioButton.setSelected(true);
        }
        else {
            radioButton.setSelected(false);
        }
    }
    public static void transferInttoString(String receivedResult, Label label) {
        if (receivedResult.equals("1")) {
            label.setText("Có");
        }
        else {
            label.setText("Không");
        }
    }
    public static void transferString(RadioButton radioButton, RadioButton radioButton1, String receivedResult, String check) {
        if (receivedResult.equals(check)) {
            radioButton.setSelected(true);
        }
        else {
            radioButton1.setSelected(true);
        }
    }
    public static void checkRadioButton(RadioButton radioButton, RadioButton radioButton1, RadioButton radioButton2, RadioButton radioButton3, RadioButton radioButton4, RadioButton radioButton5) {
        if (radioButton.isSelected() || radioButton1.isSelected() || radioButton2.isSelected()) {
            radioButton.setSelected(false);
            radioButton1.setSelected(false);
            radioButton2.setSelected(false);
        }
        if (radioButton3.isDisable() || radioButton4.isDisable() || radioButton5.isDisable()) {
            radioButton3.setDisable(false);
            radioButton4.setDisable(false);
            radioButton5.setDisable(false);
        }
    }
    public static void getScore(String subject, Label data)  {
        Connection connection = null;
        String sqlQuery = "SELECT " + subject + " FROM score WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int receivedResult = 0;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                receivedResult = resultSet.getInt(subject);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        data.setText(String.valueOf(receivedResult));
        if (receivedResult > 0 && receivedResult <= 1) {
            data.setTextFill(Color.RED);
        }
        else if (receivedResult <= 5) {
            data.setTextFill(Color.ORANGE);
        }
        else if (receivedResult < 9) {
            data.setTextFill(Color.YELLOW);
        }
        else {
            data.setTextFill(Color.GREEN);
        }
    }
    public static boolean isRequestMatchUniInfo(String uniName, String major, String trainingUnit, String trainingProgram) {
        boolean isMatch = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.connectDB();
            String query = "SELECT * FROM uniinfo WHERE name = ? AND major = ? AND training_unit = ? AND training_program = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, uniName);
            preparedStatement.setString(2, major);
            preparedStatement.setString(3, trainingUnit);
            preparedStatement.setString(4, trainingProgram);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                isMatch = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isMatch;
    }
    public static void getScienceScore(String subject, Label data) {
        Connection connection = null;
        String sqlQuery = "SELECT " + subject + " FROM score WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String receivedResult = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                receivedResult = resultSet.getString(subject);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        data.setText(receivedResult);
        if (receivedResult.equals("X")) {
            data.setTextFill(Color.BLACK);
        }
        else {
            Double transfer = Double.valueOf(receivedResult);
            if (transfer > 0 && transfer <= 1) {
                data.setTextFill(Color.RED);
            }
            else if (transfer <= 5) {
                data.setTextFill(Color.ORANGE);
            }
            else if (transfer < 9) {
                data.setTextFill(Color.web("#f9ff88"));
            }
            else {
                data.setTextFill(Color.GREEN);
            }
        }
    }
    public static void setVisibleScoreLabel(Label label, Label label1, AnchorPane pane, AnchorPane pane1) {
        if (label.getText().equals("X")) {
            pane.setVisible(false);
            pane1.setVisible(true);
        }
        else {
            pane.setVisible(true);
            pane1.setVisible(false);
        }
    }
    public static void calculateScore(Label sub1, Label sub2, Label sub3, Label combi) {
        if (!sub1.getText().equals("X") && !sub2.getText().equals("X") && !sub3.getText().equals("X")) {
            double subject1 = Double.valueOf(sub1.getText());
            double subject2 = Double.valueOf(sub2.getText());
            double subject3 = Double.valueOf(sub3.getText());
            double result = subject1 + subject2 + subject3;
            combi.setText(String.valueOf(result));
        }
    }
    public static void changePass_Main(ActionEvent event, String oldPass, String newPass, String newPass2) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from users WHERE username = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String receivedPass = resultSet.getString("password");
                if (receivedPass.equals(oldPass)) {
                    if (!newPass.isBlank()) {
                        if (newPass.equals(newPass2)) {
                            String sql = "UPDATE users SET password = ? WHERE username = ?";
                            PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
                            preparedStatement1.setString(1, newPass);
                            preparedStatement1.setString(2, LoginUtils.tempUserName);
                            preparedStatement1.executeUpdate();
                            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Đổi mã đăng nhập thành công!\n" + "Bạn có muốn tắt hộp thoại?", ButtonType.YES, ButtonType.NO);
                            alert.setTitle("Hộp thoại thông báo");
                            alert.setHeaderText("Xác nhận");
                            alert.showAndWait();
                            if (alert.getResult() == ButtonType.YES) {
                                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                stage.close();
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
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hộp thoại báo lỗi");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Nhập sai mật khẩu cũ!");
                    alert.show();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
