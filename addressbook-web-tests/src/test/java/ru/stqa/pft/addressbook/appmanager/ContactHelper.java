package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstName());
    type(By.name("middlename"), contactData.getMidName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("nickname"), contactData.getNick());
    type(By.name("title"), contactData.getTitle());
    type(By.name("company"), contactData.getCompany());
    type(By.name("address"), contactData.getAddress());
    type(By.name("home"), contactData.getTelHome());
    type(By.name("mobile"), contactData.getTelMob());
    type(By.name("work"), contactData.getTelWork());
    type(By.name("fax"),contactData.getFax());
    type(By.name("email"), contactData.getEmai() );
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getSite());
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getHome());
    type(By.name("notes"), contactData.getNotes());
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContactForModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }
}
