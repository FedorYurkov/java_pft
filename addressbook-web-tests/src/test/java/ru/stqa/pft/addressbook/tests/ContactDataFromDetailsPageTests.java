package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDataFromDetailsPageTests extends TestBase {

  @Test
  public void testContactDataFromDetailsPage() {
    app.goTo().homePage();

    ContactData contact = new ContactData().withId(app.contact().all()
                                                    .stream().min((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());

    ContactData contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    String fromEditFormReformat = Arrays.asList(mergeNames(contactInfoFromEditForm), contactInfoFromEditForm.getAddress(), mergePhones(contactInfoFromEditForm), mergeEmails(contactInfoFromEditForm))
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));

    assertThat(cleanedEmptyLines(contactInfoFromDetailsPage.getDetailsInfo()), equalTo(fromEditFormReformat));
  }

  // Вспомогательные методы для склейки данных со страницы редактирования
  private String mergePhones(ContactData contact) {
    String mergePhones = "";
    if (!contact.getHomePhone().equals("")) {
      mergePhones += "H: " + contact.getHomePhone() + "\n";
    }
    if (!contact.getMobilePhone().equals("")) {
      mergePhones += "M: " + contact.getMobilePhone() + "\n";
    }
    if (!contact.getWorkPhone().equals("")) {
      mergePhones += "W: " + contact.getWorkPhone();
    }
    return mergePhones;
  }

  private String mergeNames(ContactData contatct) {
    return Arrays.asList(contatct.getFirstName(), contatct.getLastName())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining(" "));
  }

  private String mergeEmails(ContactData contatct) {
    return Arrays.asList(contatct.getEmai(), contatct.getEmail2(), contatct.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  //Вспомогательные методы для данных со страницы детальной информации

  public static String cleanedEmptyLines(String contactData) {
    return contactData.replaceAll("\n\n", "\n");
  }

}
