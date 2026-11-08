package org.example;

import java.util.Arrays;
import java.util.Optional;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.openqa.selenium.devtools.v144.network.Network;

import org.openqa.selenium.devtools.v144.network.model.BlockPattern;

public class BlockNetworkRequestTest {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub

        //css , images
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        //log file ->
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.send(Network.setBlockedURLs(
                Optional.of(Arrays.asList(
                        new BlockPattern("*.jpg",true),
                        new BlockPattern("*.css",true)
                )),
                Optional.empty()
        ));
        long startTime = System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
        //1793 2033

        driver.close();
    }

}
