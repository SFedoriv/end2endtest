package seleniume2e.pageObject;

import org.openqa.selenium.WebElement;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageExam6 extends PageOperations {
    public static String EXAM_PAGE_URI = EXAM_PAGE_URI("/sixth");

    public Map<Character, BigDecimal> letterCounter(WebElement word){
        Map<Character, BigDecimal> letterCounter = new HashMap<>();
        char[]wordAsArray = wordToCharArray(word);
        for (int i = 0; i < wordAsArray.length; i++){
            if(!letterCounter.containsKey(wordAsArray[i])) {
                letterCounter.put(wordAsArray[i], BigDecimal.valueOf(1));
            }else {
                BigDecimal count = letterCounter.get(wordAsArray[i]);
                letterCounter.put(wordAsArray[i], count.add(BigDecimal.ONE));
            }
        }
        return  letterCounter;
    }

    public boolean checkLetterCount(WebElement word, List<WebElement> letter, List<WebElement>count){
        Map<Character, BigDecimal> counterMap = letterCounter(word);
        for(int i = 1; i < letter.size(); i++){
            if(counterMap.get(webelementToText(letter.get(i)).charAt(0)).compareTo(toNumericValue(count.get(i))) != 0){
                return false;
            }
        }
        return true;
    }
}
