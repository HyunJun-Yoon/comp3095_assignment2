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
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @NotEmpty(message = "Please enter your City")
    private String city;

    @NotEmpty(message = "Please enter your Country")
    private String country;

    @NotEmpty(message = "Please enter your Postal Code")
    private String postal;

    @NotEmpty(message = "Please enter your Date of Birth")
    private String dob;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
