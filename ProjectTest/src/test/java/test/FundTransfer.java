package test;

import Model.modelfun;
import Model.modelgeneral;
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

public class FundTransfer {
    private static final WebDriver driver = new ChromeDriver();
    static Ultils ultils;
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class

        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }

    @Test(dataProvider = "fundtransfer" )
    public void fund(String ayer,String ayees,String mount,String escrip){
        driver.get(Ultils.BASE_URL);
        WebForm web1=new WebForm(driver);
        web1.enterFirstName();
        web1.enterLastName();
        web1.pressSubmitButton();
        web1.fun();
        WebElement payer=driver.findElement(By.xpath(modelfun.funpayesraccountno));
        //txtPassword.clear();
        payer.sendKeys(ayer);
        WebElement payes=driver.findElement(By.xpath(modelfun.funpayeesaccountno));
        // txtPasswords.clear();
        payes.sendKeys(ayees);
        WebElement amount=driver.findElement(By.xpath(modelfun.funamountfundtransfer));
        // txtPasswords.clear();
        amount.sendKeys(mount);
        WebElement des=driver.findElement(By.xpath(modelfun.fundescrip));
        // txtPasswords.clear();
        des.sendKeys(escrip);
        driver.findElement(By.name(modelgeneral.accSubmit)).click(); //Login  button





    }
    @DataProvider(name="fundtransfer")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\FundTransfer.xlsx";
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