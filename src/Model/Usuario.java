package Model;

import java.util.Date;

public class Usuario {
    private int id;
    private String userName;
    private String email;
    private Telefono phoneNumber;
    private String dni;
    private String fullName;
    private String password;
    private Date createdAT;
    private Date updateAT;

    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public Usuario(int id, String userName, String email, Telefono phoneNumber, String dni,
            String fullName, String password, Date createdAT, Date updateAT) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
        this.email = email;
        this.createdAT = createdAT;
        this.updateAT = updateAT;
    }

    //SET'S
    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Telefono phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreatedAT(Date createdAT) {
        this.createdAT = createdAT;
    }

    public void setUpdateAT(Date updateAT) {
        this.updateAT = updateAT;
    }

    //GET'S

    public int  getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Telefono getPhoneNumber() {
        return phoneNumber;
    }

    public String getDni() {
        return dni;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public Date getCreatedAT() {
        return createdAT;
    }

    public Date getUpdateAT() {
        return updateAT;
    }
}
