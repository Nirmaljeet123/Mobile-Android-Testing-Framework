package actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.android.AndroidDriver;

import static basePackage.BaseClass.*;

public class FingerGestureActions {

	public static void clickUsingCoordinates(int x, int y) {
		PointerInput pointerInput = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		Sequence tapSequence = new Sequence(pointerInput, 0);
		
		tapSequence.addAction(pointerInput.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
		tapSequence.addAction(pointerInput.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tapSequence.addAction(pointerInput.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		getDriver().perform(Arrays.asList(tapSequence));
		
	}
	
	public void tap(WebElement element) {
	    Point location = element.getLocation();
	    Dimension size = element.getSize();

	    Point centerOfElement = getCenterOfElement(location, size);

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    getDriver().perform(Collections.singletonList(sequence));
	  }

	  private Point getCenterOfElement(Point location, Dimension size) {
	    return new Point(location.getX() + size.getWidth() / 2,
	                     location.getY() + size.getHeight() / 2);
	  }
	  
	  public void doubleTap(WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(100)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    getDriver().perform(Collections.singletonList(sequence));
		  }
	  
	  public void longPress(WebElement element) {
		    Point location = element.getLocation();
		    Dimension size = element.getSize();

		    Point centerOfElement = getCenterOfElement(location, size);

		    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofSeconds(2)))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		    getDriver().perform(Collections.singletonList(sequence));
		  }
	  
	  public void zoom(WebElement element)
	    {
	    Point centerOfElement = getCenterOfElement(element.getLocation(), element.getSize());

	    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
	    PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
	    Sequence sequence = new Sequence(finger1, 1)
	        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger1, Duration.ofMillis(200)))
	        .addAction(finger1.createPointerMove(Duration.ofMillis(200),
	                                             PointerInput.Origin.viewport(), centerOfElement.getX() + 100,
	                                             centerOfElement.getY() - 100))
	        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    Sequence sequence2 = new Sequence(finger2, 1)
	        .addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerOfElement))
	        .addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
	        .addAction(new Pause(finger2, Duration.ofMillis(200)))
	        .addAction(finger2.createPointerMove(Duration.ofMillis(200),
	                                             PointerInput.Origin.viewport(), centerOfElement.getX() - 100,
	                                             centerOfElement.getY() + 100))
	        .addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    getDriver().perform(Arrays.asList(sequence, sequence2));

	    //Assertion
	  }
	  
	  public void swipeOrScroll()
		 {
			 Dimension size = getDriver().manage().window().getSize();
			    int startX = size.getWidth() / 2;
			    int startY = size.getHeight() / 2;
			    int endX = startX;
			    int endY = (int) (size.getHeight() * 0.25);
			    PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			    Sequence sequence = new Sequence(finger1, 1)
			        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
			        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			        .addAction(new Pause(finger1, Duration.ofMillis(200)))
			        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
			        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			    getDriver().perform(Collections.singletonList(sequence));
			 
		 }
	
	  public void dragAndDrop(WebElement source,WebElement target)
		{
			    Point sourceElementCenter=getCenterOfElement(source.getLocation(),source.getSize());
			    Point targetElementCenter= getCenterOfElement(target.getLocation(),target.getSize());
			    PointerInput finger1=new PointerInput(PointerInput.Kind.TOUCH,"finger1");
			    Sequence sequence=new Sequence(finger1,1)
			    		.addAction(finger1.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(), sourceElementCenter))
			    		.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			    		.addAction(new Pause(finger1,Duration.ofMillis(500)))
			    		.addAction(finger1.createPointerMove(Duration.ofMillis(500),PointerInput.Origin.viewport(), targetElementCenter))
			    		.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			    getDriver().perform(Collections.singletonList(sequence));
		}
}
