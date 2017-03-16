package ru.stqa.pft.addressbook;

public class ContactData {
  private final String firstName;
  private final String midName;
  private final String lastName;
  private final String nick;
  private final String title;
  private final String company;
  private final String address;
  private final String telHome;
  private final String telMob;
  private final String telWork;
  private final String fax;
  private final String emai;
  private final String email2;
  private final String email3;
  private final String site;
  private final String secondaryAddress;
  private final String home;
  private final String notes;

  public ContactData(String firstName, String midName, String lastName, String nick, String title, String company, String address, String telHome, String telMob, String telWork, String fax, String emai, String email2, String email3, String site, String secondaryAddress, String home, String notes) {
    this.firstName = firstName;
    this.midName = midName;
    this.lastName = lastName;
    this.nick = nick;
    this.title = title;
    this.company = company;
    this.address = address;
    this.telHome = telHome;
    this.telMob = telMob;
    this.telWork = telWork;
    this.fax = fax;
    this.emai = emai;
    this.email2 = email2;
    this.email3 = email3;
    this.site = site;
    this.secondaryAddress = secondaryAddress;
    this.home = home;
    this.notes = notes;
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

  public String getTelHome() {
    return telHome;
  }

  public String getTelMob() {
    return telMob;
  }

  public String getTelWork() {
    return telWork;
  }

  public String getFax() {
    return fax;
  }

  public String getEmai() {
    return emai;
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
}
