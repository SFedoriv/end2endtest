package seleniume2e;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import seleniume2e.pageObject.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static seleniume2e.pageObject.Locators.*;

public class End2endTest {

    private static WebDriver driver;

    @BeforeClass
    public static void openDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void exam01_Validate_sum_of_5_integers_Test() throws Exception{

        PageExam1 pg = new PageExam1();
        driver.get(pg.EXAM_PAGE_URI);
        pg.button(driver.findElement(By.id(START_BUTTON_ID)));
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        BigDecimal result = pg.toNumericValue(driver.findElement(By.xpath(RESULT_VALUE_XPATH)))
                .setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @Test
    public void exam02_Validate_result_of_5_integers_and_random_operation_Test() throws Exception{
        PageExam2 pg = new PageExam2();
        driver.get(pg.EXAM_PAGE_URI);
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        BigDecimal result = (pg.toNumericValue(driver.findElement(By.xpath(RESULT_VALUE_XPATH))))
                .setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @Test
    public void exam03_Validate_result_of_variable_operands_and_fixed_operation_Multiplication_Test() throws Exception{
        PageExam3 pg = new PageExam3();
        driver.get(pg.EXAM_PAGE_URI);
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        BigDecimal result = (pg.toNumericValue(driver.findElement(By.xpath(RESULT_VALUE_XPATH))))
                .setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @Test
    public void exam04_Validate_result_of_variable_operands_and_alternates_between_multiplication_and_division_Test() throws Exception{
        PageExam4 pg = new PageExam4();
        driver.get(pg.EXAM_PAGE_URI);
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        BigDecimal result = (pg.toNumericValue(driver.findElement(By.xpath(RESULT_VALUE_XPATH))))
                .setScale(2, RoundingMode.HALF_UP);
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @Test
    public void exam05_Validate_palindrome_Test() throws Exception{
        PageExam5 pg = new PageExam5();
        driver.get(pg.EXAM_PAGE_URI);
        WebElement palindromeWord = driver.findElement(By.id(WORD_ID));
        WebElement palindromeResult = driver.findElement(By.id(PALINDROM_RESULT_ID));
        Assert.assertEquals(pg.palindromResult(palindromeResult), pg.checkPalindrom(palindromeWord));
    }

    @Test
    public void exam06_Validate_individual_letter_count_Test() throws Exception{
        PageExam6 pg = new PageExam6();
        driver.get(pg.EXAM_PAGE_URI);
        WebElement word = driver.findElement(By.id(WORD_ID));
        List<WebElement>letters = driver.findElements(By.xpath(TABLE_FIRST_COLUMN_XPATH));
        List<WebElement>counters = driver.findElements(By.xpath(TABLE_SECOND_COLUMN_XPATH));
        Assert.assertTrue(pg.checkLetterCount(word, letters, counters));
    }

    @Test
    public void exam07_Validate_factorial_calculation_Test() throws Exception{
        PageExam7 pg = new PageExam7();
        driver.get(pg.EXAM_PAGE_URI);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement givenNumber = driver.findElement(By.xpath(TABLE_FIRST_COLUMN_XPATH));
        BigDecimal factorial = pg.toNumericValue(driver.findElement(By.xpath(TABLE_SECOND_COLUMN_XPATH)));
        Assert.assertEquals(factorial, pg.factorialCalculation(givenNumber));
    }

    @Test
    public void exam08_Validate_result_of_fixed_number_of_operands_in_this_case_5_and_subtraction_as_operation_Test() throws Exception{
        PageExam8 pg = new PageExam8();
        driver.get(pg.EXAM_PAGE_URI);
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_EX_8_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        BigDecimal result = (pg.toNumericValue(numericValues.get(numericValues.size() - 1)));
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @Test
    public void exam09_Validate_result_of_fixed_number_of_operands_in_this_case_3_and_addition_as_operation_Test() throws Exception{
        PageExam9 pg = new PageExam9();
        driver.get(pg.EXAM_PAGE_URI);
        List<WebElement>numericValues = driver.findElements(By.xpath(NUMERIC_VALUES_XPATH));
        List<WebElement>mathSign = driver.findElements(By.xpath(SIGN_OF_OPERATION_XPATH));
        List<WebElement>resultAsImage = driver.findElements(By.xpath(RESULT_VALUE_AS_IMG_XPATH));
        BigDecimal result = (pg.readNumberFromImgSrc(resultAsImage))
                .setScale(2, RoundingMode.HALF_UP);;
        Assert.assertEquals(result, pg.randomMathOperation(numericValues, mathSign));
    }

    @AfterClass
    public static void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}
