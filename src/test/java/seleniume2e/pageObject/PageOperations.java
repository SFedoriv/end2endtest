package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class PageOperations {
    public static String EXAM_PAGE_URI (String endpoint){
        return "https://itk-qa-exams.itekako.com" + endpoint;
    }

    public void button(WebElement element){
        element.click();
    }

    public String webelementToText (WebElement element){
        return element.getText().trim();
    }

    public List <String> webelementToText (List<WebElement> elements){
        List<String> newList = new ArrayList<String>();
        for (WebElement element : elements) {
            newList.add(element.getText());
        }
        return newList;
    }

    public BigDecimal toNumericValue(WebElement element){
        String s = webelementToText(element);
        BigDecimal newValue = null;
        try {
            newValue = new BigDecimal(s);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return newValue;
    }

    public List<BigDecimal> toNumericValue(List <WebElement> webElements){
        List<BigDecimal> newValues = new ArrayList<BigDecimal>();
        for(WebElement we : webElements){
            newValues.add(toNumericValue(we));
        }
        return newValues;
    }


    public BigDecimal addition(BigDecimal firstOperand, BigDecimal secondOperand){
        return firstOperand.add(secondOperand);
    }


    public BigDecimal subtraction(BigDecimal firstOperand, BigDecimal secondOperand){
            return firstOperand.subtract(secondOperand);
    }

    public BigDecimal multiplication(BigDecimal firstOperand, BigDecimal secondOperand){
        return firstOperand.multiply(secondOperand);
    }

    public BigDecimal division(BigDecimal firstOperand, BigDecimal secondOperand){
        return firstOperand.divide(secondOperand, MathContext.DECIMAL32);
    }

    public BigDecimal randomMathOperation(List<WebElement> values, List<WebElement> mathSign) {
        BigDecimal result = toNumericValue(values.get(0));
        List<BigDecimal> integerValues = toNumericValue(values);
        for(int i = 0; i < integerValues.size() - 1; i++){
            String sign = webelementToText(mathSign.get(i));
            switch (sign){
                case "+":
                    result = addition(result, integerValues.get(i + 1));
                    break;
                case "-":
                    result = subtraction(result, integerValues.get(i + 1));
                    break;
                case"*":
                    result = multiplication(result, integerValues.get(i + 1));
                    break;
                case"/":
                    result = division(result, integerValues.get(i + 1));
                    break;
                default:
                    System.out.println("Invalid mathematical symbol");
                    return null;
            }

        }
        return result.setScale(2, RoundingMode.HALF_UP);
    }

    public char[] wordToCharArray(WebElement element){
        return webelementToText(element).toCharArray();
    }
}
