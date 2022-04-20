package test;

import Model.modelnewcustomer;
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

public class AddNewCustomer {
    private static final WebDriver driver = new ChromeDriver();
    static Ultils ultils;
    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
        System.setProperty("webdriver.chrome.driver", Ultils.CHROME_DRIVER_LOCATION);

    }

    @Test(dataProvider = "newcustomer" )
    public void newcustomer(String name,String radio,String date,String address,String city,String state,String pin,String mobi,String email,String password){
        driver.get(Ultils.BASE_URL);
        WebForm web1=new WebForm(driver);
        web1.enterFirstName();
        web1.enterLastName();
        web1.pressSubmitButton();
        web1.customer();
        WebElement fname=driver.findElement(By.xpath(modelnewcustomer.customername));
        //fname.clear();
        fname.sendKeys(name);
        WebElement fradio=driver.findElement(By.name(modelnewcustomer.radio));
        fradio.sendKeys(radio);
        WebElement fdate=driver.findElement(By.xpath(modelnewcustomer.date));
        fdate.sendKeys(date);
        WebElement faddress=driver.findElement(By.xpath(modelnewcustomer.address));
        faddress.sendKeys(address);
        WebElement fcity=driver.findElement(By.xpath(modelnewcustomer.city));
        fcity.sendKeys(city);
        WebElement fstate=driver.findElement(By.xpath(modelnewcustomer.state));
        fstate.sendKeys(state);
        WebElement fpin=driver.findElement(By.xpath(modelnewcustomer.pin));
        fpin.sendKeys(pin);
        WebElement fmobi=driver.findElement(By.xpath(modelnewcustomer.mobilephone));
        fmobi.sendKeys(mobi);
        WebElement fmail=driver.findElement(By.xpath(modelnewcustomer.email));
        fmail.sendKeys(email);
        WebElement fpass=driver.findElement(By.xpath(modelnewcustomer.passworda));
        fpass.sendKeys(password);

        driver.findElement(By.name(modelnewcustomer.submit)).click(); //Login  button





    }
    @DataProvider(name="newcustomer")
    public Object[][] getData() throws IOException
    {


        //get the data from excel
        String path=".\\Newcustomer.xlsx";
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
