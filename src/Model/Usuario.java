package Model;

import java.time.LocalDate;
import java.util.Date;

public class Usuario {
    private String id;
    private String userName;
    private String email;
    private Telefono phoneNumber;
    private String dni;
    private String fullName;
    private String password;
    private LocalDate createdAT;
    private LocalDate updatedAT;

    public Usuario(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
    public Usuario(String id, String userName, String email, Telefono phoneNumber, String dni,
            String fullName, String password, LocalDate createdAT, LocalDate updatedAT) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.dni = dni;
        this.email = email;
        this.createdAT = createdAT;
        this.updatedAT = updatedAT;
    }

    //SET'S
    public void setId(String id) {
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

    public void setCreatedAT(LocalDate createdAT) {
        this.createdAT = createdAT;
    }

    public void setUpdateAT(LocalDate updateAT) {
        this.updatedAT = updateAT;
    }

    //GET'S

    public String  getId() {
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

    public LocalDate getCreatedAT() {
        return createdAT;
    }

    public LocalDate getUpdateAT() {
        return updatedAT;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "id=" + id +
                " userName='" + userName + '\n' +
                " email='" + email + '\n' +
                " phoneNumber=" + phoneNumber +
                " dni='" + dni + '\n' +
                " fullName='" + fullName + '\n' +
                " password='" + password + '\n' +
                " createdAt=" + createdAT +
                " updatedAt=" + updatedAT ;
    }
}
