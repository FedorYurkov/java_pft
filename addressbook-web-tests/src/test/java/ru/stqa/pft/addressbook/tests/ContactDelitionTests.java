package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDelitionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.contact().all().size() == 0) {
      app.goTo().AddNewPage();
      app.contact().create(new ContactData("Fname", "Mname", "Lname", "Nick", "mr", "comp", "addr", "123", "456", "789", "910", "q@qa.ru", "q@qa.com", "q@qa.net", "p.ru", "test1", "Sec addr", "1", "note"));
    }
  }

  @Test
  public void testContactDelition() {


    List<ContactData> before = app.contact().all();

    app.contact().selectContact(before.size()-1);
    app.contact().deleteSelectedContact();
    app.contact().alertConfirmation();
    app.goTo().gotoHomePage();

    List<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
}
