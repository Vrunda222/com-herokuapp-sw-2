package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the text “Secure Area”
        Assert.assertEquals("Secure Area", driver.findElement(By.tagName("h2")).getText());

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the error message “Your username is invalid!”
        System.out.println(driver.findElement(By.id("flash")).getText());
        Assert.assertEquals("Not redirected to login page","Your username is invalid!", driver.findElement(By.id("flash")).getText().substring(0,25));
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //Click on ‘LOGIN’ button
        driver.findElement(By.className("radius")).click();
        //Verify the error message “Your password is invalid!”
        System.out.println(driver.findElement(By.id("flash")).getText());
        Assert.assertEquals("Not redirected to login page","Your password is invalid!", driver.findElement(By.id("flash")).getText().substring(0,25));
    }

    @After
    public void tearDown(){
        //closeBrowser();
    }
}
