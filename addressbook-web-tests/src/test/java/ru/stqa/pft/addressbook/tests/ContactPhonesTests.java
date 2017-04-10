package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhonesTests extends TestBase {

  @Test
  public void testContactPhones() {
    app.goTo().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contatctInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contatctInfoFromEditForm)));
  }

  private String mergePhones(ContactData contatct) {
    return Arrays.asList(contatct.getHomePhone(), contatct.getMobilePhone(), contatct.getWorkPhone())
              .stream().filter((s)->!s.equals(""))
              .map(ContactPhonesTests::cleaned)
              .collect(Collectors.joining("\n"));

  }


  public static String cleaned (String phone) {
    return  phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
