package models;


public class Praetor implements PraetorDto{

    private Integer id;
    private String prenomen;
    private String nomen;
    private String cognomen;
    private String province;
    private Integer yearAssigned;

    public Praetor(){

    }

    public Praetor( Integer id, String prenomen, String nomen, String cognomen, String province, Integer yearAssigned){
        this.id = id;
        this.prenomen = prenomen;
        this.nomen = nomen;
        this.cognomen = cognomen;
        this.province = province;
        this.yearAssigned = yearAssigned;
    }

    public Praetor(String prenomen, String nomen, String cognomen, String province, Integer yearAssigned){
        this.prenomen = prenomen;
        this.nomen = nomen;
        this.cognomen = cognomen;
        this.province = province;
        this.yearAssigned = yearAssigned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenomen() {
        return prenomen;
    }

    public void setPrenomen(String prenomen) {
        this.prenomen = prenomen;
    }

    public String getNomen() {
        return nomen;
    }

    public void setNomen(String nomen) {
        this.nomen = nomen;
    }

    public String getCognomen() {
        return cognomen;
    }

    public void setCognomen(String cognomen) {
        this.cognomen = cognomen;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getYearAssigned() {
        return yearAssigned;
    }

    public void setYearAssigned(Integer yearAssigned) {
        this.yearAssigned = yearAssigned;
    }
}
