package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MFT2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://app.yaware.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMFT2() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("a[title=\"Нажмите здесь, чтобы создать учётную запись Yaware.TimeTracker\"]")).click();
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Oskar");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Petrov");
    driver.findElement(By.id("registerEmail")).clear();
    driver.findElement(By.id("registerEmail")).sendKeys("P_oskar@ukr.net");
    driver.findElement(By.id("pwd1")).clear();
    driver.findElement(By.id("pwd1")).sendKeys("123456");
    driver.findElement(By.cssSelector("#register-account-submit > span")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
