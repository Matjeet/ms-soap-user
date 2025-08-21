package com.soap.user.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cellphone;

    @Column(nullable = false)
    private String identityType;

    @Column(nullable = false)
    private String identityNumber;

    @Column(nullable = false)
    private Integer balance;

    @JoinColumn(name = "country_id", nullable = false, foreignKey = @ForeignKey(name = "fk_user_country"))
    @ManyToOne
    private CountryEntity country;

    public UserEntity() {
    }

    public UserEntity(int id, String name, String lastName, String email, String cellphone, String identityType, String identityNumber, Integer balance, CountryEntity country) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.cellphone = cellphone;
        this.identityType = identityType;
        this.identityNumber = identityNumber;
        this.balance = balance;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }
}