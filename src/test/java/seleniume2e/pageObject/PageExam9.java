package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class PageExam9 extends PageOperations {
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("/ninth");

    public String readImgSrc(WebElement numberAsImage){
            return numberAsImage.getAttribute("src");
    }

    public String extractDigitsFromString(String s){
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) > 47 && s.charAt(i) < 58){
                result += s.charAt(i);
            }
        }
        return result;
    }

    public BigDecimal readNumberFromImgSrc(List<WebElement> numberAsImage) {
            String imgSrc = "";
            for(WebElement element : numberAsImage) {
                imgSrc += readImgSrc(element);
        }
            return new BigDecimal(extractDigitsFromString(imgSrc));
    }
}
