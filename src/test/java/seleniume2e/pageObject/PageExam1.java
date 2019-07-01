package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

public class PageExam1 extends PageOperations{
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("");

    public void button(WebElement element){
        element.click();
    }


}