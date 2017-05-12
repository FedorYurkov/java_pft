package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import java.util.Set;

public class TestBase {

  @BeforeSuite
  public void init() {
    RestAssured.authentication = RestAssured.basic("LSGjeU4yP1X493ud1hNniA==", "");
  }

  public boolean isIssueOpen(int issueId) {
    String json = RestAssured.get("http://demo.bugify.com/api/issues/" + issueId + ".json").asString();
    JsonElement parsed = new JsonParser().parse(json);
    JsonElement issuesAsJson = parsed.getAsJsonObject().get("issues"); //Список задач (в котором одна наша задача) в виде JSON объекта

    Set<Issue> issues = new Gson().fromJson(issuesAsJson, new TypeToken<Set<Issue>>(){}.getType()); // Преобразовали список в множество модельных объектов Issue (в нем так же будет всего один элемент - наша задача)
    Issue issue = issues.iterator().next(); // Получили из множества нашу задачу

    if (issue.getState_name().equals("Resolved") || issue.getState_name().equals("Closed")) {
      return false;
    }
    return true;
  }

  public void skipIfNotFixed(int issueId) {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

}
