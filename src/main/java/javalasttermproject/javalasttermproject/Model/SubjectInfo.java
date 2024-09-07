package javalasttermproject.javalasttermproject.Model;

public class SubjectInfo {
    String subject_column;
    String literature_column;
    String math_column;
    String physic_column;
    String chemistry_column;
    String bio_column;
    String foreignlanguage_column;
    String history_column;
    String geo_column;
    String gdcd_column;

    public SubjectInfo(String subject_column, String literature_column, String math_column, String physic_column, String chemistry_column, String bio_column, String foreignlanguage_column, String history_column, String geo_column, String gdcd_column) {
        this.subject_column = subject_column;
        this.literature_column = literature_column;
        this.math_column = math_column;
        this.physic_column = physic_column;
        this.chemistry_column = chemistry_column;
        this.bio_column = bio_column;
        this.foreignlanguage_column = foreignlanguage_column;
        this.history_column = history_column;
        this.geo_column = geo_column;
        this.gdcd_column = gdcd_column;
    }

    public String getSubject_column() {
        return subject_column;
    }

    public void setSubject_column(String subject_column) {
        this.subject_column = subject_column;
    }

    public String getLiterature_column() {
        return literature_column;
    }

    public void setLiterature_column(String literature_column) {
        this.literature_column = literature_column;
    }

    public String getMath_column() {
        return math_column;
    }

    public void setMath_column(String math_column) {
        this.math_column = math_column;
    }

    public String getPhysic_column() {
        return physic_column;
    }

    public void setPhysic_column(String physic_column) {
        this.physic_column = physic_column;
    }

    public String getChemistry_column() {
        return chemistry_column;
    }

    public void setChemistry_column(String chemistry_column) {
        this.chemistry_column = chemistry_column;
    }

    public String getBio_column() {
        return bio_column;
    }

    public void setBio_column(String bio_column) {
        this.bio_column = bio_column;
    }

    public String getForeignlanguage_column() {
        return foreignlanguage_column;
    }

    public void setForeignlanguage_column(String foreignlanguage_column) {
        this.foreignlanguage_column = foreignlanguage_column;
    }

    public String getHistory_column() {
        return history_column;
    }

    public void setHistory_column(String history_column) {
        this.history_column = history_column;
    }

    public String getGeo_column() {
        return geo_column;
    }

    public void setGeo_column(String geo_column) {
        this.geo_column = geo_column;
    }

    public String getGdcd_column() {
        return gdcd_column;
    }

    public void setGdcd_column(String gdcd_column) {
        this.gdcd_column = gdcd_column;
    }
}
