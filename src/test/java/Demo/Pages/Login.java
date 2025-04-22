package Demo.Pages;

import Demo.Core.testContext;
import Demo.utility.objectProp;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class Login extends testContext {
    private  WebDriver driver;
    private WebDriverWait wait;

    public Login(WebDriver inputDriver) throws IOException {
        driver = inputDriver;
        setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }


     By usrnamebox =By.xpath(objectProp.getObjectID("usrnamebox"));
    //static By fbUsername = By.xpath(objectProp.getObjectID("fbUsername"));
     By pwdbox = By.xpath(objectProp.getObjectID("pwdbox"));
    //static By pwd = By.xpath(objectProp.getObjectID("pwd"));
    By loginbutton = By.xpath(objectProp.getObjectID("loginbutton"));
    By icon = By.xpath(objectProp.getObjectID("icon"));
    By nameBox = By.name("username");
    By pwd = By.name("pw");
    By loginbut = By.name("Login");
    By AppLaunch = By.xpath(objectProp.getObjectID("AppLaunch"));
    By Torrent = By.xpath(objectProp.getObjectID("Torrent"));
    By verifyTorrent = By.xpath(objectProp.getObjectID("verifyTorrent"));
    By proName = By.xpath(objectProp.getObjectID("proName"));
    By thearpatic = By.xpath(objectProp.getObjectID("thearpatic"));
    By proForm = By.xpath(objectProp.getObjectID("proForm"));
    By dosagef = By.xpath(objectProp.getObjectID("dosagef"));
    By activef = By.xpath(objectProp.getObjectID("activef"));
    By manucomp = By.xpath(objectProp.getObjectID("manucomp"));
    By save = By.xpath(objectProp.getObjectID("save"));
    By accName1 = By.xpath(objectProp.getObjectID("accName"));
    By mailId = By.xpath(objectProp.getObjectID("mailId"));
    By territory = By.xpath(objectProp.getObjectID("territory"));
    By city1 =By.xpath(objectProp.getObjectID("city"));
    By country1 = By.xpath(objectProp.getObjectID("country"));
    By state1 = By.xpath(objectProp.getObjectID("state"));
    By zip =By.xpath(objectProp.getObjectID("zip"));



    public  WebDriver fetchdriver() {
        return driver;
    }

    public  void facebookURL() throws InterruptedException {
        WebDriver driver = getDriver(); // from testContext
        driver.get("https://www.facebook.com");
        sleep(1000);
    }

    public  void logindetails() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(usrnamebox).sendKeys("9566740240");
        System.out.println("input box is enter succesfully");
        sleep(1000);
        driver.findElement(pwdbox).sendKeys("Abc12345");
        System.out.println("pwd is given successfully");
        sleep(1000);
    }
    public  void loginbutton() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(loginbutton).click();
        System.out.println("Login is clicked successfully");
        sleep(1000);
    }

    public void verifyName() throws InterruptedException {
        WebDriver driver = getDriver();
        WebElement element = driver.findElement(icon);
        if (element.isDisplayed()){
            System.out.println("Facebook is login successfully");

        }
        else{
            System.out.println("Facebook is not login in ");
        }
        sleep(10000);
    }

    public void sfURL() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.get("https://login.salesforce.com/?locale=in");
        sleep(2000);
        sleep(2000);
        System.out.println("Diff acc is clicked");

    }

    public void userCred() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(nameBox).sendKeys("arafat@ris.com.lifescience.demo");
        System.out.println("usr name is given");
        sleep(2000);
        driver.findElement(pwd).sendKeys("Rudhra@2025");
        System.out.println("pwd is given");
        sleep(2000);
    }

    public void sfLogin() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(loginbut).click();
        sleep(10000);
        System.out.println("Login is click");
        sleep(10000);
    }

    public void openTorrentPhrama() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(AppLaunch).click();
        sleep(5000);
        driver.findElement(Torrent).click();
        sleep(3000);
        sleep(10000);
        System.out.println("Torrent pharama is selected");

    }

    public void  verfiyHome() throws InterruptedException {
        WebDriver driver = getDriver();
        sleep(10000);
        WebElement element = driver.findElement(verifyTorrent);
        sleep(10000);
        if(element.isDisplayed()){
            System.out.println("we are in Torrent home page");
        }
        else{
            System.out.println("we are nt in torrent page");
        }
    }

    public void openProduct(String MyProduct, String AllProduct) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath("//span[contains(text(),'" + MyProduct + "')]")).click();
        System.out.println("Myproduct is Clciked");
        sleep(5000);
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'" + AllProduct +"')]"));
        if(element.isDisplayed()){
            System.out.println("All product page is displayed");
        }
        else{
            System.out.println("All product is not displayed");
        }
        sleep(2000);
    }

    public void addNew(String newtab) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath(" //button[text()='" + newtab + "']")).click();
        sleep(5000);
        System.out.println("New button is clicked");
    }


    public void addProdFom(String prodName, String ThearpName, String prodForm, String dosage, Boolean active, String manComp) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(proName).sendKeys(prodName);
        System.out.println("prodName is given");
        sleep(2000);
        driver.findElement(thearpatic).sendKeys(ThearpName);
        sleep(2000);
        System.out.println("thearpatic is given");
        driver.findElement(By.xpath("//*[@title='" + ThearpName + "']")).click();
        System.out.println("thearpatic is clicked");
        driver.findElement(proForm).sendKeys(prodForm);
        sleep(2000);
        System.out.println("prodForm is given");
        driver.findElement(dosagef).sendKeys(dosage);
        sleep(2000);
        System.out.println("dosage is given");
        WebElement checkbox = driver.findElement(activef);
        Boolean ischecbox = checkbox.isSelected();
        if(active && !ischecbox) {
            checkbox.click();
            System.out.println("checkbox  is unchecked, now it is checked");
        }
        else if(!active && ischecbox){
            checkbox.click();
            System.out.println("checkbox  is unchecked, now it is checked");
        }
        else {
            System.out.println("checkbox is already checked");
        }
        driver.findElement(manucomp).sendKeys(manComp);
        sleep(2000);
        System.out.println("company name  is given");
    }

    public void saveform() throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(save).click();
        sleep(5000);
    }

    public void openClinicalInfo(String clinicalInfo, String org) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(By.xpath("//span[contains(text(),'" + clinicalInfo + "')]")).click();
        System.out.println("clinical is Clciked");
        sleep(5000);
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + org +"')]"));
        element.click();
        if(element.isDisplayed()){
            System.out.println("org page is displayed");
        }
        else{
            System.out.println("org is not displayed");
        }
        sleep(2000);
    }

    public void fillOrgForm (String accName,String email, String terriroty,String city,String stateValue,String country,String zip1 ) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.findElement(accName1).sendKeys(accName);
        sleep(2000);
        driver.findElement(mailId).sendKeys(email);
        sleep(2000);
        WebElement terr = driver.findElement(territory);
        terr.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement dropdownOption = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + terriroty + "')]")));
        dropdownOption.click();
        driver.findElement(city1).sendKeys(city);
        sleep(1000);
        driver.findElement(country1).sendKeys(country);
        sleep(1000);
        driver.findElement(zip).sendKeys(zip1);
        sleep(3000);
        WebElement sField = driver.findElement(state1);
        sField.sendKeys(stateValue);
        sleep(5000);
        WebElement sDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[text()='" + stateValue + "']")));
        sDropdown.click();
        sleep(5000);
    }

}
