import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class WebDriverExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://www.rozetka.com.ua");
        WebElement userLink = driver.findElement(By.className("header-topline__user-link"));
        userLink.click();
        Thread.sleep(2000);
        WebElement userLogin = driver.findElement(By.id("auth_email"));
        userLogin.sendKeys("bogdan_s86@ukr.net");
        WebElement userPass = driver.findElement(By.id("auth_pass"));
        userPass.sendKeys("Bogdan99!");
        driver.findElement(By.className("auth-modal__submit")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.className("header-topline__user-link")).getText());
        driver.quit();
    }

    public static WebDriver getDriver() {
        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);
        //Create an instance of ChromeOptions
        ChromeOptions options = new ChromeOptions();
        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources//chromedriver.exe");
        return new ChromeDriver(options);
    }
}
