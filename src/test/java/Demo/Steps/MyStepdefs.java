package Demo.Steps;

import Demo.Core.testContext;
import Demo.Pages.Login;
import Demo.utility.fileUtil;
import io.cucumber.java.Before;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import java.util.List;
import java.util.Map;

import static Demo.utility.fileUtil.readCSV;

public class MyStepdefs extends testContext {
    public Scenario scenario;
    private Login login; // Declare instance of Login

    @Before
    public void before(Scenario scenario) throws Exception {
        this.scenario = scenario;
        login = new Login(getDriver()); // Initialize Login with driver
    }

    @Given("^Open the browser and search for the facebook url$")
    public void openBrowserAndSearchFacebookUrl() throws InterruptedException {
        login.facebookURL();
    }

    @When("facebook url open for login enter the username and password")
    public void facebookUrlOpenForLoginEnterTheUsernameAndPassword() throws InterruptedException {
        login.logindetails();
    }

    @Then("click on the login button")
    public void clickOnTheLoginButton() throws InterruptedException {
        login.loginbutton();
    }

    @And("user is successfully able to login to the account")
    public void userIsSuccessfullyAbleToLoginToTheAccount() throws InterruptedException {
        login.verifyName();
    }

    @Given("user enter the salesforce application")
    public void userEnterTheSalesforceApplication() throws InterruptedException {
        login.sfURL();
    }

    @When("user enter the username and password")
    public void userEnterTheUsernameAndPassword() throws InterruptedException {
        login.userCred();

    }

    @And("user click on the login button")
    public void userClickOnTheLoginButton() throws InterruptedException {
        login.sfLogin();
    }

    @And("Click on the app Launcher and open the Torrent pharama")
    public void clickOnTheAppLauncherAndOpenTheTorrentPharama() throws InterruptedException {
        login.openTorrentPhrama();
    }

    @And("Verify the Home page of Torrent pharam is displayed")
    public void verifyTheHomePageOfTorrentPharamIsDisplayed() throws InterruptedException {
        login.verfiyHome();
    }

    @And("user click on the {string} from the tab and verify user is in {string} page")
    public void userClickOnTheMyProductsFromTheTabAndVerifyUserIsInAllProductsPage(String MyProduct, String AllProduct) throws InterruptedException {
        login.openProduct(MyProduct, AllProduct);

    }

    @And("click on the {string} button")
    public void clickOnTheNewButton(String newtab) throws InterruptedException {
        login.addNew(newtab);
    }


    @And("fill the details")
    public void fillTheDetails(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> prodAddOn = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> row : prodAddOn) {

            login.addNew("New");
            String prodName = row.get("Product Name");
            String ThearpName = row.get("Therapeutic Area");
            String prodForm = row.get("Product Formulation");
            String dosage = row.get("Dosage");
            Boolean active = Boolean.valueOf(row.get("Active"));
            String manComp = row.get("Manufacturing Company");

            login.addProdFom(prodName, ThearpName, prodForm, dosage, active, manComp);

            login.saveform();

            System.out.println("New product is saved" +prodName);
        }

    }

    @And("click on the save button and verify the product is added to all product")
    public void clickOnTheSaveButtonAndVerifyTheProductIsAddedToAllProduct() throws InterruptedException {
        login.saveform();
    }

    @And("upload the form with the {string}")
    public void uploadTheFormWithTheProductCsv(String filename) throws InterruptedException {
        String filepath = "src/test/resource/testdata/" +filename ;

        List<Map<String, String>> prodList = readCSV(filepath);

        for (Map<String, String> row : prodList) {

            login.addNew("New");
            String prodName = row.get("Product Name");
            String ThearpName = row.get("Therapeutic Area");
            String prodForm = row.get("Product Formulation");
            String dosage = row.get("Dosage");
            Boolean active = Boolean.valueOf(row.get("Active"));
            String manComp = row.get("Manufacturing Company");

            login.addProdFom(prodName, ThearpName, prodForm, dosage, active, manComp);

            login.saveform();

            System.out.println("New product is saved" +prodName);
        }

    }

    @And("user click on the {string} from the tab and verify user  in {string} page")
    public void userClickOnTheClinicalInfoFromTheTabAndVerifyUserInOrganisationPage(String clinical,String org) throws InterruptedException {
        login.openClinicalInfo(clinical,org);

    }

    @And("user Click on the{string} button and upload the form with {string}")
    public void userClickOnTheNewButtonAndUploadTheFormWithOrgCsv(String newButton, String filepath) throws InterruptedException {


        String filename = "src/test/resource/testdata/" +filepath ;

        List<Map<String,String>> orgAddOn = readCSV(filename);

        for(Map<String,String> row : orgAddOn){
            login.addNew(newButton);
            String AccName = row.get("Account Name");
            String Email = row.get("Hospital Email ID");
            String territory = row.get("Territory");
            String city = row.get("City");
            String state = row.get("State");
            String country = row.get("Country");
            String zip = row.get("Zip/Postal code");
            login.fillOrgForm(AccName,Email,territory,city,state,country,zip);
            login.saveform();
            System.out.println("AccName is inserted" +AccName);
        }
    }

    @And("user Click on the {string} button and upload the form with {string}")
    public void userClickOnTheNewButtonAndUploadTheFormWithDoctorCsv(String newbutton, String filepath) throws InterruptedException {

        String filename = "src/test/resource/testdata/"  +filepath;

        List<Map<String,String>> docAddOn = readCSV(filename);

        for(Map<String,String> row : docAddOn){
            login.addNew2(newbutton);
            String DocName = row.get("Account Name");
            String rating = row.get("Professional Rating");
            String phone = row.get("Phone");
            String accType = row.get("Account Type");
            String hospital = row.get("Primary Hospital");
            String special = row.get("Speciality");
            String city = row.get("City");
            String state = row.get("State");
            String country = row.get("Country");
            String Zip = row.get("Zip/Postal Code");
            login.docFillForm(DocName,rating,phone,accType,hospital,special,city,state,country,Zip);

            login.saveform();

            System.out.println("Doctor inserted " +DocName);
        }

    }
}
