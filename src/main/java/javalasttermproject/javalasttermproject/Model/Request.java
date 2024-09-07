package javalasttermproject.javalasttermproject.Model;

public class Request {
    String personal_id;
    int request_order;
    String uni_name;
    String major;
    String training_unit;
    String training_program;

    public Request(String personal_id, int request_order, String uni_name, String major, String training_unit, String training_program) {
        this.personal_id = personal_id;
        this.request_order = request_order;
        this.uni_name = uni_name;
        this.major = major;
        this.training_unit = training_unit;
        this.training_program = training_program;
    }

    public String getPersonal_id() {
        return personal_id;
    }

    public void setPersonal_id(String personal_id) {
        this.personal_id = personal_id;
    }

    public int getRequest_order() {
        return request_order;
    }

    public void setRequest_order(int request_order) {
        this.request_order = request_order;
    }

    public String getUni_name() {
        return uni_name;
    }

    public void setUni_name(String uni_name) {
        this.uni_name = uni_name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTraining_unit() {
        return training_unit;
    }

    public void setTraining_unit(String training_unit) {
        this.training_unit = training_unit;
    }

    public String getTraining_program() {
        return training_program;
    }

    public void setTraining_program(String training_program) {
        this.training_program = training_program;
    }
}
