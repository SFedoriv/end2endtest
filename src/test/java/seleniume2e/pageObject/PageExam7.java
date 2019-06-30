package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;

public class PageExam7 extends PageOperations {
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("/seventh");

    public BigDecimal calculation(BigDecimal number) {
        if(number.compareTo(BigDecimal.ZERO) == 0){
            return BigDecimal.valueOf(1);
        }else{
            return number.multiply(calculation(number.subtract(BigDecimal.valueOf(1))));
        }
    }

    public BigDecimal factorialCalculation (WebElement element){
        return calculation(super.toNumericValue(element));
    }
}
