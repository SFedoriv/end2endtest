package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

public class PageExam5 extends PageOperations {
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("/fifth");

    public String checkPalindrom (WebElement element){
        char[] palindrom = wordToCharArray(element);
            for(int i = 0, j = palindrom.length - 1; i < palindrom.length / 2 + 1; i++, j--){
                if(palindrom[i] != palindrom[j]){
                    return "no";
                }
            }
            return "yes";
    }

    public String palindromResult(WebElement element){
        return webelementToText(element).toLowerCase();
    }
}
