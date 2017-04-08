package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().AddNewPage();
      app.contact().create(new ContactData("Fname", "Mname", "Lname", "Nick", "mr", "comp", "addr", "123", "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net", "p.ru", "test1", "Sec addr", "1", "note"));
    }
  }


  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().all();

    app.contact().selectContactForModification(before.size()-1);
    ContactData contact = new ContactData(before.get(before.size()-1).getId(), "UpdFname", "Mname", "Lname", "Nick", "mr", "comp", "addr", "123", "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net", "p.ru", null, "Sec addr", "1", "note");
    app.contact().fillContactForm(contact, false);
    app.contact().submitContactModification();
    app.contact().returnToHomePage();

    List<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() - 1);
    before.add(contact);

    Comparator<? super ContactData> byId = (с1, с2) -> Integer.compare(с1.getId(), с2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }
}
