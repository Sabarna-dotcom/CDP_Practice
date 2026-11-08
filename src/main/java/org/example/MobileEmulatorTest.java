package org.example;
import java.util.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.emulation.Emulation;

public class MobileEmulatorTest {
    public static void main(String[] args) throws InterruptedException  {
        // TODO Auto-generated method stub

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        DevTools devTools = driver.getDevTools();

        devTools.createSession();

        //send command to CDP Methods-> CDP Methods will invoke and get access to chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(
                600,   // width
                1000,  // height
                50,    // deviceScaleFactor
                true,  // mobile
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()
        ));

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler")).click();
        Thread.sleep(3000);

        driver.findElement(By.linkText("Library")).click();
        driver.close();
        //Network.getRequestPostData
    }

}
