package test;

import Ultil.Ultils;
import WebForm.WebForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Logout {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }



    @Test(priority = 1)
    public static void login(){
        driver.get(Ultils.BASE_URL);
        WebForm web = new WebForm(driver);
        web.enterFirstName();
        web.enterLastName();
        web.pressSubmitButton();
        web.logout1();

    }
    
}
