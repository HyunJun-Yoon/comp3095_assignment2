package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlType;

/*@Data
@NoArgsConstructor*/
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty(message = "Please enter your First Name")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Please enter your Name in English")
    private String firstName;

    @NotEmpty(message = "Please enter your Last Name")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Please enter your Name in English")
    private String lastName;

    @NotEmpty(message = "Please enter your Email")
    @Email(message = "Please Enter an email address in the correct format")
    private String email;

    @NotEmpty(message = "Please enter your Address")
    private String address;

    @NotEmpty(message = "Please enter your Password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[#?!@$%^&*-]).{6,12}$", message = "Password must be 6-12 characters in length and must contain at least 1 uppercase letter and 1 special character")
    private String password;

    @NotEmpty(message = "Please enter your Confirm Password")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[#?!@$%^&*-]).{6,12}$",message = "Password must be 6-12 characters in length and must contain at least 1 uppercase letter and 1 special character")
    private String confirmPassword;

    private boolean agree;


    private String role = "user";

    public boolean isPwEqualToCheckPw() {
        return password.equals(confirmPassword);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String getRole(){
        return role;
    }

}
