package org.viarzilin.hospital.model.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Table(name = "Patient")
@Entity
public class Patient {

  @Id
  @Column(name = "ID_PATIENT")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "LASTNAME", nullable = false, length = 20)
  private String lastName;

  @Column(name = "FIRSTNAME", nullable = false, length = 20)
  private String firstName;

  @Column(name = "SURNAME", length = 20)
  private String surName;


  @Column(name = "BIRTH_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date birthDate;

  @Column(name = "ADRESS",  length = 45)
  private String adress;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "CREATE_DATE",  updatable = false)
  private Date createDate;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "UPDATE_DATE")
  private Date updateDate;


  /**
   * One-to-many relationship Patient to Reception
   */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient", orphanRemoval = true)
  private List<Reception> reception;


  public Patient(){

  }

  /**
   * Getters and Setters
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getSurName() {
    return surName;
  }

  public void setSurName(String surName) {
    this.surName = surName;
  }

  public Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getAdress() {
    return adress;
  }

  public void setAdress(String adress) {
    this.adress = adress;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }

  public List<Reception> getReception() {
    return reception;
  }

  public void setReception(List<Reception> receptions) {
    this.reception = receptions;
  }


  @Override
  public String toString() {
    return "Patient{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", surName='" + surName + '\'' +
        ", birthDate=" + birthDate +
        ", adress='" + adress + '\'' +
        ", createDate=" + createDate +
        ", updateDate=" + updateDate +
        '}';
  }
}
