package test;

import Model.modelnewaccount;
import Ultil.Ultils;
import Ultil.XLUtility;
import WebForm.WebForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class ResetNewAccount {
    private static final WebDriver driver = new ChromeDriver();
    static Ultils ultils;
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class

        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }

    @Test(dataProvider = "resetnewaccount" )
    public void resetnewaccount(String id,String type,String deposit){
        driver.get(Ultils.BASE_URL);
        WebForm web1=new WebForm(driver);
        web1.enterFirstName();
        web1.enterLastName();
        web1.pressSubmitButton();
        web1.newaccad();
        WebElement txtEmail=driver.findElement(By.xpath(modelnewaccount.newaccountid));
        //txtEmail.clear();
        txtEmail.sendKeys(id);

        WebElement txtPassword=driver.findElement(By.name(modelnewaccount.selecta));
        //txtPassword.clear();
        txtPassword.sendKeys(type);
        WebElement txtPasswords=driver.findElement(By.name(modelnewaccount.inideposit));
       // txtPasswords.clear();
        txtPasswords.sendKeys(deposit);
        driver.findElement(By.name(modelnewaccount.reset_button)).click(); //Login  button





    }
    @DataProvider(name="resetnewaccount")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\NewAccount.xlsx";
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