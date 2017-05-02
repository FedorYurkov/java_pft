package ru.stqa.pft.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.MailMessage;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetAndChangePasswordTests extends TestBase {

  @BeforeMethod
  public void startMailServer() {
    app.mail().start();
  }

  @Test
  public void testResetAndChangePassword() throws IOException, MessagingException {
    // Все пользователи без администратора
    Users users = app.db().usersWithoutAdmin();

    // Выбираем любого пользователя
    UserData user = users.iterator().next();
    String userName = user.getName();
    String userEmail = user.getEmail();
    // Новый пароль
    String newPassword = "qwerty";

    // Логин администратора
    app.session().login(app.getProperty("web.adminLogin"), app.getProperty("web.adminPassword"));
    // Переход на страницу Управлние
    app.goTo().managePage();
    // Переход на вкладку Управление пользователями
    app.goTo().usersManageTab();
    // Переход на страницу заданного пользователя
    app.user().selectById(user.getId());
    // Сброс пароля
    app.user().initPasswordReset();
    
    List<MailMessage> mailMessages = app.mail().waitForMail(1, 10000);
    String confirmationLink = app.mail().findConfirmationLink(mailMessages, userEmail);

    // Переход по ссылке подтверждения и установка нового пароля
    app.rgistration().finish(confirmationLink, newPassword);

    assertTrue(app.newSession().login(userName, newPassword));
  }

  @AfterMethod(alwaysRun = true)
  public void stopMailServer() {
    app.mail().stop();
  }

}
