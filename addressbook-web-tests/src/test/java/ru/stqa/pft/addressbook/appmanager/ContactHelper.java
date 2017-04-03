package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactForm() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
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
    type(By.name("fax"), contactData.getFax());
    type(By.name("email"), contactData.getEmai());
    type(By.name("email2"), contactData.getEmail2());
    type(By.name("email3"), contactData.getEmail3());
    type(By.name("homepage"), contactData.getSite());
    type(By.name("address2"), contactData.getSecondaryAddress());
    type(By.name("phone2"), contactData.getHome());
    type(By.name("notes"), contactData.getNotes());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContactForModification(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']/td[8]/a/img")).get(index).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void createContact(ContactData contact) {
    fillContactForm(contact, true);
    submitContactForm();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();

    List<WebElement>  elements = wd.findElements(By.name("entry"));

    for (WebElement element : elements) {
      String LastName = element.findElement(By.xpath(".//td[2]")).getText();
      String FirstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));

      ContactData contact = new ContactData(id, FirstName, null, LastName,null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null );
      contacts.add(contact);
    }
    return contacts;

  }
}
