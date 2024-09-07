package javalasttermproject.javalasttermproject.Controller;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.text.Normalizer;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;
import javafx.stage.FileChooser;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javalasttermproject.javalasttermproject.Model.*;

public class MainInterface implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label a001;

    @FXML
    private Label a011;

    @FXML
    private Button addrequest_button;

    @FXML
    private Label address_label;

    @FXML
    private Label address_label_form;

    @FXML
    private TextField address_textfield;

    @FXML
    private TextField address_textfield_form;

    @FXML
    private Label appliedsubject_label;

    @FXML
    private Label appliedsubject_label_form;

    @FXML
    private Label appliedsubject_label_form1;

    @FXML
    private Label b001;

    @FXML
    private Label b081;

    @FXML
    private RadioButton bio;

    @FXML
    private TableColumn<SubjectInfo, String> bio_column;

    @FXML
    private Label bio_score1;

    @FXML
    private AnchorPane bio_scorepane1;

    @FXML
    private Label birthdate_label;

    @FXML
    private Label birthdate_label_form;

    @FXML
    private DatePicker birthdate_textfield;

    @FXML
    private TextField birthdate_textfield_form;

    @FXML
    private Label birthplace_label;

    @FXML
    private Label birthplace_label_form;

    @FXML
    private TextField birthplace_textfield;

    @FXML
    private TextField birthplace_textfield1;

    @FXML
    private Label c001;

    @FXML
    private Label c191;

    @FXML
    private Button change_button;

    @FXML
    private Button changeorder_button;

    @FXML
    private Label changepass_item;

    @FXML
    private Label checkindateandtime_label;

    @FXML
    private Label checkindateandtime_label1;

    @FXML
    private Label checkintime;

    @FXML
    private Label checkintime_dashboard;

    @FXML
    private RadioButton chemistry;

    @FXML
    private TableColumn<SubjectInfo, String> chemistry_column;

    @FXML
    private Label chemistry_score1;

    @FXML
    private AnchorPane chemistry_scorepane1;

    @FXML
    private Label countdown_timer;

    @FXML
    private Label d001;

    @FXML
    private Label d071;

    @FXML
    private AnchorPane dashboard_panel;

    @FXML
    private Label datetime_panel;

    @FXML
    private Button delete_button;

    @FXML
    private Button deleterequest_button;

    @FXML
    private AnchorPane detailedtime_label;

    @FXML
    private ToggleGroup edumethod;

    @FXML
    private ImageView eduministry_logo;

    @FXML
    private Label email_label;

    @FXML
    private Label email_label_form;

    @FXML
    private TextField email_textfield;

    @FXML
    private TextField email_textfield_form;

    @FXML
    private RadioButton female_radiobutton;

    @FXML
    private AnchorPane fillform_panel;

    @FXML
    private AnchorPane firstrequest_panel1;

    @FXML
    private ImageView folder_icon;

    @FXML
    private RadioButton foreignlanguage;

    @FXML
    private TableColumn<SubjectInfo, String> foreignlanguage_column;

    @FXML
    private Label foreignlanguage_score1;

    @FXML
    private Button form_button;

    @FXML
    private ButtonBar form_buttonbar;

    @FXML
    private AnchorPane form_dashboard;

    @FXML
    private Button form_dashboard_editbutton;

    @FXML
    private Label form_label;

    @FXML
    private Line form_line;

    @FXML
    private StackPane form_stackpanel;

    @FXML
    private TextField free_textfield_dashboard;

    @FXML
    private TextField free_textfield_form;

    @FXML
    private RadioButton gdcd;

    @FXML
    private TableColumn<SubjectInfo, String> gdcd_column;

    @FXML
    private Label gdcd_score1;

    @FXML
    private AnchorPane gdcd_scorepane1;

    @FXML
    private RadioButton gdtx_radiobutton;

    @FXML
    private Label gender_label;

    @FXML
    private Label gender_label_form;

    @FXML
    private TextField gender_textfield_form;

    @FXML
    private TableColumn<SubjectInfo, String> geo_column;

    @FXML
    private RadioButton geography;

    @FXML
    private Label geography_score1;

    @FXML
    private AnchorPane geography_scorepane1;

    @FXML
    private RadioButton graduated_radiobutton;

    @FXML
    private AnchorPane grey_panel;

    @FXML
    private Label hello_label;

    @FXML
    private Label highschool_label;

    @FXML
    private Label highschool_label_form;

    @FXML
    private TextField highschool_textfield;

    @FXML
    private TextField highschool_textfield_form;

    @FXML
    private RadioButton history;

    @FXML
    private TableColumn<SubjectInfo, String> history_column;

    @FXML
    private Label history_score1;

    @FXML
    private AnchorPane history_scorepane1;

    @FXML
    private Button home_button;

    @FXML
    private Line home_line;

    @FXML
    private ImageView home_logo;

    @FXML
    private Label id_label;

    @FXML
    private Label id_testinfo_label;

    @FXML
    private Label id_testinfo_label1;

    @FXML
    private Label id_testinfo_label11;

    @FXML
    private Label id_testinfo_label111;

    @FXML
    private Label id_testinfo_label112;

    @FXML
    private Label idnum_dashboard_textfield;

    @FXML
    private Label idnum_label;

    @FXML
    private Label idnum_label1;

    @FXML
    private Label idnum_label_form;

    @FXML
    private Label idnum_testinfo_textfield;

    @FXML
    private TextField idnum_textfield;

    @FXML
    private TextField idnum_textfield_form;

    @FXML
    private AnchorPane infoform_pane;

    @FXML
    private Line line;

    @FXML
    private Line line11;

    @FXML
    private Line line111;

    @FXML
    private Line line1111;

    @FXML
    private Line line121;

    @FXML
    private Line line1211;

    @FXML
    private Line line12111;

    @FXML
    private Line line1221;

    @FXML
    private Line line12211;

    @FXML
    private Line line1231;

    @FXML
    private Line line131;

    @FXML
    private ImageView list_icon1;

    @FXML
    private ImageView list_icon2;

    @FXML
    private ImageView list_icon21;

    @FXML
    private ImageView list_icon211;

    @FXML
    private RadioButton literature;

    @FXML
    private TableColumn<SubjectInfo, String> literature_column;

    @FXML
    private Label literature_score1;

    @FXML
    private Label living_label;

    @FXML
    private Label living_label1;

    @FXML
    private TextField living_textfield;

    @FXML
    private TextField living_textfield_form;

    @FXML
    private Button logout_item;

    @FXML
    private Label major1_dashboard_field;

    @FXML
    private Label major2_dashboard_field;

    @FXML
    private Label major3_dashboard_field;

    @FXML
    private TableColumn<Request, String> major_column;

    @FXML
    private Label major_label1;

    @FXML
    private RadioButton male_radiobutton;

    @FXML
    private RadioButton math;

    @FXML
    private TableColumn<SubjectInfo, String> math_column;

    @FXML
    private Label math_score1;

    @FXML
    private Label method_label;

    @FXML
    private Label method_label_form;

    @FXML
    private TextField method_textfield_form;

    @FXML
    private TextField mobile_textfield;

    @FXML
    private TextField mobile_textfield_form;

    @FXML
    private Label name_label;

    @FXML
    private Label name_label1;

    @FXML
    private Label name_label2;

    @FXML
    private Label name_label_form;

    @FXML
    private TextField name_textfield;

    @FXML
    private TextField name_textfield_form;

    @FXML
    private Label nation_label;

    @FXML
    private Label nation_label1;

    @FXML
    private TextField nation_textfield;

    @FXML
    private TextField nation_textfield_form;

    @FXML
    private RadioButton naturalscience;

    @FXML
    private Label noformtoshow;

    @FXML
    private AnchorPane norequesttoview;

    @FXML
    private AnchorPane noscoretoview;

    @FXML
    private AnchorPane noscoretoview_panel;

    @FXML
    private Label notestinfotoview;

    @FXML
    private AnchorPane notestinfotoview_panel;

    @FXML
    private RadioButton notgraduated_radiobutton;

    @FXML
    private MenuButton option_button;

    @FXML
    private Line option_line;

    @FXML
    private TableColumn<Request, Integer> order_column;

    @FXML
    private Label order_label_fill;

    @FXML
    private Label outsidecandidate_label;

    @FXML
    private Label outsidecandidate_label_form;

    @FXML
    private Label outsidecandidate_label_form1;

    @FXML
    private Label partA_label;

    @FXML
    private Label partA_label_form;

    @FXML
    private Label partB_label;

    @FXML
    private Label partB_label_form;

    @FXML
    private Label phone_label;

    @FXML
    private Label phone_label_form;

    @FXML
    private RadioButton physic;

    @FXML
    private TableColumn<SubjectInfo, String> physic_column;

    @FXML
    private Label physic_score1;

    @FXML
    private AnchorPane physic_scorepane1;

    @FXML
    private Button printform_button;

    @FXML
    private TableColumn<Request, String> program_column;

    @FXML
    private AnchorPane prohibitedrequestpanel;

    @FXML
    private Button request_button;

    @FXML
    private ButtonBar request_buttonbar;

    @FXML
    private AnchorPane request_dashboard;

    @FXML
    private Label request_dashboard_label;

    @FXML
    private Button request_dashboard_viewbutton;

    @FXML
    private Label request_label;

    @FXML
    private Line request_line;

    @FXML
    private AnchorPane request_panel;

    @FXML
    private TableView<Request> request_tableview;

    @FXML
    private TextField requestorder_textfield;

    @FXML
    private Label room;

    @FXML
    private Label room_dashboard;

    @FXML
    private Label room_label;

    @FXML
    private Label room_label1;

    @FXML
    private Button save_button;

    @FXML
    private TableColumn<?, ?> science_column;

    @FXML
    private ToggleGroup science_subjects;

    @FXML
    private ToggleGroup science_subjects1;

    @FXML
    private BarChart<String, Double> score_barchart;

    @FXML
    private AnchorPane score_dashboard;

    @FXML
    private Label score_dashboard_label;

    @FXML
    private Button score_dashboard_viewbutton;

    @FXML
    private MenuItem score_item;

    @FXML
    private AnchorPane score_anchorpane;

    @FXML
    private ToggleGroup sex;

    @FXML
    private AnchorPane showform_panel;

    @FXML
    private RadioButton socialscience;

    @FXML
    private TableColumn<?, ?> socialscience_column;

    @FXML
    private TableColumn<SubjectInfo, String> subject_column;

    @FXML
    private TextField subject_field_dashboard;

    @FXML
    private Label subject_label;

    @FXML
    private TextArea subject_textarea;

    @FXML
    private TableView<SubjectInfo> subjectandtime_table;

    @FXML
    private ToggleGroup subjectcombo;

    @FXML
    private Label testcheckin_label;

    @FXML
    private Label testcheckin_label11;

    @FXML
    private Label testcheckin_label111;

    @FXML
    private Label testcheckin_label1111;

    @FXML
    private Label testcheckin_label121;

    @FXML
    private Label testcheckin_label1211;

    @FXML
    private Label testcheckin_label12111;

    @FXML
    private Label testcheckin_label1221;

    @FXML
    private Label testcheckin_label12211;

    @FXML
    private Label testcheckin_label1231;

    @FXML
    private AnchorPane testinfo_dashboard;

    @FXML
    private Button testinfo_dashboard_viewbutton;

    @FXML
    private MenuItem testinfo_item;

    @FXML
    private Label testinfo_label;

    @FXML
    private Label testinfo_label1;

    @FXML
    private AnchorPane testinfo_panel;

    @FXML
    private AnchorPane testplace_panel;

    @FXML
    private AnchorPane testplace_panel111;

    @FXML
    private AnchorPane testplace_panel1111;

    @FXML
    private Label testvenue;

    @FXML
    private Label testvenue_dashboard;

    @FXML
    private Label testvenue_label;

    @FXML
    private Label testvenue_label1;

    @FXML
    private RadioButton thpt_radiobutton;

    @FXML
    private Label thptqg_label;

    @FXML
    private Label thptqg_label_form;

    @FXML
    private Label thptqg_label_form1;

    @FXML
    private RadioButton thptqg_radiobutton;

    @FXML
    private Label thptqg_radiobutton_dashboard;

    @FXML
    private Label thptqg_radiobutton_form;

    @FXML
    private ComboBox<String> trainingprogram_combobox_fill;

    @FXML
    private Label trainingprogram_label1;

    @FXML
    private Label trainingunit_fill;

    @FXML
    private Label trainingunit_label1;

    @FXML
    private Label uni1_dashboard_field;

    @FXML
    private Label uni2_dashboard_field;

    @FXML
    private Label uni3_dashboard_field;

    @FXML
    private TableColumn<Request, String> uni_column;

    @FXML
    private Label uni_label1;

    @FXML
    private TableColumn<Request, String> unit_column;

    @FXML
    private AnchorPane verticalmenu;

    @FXML
    private Button viewform_button;

    @FXML
    private Label warning_label;

    @FXML
    private Label warning_label11;

    @FXML
    private AnchorPane warning_panel;

    @FXML
    private AnchorPane warning_panel11;

    @FXML
    private TextArea warning_textarea;

    @FXML
    private CategoryAxis x_axis;

    @FXML
    private NumberAxis y_axis;

    @FXML
    private ComboBox<String> uni_combobox;

    @FXML
    private ComboBox<String> majors_combobox;

    private Alert alert;

    IntegerProperty property = new SimpleIntegerProperty();

    @FXML
    private AnchorPane prohibitedstatusinfopanel;

    @FXML
    private TableColumn<StatusInfo, String> statusinfo_acceptedornot_column;

    @FXML
    private TableColumn<StatusInfo, String> statusinfo_major_column;

    @FXML
    private TableColumn<StatusInfo, String> statusinfo_program_column;

    @FXML
    private TableView<StatusInfo> statusinfo_tableview;

    @FXML
    private TableColumn<StatusInfo, String> statusinfo_uni_column;

    @FXML
    private TableColumn<StatusInfo, String> statusinfo_unit_column;

    @FXML
    private MenuItem statusinfo_item;

    @FXML
    private AnchorPane statusinfo_panel;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private String tempName;
    private String tempDate;
    private String tempOrder;

    static String OS = null;
    public static String getOsName() {
        if(OS == null) { OS = System.getProperty("os.name"); }
        return OS;
    }
    ObservableList<String> trainingprogram_list = FXCollections.observableArrayList("Đại trà", "Chất lượng cao", "Tiên tiến");

    ArrayList<String> listSchool= new ArrayList<>();
    // đọc file ghi danh sách các trường vào 1 list
    public ArrayList listNameSchool() {
        listSchool.clear();
        String url = "src/main/java/javalasttermproject/javalasttermproject/Model/List/ListSchool.txt";
        File file = new File(url);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                listSchool.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSchool;
    }
    ObservableList<String> nameSchool_list = FXCollections.observableArrayList(listNameSchool());

    private String editText(String input) {
        // Chuẩn hóa chuỗi để loại bỏ dấu
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);// các chứ có dấu sẽ chuyển thành các chữ k dấu tương tự
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");//xóa các dầu sau khi chuỗi trên đã chuẩn hóa
        String noDiacritics = pattern.matcher(normalized).replaceAll("");//xóa các dâu cách
        // Loại bỏ tất cả các ký tự không phải chữ cái hoặc số và khoảng trắng
        return noDiacritics.replaceAll("Đ","D").replaceAll("đ","d").replaceAll("[^a-zA-Z0-9]", "");
    }
    public ArrayList listNameMajors(String check) {
        String nameSchool= null;
        switch (check){
            case "DDY-Khoa Y dược-Đại học Đà Nẵng":
                nameSchool="ListDDY.txt";
                break;
            case "DDK-Đại học Bách Khoa":
                nameSchool="ListDDK.txt";
                break;
            case "VKU-Đại học Công nghệ thông tin và Truyền thông Việt Hàn":
                nameSchool="ListVKU.txt";
                break;
            case "DDT-Đại học Duy Tân":
                nameSchool="ListDDT.txt";
                break;
            case "FPT-Đại học FPT Đà Nẵng":
                nameSchool="ListFPT.txt";
                break;
            case "DDQ-Đại học Kinh Tế":
                nameSchool="ListDDQ.txt";
                break;
            case "YDN-Đại học Kỹ thuật Y-Dược":
                nameSchool="ListYDN.txt";
                break;
            case "DDF-Đại học Ngoại Ngữ":
                nameSchool="ListDDF.txt";
                break;
            case "DSK-Đại học Sư phạm Kỹ thuật":
                nameSchool="ListDSK.txt";
                break;
            case "DAD-Đại học Đông Á":
                nameSchool="ListDAD.txt";
                break;
            case "CPN-Cao đẳng Phương Đông":
                nameSchool="ListCPN.txt";
                break;
        }

        ArrayList<String> list=new ArrayList<>();
        String url = "src/main/java/javalasttermproject/javalasttermproject/Model/List/"+nameSchool;
        File file = new File(url);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String selectedFreeCandidate() {
        if (graduated_radiobutton.isSelected()) {
            return graduated_radiobutton.getText();
        }
        else if (notgraduated_radiobutton.isSelected()) {
            return notgraduated_radiobutton.getText();
        }
        else {
            return "NULL";
        }
    }
    public boolean isMobileNum(String str) {
        return str.matches("\\d{9,10}");
    }
    public boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(emailRegex);
    }
    public ObservableList<SubjectInfo> addSubjectsListInfo() {
        ObservableList<SubjectInfo> listSubjectsInfo = FXCollections.observableArrayList();
        String subjectsInfo = "SELECT subject_column, literature_column, math_column, physic_column, chemistry_column, bio_column, foreignlanguage_column, history_column, geo_column, gdcd_column FROM OOP_schema.subjectinfo WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        Connection connection = Database.connectDB();
        try {
            SubjectInfo subjectInfo;
            prepare = connection.prepareStatement(subjectsInfo);
            result = prepare.executeQuery();
            while (result.next()) {
                subjectInfo = new SubjectInfo(result.getNString("subject_column"), result.getString("literature_column"), result.getString("math_column"), result.getString("physic_column"), result.getString("chemistry_column"), result.getString("bio_column"), result.getString("foreignlanguage_column"), result.getString("history_column"), result.getString("geo_column"), result.getString("gdcd_column"));
                listSubjectsInfo.add(subjectInfo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listSubjectsInfo;
    }
    public ObservableList<Request> addRequestsList() {
        ObservableList<Request> listRequests = FXCollections.observableArrayList();
        String receiver = "SELECT * FROM request WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        Connection connection = Database.connectDB();
        try {
            Request request;
            prepare = connection.prepareStatement(receiver);
            result = prepare.executeQuery();
            while (result.next()) {
                request = new Request(result.getString("personal_id"),result.getInt("request_order"), result.getNString("uni_name"), result.getNString("major"), result.getNString("training_unit"), result.getNString("training_program"));
                listRequests.add(request);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return listRequests;
    }
    public void candidateAdd() {
        String insertData = "INSERT INTO candidate (name, gender, birthdate, birthplace, nation, personal_id, livingaddress, highschool, mobilephone, email, contactaddress, thptqg, edumethod, freecandidate, math, literature, science, social, foreign_language, physic, chemistry, bio, history, geography, gdcd) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        connect = Database.connectDB();
        try {
            Alert alert;
            if (name_textfield.getText().isEmpty() || sex.getSelectedToggle() == null || birthdate_textfield.getValue() == null || birthplace_textfield.getText().isEmpty() || nation_textfield.getText().isEmpty() || idnum_textfield.getText().isEmpty() || living_textfield.getText().isEmpty() || highschool_textfield.getText().isEmpty() || mobile_textfield.getText().isEmpty() || email_textfield.getText().isEmpty() || address_textfield.getText().isEmpty() ||  edumethod.getSelectedToggle() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng điền tất cả các thông tin bắt buộc!");
                alert.showAndWait();
            }
            else if (!isMobileNum(mobile_textfield.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng định dạng số điện thoại!");
                alert.showAndWait();
            }
            else if (!isValidEmail(email_textfield.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng định dạng email!");
                alert.showAndWait();
            }
            else if (birthdate_textfield.getValue().getYear() > 2006) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng năm sinh được cho phép!");
                alert.showAndWait();
            }
            else if (graduated_radiobutton.isSelected() && notgraduated_radiobutton.isSelected()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng không chọn cả hai lựa chọn trong mục thí sinh tự do!");
                alert.showAndWait();
            }
            else {
                LocalDate birthdate = birthdate_textfield.getValue();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String birthdateString = birthdate.format(dateTimeFormatter);
                prepare = connect.prepareStatement(insertData);
                prepare.setString(1, tempName);
                prepare.setString(2, MainUtils.selectedOption(male_radiobutton, male_radiobutton.getText(),female_radiobutton.getText()));
                prepare.setString(3, birthdateString);
                prepare.setString(4, birthplace_textfield.getText());
                prepare.setString(5, nation_textfield.getText());
                prepare.setString(6, LoginUtils.tempUserName);
                prepare.setString(7, living_textfield.getText());
                prepare.setString(8, highschool_textfield.getText());
                prepare.setString(9, mobile_textfield.getText());
                prepare.setString(10, email_textfield.getText());
                prepare.setString(11, address_textfield.getText());
                prepare.setString(12, MainUtils.selectedOption(thptqg_radiobutton, "1","0"));
                prepare.setString(13, MainUtils.selectedOption(thpt_radiobutton,thpt_radiobutton.getText(),gdtx_radiobutton.getText()));
                prepare.setString(14, selectedFreeCandidate());
                prepare.setString(15, MainUtils.selectedOption(math, "1", "0"));
                prepare.setString(16, MainUtils.selectedOption(literature, "1", "0"));
                prepare.setString(17, MainUtils.selectedOption(naturalscience, "1","0"));
                prepare.setString(18, MainUtils.selectedOption(socialscience, "1","0"));
                prepare.setString(19, MainUtils.selectedOption(foreignlanguage, "1","0"));
                prepare.setString(20, MainUtils.selectedOption(physic, "1", "0"));
                prepare.setString(21, MainUtils.selectedOption(chemistry, "1","0"));
                prepare.setString(22, MainUtils.selectedOption(bio,"1","0"));
                prepare.setString(23, MainUtils.selectedOption(history, "1","0"));
                prepare.setString(24, MainUtils.selectedOption(geography, "1","0"));
                prepare.setString(25, MainUtils.selectedOption(gdcd, "1","0"));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Lưu thành công!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void checkPaneltoShow() {
        if (thptqg_radiobutton_dashboard.getText().isEmpty()) {
            noformtoshow.setVisible(true);
        }
        else {
            noformtoshow.setVisible(false);
        }
        if (uni1_dashboard_field.getText().isEmpty()) {
            norequesttoview.setVisible(true);
        }
        else {
            norequesttoview.setVisible(false);
        }
        String dateTestInfo = "2024-05-23 23:59:59";
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter tempFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime tempDateTime = LocalDateTime.parse(dateTestInfo, tempFormatter);
        Duration duration = Duration.between(currentDate, tempDateTime);
        long daysBetween = duration.toDays();
        if (daysBetween > 0) {
            notestinfotoview.setVisible(true);
            notestinfotoview_panel.setVisible(true);
        }
        String dateScore = "2024-05-23 23:59:59";
        LocalDateTime tempDateScore = LocalDateTime.parse(dateScore, tempFormatter);
        Duration duration1 = Duration.between(currentDate, tempDateScore);
        long daysBetween1 = duration1.toDays();
        if (daysBetween1 > 0) {
            noscoretoview_panel.setVisible(true);
            noscoretoview.setVisible(true);
        }
        String dateRequest = "2024-05-23 23:59:59";
        LocalDateTime tempDateRequest = LocalDateTime.parse(dateScore, tempFormatter);
        Duration duration2 = Duration.between(currentDate, tempDateRequest);
        long daysBetween2 = duration2.toDays();
        if (daysBetween2 > 0) {
            norequesttoview.setVisible(true);
            prohibitedrequestpanel.setVisible(true);
        }
        String dateStatus = "2024-05-23 23:59:59";
        LocalDateTime tempDateStatus = LocalDateTime.parse(dateStatus, tempFormatter);
        Duration duration3 = Duration.between(currentDate, tempDateStatus);
        long daysBetween3 = duration3.toDays();
        if (daysBetween3 > 0) {
            prohibitedstatusinfopanel.setVisible(true);
        }
    }
    public void showCandidateForm() {
        name_textfield_form.setText(tempName);
        gender_textfield_form.setText(MainUtils.setLabel("SELECT gender FROM OOP_schema.candidate where personal_id = ?", "gender", LoginUtils.tempUserName));
        LocalDateTime birthdate = LocalDateTime.parse(MainUtils.setLabel("SELECT birthdate FROM OOP_schema.candidate where personal_id = ?", "birthdate", LoginUtils.tempUserName), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String birthdateString = birthdate.format(dateTimeFormatter);
        birthdate_textfield_form.setText(birthdateString);
        birthplace_textfield1.setText(MainUtils.setLabel("SELECT birthplace FROM OOP_schema.candidate where personal_id = ?", "birthplace", LoginUtils.tempUserName));
        nation_textfield_form.setText(MainUtils.setLabel("SELECT nation FROM OOP_schema.candidate where personal_id = ?", "nation", LoginUtils.tempUserName));
        idnum_textfield_form.setText(LoginUtils.tempUserName);
        living_textfield_form.setText(MainUtils.setLabel("SELECT livingaddress FROM OOP_schema.candidate where personal_id = ?", "livingaddress", LoginUtils.tempUserName));
        highschool_textfield_form.setText(MainUtils.setLabel("SELECT highschool FROM OOP_schema.candidate where personal_id = ?", "highschool", LoginUtils.tempUserName));
        email_textfield_form.setText(MainUtils.setLabel("SELECT email FROM OOP_schema.candidate where personal_id = ?", "email", LoginUtils.tempUserName));
        mobile_textfield_form.setText(MainUtils.setLabel("SELECT mobilephone FROM OOP_schema.candidate where personal_id = ?", "mobilephone", LoginUtils.tempUserName));
        address_textfield_form.setText(MainUtils.setLabel("SELECT contactaddress FROM OOP_schema.candidate where personal_id = ?", "contactaddress", LoginUtils.tempUserName));
        String thptqgValue = MainUtils.setLabel("SELECT thptqg FROM OOP_schema.candidate where personal_id = ?", "thptqg", LoginUtils.tempUserName);
        MainUtils.transferInttoString(MainUtils.setLabel("SELECT thptqg FROM candidate WHERE personal_id = ?", "thptqg", LoginUtils.tempUserName), thptqg_radiobutton_form);
        method_textfield_form.setText(MainUtils.setLabel("SELECT edumethod FROM OOP_schema.candidate where personal_id = ?", "edumethod", LoginUtils.tempUserName));
        String free = MainUtils.setLabel("SELECT freecandidate FROM candidate WHERE personal_id = ?", "freecandidate", LoginUtils.tempUserName);
        if (free.equals("NULL")) {
            free_textfield_form.setText("Không có");
        }
        else {
            free_textfield_form.setText(free);
        }
        StringBuilder subjects = new StringBuilder();

        String mathValue = MainUtils.setLabel("SELECT math FROM OOP_schema.candidate where personal_id = ?", "math", LoginUtils.tempUserName);
        if (mathValue.equals("1")) {
            subjects.append("Toán, ");
        }

        String literatureValue = MainUtils.setLabel("SELECT literature FROM OOP_schema.candidate where personal_id = ?", "literature", LoginUtils.tempUserName);
        if (literatureValue.equals("1")) {
            subjects.append("Ngữ Văn, ");
        }

        String naturalscienceValue = MainUtils.setLabel("SELECT science FROM OOP_schema.candidate where personal_id = ?", "science", LoginUtils.tempUserName);
        if (naturalscienceValue.equals("1")) {
            subjects.append("Khoa học tự nhiên: Vật lý, Hoá học, Sinh học, ");
        }
        else {
            String physicValue = MainUtils.setLabel("SELECT physic FROM OOP_schema.candidate where personal_id = ?", "physic", LoginUtils.tempUserName);
            if (physicValue.equals("1")) {
                subjects.append("Vật lý, ");
            }

            String chemistryValue = MainUtils.setLabel("SELECT chemistry FROM OOP_schema.candidate where personal_id = ?", "chemistry", LoginUtils.tempUserName);
            if (chemistryValue.equals("1")) {
                subjects.append("Hoá học, ");
            }

            String bioValue = MainUtils.setLabel("SELECT bio FROM OOP_schema.candidate where personal_id = ?", "bio", LoginUtils.tempUserName);
            if (bioValue.equals("1")) {
                subjects.append("Vật lý, ");
            }
        }

        String socialscienceValue = MainUtils.setLabel("SELECT social FROM OOP_schema.candidate where personal_id = ?", "social", LoginUtils.tempUserName);
        if (socialscienceValue.equals("1")) {
            subjects.append("Khoa học xã hội: Lịch sử, Địa lý, GDCD ");
        }
        else {
            String historyValue = MainUtils.setLabel("SELECT history FROM OOP_schema.candidate where personal_id = ?", "history", LoginUtils.tempUserName);
            if (historyValue.equals("1")) {
                subjects.append("Lịch sử, ");
            }

            String geoValue = MainUtils.setLabel("SELECT geography FROM OOP_schema.candidate where personal_id = ?", "geography", LoginUtils.tempUserName);
            if (geoValue.equals("1")) {
                subjects.append("Địa lý, ");
            }

            String gdcdValue = MainUtils.setLabel("SELECT gdcd FROM OOP_schema.candidate where personal_id = ?", "gdcd", LoginUtils.tempUserName);
            if (gdcdValue.equals("1")) {
                subjects.append("Vật lý, ");
            }
        }

        String languageValue = MainUtils.setLabel("SELECT foreign_language FROM OOP_schema.candidate where personal_id = ?", "foreign_language", LoginUtils.tempUserName);
        if (languageValue.equals("1")) {
            subjects.append("Ngoại ngữ, ");
        }

        if (subjects.length() > 0) {
            subjects.setLength(subjects.length() - 2);
        }

        subject_textarea.setText(subjects.toString());
    }
    public void showCandidateFields() {
        String gender = MainUtils.setLabel("SELECT gender FROM OOP_schema.candidate where personal_id = ?", "gender", LoginUtils.tempUserName);
        MainUtils.transferString(male_radiobutton, female_radiobutton, gender, "Nam");
        String edumethod = MainUtils.setLabel("SELECT edumethod FROM OOP_schema.candidate where personal_id = ?", "edumethod", LoginUtils.tempUserName);
        MainUtils.transferString(thpt_radiobutton, gdtx_radiobutton, edumethod, "THPT");
        String freeCandidate = MainUtils.setLabel("SELECT freecandidate FROM OOP_schema.candidate where personal_id = ?", "freecandidate", LoginUtils.tempUserName);
        if (!freeCandidate.equals("NULL")) {
            MainUtils.transferString(graduated_radiobutton, notgraduated_radiobutton, freeCandidate, "Đã tốt nghiệp THPT");
        }
        String dateString = birthdate_textfield_form.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        birthdate_textfield.setValue(localDate);
        birthplace_textfield.setText(birthplace_textfield1.getText());
        nation_textfield.setText(nation_textfield_form.getText());
        living_textfield.setText(living_textfield_form.getText());
        highschool_textfield.setText(highschool_textfield_form.getText());
        mobile_textfield.setText(mobile_textfield_form.getText());
        email_textfield.setText(email_textfield_form.getText());
        address_textfield.setText(address_textfield_form.getText());
        String thptqgValue = MainUtils.setLabel("SELECT thptqg FROM candidate WHERE personal_id = ?", "thptqg", LoginUtils.tempUserName);
        MainUtils.transferInt(thptqg_radiobutton, thptqgValue);
        String mathValue = MainUtils.setLabel("SELECT math FROM OOP_schema.candidate where personal_id = ?", "math", LoginUtils.tempUserName);
        MainUtils.transferInt(math, mathValue);
        String literatureValue = MainUtils.setLabel("SELECT literature FROM OOP_schema.candidate where personal_id = ?", "literature", LoginUtils.tempUserName);
        MainUtils.transferInt(literature, literatureValue);
        String naturalscienceValue = MainUtils.setLabel("SELECT science FROM OOP_schema.candidate where personal_id = ?", "science", LoginUtils.tempUserName);
        MainUtils.transferInt(naturalscience, naturalscienceValue);
        String socialscienceValue = MainUtils.setLabel("SELECT social FROM OOP_schema.candidate where personal_id = ?", "social", LoginUtils.tempUserName);
        MainUtils.transferInt(socialscience, socialscienceValue);
        String languageValue = MainUtils.setLabel("SELECT foreign_language FROM OOP_schema.candidate where personal_id = ?", "foreign_language", LoginUtils.tempUserName);
        MainUtils.transferInt(foreignlanguage, languageValue);
        if (naturalscience.isSelected()) {
            physic.setSelected(true);
            chemistry.setSelected(true);
            bio.setSelected(true);
            history.setSelected(false);
            geography.setSelected(false);
            gdcd.setSelected(false);
        }
        if (socialscience.isSelected()) {
            history.setSelected(true);
            geography.setSelected(true);
            gdcd.setSelected(true);
            physic.setSelected(false);
            chemistry.setSelected(false);
            bio.setSelected(false);
        }
        String physicValue = MainUtils.setLabel("SELECT physic FROM OOP_schema.candidate where personal_id = ?", "physic", LoginUtils.tempUserName);
        MainUtils.transferInt(physic, physicValue);

        String chemistryValue = MainUtils.setLabel("SELECT chemistry FROM OOP_schema.candidate where personal_id = ?", "chemistry", LoginUtils.tempUserName);
        MainUtils.transferInt(chemistry, chemistryValue);

        String bioValue = MainUtils.setLabel("SELECT bio FROM OOP_schema.candidate where personal_id = ?", "bio", LoginUtils.tempUserName);
        MainUtils.transferInt(bio, bioValue);

        String historyValue = MainUtils.setLabel("SELECT history FROM OOP_schema.candidate where personal_id = ?", "history", LoginUtils.tempUserName);
        MainUtils.transferInt(history, historyValue);

        String geoValue = MainUtils.setLabel("SELECT geography FROM OOP_schema.candidate where personal_id = ?", "geography", LoginUtils.tempUserName);
        MainUtils.transferInt(geography, geoValue);

        String gdcdValue = MainUtils.setLabel("SELECT gdcd FROM OOP_schema.candidate where personal_id = ?", "gdcd", LoginUtils.tempUserName);
        MainUtils.transferInt(gdcd, gdcdValue);
    }

    public void changeCandidate() {
        String changeData = "UPDATE candidate SET gender = ?, birthdate = ?, birthplace = ?, nation = ?, livingaddress = ?, highschool = ?, mobilephone = ?, email = ?, contactaddress = ?, thptqg = ?, edumethod = ?, freecandidate = ?, math = ?, literature = ?, science = ?, social = ?, foreign_language = ?, physic = ?, chemistry = ?, bio = ?, history = ?, geography = ?, gdcd = ? WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        Connection Connect = Database.connectDB();
        try {
            Alert alert;
            if (name_textfield.getText().isEmpty() || sex.getSelectedToggle() == null || birthdate_textfield.getValue() == null || birthplace_textfield.getText().isEmpty() || nation_textfield.getText().isEmpty() || idnum_textfield.getText().isEmpty() || living_textfield.getText().isEmpty() || highschool_textfield.getText().isEmpty() || mobile_textfield.getText().isEmpty() || email_textfield.getText().isEmpty() || address_textfield.getText().isEmpty() ||  edumethod.getSelectedToggle() == null) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng điền tất cả các thông tin bắt buộc!");
                alert.showAndWait();
            }
            else if (!isMobileNum(mobile_textfield.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng định dạng số điện thoại!");
                alert.showAndWait();
            }
            else if (!isValidEmail(email_textfield.getText())) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng định dạng email!");
                alert.showAndWait();
            }
            else if (birthdate_textfield.getValue().getYear() > 2006) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng nhập đúng năm sinh được cho phép!");
                alert.showAndWait();
            }
            else if (graduated_radiobutton.isSelected() && notgraduated_radiobutton.isSelected()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Vui lòng không chọn cả hai lựa chọn trong mục thí sinh tự do!");
                alert.showAndWait();
            }
            else {
                LocalDate birthdate = birthdate_textfield.getValue();
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String birthdateString = birthdate.format(dateTimeFormatter);
                prepare = Connect.prepareStatement(changeData);
                prepare.setString(1, MainUtils.selectedOption(male_radiobutton, male_radiobutton.getText(),female_radiobutton.getText()));
                prepare.setString(2, birthdateString);
                prepare.setString(3, birthplace_textfield.getText());
                prepare.setString(4, nation_textfield.getText());
                prepare.setString(5, living_textfield.getText());
                prepare.setString(6, highschool_textfield.getText());
                prepare.setString(7, mobile_textfield.getText());
                prepare.setString(8, email_textfield.getText());
                prepare.setString(9, address_textfield.getText());
                prepare.setString(10, MainUtils.selectedOption(thptqg_radiobutton, "1","0"));
                prepare.setString(11, MainUtils.selectedOption(thpt_radiobutton,thpt_radiobutton.getText(),gdtx_radiobutton.getText()));
                prepare.setString(12, selectedFreeCandidate());
                prepare.setString(13, MainUtils.selectedOption(math, "1", "0"));
                prepare.setString(14, MainUtils.selectedOption(literature, "1", "0"));
                prepare.setString(15, MainUtils.selectedOption(naturalscience, "1","0"));
                prepare.setString(16, MainUtils.selectedOption(socialscience, "1","0"));
                prepare.setString(17, MainUtils.selectedOption(foreignlanguage, "1","0"));
                prepare.setString(18, MainUtils.selectedOption(physic, "1", "0"));
                prepare.setString(19, MainUtils.selectedOption(chemistry, "1","0"));
                prepare.setString(20, MainUtils.selectedOption(bio,"1","0"));
                prepare.setString(21, MainUtils.selectedOption(history, "1","0"));
                prepare.setString(22, MainUtils.selectedOption(geography, "1","0"));
                prepare.setString(23, MainUtils.selectedOption(gdcd, "1","0"));
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Lưu thành công!");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCandidate() {
        String dateForm = "2024-06-30 23:59:59";
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter tempFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime tempDateForm = LocalDateTime.parse(dateForm, tempFormatter);
        Duration duration3 = Duration.between(currentDate, tempDateForm);
        long daysBetween3 = duration3.toDays();
        if (daysBetween3 < 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hộp thoại báo lỗi");
            alert.setHeaderText("Lỗi");
            alert.setContentText("Quá thời hạn thực hiện chức năng!");
            alert.showAndWait();
        }
        else {
            String deleteSQL = "DELETE FROM candidate WHERE personal_id = '" + LoginUtils.tempUserName + "'";
            Connection connectDB = Database.connectDB();
            try {
                prepare = connectDB.prepareStatement(deleteSQL);
                prepare.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Xoá thành công!");
                alert.showAndWait();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            thptqg_radiobutton_dashboard.setText("");
        }
        String dateForm1 = "2024";
        LocalDateTime lastDate = LocalDateTime.parse(dateForm, DateTimeFormatter.ofPattern("yyyy"));
    }

    public void showSubjectsInfo() {
        subject_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("subject_column"));
        literature_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("literature_column"));
        math_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("math_column"));
        physic_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("physic_column"));
        chemistry_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("chemistry_column"));
        bio_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("bio_column"));
        foreignlanguage_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("foreignlanguage_column"));
        history_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("history_column"));
        geo_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("geo_column"));
        gdcd_column.setCellValueFactory(new PropertyValueFactory<SubjectInfo, String>("gdcd_column"));
        subjectandtime_table.setItems(addSubjectsListInfo());
    }
    public void showRequestInfo() {
        order_column.setCellValueFactory(new PropertyValueFactory<Request, Integer>("request_order"));
        uni_column.setCellValueFactory(new PropertyValueFactory<Request, String>("uni_name"));
        major_column.setCellValueFactory(new PropertyValueFactory<Request, String>("major"));
        unit_column.setCellValueFactory(new PropertyValueFactory<Request, String>("training_unit"));
        program_column.setCellValueFactory(new PropertyValueFactory<Request, String>("training_program"));
        request_tableview.setItems(addRequestsList());
    }
    public int checkNum(){
        Connection connection = Database.connectDB();
        ResultSet reSet=null;
        PreparedStatement pStatement=null;
        String checkData="SELECT request_order FROM request";
        int numOrder = 0;
        try{
            pStatement=connection.prepareStatement(checkData);
            reSet=pStatement.executeQuery();
            while (reSet.next()){
                numOrder=reSet.getInt("request_order");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return numOrder;
    }
    public void requestAdd() {
        int checkN=checkNum();
        int numText= Integer.parseInt(requestorder_textfield.getText());
        if(checkN+1 == numText){
            String insertData = "INSERT INTO request (personal_id, request_order, uni_name, major, training_unit, training_program) VALUES (?, ?, ?, ?, ?, ?)";
            Connection connection = Database.connectDB();
            try {
                prepare = connection.prepareStatement(insertData);
                prepare.setString(1, LoginUtils.tempUserName);
                prepare.setString(2, requestorder_textfield.getText());
                prepare.setString(3, uni_combobox.getValue());
                prepare.setString(4, majors_combobox.getValue());
                prepare.setString(5, trainingunit_fill.getText());
                prepare.setString(6, trainingprogram_combobox_fill.getValue());
                prepare.executeUpdate();
                Alert alert;
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Lưu thành công!");
                alert.showAndWait();

                requestorder_textfield.setText("");
                uni_combobox.setValue(null);
                majors_combobox.setValue(null);
                trainingprogram_combobox_fill.setValue(null);
                trainingunit_fill.setText("");


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else{
            Alert alert1;
            alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Hộp thoại");
            alert1.setHeaderText("Lỗi");
            alert1.setContentText("Vui lòng nhập thứ tự nguyện vọng phù hợp!");
            alert1.showAndWait();

        }
    }
    public void changeRequest() {
        Connection connectDB = Database.connectDB();
        if (tempOrder.equals(requestorder_textfield.getText())) {
            String changeData = "UPDATE request SET uni_name = ?, major = ?, training_unit = ?, training_program = ? WHERE personal_id = '" + LoginUtils.tempUserName + "' AND request_order = " + requestorder_textfield.getText();
            try {
                Alert alert;
                prepare = connectDB.prepareStatement(changeData);
                prepare.setString(1, uni_combobox.getValue());
                prepare.setString(2, majors_combobox.getValue());
                prepare.setString(3, trainingunit_fill.getText());
                prepare.setString(4, trainingprogram_combobox_fill.getValue());
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Sửa thành công!");
                alert.showAndWait();

                requestorder_textfield.setText("");
                uni_combobox.setValue(null);
                majors_combobox.setValue(null);
                trainingprogram_combobox_fill.setValue(null);
                trainingunit_fill.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {
            String tempUni = null;
            String tempMajor = null;
            String tempUnit = null;
            String tempProgram = null;
            String uni_name = "SELECT uni_name FROM request WHERE personal_id = ? AND request_order = ?";
            connectDB = Database.connectDB();
            try (PreparedStatement statement2 = connectDB.prepareStatement(uni_name)) {
                statement2.setString(1, LoginUtils.tempUserName);
                statement2.setString(2, requestorder_textfield.getText());
                ResultSet resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    tempUni = resultSet1.getString("uni_name");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            String major = "SELECT major FROM request WHERE personal_id = ? AND request_order = ?";
            connectDB = Database.connectDB();
            try (PreparedStatement statement2 = connectDB.prepareStatement(major)) {
                statement2.setString(1, LoginUtils.tempUserName);
                statement2.setString(2, requestorder_textfield.getText());
                ResultSet resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    tempMajor = resultSet1.getString("major");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            String unit = "SELECT training_unit FROM request WHERE personal_id = ? AND request_order = ?";
            connectDB = Database.connectDB();
            try (PreparedStatement statement2 = connectDB.prepareStatement(unit)) {
                statement2.setString(1, LoginUtils.tempUserName);
                statement2.setString(2, requestorder_textfield.getText());
                ResultSet resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    tempUnit = resultSet1.getString("training_unit");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            String program = "SELECT training_program FROM request WHERE personal_id = ? AND request_order = ?";
            connectDB = Database.connectDB();
            try (PreparedStatement statement2 = connectDB.prepareStatement(program)) {
                statement2.setString(1, LoginUtils.tempUserName);
                statement2.setString(2, requestorder_textfield.getText());
                ResultSet resultSet1 = statement2.executeQuery();
                if (resultSet1.next()) {
                    tempProgram = resultSet1.getString("training_program");
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            String changeData = "UPDATE request SET uni_name = ?, major = ?, training_unit = ?, training_program = ? WHERE personal_id = '" + LoginUtils.tempUserName + "' AND request_order = " + requestorder_textfield.getText();
            try {
                prepare = connectDB.prepareStatement(changeData);
                prepare.setString(1, uni_combobox.getValue());
                prepare.setString(2, majors_combobox.getValue());
                prepare.setString(3, trainingunit_fill.getText());
                prepare.setString(4, trainingprogram_combobox_fill.getValue());
                prepare.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String changeData1 = "UPDATE request SET uni_name = ?, major = ?, training_unit = ?, training_program = ? WHERE personal_id = '" + LoginUtils.tempUserName + "' AND request_order = " + tempOrder;
            Connection connection = Database.connectDB();
            try {
                Alert alert;
                prepare = connection.prepareStatement(changeData1);
                prepare.setString(1, tempUni);
                prepare.setString(2, tempMajor);
                prepare.setString(3, tempUnit);
                prepare.setString(4, tempProgram);
                prepare.executeUpdate();
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hộp thoại thông báo");
                alert.setHeaderText("Thông báo");
                alert.setContentText("Sửa thành công!");
                alert.showAndWait();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void deleteRequest() {
        TextInputDialog requestOrder =  new TextInputDialog();
        requestOrder.setTitle("Nhập thông tin");
        requestOrder.getDialogPane().setContentText("Nhập thứ tự nguyện vọng cần xoá:");
        Optional<String> order = requestOrder.showAndWait();
        TextField num = requestOrder.getEditor();
        if (order.isPresent()) {
            if (num.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Hộp thoại báo lỗi");
                alert.setHeaderText("Lỗi");
                alert.setContentText("Bạn chưa chọn ngành cần xóa");
                alert.showAndWait();
            }
            else {
                String checkOrder = "SELECT * FROM request WHERE personal_id = ? AND request_order = ?";
                Connection connectDB = Database.connectDB();
                try (PreparedStatement statement1 = connectDB.prepareStatement(checkOrder)) {
                    statement1.setString(1, LoginUtils.tempUserName);
                    statement1.setString(2, num.getText());
                    ResultSet resultSet = statement1.executeQuery();
                    if (!resultSet.next()) {
                        Alert alert2 = new Alert(Alert.AlertType.ERROR);
                        alert2.setTitle("Hộp thoại báo lỗi");
                        alert2.setHeaderText("Lỗi");
                        alert2.setContentText("Chưa có dữ liệu nguyện vọng vừa nhập trong hệ thống!");
                        alert2.showAndWait();
                    }
                    else {
                        String deleteRequest = "DELETE FROM request WHERE personal_id = ? AND request_order = ?";
                        try (PreparedStatement statement2 = connectDB.prepareStatement(deleteRequest)){
                            statement2.setString(1, LoginUtils.tempUserName);
                            statement2.setString(2, num.getText());
                            statement2.executeUpdate();

                            // đoạn code mới thêm dùng cập nhật số khi xóa 1 thành viên trong bảng
                            String updateOrder = "UPDATE request SET request_order = request_order - 1 " +
                                    "WHERE personal_id = ? AND request_order > ?";
                            try (PreparedStatement statement3 = connectDB.prepareStatement(updateOrder)) {
                                statement3.setString(1, LoginUtils.tempUserName);
                                statement3.setInt(2, Integer.parseInt(num.getText()));
                                statement3.executeUpdate();
                            }


                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Hộp thoại thông báo");
                            alert.setHeaderText("Thông báo");
                            alert.setContentText("Xoá thành công!");
                            alert.showAndWait();
                            switch (num.getText()) {
                                case "1": {
                                    uni1_dashboard_field.setText("");
                                    major1_dashboard_field.setText("");
                                    break;
                                }
                                case "2": {
                                    uni2_dashboard_field.setText("");
                                    major2_dashboard_field.setText("");
                                    break;
                                }
                                case "3": {
                                    uni3_dashboard_field.setText("");
                                    major3_dashboard_field.setText("");
                                    break;
                                }
                                default: {
                                    break;
                                }
                            }
                            showRequestInfo();
                        }
                        catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void fillFormDashboard() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from candidate WHERE personal_id = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                MainUtils.transferInttoString(MainUtils.setLabel("SELECT thptqg FROM candidate WHERE personal_id = ?", "thptqg", LoginUtils.tempUserName), thptqg_radiobutton_dashboard);
                String free = MainUtils.setLabel("SELECT freecandidate FROM candidate WHERE personal_id = ?", "freecandidate", LoginUtils.tempUserName);
                if (free.equals("NULL")) {
                    free_textfield_dashboard.setText("Không có");
                }
                else {
                    free_textfield_dashboard.setText(free);
                }
                subject_field_dashboard.setText(MainUtils.countSubject("SELECT SUM(CASE WHEN math=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN literature=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN history=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN geography=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN gdcd=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN bio=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN physic=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN chemistry=1 THEN 1 ELSE 0 END +\n" +
                        "CASE WHEN foreign_language=1 THEN 1 ELSE 0 END\n" +
                        ") AS total FROM candidate WHERE personal_id ='" + LoginUtils.tempUserName + "'", "total"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fillTestDashboard() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from testinfo WHERE personal_id = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                idnum_dashboard_textfield.setText(MainUtils.setLabel("SELECT candidateid FROM testinfo WHERE personal_id = ?", "candidateid", LoginUtils.tempUserName));
                testvenue_dashboard.setText(MainUtils.setLabel("SELECT testvenue FROM testinfo WHERE personal_id = ?", "testvenue", LoginUtils.tempUserName));
                tempDate = MainUtils.setLabel("SELECT checkintime FROM testinfo WHERE personal_id = ?", "checkintime", LoginUtils.tempUserName);
                if (tempDate != null) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    LocalDateTime dateTime = LocalDateTime.parse(tempDate, formatter);
                    DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedString = dateTime.format(newFormatter);
                    checkintime_dashboard.setText(formattedString);
                }
                room_dashboard.setText(MainUtils.setLabel("SELECT testroom FROM testinfo WHERE personal_id = ?", "testroom", LoginUtils.tempUserName));
                LocalDateTime currentDate = LocalDateTime.now();
                DateTimeFormatter tempFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime tempDateTime = LocalDateTime.parse(tempDate, tempFormatter);
                Duration duration = Duration.between(currentDate, tempDateTime);
                long daysBetween = duration.toDays();
                if (daysBetween > 0) {
                    countdown_timer.setText("Còn " + String.valueOf(daysBetween) + " ngày");
                }
                else if (daysBetween == 0) {
                    countdown_timer.setText("Đến ngày dự thi");
                }
                else {
                    countdown_timer.setText("Đã qua ngày thi");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fillRequestDashboard() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from request WHERE personal_id = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                uni1_dashboard_field.setText(MainUtils.setLabel("SELECT uni_name FROM OOP_schema.request WHERE request_order = 1 AND personal_id = ?", "uni_name", LoginUtils.tempUserName));
                uni2_dashboard_field.setText(MainUtils.setLabel("SELECT uni_name FROM OOP_schema.request WHERE request_order = 2 AND personal_id = ?", "uni_name", LoginUtils.tempUserName));
                uni3_dashboard_field.setText(MainUtils.setLabel("SELECT uni_name FROM OOP_schema.request WHERE request_order = 3 AND personal_id = ?", "uni_name", LoginUtils.tempUserName));
                major1_dashboard_field.setText(MainUtils.setLabel("SELECT major FROM OOP_schema.request WHERE request_order = 1 AND personal_id = ?", "major", LoginUtils.tempUserName));
                major2_dashboard_field.setText(MainUtils.setLabel("SELECT major FROM OOP_schema.request WHERE request_order = 2 AND personal_id = ?", "major", LoginUtils.tempUserName));
                major3_dashboard_field.setText(MainUtils.setLabel("SELECT major FROM OOP_schema.request WHERE request_order = 3 AND personal_id = ?", "major", LoginUtils.tempUserName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void fillScoreDashboard() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from score WHERE personal_id = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                XYChart.Series dataseries = new XYChart.Series();
                Double mathScore = Double.parseDouble(MainUtils.setLabel("SELECT math FROM OOP_schema.score WHERE personal_id = ?", "math", LoginUtils.tempUserName));
                Double literatureScore = Double.parseDouble(MainUtils.setLabel("SELECT literature FROM OOP_schema.score WHERE personal_id = ?", "literature", LoginUtils.tempUserName));
                Double foreignlanguage = Double.parseDouble(MainUtils.setLabel("SELECT foreignlanguage FROM OOP_schema.score WHERE personal_id = ?", "foreignlanguage", LoginUtils.tempUserName));
                String physicScore = MainUtils.setLabel("SELECT physic FROM OOP_schema.score WHERE personal_id = ?", "physic", LoginUtils.tempUserName);
                String chemistryScore = MainUtils.setLabel("SELECT chemistry FROM OOP_schema.score WHERE personal_id = ?", "chemistry", LoginUtils.tempUserName);
                String bioScore = MainUtils.setLabel("SELECT bio FROM OOP_schema.score WHERE personal_id = ?", "bio", LoginUtils.tempUserName);
                String historyScore = MainUtils.setLabel("SELECT history FROM OOP_schema.score WHERE personal_id = ?", "history", LoginUtils.tempUserName);
                String geoScore = MainUtils.setLabel("SELECT geography FROM OOP_schema.score WHERE personal_id = ?", "geography", LoginUtils.tempUserName);
                String gdcdScore = MainUtils.setLabel("SELECT gdcd FROM OOP_schema.score WHERE personal_id = ?", "gdcd", LoginUtils.tempUserName);
                if (!physicScore.equals("X")) {
                    Double transferPhysic = Double.parseDouble(physicScore);
                    dataseries.getData().add(new XYChart.Data("Vật lí", transferPhysic));
                }
                if (!chemistryScore.equals("X")) {
                    Double transferChemistry = Double.parseDouble(chemistryScore);
                    dataseries.getData().add(new XYChart.Data("Hoá học", transferChemistry));
                }
                if (!bioScore.equals("X")) {
                    Double transferBio = Double.parseDouble(bioScore);
                    dataseries.getData().add(new XYChart.Data("Sinh học", transferBio));
                }
                if (!historyScore.equals("X")) {
                    Double transferHis = Double.parseDouble(historyScore);
                    dataseries.getData().add(new XYChart.Data("Lịch sử", transferHis));
                }
                if (!geoScore.equals("X")) {
                    Double transferGeo = Double.parseDouble(geoScore);
                    dataseries.getData().add(new XYChart.Data("Địa lý", transferGeo));
                }
                if (!gdcdScore.equals("X")) {
                    Double transferGDCD = Double.parseDouble(gdcdScore);
                    dataseries.getData().add(new XYChart.Data("GDCD", transferGDCD));
                }
                dataseries.getData().add(new XYChart.Data("Toán", mathScore));
                dataseries.getData().add(new XYChart.Data("Ngữ Văn", literatureScore));
                dataseries.getData().add(new XYChart.Data("Ngoại ngữ", foreignlanguage));
                dataseries.setName("Điểm thi THPTQG");
                score_barchart.getData().add(dataseries);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean compareWithLabel(Label label, String data) {
        if (label.getText().isEmpty()) {
            return false;
        }
        double labelValue = Double.parseDouble(label.getText());
        double dataValue = Double.parseDouble(data);

        return labelValue > dataValue;
    }
    public void compareDataWithLabels() {
        String deleteQuery = "DELETE FROM accepteduni WHERE personal_id = ?";
        try (Connection connection = Database.connectDB();
             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
            deleteStatement.setString(1, LoginUtils.tempUserName);
            deleteStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String selectedUniversity = null;
        String selectedMajor = null;
        String selectedTrainingUnit = null;
        String selectedTraningProgram = null;

        String queryRequest = "SELECT uni_name, major, training_unit, training_program FROM request WHERE personal_id = ?";

        try (Connection connection = Database.connectDB()) {
            PreparedStatement preparedStatement = connection.prepareStatement(queryRequest);
            preparedStatement.setString(1, LoginUtils.tempUserName);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) { // Move to the first row
                selectedUniversity = resultSet.getString("uni_name");
                selectedMajor = resultSet.getString("major");
                selectedTrainingUnit = resultSet.getString("training_unit");
                selectedTraningProgram = resultSet.getString("training_program");

                String queryUniInfo = "SELECT a00, a01, b00, c00, d00, d07 FROM uniinfo WHERE name = ? AND major = ? AND training_program = ?";
                PreparedStatement preparedStatement1 = connection.prepareStatement(queryUniInfo);
                preparedStatement1.setString(1, selectedUniversity);
                preparedStatement1.setString(2, selectedMajor);
                preparedStatement1.setString(3, selectedTraningProgram);
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                if (resultSet1.next()) {
                    boolean isAccepted = false;
                    if (resultSet1.getDouble("a00") != 40 && compareWithLabel(a001, resultSet1.getString("a00"))) {
                        isAccepted = true;
                    }
                    if (resultSet1.getDouble("a01") != 40 && compareWithLabel(a011, resultSet1.getString("a01"))) {
                        isAccepted = true;
                    }
                    if (resultSet1.getDouble("b00") != 40 && compareWithLabel(b001, resultSet1.getString("b00"))) {
                        isAccepted = true;
                    }
                    if (resultSet1.getDouble("c00") != 40 && compareWithLabel(c001, resultSet1.getString("c00"))) {
                        isAccepted = true;
                    }
                    if (resultSet1.getDouble("d00") != 40 && compareWithLabel(d001, resultSet1.getString("d00"))) {
                        isAccepted = true;
                    }
                    if (resultSet1.getDouble("d07") != 40 && compareWithLabel(d071, resultSet1.getString("d07"))) {
                        isAccepted = true;
                    }
                    if (isAccepted) { // Check if accepted before inserting
                        String check = "SELECT * FROM accepteduni WHERE personal_id = ? AND name = ? AND major = ? AND training_program = ?";
                        try (PreparedStatement preparedStatement2 = connection.prepareStatement(check)) {
                            preparedStatement2.setString(1, LoginUtils.tempUserName);
                            preparedStatement2.setString(2, selectedUniversity);
                            preparedStatement2.setString(3, selectedMajor);
                            preparedStatement2.setString(4, selectedTraningProgram);

                            ResultSet checkResult = preparedStatement2.executeQuery();
                            if (!checkResult.next()) {
                                if (!thptqg_radiobutton_dashboard.getText().equals("Không")) {
                                    if (!free_textfield_dashboard.getText().equals("Đã tốt nghiệp THPT") && Double.parseDouble(math_score1.getText()) > 1 && Double.parseDouble(literature_score1.getText()) > 1 && Double.parseDouble(foreignlanguage_score1.getText()) > 1) {
                                        if (!physic_score1.getText().equals("X") && !chemistry_score1.getText().equals("X") && !bio_score1.getText().equals("X")) {
                                            if (Double.parseDouble(physic_score1.getText()) > 1 && Double.parseDouble(chemistry_score1.getText()) > 1 && Double.parseDouble(bio_score1.getText()) > 1) {
                                                String insertQuery = "INSERT INTO accepteduni (personal_id, name, major, training_unit, training_program, status) VALUES (?, ?, ?, ?, ?, ?)";
                                                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                                    insertStatement.setString(1, LoginUtils.tempUserName);
                                                    insertStatement.setString(2, selectedUniversity);
                                                    insertStatement.setString(3, selectedMajor);
                                                    insertStatement.setString(4, selectedTrainingUnit);
                                                    insertStatement.setString(5, selectedTraningProgram);
                                                    insertStatement.setString(6, "Trúng tuyển");
                                                    insertStatement.executeUpdate();
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                                //break;
                                            }
                                            else {
                                                String insertQuery = "INSERT INTO accepteduni (personal_id, name, major, training_unit, training_program, status) VALUES (?, ?, ?, ?, ?, ?)";
                                                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                                    insertStatement.setString(1, LoginUtils.tempUserName);
                                                    insertStatement.setString(2, selectedUniversity);
                                                    insertStatement.setString(3, selectedMajor);
                                                    insertStatement.setString(4, selectedTrainingUnit);
                                                    insertStatement.setString(5, selectedTraningProgram);
                                                    insertStatement.setString(6, "Không trúng tuyển");
                                                    insertStatement.executeUpdate();
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                                //break;
                                            }
                                        }
                                        else {
                                            if (Double.parseDouble(history_score1.getText()) > 1 && Double.parseDouble(geography_score1.getText()) > 1 && Double.parseDouble(gdcd_score1.getText()) > 1) {
                                                String insertQuery = "INSERT INTO accepteduni (personal_id, name, major, training_unit, training_program, status) VALUES (?, ?, ?, ?, ?, ?)";
                                                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                                    insertStatement.setString(1, LoginUtils.tempUserName);
                                                    insertStatement.setString(2, selectedUniversity);
                                                    insertStatement.setString(3, selectedMajor);
                                                    insertStatement.setString(4, selectedTrainingUnit);
                                                    insertStatement.setString(5, selectedTraningProgram);
                                                    insertStatement.setString(6, "Trúng tuyển");
                                                    insertStatement.executeUpdate();
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                                //break;
                                            }
                                            else {
                                                String insertQuery = "INSERT INTO accepteduni (personal_id, name, major, training_unit, training_program, status) VALUES (?, ?, ?, ?, ?, ?)";
                                                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                                    insertStatement.setString(1, LoginUtils.tempUserName);
                                                    insertStatement.setString(2, selectedUniversity);
                                                    insertStatement.setString(3, selectedMajor);
                                                    insertStatement.setString(4, selectedTrainingUnit);
                                                    insertStatement.setString(5, selectedTraningProgram);
                                                    insertStatement.setString(6, "Không trúng tuyển");
                                                    insertStatement.executeUpdate();
                                                } catch (SQLException e) {
                                                    e.printStackTrace();
                                                }
                                                //break;
                                            }
                                        }
                                    }
                                else {
                                        String insertQuery = "INSERT INTO accepteduni (personal_id, name, major, training_unit, training_program, status) VALUES (?, ?, ?, ?, ?, ?)";
                                        try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                                            insertStatement.setString(1, LoginUtils.tempUserName);
                                            insertStatement.setString(2, selectedUniversity);
                                            insertStatement.setString(3, selectedMajor);
                                            insertStatement.setString(4, selectedTrainingUnit);
                                            insertStatement.setString(5, selectedTraningProgram);
                                            insertStatement.setString(6, "Trúng tuyển");
                                            insertStatement.executeUpdate();
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                        //break;
                                    }
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public ObservableList<StatusInfo> addStatusList() {
        ObservableList<StatusInfo> status_list = FXCollections.observableArrayList();
        String receiver = "SELECT * FROM accepteduni WHERE personal_id = '" + LoginUtils.tempUserName + "'";
        Connection connection = Database.connectDB();
        try {
            StatusInfo statusInfo;
            prepare = connection.prepareStatement(receiver);
            result = prepare.executeQuery();
            if (result.next()) {
                statusInfo = new StatusInfo(result.getNString("name"), result.getNString("major"), result.getNString("training_unit"), result.getNString("training_program"), result.getNString("status"));
                status_list.add(statusInfo);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return status_list;
    }
    public void showScoreInfo() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = Database.connectDB();
            preparedStatement = connection.prepareStatement("SELECT * from score WHERE personal_id = ?");
            preparedStatement.setString(1, LoginUtils.tempUserName);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                MainUtils.getScore("math", math_score1);
                MainUtils.getScore("literature", literature_score1);
                MainUtils.getScore("foreignlanguage", foreignlanguage_score1);
                MainUtils.getScienceScore("physic", physic_score1);
                MainUtils.getScienceScore("history", history_score1);
                MainUtils.setVisibleScoreLabel(physic_score1, history_score1, physic_scorepane1, history_scorepane1);
                MainUtils.getScienceScore("chemistry", chemistry_score1);
                MainUtils.getScienceScore("geography", geography_score1);
                MainUtils.setVisibleScoreLabel(chemistry_score1, geography_score1, chemistry_scorepane1, geography_scorepane1);
                MainUtils.getScienceScore("bio", bio_score1);
                MainUtils.getScienceScore("gdcd", gdcd_score1);
                MainUtils.setVisibleScoreLabel(bio_score1, gdcd_score1, bio_scorepane1, gdcd_scorepane1);
                MainUtils.calculateScore(math_score1, physic_score1, chemistry_score1, a001);
                MainUtils.calculateScore(math_score1, physic_score1, foreignlanguage_score1, a011);
                MainUtils.calculateScore(math_score1, chemistry_score1, bio_score1, b001);
                MainUtils.calculateScore(math_score1, bio_score1, foreignlanguage_score1, b081);
                MainUtils.calculateScore(literature_score1, history_score1, geography_score1, c001);
                MainUtils.calculateScore(literature_score1, history_score1, gdcd_score1, c191);
                MainUtils.calculateScore(math_score1, literature_score1, foreignlanguage_score1, d001);
                MainUtils.calculateScore(math_score1, chemistry_score1, foreignlanguage_score1, d071);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showStatusInfo() {
        statusinfo_uni_column.setCellValueFactory(new PropertyValueFactory<StatusInfo, String>("university"));
        statusinfo_major_column.setCellValueFactory(new PropertyValueFactory<StatusInfo, String>("major"));
        statusinfo_unit_column.setCellValueFactory(new PropertyValueFactory<StatusInfo, String>("trainingUnit"));
        statusinfo_program_column.setCellValueFactory(new PropertyValueFactory<StatusInfo, String>("trainingProgram"));
        statusinfo_acceptedornot_column.setCellValueFactory(new PropertyValueFactory<StatusInfo, String>("status"));
        statusinfo_tableview.setItems(addStatusList());
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showRequestInfo();
        String nameLabel = MainUtils.setLabel("SELECT user_name FROM OOP_schema.users where username = ?", "user_name", LoginUtils.tempUserName);
        name_label.setText(nameLabel);
        name_label2.setText(nameLabel);
        tempName = nameLabel;
        idnum_label.setText(LoginUtils.tempUserName);
        name_textfield.setText(nameLabel);
        name_textfield.setEditable(false);
        idnum_textfield.setEditable(false);
        idnum_textfield.setText(LoginUtils.tempUserName);
        trainingprogram_combobox_fill.setItems(trainingprogram_list);
        showScoreInfo();
        uni_combobox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (newValue.contains("Đại học")) {
                    trainingunit_fill.setText("Đại học");
                } else if (newValue.contains("Cao đẳng")) {
                    trainingunit_fill.setText("Cao đẳng");
                }
            }
        });
        uni_combobox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                uni_combobox.setItems(nameSchool_list);
                // đưa danh sách các trường vào ci uni_combobox
                if (uni_combobox != null) {
                    uni_combobox.valueProperty().addListener((observable, oldValue, newValue) -> {
                        if (newValue != null) {
                            ObservableList<String> nameMajors_list = FXCollections.observableArrayList(listNameMajors(newValue));
                            majors_combobox.setItems(nameMajors_list);
                        } else {
                            majors_combobox.setItems(FXCollections.observableArrayList());
                        }
                    });
                }
                property.set(property.get() + 1);
                // kiểm tra nếu uni_combobox đã được chọn thì sẽ thực hiện cái listener thực hiện đưa danh sách các ngành vào
            }
        });
        fillFormDashboard();
        fillTestDashboard();
        fillRequestDashboard();
        fillScoreDashboard();
        checkPaneltoShow();
        changepass_item.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                MainUtils.changeStage(event, "Đổi mã đăng nhập - Hệ thống quản lí thi tốt nghiệp THPTQG", "changepass-view.fxml",600,400);
            }
        });

        home_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboard_panel.setVisible(true);
                form_stackpanel.setVisible(false);
                testinfo_panel.setVisible(false);
                score_anchorpane.setVisible(false);
                request_panel.setVisible(false);
                statusinfo_panel.setVisible(false);
                fillFormDashboard();
                fillRequestDashboard();
                checkPaneltoShow();
            }
        });
        home_button.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(true);
            form_line.setVisible(false);
            option_line.setVisible(false);
            request_line.setVisible(false);
        });
        form_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String checkForm = "SELECT * FROM candidate WHERE personal_id = '" + LoginUtils.tempUserName + "'";
                Connection connection = Database.connectDB();
                try {
                    Statement preparedStatement = connection.createStatement();
                    ResultSet receivedResult = preparedStatement.executeQuery(checkForm);
                    if (receivedResult.next()) {
                        dashboard_panel.setVisible(false);
                        form_stackpanel.setVisible(true);
                        showform_panel.setVisible(true);
                        showCandidateForm();
                        delete_button.setVisible(true);
                        change_button.setVisible(true);
                        fillform_panel.setVisible(false);
                        testinfo_panel.setVisible(false);
                        score_anchorpane.setVisible(false);
                        request_panel.setVisible(false);
                        statusinfo_panel.setVisible(false);
                        printform_button.setVisible(true);
                        viewform_button.setVisible(true);
                    }
                    else {
                        dashboard_panel.setVisible(false);
                        form_stackpanel.setVisible(true);
                        fillform_panel.setVisible(true);
                        delete_button.setVisible(false);
                        change_button.setVisible(false);
                        showform_panel.setVisible(false);
                        testinfo_panel.setVisible(false);
                        score_anchorpane.setVisible(false);
                        request_panel.setVisible(false);
                        statusinfo_panel.setVisible(false);
                        printform_button.setVisible(false);
                        viewform_button.setVisible(false);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        form_button.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(true);
            option_line.setVisible(false);
            request_line.setVisible(false);
        });
        request_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dashboard_panel.setVisible(false);
                form_stackpanel.setVisible(false);
                testinfo_panel.setVisible(false);
                score_anchorpane.setVisible(false);
                request_panel.setVisible(true);
                statusinfo_panel.setVisible(false);
                showRequestInfo();
            }
        });
        request_button.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(false);
            option_line.setVisible(false);
            request_line.setVisible(true);
        });
        option_button.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(false);
            option_line.setVisible(true);
            request_line.setVisible(false);
        });
        form_dashboard_editbutton.setOnAction(form_button.getOnAction());
        form_dashboard_editbutton.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(true);
            option_line.setVisible(false);
            request_line.setVisible(false);
        });
        request_dashboard_viewbutton.setOnAction(request_button.getOnAction());
        request_dashboard_viewbutton.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(false);
            option_line.setVisible(false);
            request_line.setVisible(true);
        });

        logout_item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Xác nhận thoát");
                    alert.setHeaderText(null);
                    alert.setContentText("Bạn có chắc chắn muốn thoát không?");
                    Optional<ButtonType> option = alert.showAndWait();

                    if (option.isPresent() && option.get() == ButtonType.OK) {

                        logout_item.getScene().getWindow().hide();
                        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
                        Stage stage = new Stage();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        EventHandler<ActionEvent> action1 = event -> {
            dashboard_panel.setVisible(false);
            form_stackpanel.setVisible(false);
            testinfo_panel.setVisible(true);
            score_anchorpane.setVisible(false);
            request_panel.setVisible(false);
            statusinfo_panel.setVisible(false);
            idnum_testinfo_textfield.setText(MainUtils.setLabel("SELECT candidateid FROM OOP_schema.testinfo WHERE personal_id = ?","candidateid",LoginUtils.tempUserName));
            testvenue.setText(MainUtils.setLabel("SELECT testvenue FROM OOP_schema.testinfo WHERE personal_id = ?","testvenue",LoginUtils.tempUserName));
            room.setText(MainUtils.setLabel("SELECT testroom FROM OOP_schema.testinfo WHERE personal_id = ?","testroom",LoginUtils.tempUserName));
            String datetimeString = MainUtils.setLabel("SELECT checkintime FROM OOP_schema.testinfo WHERE personal_id = ?","checkintime",LoginUtils.tempUserName);
            if (datetimeString != null) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(datetimeString, formatter);
                DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedString = dateTime.format(newFormatter);
                checkintime.setText(formattedString);
            }
            showSubjectsInfo();
        };
        testinfo_item.setOnAction(action1);
        testinfo_dashboard_viewbutton.setOnAction(action1);
        testinfo_dashboard_viewbutton.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(false);
            option_line.setVisible(true);
            request_line.setVisible(false);
        });
        EventHandler<ActionEvent> action2 = event -> {
            dashboard_panel.setVisible(false);
            form_stackpanel.setVisible(false);
            testinfo_panel.setVisible(false);
            score_anchorpane.setVisible(true);
            request_panel.setVisible(false);
            statusinfo_panel.setVisible(false);

        };
        score_item.setOnAction(action2);
        score_dashboard_viewbutton.setOnAction(action2);
        score_dashboard_viewbutton.setOnMouseClicked(mouseEvent -> {
            home_line.setVisible(false);
            form_line.setVisible(false);
            option_line.setVisible(true);
            request_line.setVisible(false);
        });
        EventHandler<ActionEvent> action3 = event -> {
            dashboard_panel.setVisible(false);
            form_stackpanel.setVisible(false);
            testinfo_panel.setVisible(false);
            score_anchorpane.setVisible(false);
            request_panel.setVisible(false);
            statusinfo_panel.setVisible(true);
            addStatusList().clear();
            compareDataWithLabels();
            showStatusInfo();
        };
        statusinfo_item.setOnAction(action3);
        save_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connection connection = Database.connectDB();
                String checkAvailable = "SELECT * FROM candidate WHERE personal_id = '" + LoginUtils.tempUserName + "'";
                try {
                    statement = connection.createStatement();
                    result = statement.executeQuery(checkAvailable);
                    if (result.next()) {
                        if ((!graduated_radiobutton.isSelected() && !notgraduated_radiobutton.isSelected() || notgraduated_radiobutton.isSelected())) {
                            if (!math.isSelected() || !literature.isSelected() || !foreignlanguage.isSelected()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Hộp thoại báo lỗi");
                                alert.setHeaderText("Lỗi");
                                alert.setContentText("Thí sinh chưa tốt nghiệp vui lòng chọn đủ các môn thi bắt buộc !");
                                alert.showAndWait();
                            }
                            else {
                                if (!naturalscience.isSelected() && !socialscience.isSelected()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Hộp thoại báo lỗi");
                                    alert.setHeaderText("Lỗi");
                                    alert.setContentText("Thí sinh chưa tốt nghiệp vui lòng chọn đủ các môn thi bắt buộc !");
                                    alert.showAndWait();
                                }
                                else {
                                    changeCandidate();
                                    delete_button.setVisible(true);
                                    change_button.setVisible(true);
                                    showCandidateForm();
                                    showform_panel.setVisible(true);
                                    printform_button.setVisible(true);
                                    fillform_panel.setVisible(false);
                                }
                            }
                        }
                        if (graduated_radiobutton.isSelected() && !notgraduated_radiobutton.isSelected()) {
                            changeCandidate();
                            delete_button.setVisible(true);
                            change_button.setVisible(true);
                            showCandidateForm();
                            showform_panel.setVisible(true);
                            printform_button.setVisible(true);
                            fillform_panel.setVisible(false);
                        }
                    }
                    else {
                        if ((!graduated_radiobutton.isSelected() && !notgraduated_radiobutton.isSelected() || notgraduated_radiobutton.isSelected())) {
                            if (!math.isSelected() || !literature.isSelected() || !foreignlanguage.isSelected()) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Hộp thoại báo lỗi");
                                alert.setHeaderText("Lỗi");
                                alert.setContentText("Thí sinh chưa tốt nghiệp vui lòng chọn đủ các môn thi bắt buộc !");
                                alert.showAndWait();
                            }
                            else {
                                if (!naturalscience.isSelected() && !socialscience.isSelected()) {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Hộp thoại báo lỗi");
                                    alert.setHeaderText("Lỗi");
                                    alert.setContentText("Thí sinh chưa tốt nghiệp vui lòng chọn đủ các môn thi bắt buộc !");
                                    alert.showAndWait();
                                }
                                else {
                                    candidateAdd();
                                }
                            }
                        }
                        if (graduated_radiobutton.isSelected() && !notgraduated_radiobutton.isSelected()) {
                            candidateAdd();
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                fillFormDashboard();
            }
        });
        naturalscience.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainUtils.checkRadioButton(history, geography, gdcd, physic, chemistry, bio);
                history.setDisable(true);
                geography.setDisable(true);
                gdcd.setDisable(true);
                physic.setSelected(true);
                chemistry.setSelected(true);
                bio.setSelected(true);
            }
        });
        socialscience.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainUtils.checkRadioButton(physic, chemistry, bio, history, geography, gdcd);
                physic.setDisable(true);
                chemistry.setDisable(true);
                bio.setDisable(true);
                history.setSelected(true);
                geography.setSelected(true);
                gdcd.setSelected(true);
            }
        });
        change_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String dateForm = "2024-06-30 23:59:59";
                LocalDateTime currentDate = LocalDateTime.now();
                DateTimeFormatter tempFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime tempDateForm = LocalDateTime.parse(dateForm, tempFormatter);
                Duration duration3 = Duration.between(currentDate, tempDateForm);
                long daysBetween3 = duration3.toDays();
                if (daysBetween3 < 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hộp thoại báo lỗi");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Quá thời hạn thực hiện chức năng!");
                    alert.showAndWait();
                }
                else {
                    fillform_panel.setVisible(true);
                    showform_panel.setVisible(false);
                    showCandidateFields();
                }
            }
        });
        delete_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteCandidate();
                free_textfield_dashboard.setText("");
                subject_field_dashboard.setText("");
            }
        });
        viewform_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Connection connectedDB = Database.connectDB();
                String checkAvailable = "SELECT * FROM candidate WHERE personal_id = '" + LoginUtils.tempUserName + "'";
                try {
                    statement = connectedDB.createStatement();
                    result = statement.executeQuery(checkAvailable);
                    if (result.next()) {
                        fillform_panel.setVisible(false);
                        showform_panel.setVisible(true);
                        showCandidateForm();
                        delete_button.setVisible(true);
                        change_button.setVisible(true);
                        printform_button.setVisible(true);
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hộp thoại báo lỗi");
                        alert.setHeaderText("Lỗi");
                        alert.setContentText("Chưa có dữ liệu để xem!");
                        alert.showAndWait();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        addrequest_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Alert alert;
                if (requestorder_textfield.getText().isEmpty() || uni_combobox.getValue()== null || majors_combobox.getValue()==null || trainingprogram_combobox_fill.getValue() == null) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hộp thoại báo lỗi");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Vui lòng điền tất cả các thông tin bắt buộc!");
                    alert.showAndWait();
                }
                else {
                    if (isNumeric(requestorder_textfield.getText())) {
                        Connection connection = Database.connectDB();
                        String checkRequest = "SELECT * FROM request WHERE request_order >= " + requestorder_textfield.getText() + " AND personal_id = '" + LoginUtils.tempUserName + "'";
                        Alert alert1 = null;
                        try {
                            statement = connection.createStatement();
                            result = statement.executeQuery(checkRequest);
                            if (result.next()) {
                                String checkOrder = "SELECT * FROM request WHERE request_order = " + requestorder_textfield.getText() + " AND personal_id = '" + LoginUtils.tempUserName + "'";
                                statement = connection.createStatement();
                                result = statement.executeQuery(checkOrder);
                                if (result.next()) {
                                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                                    alert2.setTitle("Hộp thoại xác nhận");
                                    alert2.setHeaderText("Xác nhận");
                                    alert2.setContentText("Có muốn chỉnh sửa nguyện vọng không?");
                                    Optional<ButtonType> option = alert2.showAndWait();
                                    if (option.get() == null) {
                                        alert1 = new Alert(Alert.AlertType.ERROR);
                                        alert1.setTitle("Hộp thoại báo lỗi");
                                        alert1.setHeaderText("Lỗi");
                                        alert1.setContentText("Đã có nguyện vọng tương tự được thêm vào!");
                                        alert1.showAndWait();
                                    } else if (option.get() == ButtonType.OK) {
                                        if (MainUtils.isRequestMatchUniInfo(uni_combobox.getValue(), majors_combobox.getValue(), trainingunit_fill.getText(), trainingprogram_combobox_fill.getValue())) {
                                            changeRequest();
                                            requestorder_textfield.setText("");
                                            uni_combobox.setValue(null);
                                            majors_combobox.setValue(null);
                                            trainingunit_fill.setText("");
                                            trainingprogram_combobox_fill.setValue(null);
                                        } else {
                                            alert1 = new Alert(Alert.AlertType.ERROR);
                                            alert1.setTitle("Hộp thoại báo lỗi");
                                            alert1.setHeaderText("Lỗi");
                                            alert1.setContentText("Thông tin không trùng khớp với cơ sở dữ liệu!");
                                            alert1.showAndWait();
                                        }
                                    } else if (option.get() == ButtonType.CANCEL) {
                                        alert1 = new Alert(Alert.AlertType.ERROR);
                                        alert1.setTitle("Hộp thoại báo lỗi");
                                        alert1.setHeaderText("Lỗi");
                                        alert1.setContentText("Đã có nguyện vọng tương tự được thêm vào!");
                                        alert1.showAndWait();
                                    }
                                } else {
                                    if (MainUtils.isRequestMatchUniInfo(uni_combobox.getValue(), majors_combobox.getValue(), trainingunit_fill.getText(), trainingprogram_combobox_fill.getValue())) {
                                        requestAdd();
                                        requestorder_textfield.setText("");
                                        uni_combobox.setValue(null);
                                        majors_combobox.setValue(null);
                                        trainingunit_fill.setText("");
                                        trainingprogram_combobox_fill.setValue(null);
                                    } else {
                                        alert1 = new Alert(Alert.AlertType.ERROR);
                                        alert1.setTitle("Hộp thoại báo lỗi");
                                        alert1.setHeaderText("Lỗi");
                                        alert1.setContentText("Thông tin không trùng khớp với cơ sở dữ liệu!");
                                        alert1.showAndWait();
                                    }
                                }
                            } else {
                                String checkAvailable = "SELECT * FROM OOP_schema.request WHERE uni_name = ? AND major = ? AND training_unit = ? AND training_program = ?";
                                try (PreparedStatement statement1 = connection.prepareStatement(checkAvailable)) {
                                    statement1.setString(1, uni_combobox.getValue());
                                    statement1.setString(2, majors_combobox.getValue());
                                    statement1.setString(3, trainingunit_fill.getText());
                                    statement1.setString(4, trainingprogram_combobox_fill.getValue());
                                    ResultSet resultSet = statement1.executeQuery();
                                    if (resultSet.next()) {
                                        alert1 = new Alert(Alert.AlertType.ERROR);
                                        alert1.setTitle("Hộp thoại báo lỗi");
                                        alert1.setHeaderText("Lỗi");
                                        alert1.setContentText("Đã có nguyện vọng tương tự được thêm vào!");
                                        alert1.showAndWait();
                                    } else {
                                        if (MainUtils.isRequestMatchUniInfo(uni_combobox.getValue(), majors_combobox.getValue(), trainingunit_fill.getText(), trainingprogram_combobox_fill.getValue())) {
                                            requestAdd();
                                        } else {
                                            alert1 = new Alert(Alert.AlertType.ERROR);
                                            alert1.setTitle("Hộp thoại báo lỗi");
                                            alert1.setHeaderText("Lỗi");
                                            alert1.setContentText("Thông tin không trùng khớp với cơ sở dữ liệu!");
                                            alert1.showAndWait();
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        showRequestInfo();
                    } else {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
                        alert1.setTitle("Hộp thoại báo lỗi");
                        alert1.setHeaderText("Lỗi");
                        alert1.setContentText("Vui lòng điền đúng kiểu dữ liệu!");
                        alert1.showAndWait();
                    }
                }
            }
        });
        deleterequest_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                deleteRequest();
            }
        });
        changeorder_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog requestOrder =  new TextInputDialog();
                requestOrder.setTitle("Nhập thông tin");
                requestOrder.getDialogPane().setContentText("Nhập thứ tự nguyện vọng cần thay đổi:");
                Optional<String> order = requestOrder.showAndWait();
                TextField num = requestOrder.getEditor();
                tempOrder = num.getText();
                if (order.isPresent()) {
                    if (num.getText().isEmpty()) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Hộp thoại báo lỗi");
                        alert.setHeaderText("Lỗi");
                        alert.setContentText("Chưa nhập dữ liệu!");
                        alert.showAndWait();
                    }
                    else {
                        String checkOrder = "SELECT * FROM request WHERE personal_id = ? AND request_order = ?";
                        Connection Connect = Database.connectDB();
                        try (PreparedStatement prepare = Connect.prepareStatement(checkOrder)) {
                            prepare.setString(1, LoginUtils.tempUserName);
                            prepare.setString(2, num.getText());
                            try (ResultSet result = prepare.executeQuery()) {
                                if (result.next()) {
                                    String getUniField = "SELECT uni_name FROM request WHERE personal_id = ? AND request_order = ?";
                                    try (PreparedStatement prepare1 = Connect.prepareStatement(getUniField)) {
                                        prepare1.setString(1, LoginUtils.tempUserName);
                                        prepare1.setString(2, num.getText());
                                        try (ResultSet result1 = prepare1.executeQuery()) {
                                            if (result1.next()) {
                                                uni_combobox.setValue(result1.getNString("uni_name"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    String getMajorField = "SELECT major FROM request WHERE personal_id = ? AND request_order = ?";
                                    try (PreparedStatement prepare2 = Connect.prepareStatement(getMajorField)) {
                                        prepare2.setString(1, LoginUtils.tempUserName);
                                        prepare2.setString(2, num.getText());
                                        try (ResultSet result2 = prepare2.executeQuery()) {
                                            if (result2.next()) {
                                                majors_combobox.setValue(result2.getNString("major"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    String getTUField = "SELECT training_unit FROM request WHERE personal_id = ? AND request_order = ?";
                                    try (PreparedStatement prepare3 = Connect.prepareStatement(getTUField)) {
                                        prepare3.setString(1, LoginUtils.tempUserName);
                                        prepare3.setString(2, num.getText());
                                        try (ResultSet result3 = prepare3.executeQuery()) {
                                            if (result3.next()) {
                                                trainingunit_fill.setText((result3.getNString("training_unit")));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    String getTPField = "SELECT training_program FROM request WHERE personal_id = ? AND request_order = ?";
                                    try (PreparedStatement prepare4 = Connect.prepareStatement(getTPField)) {
                                        prepare4.setString(1, LoginUtils.tempUserName);
                                        prepare4.setString(2, num.getText());
                                        try (ResultSet result4 = prepare4.executeQuery()) {
                                            if (result4.next()) {
                                                trainingprogram_combobox_fill.setValue(result4.getNString("training_program"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    requestorder_textfield.setText(num.getText());
                                }
                                else {
                                    Alert alert = new Alert(Alert.AlertType.ERROR);
                                    alert.setTitle("Hộp thoại báo lỗi");
                                    alert.setHeaderText("Lỗi");
                                    alert.setContentText("Chưa có dữ liệu trong hệ thống!");
                                    alert.showAndWait();
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        printform_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(name_textfield_form.getText()==null ||
                        birthdate_textfield_form.getText()==null ||
                        nation_textfield_form.getText()==null ||
                        birthplace_textfield1.getText()==null
                ){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Hộp thoại báo lỗi");
                    alert.setHeaderText("Lỗi");
                    alert.setContentText("Chưa có dữ liệu để xuất!");
                    alert.showAndWait();
                }
                else {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf"));
                    String nameClear=editText(nameLabel) ;
                    fileChooser.setInitialFileName(nameClear+".pdf");

                    File file=fileChooser.showSaveDialog(new Stage());

                    if(file != null){
                        PdfWriter writer = null;
                        try {
                            writer = new PdfWriter(file.getAbsolutePath());
                            // Tạo PdfDocument
                            PdfDocument pdfDoc = new PdfDocument(writer);
                            // Tạo Document
                            Document document = new Document(pdfDoc);
                            if (getOsName().startsWith("Windows")) {
                                document.setFont(PdfFontFactory.createFont("C:\\Windows\\Fonts\\arial.ttf"));
                            }
                            else if (getOsName().startsWith("Mac")) {
                                document.setFont(PdfFontFactory.createFont("/System/Library/Fonts/Supplemental/Arial.ttf"));
                            }
                            else {
                                document.setFont(PdfFontFactory.createFont("/usr/share/fonts/truetype/dejavu/DejaVuSans-Bold.ttf"));
                            }

                            // Thêm tiêu đề
                            document.add(new Paragraph("Giấy đăng ký dự thi").setBold().setFontSize(24)
                                    .setMarginBottom(5).setTextAlignment(TextAlignment.CENTER));

                            // Thêm thông tin học sinh
                            document.add(new Paragraph("A.Thông tin cá nhân").setFontSize(17).setBold());
                            document.add(new Paragraph("Họ và tên: "+name_textfield_form.getText()));
                            document.add(new Paragraph("Ngày sinh: "+birthdate_textfield_form.getText()+"                                   Giới tính: "+gender_textfield_form.getText()));
                            document.add(new Paragraph("Dân tộc: "+nation_textfield_form.getText()+"                                                  Số CCCD/CMND: "+idnum_textfield.getText()));
                            document.add(new Paragraph("Nơi sinh: "+birthplace_textfield1.getText()));
                            document.add(new Paragraph("Nơi thường trú: "+living_textfield_form.getText()));
                            document.add(new Paragraph("Trường học hiện tại: "+highschool_textfield_form.getText()));
                            document.add(new Paragraph("Số điện thoại: "+mobile_textfield_form.getText()+"                                    Email: "+email_textfield.getText()));
                            document.add(new Paragraph("Địa chỉ liên hệ: "+address_textfield_form.getText()));

                            document.add(new Paragraph("B.Thông tin đăng ký").setFontSize(17).setBold());
                            String thpt="Không";
                            if(thptqg_radiobutton_form.getText().equals("Có")){
                                thpt="Có";
                            }
                            document.add(new Paragraph("Sử dụng kết quả thi THPT để xét tuyển ĐH, CĐ: "+thpt));
                            document.add(new Paragraph("Hình thức giáo dục phổ thông: "+method_textfield_form.getText()));
                            document.add(new Paragraph("Thí sinh tự do: "+free_textfield_form.getText()));


                            document.add(new Paragraph("Tổ hợp môn thi: "+subject_textarea.getText()));

                            document.add(new Paragraph("Thí sinh ký tên").setTextAlignment(TextAlignment.RIGHT).setMarginRight(52));
                            document.add(new Paragraph(""));
                            document.add(new Paragraph(""));
                            document.add(new Paragraph(""));
                            document.add(new Paragraph(""));
                            document.add(new Paragraph(""));
                            document.add(new Paragraph(nameLabel).setTextAlignment(TextAlignment.RIGHT).setMarginRight(40));

                            // Đóng tài liệu
                            document.close();
                        }catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        });
    }
}
