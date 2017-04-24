package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;

@XStreamAlias("contact")
@Entity
@Table (name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;
  @Column(name = "firstname")
  private String firstName;
  @Column(name = "middlename")
  private String midName;
  @Column(name = "lastname")
  private String lastName;
  @Column(name = "nickname")
  private String nick;
  @Column(name = "title")
  private String title;
  @Column(name = "company")
  private String company;
  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;
  @Transient
  private String allPhones;

  @Column(name = "fax")
  @Type(type = "text")
  private String fax;

  @Column(name = "email")
  @Type(type = "text")
  private String email;
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;
  @Transient
  private String allEmails;

  @Column(name = "homepage")
  @Type(type = "text")
  private String site;
  @Transient
  private String group;
  @Column(name = "address2")
  @Type(type = "text")
  private String secondaryAddress;
  @Column (name = "phone2")
  @Type(type = "text")
  private String home;
  @Column(name = "notes")
  @Type(type = "text")
  private String notes;

  @Transient
  private String detailsInfo;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {
    return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public String getDetailsInfo() {
    return detailsInfo;
  }

  public ContactData withDetailsInfo(String detilsInfo) {
    this.detailsInfo = detilsInfo;
    return this;
  }

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }


  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMidName(String midName) {
    this.midName = midName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNick(String nick) {
    this.nick = nick;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withSite(String site) {
    this.site = site;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withSecondaryAddress(String secondaryAddress) {
    this.secondaryAddress = secondaryAddress;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMidName() {
    return midName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNick() {
    return nick;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getFax() {
    return fax;
  }

  public String getEmai() {
    return email;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getSite() {
    return site;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getHome() {
    return home;
  }

  public String getNotes() {
    return notes;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
    return midName != null ? midName.equals(that.midName) : that.midName == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (midName != null ? midName.hashCode() : 0);
    return result;
  }
}
