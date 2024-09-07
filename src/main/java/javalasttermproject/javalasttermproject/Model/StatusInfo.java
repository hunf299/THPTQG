package javalasttermproject.javalasttermproject.Model;

public class StatusInfo {
    private String university;
    private String major;
    private String status;
    private String trainingUnit;
    private String trainingProgram;
    public StatusInfo(String university, String major, String trainingUnit, String trainingProgram, String status) {
        this.university = university;
        this.major = major;
        this.trainingUnit = trainingUnit;
        this.trainingProgram = trainingProgram;
        this.status = status;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainingUnit() {
        return trainingUnit;
    }

    public void setTrainingUnit(String trainingUnit) {
        this.trainingUnit = trainingUnit;
    }

    public String getTrainingProgram() {
        return trainingProgram;
    }

    public void setTrainingProgram(String trainingProgram) {
        this.trainingProgram = trainingProgram;
    }
}

