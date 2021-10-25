package Pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    @Step
    public void AcceptCookies(){
        // Accepting Cookies and Wait
        waitForCondition().until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-testid=\"accept-btn\"]"))).click();
    }
}
