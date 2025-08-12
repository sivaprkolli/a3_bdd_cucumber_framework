package com.sft.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

import static java.util.Collections.singletonList;

public class MobileActions {

    public Point getCenterPoint(WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();
//        System.out.println(location.x);
//        System.out.println(location.y);
        return new Point(location.x + (size.getWidth() / 2), location.y + (size.getHeight() / 2));
    }

    public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
        Point sourcePoint = getCenterPoint(source);
        Point targetPoint = getCenterPoint(target);
        Point endPoint = new Point (750, 1341);
        swipeOnMobile(sourcePoint, endPoint, driver);
    }

    public void dragAndDropIOS(WebElement source, WebElement target, WebDriver driver) {
        Point sourcePoint = getCenterPoint(source);
        Point targetPoint = getCenterPoint(target);
        Point endPoint = new Point (262, 435);
        swipeOnMobileIOS(sourcePoint, endPoint, driver);
    }

    public void swipeOnMobile(Point startPoint, Point endPoint, WebDriver driver){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), startPoint.x, startPoint.y));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(600)));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600),
                        PointerInput.Origin.viewport(), endPoint.x, endPoint.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AndroidDriver) driver).perform(singletonList(swipe));
    }

    public void swipeOnMobileIOS(Point startPoint, Point endPoint, WebDriver driver){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(0),
                        PointerInput.Origin.viewport(), startPoint.x, startPoint.y));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(new Pause(finger, Duration.ofMillis(600)));
        swipe.addAction(
                finger.createPointerMove(Duration.ofMillis(600),
                        PointerInput.Origin.viewport(), endPoint.x, endPoint.y));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((IOSDriver) driver).perform(singletonList(swipe));
    }

}
