package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import ru.stqa.pft.mantis.tests.TestBase;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(ApplicationManager app) {
    super(app);
  }

  public void managePage() {
    click(By.cssSelector("a[href='/manage_overview_page.php']"));

  }

  public void usersManageTab() {
    click(By.cssSelector("a[href='/manage_user_page.php']"));

  }

}
