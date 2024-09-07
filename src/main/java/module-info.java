module javalasttermproject.javalasttermproject.Controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires org.apache.commons.mail;
    requires kernel;
    requires layout;

    exports javalasttermproject.javalasttermproject.Controller;
    opens javalasttermproject.javalasttermproject.Controller to javafx.fxml;
    exports javalasttermproject.javalasttermproject.Model;
    opens javalasttermproject.javalasttermproject.Model to javafx.fxml;
}