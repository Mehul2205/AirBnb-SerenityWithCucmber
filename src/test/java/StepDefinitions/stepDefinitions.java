package StepDefinitions;

import Pages.BookHotel;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;

public class stepDefinitions extends PageObject {

    @Managed
    WebDriver driver;

    @Steps
    HomePage homePage;

    @Steps
    BookHotel bookHotel;

    @Given("Open the url")
    public void CodeStarts(){
        try{
            open();
            homePage.AcceptCookies();
        }catch (Exception e){
            System.out.println("Error!");
        }
    }

    @When("^enter (.*) in the search box$")
    public void selectLocation(String location){
        System.out.println(location);

        bookHotel.setLocation(location);
    }

    @When("^enter (.*) as startdate$")
    public void getStartDate(String startDate) throws ParseException {
        System.out.println(startDate);

        bookHotel.setStartDate(startDate);
    }

    @When("^enter (.*) as endDate$")
    public void getEndDate(String endDate) throws ParseException {
        System.out.println(endDate);

        bookHotel.setEndDate(endDate);
    }

    @When("^enter (.*) as elder$")
    public void getNumsOfElders(String numOfElders){
        System.out.println(numOfElders);

        bookHotel.addListOfAdults(numOfElders);

    }

    @When("^enter (.*) as children$")
    public void getNumsOfChildren(String numOfChildren){
        System.out.println(numOfChildren);

        bookHotel.addListOfChildren(numOfChildren);
    }

    @When("^enter (.*) as infant$")
    public void getNumsOfInfants(String numOfInfants) {
        try{
            System.out.println(numOfInfants);
            bookHotel.addListOfInfants(numOfInfants);
        }catch(Exception e){
            System.out.println("Error! -"+e);
        }
    }

    @Then("^I should get the result as (.*)$")
    public void getResults(String results){
        try{
            Thread.sleep(3000);

            System.out.println(results);
            Assert.assertEquals(new String().valueOf(20), results);
        }catch (Exception e){
            System.out.println("Error in Thread Sleep");
        }

    }




}
