package com.cafe24.lms.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cafe24.security.Auth.Role;
import com.cafe24.type.Gender;

@Entity
@Table( name = "user" )
public class User {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "user_no" )
    private Long no;

    @Column( name = "name", nullable = false, length = 15 )
    private String name;

    @Column( name = "email", nullable = false, length = 50 )
    private String email;

    @Column( name = "password", nullable = false, length = 64 )
    private String password;

    @Column( name = "phone", nullable = false, length = 15 )
    private String phone;

    @Temporal( TemporalType.TIMESTAMP )
    @Column( name = "reg_date", nullable = false )
    private Date regDate;

    @Enumerated( EnumType.STRING )
    @Column( name = "gender", nullable = true, columnDefinition = "ENUM('FEMALE','MALE')" )
    private Gender gender;

    @Enumerated( EnumType.STRING )
    @Column( name = "role", nullable = false, columnDefinition = "ENUM('USER', 'ADMIN')" )
    private Role role;

    @OneToMany( mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Rent> rents = new ArrayList<Rent>();

    @OneToMany( mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Reserve> reserves = new ArrayList<Reserve>();

    // -- Constructor
    public User() {
    }

    public User(Long no, String name, String email, Role role) {
	this.no = no;
	this.name = name;
	this.email = email;
	this.role = role;
    }

    public User(Long no, String name, String email, String phone, Gender gender) {
	this.no = no;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.gender = gender;
    }

    // -- Getter/Setter
    public Long getNo() {
	return no;
    }

    public void setNo( Long no ) {
	this.no = no;
    }

    public String getName() {
	return name;
    }

    public void setName( String name ) {
	this.name = name;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail( String email ) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword( String password ) {
	this.password = password;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone( String phone ) {
	this.phone = phone;
    }

    public Date getRegDate() {
	return regDate;
    }

    public void setRegDate( Date regDate ) {
	this.regDate = regDate;
    }

    public Gender getGender() {
	return gender;
    }

    public void setGender( Gender gender ) {
	this.gender = gender;
    }

    public Role getRole() {
	return role;
    }

    public void setRole( Role role ) {
	this.role = role;
    }

    public List<Rent> getRents() {
	return rents;
    }

    public void setRents( List<Rent> rents ) {
	this.rents = rents;
    }

    public List<Reserve> getReserves() {
	return reserves;
    }

    public void setReserves( List<Reserve> reserves ) {
	this.reserves = reserves;
    }

    @Override
    public String toString() {
	return "User [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone
		+ ", regDate=" + regDate + ", gender=" + gender + ", role=" + role + "]";
    }

}
