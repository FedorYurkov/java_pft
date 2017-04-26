package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class AddContactToGroupTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

  }

  @Test
  public void testContactAddToGroup() {

    // Выбираются конкретные тестовые данные, без проверки предусловий
    ContactData contact = new ContactData().withId(233);
    GroupData group = new GroupData().withName("test1");


    Groups contactGroupsBefore = app.db().contactById(contact.getId()).getGroups();
    Contacts groupContactsBefore = app.db().contactsInGroupByName(group.getName());

    app.goTo().homePage();
    app.contact().addContactToGroup(contact, group);

    Groups contactGroupsAfter = app.db().contactById(contact.getId()).getGroups();
    Contacts groupContactsAfter = app.db().contactsInGroupByName(group.getName());

    // Проверки по данным контакта (группы в контакте)
    assertEquals(contactGroupsAfter.size(), contactGroupsBefore.size() + 1);
    assertThat(contactGroupsAfter, equalTo(contactGroupsBefore.withAdded(app.db().groupByName(group.getName()))));

    // Проверки по данным группы (контакты в группе)
    assertEquals(groupContactsAfter.size(), groupContactsBefore.size() + 1);
    assertThat(groupContactsAfter, equalTo(groupContactsBefore.withAdded(app.db().contactById(contact.getId()))));

  }
}
