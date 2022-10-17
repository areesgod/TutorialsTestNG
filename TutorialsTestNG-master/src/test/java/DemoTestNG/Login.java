package DemoTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private static WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    By email = By.id("username");
    By password = By.id("password");
    By submit = By.id("loginbtn");

    public void Login() throws InterruptedException {
        driver.findElement(email).click();
        Thread.sleep(400);
        driver.findElement(email).sendKeys("201219");
        Thread.sleep(400);
        driver.findElement(password).click();
        Thread.sleep(400);
        driver.findElement(password).sendKeys("Lenovo2001!");
        Thread.sleep(400);
        driver.findElement(submit).click();

    }




}