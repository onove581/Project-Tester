package test;

import Model.CustomizedStatementForm;
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

public class ResetCustomizedStatementForm {
    private static final WebDriver driver = new ChromeDriver();
    static Ultils ultils;
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class

        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }

    @Test(dataProvider = "csf" )
    public void resetcsfs(String account,String date,String todate,String minum,String number){
        driver.get(Ultils.BASE_URL);
        WebForm web1=new WebForm(driver);
        web1.enterFirstName();
        web1.enterLastName();
        web1.pressSubmitButton();
        web1.csf();
        WebElement Account=driver.findElement(By.xpath(CustomizedStatementForm.csfaccount));
        //txtEmail.clear();
        Account.sendKeys(account);
        WebElement Date=driver.findElement(By.xpath(CustomizedStatementForm.csfformdate));
        //txtPassword.clear();
        Date.sendKeys(date);
        WebElement ftodate=driver.findElement(By.xpath(CustomizedStatementForm.csftodate));
        //txtPassword.clear();
        ftodate.sendKeys(todate);
        WebElement mini=driver.findElement(By.xpath(CustomizedStatementForm.csfminimumvalue));
        //txtPassword.clear();
        mini.sendKeys(minum);
        WebElement snumber=driver.findElement(By.xpath(CustomizedStatementForm.csfnumbertrans));
        // txtPasswords.clear();
        snumber.sendKeys(number);
        driver.findElement(By.name(CustomizedStatementForm.reset_button)).click(); //Login  button





    }
    @DataProvider(name="csf")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\CustomizedStatementForm.xlsx";
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
