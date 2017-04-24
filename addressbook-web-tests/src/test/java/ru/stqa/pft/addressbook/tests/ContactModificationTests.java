package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.db().contacts().size() == 0) {
      app.goTo().AddNewPage();
      app.contact().create(new ContactData().withFirstName("Fname").withLastName("Lname").withGroup("test1"));
    }
    app.goTo().homePage();
  }

  @Test
  public void testContactModification() {
    Contacts before = app.db().contacts();

    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData().
            withId(modifiedContact.getId()).withFirstName("UpdFname").withLastName("UpdLname").withPhoto(new File("src/test/resources/foto.png"));
    app.contact().modify(contact);

    Contacts after = app.db().contacts();

    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(app.db().contactById(modifiedContact.getId()))));
  }

}
