package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookHotel extends PageObject {

    BookHotelConfigure bookHotelConfigure;

    @Step
    public void setLocation(String location){
        bookHotelConfigure.SelectLocationForBooking(location);
    }

    @Step
    public void setStartDate(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println(date1);

        bookHotelConfigure.SelectStartDateOfBooking(date1);
    }

    @Step
    public void setEndDate(String date) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);
        System.out.println(date1);

        bookHotelConfigure.SelectEndDateForBooking(date1);
    }

    @Step
    public void addListOfAdults(String adults){

        $(By.xpath("//*[@id=\"search-tabpanel\"]/div/div[5]/div[1]/div")).click();

        int numOfAdults = Integer.parseInt(adults);
        System.out.println(numOfAdults);

        bookHotelConfigure.AddNumOfAdultsForBooking(numOfAdults);
    }

    @Step
    public void addListOfChildren(String children){
        int numOfChildren = Integer.parseInt(children);
        System.out.println(numOfChildren);

        bookHotelConfigure.AddNumOfChildrenForBooking(numOfChildren);
    }

    @Step
    public void addListOfInfants(String infants) throws InterruptedException {
        int numOfInfants = Integer.parseInt(infants);
        System.out.println(numOfInfants);

        bookHotelConfigure.AddNumOfInfantsForBooking(numOfInfants);

        $(By.xpath("//*[@id=\"search-tabpanel\"]//div[@class='_w64aej']/button")).click();
        Thread.sleep(3000L);

    }
}
