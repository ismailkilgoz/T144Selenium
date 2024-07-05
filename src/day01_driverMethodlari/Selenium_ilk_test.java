package day01_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_ilk_test {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","Kurulum Dosyalari/chromedriver.exe");
        WebDriver driver  =new ChromeDriver();
        driver.get("https://testotomasyonu.com");

    }
}
