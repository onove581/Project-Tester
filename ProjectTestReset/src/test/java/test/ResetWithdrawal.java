package test;

import Model.AmountWithdrawalForm;
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

public class ResetWithdrawal {
    private static final WebDriver driver = new ChromeDriver();
    static Ultils ultils;
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class

        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }

    @Test(dataProvider = "with" )
    public void resetwith(String Account,String Amount,String Descrip){
        driver.get(Ultils.BASE_URL);
        WebForm web1=new WebForm(driver);
        web1.enterFirstName();
        web1.enterLastName();
        web1.pressSubmitButton();
        web1.wd();
        WebElement account=driver.findElement(By.xpath(AmountWithdrawalForm.wdaccount));
        //txtPassword.clear();
        account.sendKeys(Account);

        WebElement amount=driver.findElement(By.xpath(AmountWithdrawalForm.wdamount));
        // txtPasswords.clear();
        amount.sendKeys(Amount);
        WebElement des=driver.findElement(By.xpath(AmountWithdrawalForm.wddecrip));
        // txtPasswords.clear();
        des.sendKeys(Descrip);
        driver.findElement(By.name(AmountWithdrawalForm.reset_button)).click(); //Login  button





    }
    @DataProvider(name="with")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\Withdrawal.xlsx";
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