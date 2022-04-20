package WebForm;

import Model.*;
import PageObject.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public  class WebForm extends PageObject {
    private final String u_name = "mngr399864";
    private final String password = "tahEbEb";
    /////////////////login guru/////////////////////////
    @FindBy(name = modellogin.username)
    private WebElement username;
    @FindBy(name = modellogin.passwor)
    private WebElement passwor;
    @FindBy(name = modellogin.submit_button)
    private WebElement submit_button;
    @FindBy(name = modellogin.reset_button)
    private WebElement reset_login;
    ////////////////////////logout/////////////////////////
    @FindBy(xpath= modelgeneral.logout)
    private WebElement logout;
    ////////////////////new account////////////////////////////
    @FindBy(xpath= modelnewaccount.newaccountadd)
    private WebElement newaccountadd;
    @FindBy(xpath= modelnewaccount.newaccountid)
    private WebElement newaccountid;
    @FindBy(name= modelnewaccount.selecta)
    private WebElement selecta;
    @FindBy(name= modelnewaccount.inideposit)
    private WebElement initial;
    @FindBy(name= modelnewaccount.submitnewaccount)
    private WebElement submitnewaccount;
    //////////////new customer/////////////////////////////////
    @FindBy(xpath= modelnewcustomer.customer)
    private WebElement customer;
    @FindBy(xpath= modelnewcustomer.customername)
    private WebElement customername;
    @FindBy (name= modelnewcustomer.radio)
    private WebElement radio;
    @FindBy(xpath= modelnewcustomer.date)
    private WebElement date;
    @FindBy(xpath= modelnewcustomer.address)
    private WebElement address;
    @FindBy(xpath= modelnewcustomer.city)
    private WebElement city;
    @FindBy(xpath= modelnewcustomer.state)
    private WebElement state;
    @FindBy(xpath= modelnewcustomer.pin)
    private WebElement pin;
    @FindBy(xpath= modelnewcustomer.mobilephone)
    private WebElement mobilephone;
    @FindBy(xpath= modelnewcustomer.email)
    private WebElement email;
    @FindBy(xpath= modelnewcustomer.passworda)
    private WebElement passworda;
    @FindBy(name= modelnewcustomer.submit)
    private WebElement submit;
    //Funds Transfer
    @FindBy(xpath= modelfun.funtransfer)
    private WebElement funtransfer;
    @FindBy(xpath= modelfun.funpayesraccountno)
    private WebElement funpayesraccountno;
    @FindBy(xpath= modelfun.funpayeesaccountno)
    private WebElement funpayeesaccountno;
    @FindBy(xpath= modelfun.funamountfundtransfer)
    private WebElement funamountfundtransfer;
    @FindBy(xpath= modelfun.fundescrip)
    private WebElement fundescrip;
    ////////////////accsubmit///////////////////////////////
    @FindBy(name= modelgeneral.accSubmit)
    private WebElement accSubmit;
    //////////////Customized Statement Form////////////////////////
    @FindBy(xpath= CustomizedStatementForm.csf)
    private WebElement csf;
    @FindBy(xpath= CustomizedStatementForm.csfaccount)
    private WebElement csfaccount;
    @FindBy(xpath= CustomizedStatementForm.csfformdate)
    private WebElement csfformdate;
    @FindBy(xpath= CustomizedStatementForm.csftodate)
    private WebElement csftodate;
    @FindBy(xpath= CustomizedStatementForm.csfminimumvalue)
    private WebElement csfminimumvalue;
    @FindBy(xpath= CustomizedStatementForm.csfnumbertrans)
    private WebElement csfnumbertrans;

    ////////////Amount Withdrawal Form///////////////////////
    @FindBy(xpath=AmountWithdrawalForm.wd)
    private WebElement wd;
    @FindBy(xpath=AmountWithdrawalForm.wdaccount)
    private WebElement wdaccount;
    @FindBy(xpath=AmountWithdrawalForm.wdamount)
    private WebElement wdamount;
    @FindBy(xpath=AmountWithdrawalForm.wddecrip)
    private WebElement wddecrip;
    //Amount Deposit Form
    @FindBy(xpath= AmountDepositForm.adf)
    private WebElement adf;
    @FindBy(xpath= AmountDepositForm.adfaccount)
    private WebElement adfaccount;
    @FindBy(xpath= AmountDepositForm.adfamount)
    private WebElement adfamount;
    @FindBy(xpath= AmountDepositForm.adfdescrip)
    private WebElement adfdescrip;




    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.username.sendKeys(u_name);
    }

    public void enterLastName(){
        this.passwor.sendKeys(password);
    }
    public void pressSubmitButton(){
        this.submit_button.click();
    }


    //newaccount
    public void newaccad(){this.newaccountadd.click();}
    public void enternewaccountid(){this.newaccountid.sendKeys("1");}
    public void enterselec(){this.selecta.sendKeys("Savings");}
    public void enterini(){this.initial.sendKeys("12");}
    public void submitnewacc(){this.submitnewaccount.click();}
    //new customer
    public void customer(){
        this.customer.click();
    }
    public void custoname(){ this.customername.sendKeys("fdfdfsdsd"); }
    public void radio1(){ this.radio.sendKeys("male"); }
    public void date(){ this.date.sendKeys("01/01/2001"); }
    public void address(){ this.address.sendKeys("dfd"); }
    public void city(){ this.city.sendKeys("sdfsds"); }
    public void state(){ this.state.sendKeys("dfdf"); }
    public void pin(){ this.pin.sendKeys("123423"); }
    public void mophone(){ this.mobilephone.sendKeys("02932382"); }
    public void mail(){ this.email.sendKeys("madflse@gmail.com"); }
    public void pas(){ this.passworda.sendKeys("dsfdfe"); }
    public void recustomer(){
        this.submit.click();
    }
    //desposit
    public void adfDespoit(){ this.adf.click(); }
    public void adfAccount(){ this.adfaccount.sendKeys("13"); }
    public void adfAmount(){ this.adfamount.sendKeys("23234"); }
    public void adfDescription(){ this.adfdescrip.sendKeys("dsfdsfdfe"); }
    public void adfsubmit(){ this.accSubmit.click(); }
    //Withdrawal
    public void wd(){ this.wd.click(); }
    public void wdAccount(){ this.wdaccount.sendKeys("13"); }
    public void wdAmount(){ this.wdamount.sendKeys("100"); }
    public void wdDescription(){ this.wddecrip.sendKeys("dsfdsfdfe"); }
    public void wdsubmit(){ this.accSubmit.click(); }
    //Fund transfer
    public void fun(){ this.funtransfer.click(); }
    public void funpayerAccount(){ this.funpayesraccountno.sendKeys("13"); }
    public void funpeyeesAccount(){ this.funpayeesaccountno.sendKeys("10"); }
    public void funAmount(){ this.funamountfundtransfer.sendKeys("1000"); }
    public void funDescription(){ this.fundescrip.sendKeys("dsfdsfdfdfe"); }
    public void funsubmit(){ this.accSubmit.click(); }
    //CustomizedStatementForm
    public void csf(){ this.csf.click(); }
    public void csfAccount(){ this.csfaccount.sendKeys("13"); }
    public void csfDate(){ this.csfformdate.sendKeys("12/2/2012"); }
    public void csfTodate(){ this.csftodate.sendKeys("12/2/2020"); }
    public void csfMinium(){ this.csfminimumvalue.sendKeys("12912"); }
    public void csftran(){ this.csfnumbertrans.sendKeys("30"); }
    public void csfsubmit(){ this.accSubmit.click(); }
    //logout
    public void logout1(){this.logout.click();}

}