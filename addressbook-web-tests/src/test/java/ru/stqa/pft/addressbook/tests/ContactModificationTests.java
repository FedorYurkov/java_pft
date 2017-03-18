package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {
  @Test
  public void testContactDelition() {
    app.getContactHelper().selectContactForModification();
    app.getContactHelper().fillContactForm(new ContactData("UpdFname", "Mname", "Lname", "Nick", "mr", "comp", "addr", "123", "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net", "p.ru", "Sec addr", "1", "note"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }
}
