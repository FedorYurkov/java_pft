package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    List<ContactData> before = app.getContactHelper().getContactList();

    app.goTo().gotoAddNewPage();

    ContactData contact = new ContactData("Fname", "Mname",
            "Lname", "Nick", "mr", "comp", "addr", "123",
            "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net",
            "p.ru", "test1", "Sec addr", "1", "note");

    app.getContactHelper().createContact(contact);

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);

    Comparator<? super ContactData> byId = (с1, с2) -> Integer.compare(с1.getId(), с2.getId());
    before.sort(byId);
    after.sort(byId);

    Assert.assertEquals(before, after);
  }

}
