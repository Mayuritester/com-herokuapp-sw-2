package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

   public static WebDriver driver;

   public void openBrowser (String baseURL){
       driver = new ChromeDriver();
       driver.get(baseURL);
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
       driver.manage().window().maximize();


   }
}
