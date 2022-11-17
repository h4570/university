package com.h4570.tau;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class SeleniumTests {

    private WebDriver driver;
    private StringBuffer errors = new StringBuffer();

    @Before
    public void setup() throws Exception {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:\\Users\\hasto\\Documents\\repositories\\university\\7-semester-tau\\excercise-3\\chromedriver-107.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @Test
    public void isJKMInNonsensopedia() throws Exception {
        driver.get("https://nonsa.pl/wiki/Strona_g%C5%82%C3%B3wna");
        driver.findElement(By.id("searchInput")).click();
        driver.findElement(By.id("searchInput")).sendKeys("janusz koran mekka");
        driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@href=\"/wiki/Janusz_Korwin-Mikke\"]")).click();
    }

    @Test
    public void isOldStart24StillAlive() throws Exception {
        driver.get("https://www.start24.pl/");
        driver.findElement(By.xpath("//a[@href=\"stara.htm\"]")).click();
        var tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(By.name("q")).clear();
        driver.findElement(By.name("q")).sendKeys("twoje miejsce w sieci");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @After
    public void teardown() throws Exception {
        driver.quit();
        String verificationErrorString = errors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
