package Pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.util.Date;

public class BookHotelConfigure extends PageObject {

    public void SelectLocationForBooking(String location){
        try{
            $(By.xpath("//div[@class='_gor68n']//input")).sendKeys(new CharSequence[]{location});
            Thread.sleep(3000L);
            System.out.println(1);
            withAction().moveToElement($("//div[@class='_zusf8ed']//div[@class='_mnnz9u']")).perform();
            System.out.println(2);
            withAction().sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
            //withAction().sendKeys(Keys.DOWN, $("//div[@class='_zusf8ed']//div[@class='_mnnz9u']")).perform();
            //withAction().sendKeys(Keys.ENTER, $("//div[@class='_zusf8ed']//div[@class='_mnnz9u']")).perform();

            //$("//div[@class='_zusf8ed']//div[@class='_mnnz9u']").sendKeys(new CharSequence[]{Keys.DOWN, Keys.ENTER});
            System.out.println(3);
        }catch (InterruptedException e){
            System.out.println("Error Occured! On Selecting Location");
        }
    }

    public void SelectStartDateOfBooking(Date startDate){
        LocalDate localDate = LocalDate.now();
        if(startDate.getYear()+1900 == localDate.getYear()){
            if(startDate.getMonth()+1 == localDate.getMonthValue()){
                for(int i=1; i<7; i++){
                    for(int j=1; j<8; j++){
                        int checkIfContainsDates = findAll(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]//div")).size();
                        //System.out.println(new String().valueOf(startDate.getDate()));
                        if(checkIfContainsDates!=0){
                            String tempDate = $(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText();
                            //System.out.println(driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText()+":"+driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText().length());
                            if(new String().valueOf(startDate.getDate()).equals(tempDate)){
                                $(By.xpath("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][1]//table//tr["+i+"]//td["+j+"]")).click();
                                break;
                            }
                        }
                    }
                }
            }else if(startDate.getMonth()+1 > localDate.getMonthValue()){
                int numOfClicks = startDate.getMonth()+1-localDate.getMonthValue();
                for(int i=0; i<numOfClicks; i++){
                    $(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/button")).click();
                }
                for(int i=1; i<7; i++){
                    for(int j=1; j<8; j++){
                        int checkIfContainsDates = findAll(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]//div")).size();
                        //System.out.println(new String().valueOf(startDate.getDate()));
                        if(checkIfContainsDates!=0){
                            String tempDate = $(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText();
                            //System.out.println(driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText()+":"+driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText().length());
                            if(new String().valueOf(startDate.getDate()).equals(tempDate)){
                                $(By.xpath("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][1]//table//tr["+i+"]//td["+j+"]")).click();
                                break;
                            }
                        }
                    }
                }
            }else{
                System.out.println("Error");
            }
        }else if(startDate.getYear()+1900 > localDate.getYear()){
            int getYearsAhead = startDate.getYear()+1900 - localDate.getYear();
            int numOfClicks = getYearsAhead*12 + startDate.getMonth()+1 - localDate.getMonthValue();
            for(int i=0; i<numOfClicks; i++){
                $(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[1]/div[2]/div/button")).click();
            }
            for(int i=1; i<7; i++){
                outerLoop:
                for(int j=1; j<8; j++){
                    int checkIfContainsDates = findAll(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]//div")).size();
                    //System.out.println(new String().valueOf(startDate.getDate()));
                    if(checkIfContainsDates!=0){
                        String tempDate = $(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText();
                        //System.out.println(driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText()+":"+driver.findElement(By.xpath("//*[@id=\"panel--tabs--0\"]/div[1]/div/div/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr["+i+"]/td["+j+"]/div/div/div")).getText().length());
                        if(new String().valueOf(startDate.getDate()).equals(tempDate)){
                            $(By.xpath("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][1]//table//tr["+i+"]//td["+j+"]")).click();
                            break outerLoop;
                        }
                    }
                }
            }
        }else{
            System.out.println("Error Date Invalid");
        }
    }

    public void SelectEndDateForBooking(Date endDate){

        for(int i=1; i<7; i++) {
            outerloop:
            for (int j = 1; j < 8; j++) {
                int checkForDates = findAll(By.xpath("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][2]//table/tbody/tr[" + i + "]/td[" + j + "]//div")).size();
                if (checkForDates != 0) {
                    String tempDate = $("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][2]//table/tbody/tr[" + i + "]/td[" + j + "]/div/div/div").getText();
                    if (new String().valueOf(endDate.getDate()).equals(tempDate)) {
                        $("//*[@id=\"panel--tabs--0\"]//div[@class='_1lds9wb'][2]//table//tr[" + i + "]//td[" + j + "]").click();
                        //ac.click(driver.findElement(By.xpath())).build().perform();
                        break outerloop;
                    }
                }
            }
        }

    }

    public void AddNumOfAdultsForBooking(int numsOfAdults){
        for(int i=0; i<numsOfAdults; i++)
            $(By.xpath("//*[@id=\"stepper-adults\"]/button[2]")).click();
    }

    public void AddNumOfChildrenForBooking(int numsOfChildren){
        for(int i=0; i<numsOfChildren; i++)
            $(By.xpath("//*[@id=\"stepper-children\"]/button[2]")).click();
    }
    public void AddNumOfInfantsForBooking(int numsOfInfants){
        for(int i=0; i<numsOfInfants; i++)
            $(By.xpath("//*[@id=\"stepper-infants\"]/button[2]")).click();
    }

}
