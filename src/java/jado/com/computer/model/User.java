package jado.com.computer.model;

public class User {

    private String username;
    private String school;
    private String department;
    private int regnumber;
    private int id;

    private String gate;
    private String identification;
    private String phone;
    private String email;
    private String gateman;
    private String date;
    private String serialnumber;

    public User(int id,int regnumber, String username, String email, String phone, String serialnumber, String identification, String school, String department, String gate, String gateman, String date) {
        super();
        this.id=id;
        this.regnumber = regnumber;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.serialnumber = serialnumber;
        this.identification = identification;
        this.school = school;
        this.department = department;
        this.gate = gate;
        this.gateman = gateman;

        this.date = date;

    }
    
    public User(int regnumber, String username, String email, String phone, String serialnumber, String identification, String school, String department, String gate, String gateman, String date) {
        super();
        this.regnumber = regnumber;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.serialnumber = serialnumber;
        this.identification = identification;
        this.school = school;
        this.department = department;
        this.gate = gate;
        this.gateman = gateman;

        this.date = date;

    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getRegnumber() {
        return regnumber;
    }

    public void setRegnumber(int regnumber) {
        this.regnumber = regnumber;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGateman() {
        return gateman;
    }

    public void setGateman(String gateman) {
        this.gateman = gateman;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

}
