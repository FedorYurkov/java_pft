package ru.stqa.pft.rest;

import org.testng.annotations.Test;

public class SkipTests extends TestBase {

  @Test
  public void testSkip() {
    int blockedIssueId = 7; // Указан id конкретного, блокирующего данный тест, бага
    skipIfNotFixed(blockedIssueId);
    System.out.println("Я выполнился!");
  }

}
