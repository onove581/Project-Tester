package test;

import Model.modellogin;
import Ultil.Ultils;
import Ultil.XLUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetLogin {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }
    @Test(dataProvider = "LoginData")
    public void resetlogin(String username,String password,String exp){
        driver.get(Ultils.BASE_URL);
        WebElement txtEmail=driver.findElement(By.name(modellogin.username));
        txtEmail.clear();
        txtEmail.sendKeys(username);


        WebElement txtPassword=driver.findElement(By.name(modellogin.passwor));
        txtPassword.clear();
        txtPassword.sendKeys(password);

        driver.findElement(By.name(modellogin.reset_button)).click(); //Login  button

        String exp_title="Guru99 Bank";
        String act_title=driver.getTitle();

        if(exp.equals("Valid"))
        {
            if(exp_title.equals(act_title))
            {
                driver.findElement(By.xpath("//a[@href ='Logout.php']")).click();
                Assert.assertTrue(true);
            }
            else
            {
                Assert.assertTrue(false);
            }
        }
        else if(exp.equals("Invalid"))
        {
            if(exp_title.equals(act_title))
            {
                driver.findElement(By.linkText("Logout")).click();
                Assert.assertTrue(false);
            }
            else
            {
                Assert.assertTrue(true);
            }
        }


    }

    @DataProvider(name="LoginData")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\loginData.xlsx";
        XLUtility xlutil=new XLUtility(path);

        int totalrows=xlutil.getRowCount("Sheet1");
        int totalcols=xlutil.getCellCount("Sheet1",1);

        String loginData[][]=new String[totalrows][totalcols];


        for(int i=1;i<=totalrows;i++) //1
        {
            for(int j=0;j<totalcols;j++) //0
            {
                loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
            }

        }

        return loginData;
    }



}