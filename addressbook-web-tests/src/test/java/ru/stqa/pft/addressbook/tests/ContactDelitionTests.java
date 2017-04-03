package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase {
  @Test
  public void testContactDelition() {
    if (!app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewPage();
      app.getContactHelper().createContact(new ContactData("Fname", "Mname", "Lname", "Nick", "mr", "comp", "addr", "123", "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net", "p.ru", "test1", "Sec addr", "1", "note"));
    }

    List<ContactData> before = app.getContactHelper().getContactList();

    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().alertConfirmation();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
}
