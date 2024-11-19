//1. userSholdLoginSuccessfullyWithValidCredentials()
//* Enter “tomsmith” for the username
//* Enter “SuperSecretPassword!” for the
//password
//* Click on the ‘Login’ button
//* Verify the text “Secure Area”
//* Click on the ‘Logout’ button
//* Verify the text ‘You logged out of the secure area!’
//2. verifyTheUsernameErrorMessage()
//* Enter “tomsmith1” for the username
//* Enter “SuperSecretPassword!” for the
//password
//* Click on the ‘Login’ button
//* Verify the error message “Your username is invalid!”
//3. verifyThePasswordErrorMessage()
//* Enter “tomsmith” for the username
//* Enter “SuperSecretPassword” for the
//password
//* Click on the ‘Login’ button
//* Verify the error message “Your password is invalid!”
package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseURL = "http://the-internet.herokuapp.com/login";


    @Before
    public void setup (){
      openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expectedTest = "Secure Area";
        WebElement secureArea = driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/h2[1]"));
        String actualText = secureArea.getText();
        Assert.assertEquals("Text not displayed", actualText, expectedTest);
        driver.findElement(By.xpath("//i[contains(text(),'Logout')]")).click();
        String expectedText1 = "You logged out of the secure area!";
        WebElement loggedOut = driver.findElement(By.id("flash"));
         String actualText1 = loggedOut.getText();
         Assert.assertEquals("Text Not Displayed", actualText1,expectedText1);


    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expectedText = "Your username is invalid!";
        WebElement username = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = username.getText();
        Assert.assertEquals("Text not displayed", actualText, expectedText);

    }

    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        String expectedText = "Your password is invalid!";
        WebElement password = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = password.getText();
        Assert.assertEquals("Text not displayed", actualText, expectedText);

    }

    @After

    public  void teardown(){
        driver.quit();
    }

}
