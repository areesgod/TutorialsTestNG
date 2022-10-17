package DemoTestNG;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class First_Automated_Test {
  WebDriver driver;
  private static final Logger logger = LogManager.getLogger(First_Automated_Test.class);
  ExtentReports extent;
  private static ExtentHtmlReporter htmlReporter;
  String screenshotsDir = "./failed_tests/";

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\webdriver\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://moodle.astanait.edu.kz/");

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }

  @Test(priority = 1)
  public void test1() throws InterruptedException, IOException {
    System.out.println("Test 1");
    driver.findElement(By.xpath("//a[@href='https://moodle.astanait.edu.kz/login/index.php']")).click();
    Thread.sleep(400);

    Login signIn = new Login(driver);
    signIn.Login();


    ExtentTest test = extent.createTest("Test 1");
    try {
      driver.findElement(By.xpath("/html/body/div[5]/div[1]/div[1]/div/div[1]/h1"));
      test.pass("You login in site!");
    } catch (Exception e) {
      logger.error("You didn't login!");
      test.fail("You didn't login!");

    }

  }

}
