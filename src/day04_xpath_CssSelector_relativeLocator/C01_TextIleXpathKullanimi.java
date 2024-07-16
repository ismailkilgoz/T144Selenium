package day04_xpath_CssSelector_relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TextIleXpathKullanimi {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1- https://testotomasyonu.com/addremove/ adresine gidin
        driver.get("https://testotomasyonu.com/addremove/");

        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']"))
                .click();

        //3- Remove butonu’nun gorunur oldugunu test edin
        WebElement removeButonu = driver.findElement(By.xpath("//*[text()='Remove']"));
        if (removeButonu.isDisplayed()){
            System.out.println("Remove butonu gorunurlugu testi PASSED");
        }else System.out.println("Remove butonu gorunurlugu testi FAILED");

        //4- Remove tusuna basin
        removeButonu.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        String exceptedText = "Add/Remove Elements";
        WebElement actualText1 = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        String actualText = actualText1.getText();


        //  System.out.println(actualText);

        if (actualText.contains(exceptedText)){
            System.out.println("Add/Remove Elements yazisi testi PASSED");
        }else System.out.println("Add/Remove Elements yazisi testi FAILED");

        driver.quit();



    }
}
