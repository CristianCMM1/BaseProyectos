package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetHomeToolsQA extends ClaseBase {

	public MapObjetHomeToolsQA( AppiumDriver<MobileElement> driver)  {
		super(driver);
		
	}

	//ELEMENTOS DE LA PAGINA PRINCIPAL HOME TOOLS QA
	protected By linkAlertsFrameWindows = By.xpath("//android.widget.TextView[@text='Alerts, Frame & Windows']");
	protected By linkAlerts = By.xpath("//android.widget.TextView[@text='Alerts']");
	protected By linkWidgets = By.xpath("//android.widget.TextView[@text='Widgets']");
	protected By linkDatePicker = By.xpath("//android.widget.TextView[@text='Date Picker']");
}
