package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.List;

public class PageExam8 extends PageOperations {
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("/eighth");

    public BigDecimal randomMathOperation(List<WebElement> values, List<WebElement> mathSign) {
        BigDecimal result = toNumericValue(values.get(0));
        List<BigDecimal> integerValues = toNumericValue(values);
        for(int i = 0; i < integerValues.size() - 2; i++){
            String sign = webelementToText(mathSign.get(i));
            if (sign.equals("-")) {
                result = subtraction(result, integerValues.get(i + 1));
            }else {
                System.out.println("Invalid mathematical symbol");
                    return null;
            }
        }
        return result;
    }
}
