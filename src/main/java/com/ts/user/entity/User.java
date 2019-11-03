package com.ts.user.entity;

import java.util.Date;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "User")
public class User implements java.io.Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String loginId;
    private String password;
    private String passwordSalt;
    private Long createdBy;
    private Date createdDate;
    private Long updatedBy;
    private Date updatedDate;
    private Integer rowStatusId;

    public User() {
    }

    public User(String firstName, String lastName, String middleName, String email, String loginId, String password,
                String passwordSalt, Long createdBy, Date createdDate, Long updatedBy, Date updatedDate,
                Integer rowStatusId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.email = email;
        this.loginId = loginId;
        this.password = password;
        this.passwordSalt = passwordSalt;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.rowStatusId = rowStatusId;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FirstName", length = 100)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LastName", length = 100)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "MiddleName", length = 100)
    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "Email", length = 45)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "LoginId", length = 100)
    public String getLoginId() {
        return this.loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Column(name = "Password", length = 1000)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "PasswordSalt", length = 100)
    public String getPasswordSalt() {
        return this.passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Column(name = "CreatedBy")
    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedDate", length = 19)
    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "UpdatedBy")
    public Long getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UpdatedDate", length = 19)
    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Column(name = "RowStatusId")
    public Integer getRowStatusId() {
        return this.rowStatusId;
    }

    public void setRowStatusId(Integer rowStatusId) {
        this.rowStatusId = rowStatusId;
    }

}