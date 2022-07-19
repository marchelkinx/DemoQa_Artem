import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TextBoxTest {

    WebDriver wd;

    @BeforeClass
    public void init(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("load-extension=C:\\Tools\\5.0.2_0");

        wd = new ChromeDriver(options);
        wd.manage().window().maximize();
        wd.navigate().to("https://demoqa.com/");
        returnToDemoQa();

    }

    @BeforeMethod
    public void goToTextBox() {
        wd.findElement(By.xpath("//h5[.='Elements']")).click();
        wd.findElement(By.xpath("//li/span[.='Text Box']")).click();

    }

    @Test
    public void textBoxTest(){
        WebElement fullName = wd.findElement(By.id("userName"));
        fullName.click();
        fullName.click();
        fullName.sendKeys("Artem Marchenko");

        WebElement email = wd.findElement(By.id("userEmail"));
        email.click();
        email.clear();
        email.sendKeys("artem@gmail.com");

        WebElement current = wd.findElement(By.id("currentAddress"));
        current.click();
        current.clear();
        current.sendKeys("Hello Hello");

        WebElement address = wd.findElement(By.id("permanentAddress"));
        address.click();
        address.clear();
        address.sendKeys("Hy Hy Hy");

        wd.findElement(By.id("submit")).click();

//        Assert.assertEquals(wd.findElement(By.cssSelector("p#name")).getText(), "Artem Marchenko");
        Assert.assertTrue(wd.findElement(By.cssSelector("p#name")).getText().contains("Artem Marchenko"));



    }

    private void returnToDemoQa() {
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1)).close();
        wd.switchTo().window(tabs.get(0));
    }
}
