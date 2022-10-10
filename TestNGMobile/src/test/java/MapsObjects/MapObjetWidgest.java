package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetWidgest extends ClaseBase{
	public MapObjetWidgest(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	//PROCESO LLENAR CAMPOS
	protected By txtSelectDate = By.xpath("//android.widget.EditText[@resource-id='datePickerMonthYearInput']");
	protected By txtDateAndTime = By.xpath("//android.widget.EditText[@resource-id='dateAndTimePickerInput']");
	protected By clickfuera = By.xpath("//android.widget.TextView[@text='Date And Time']");
}
