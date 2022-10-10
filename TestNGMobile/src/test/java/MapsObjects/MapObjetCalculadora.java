package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetCalculadora extends ClaseBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapObjetCalculadora(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	//ELEMENTOS DE LA CLASE CALCULADORA
	protected By btnNumeros = By.xpath("//android.widget.Button[@text='{0}']");
	protected By btnOperaciones = By.xpath("//android.widget.ImageView[@content-desc='{0}']");
	protected By btnigual = By.id ("com.android.calculator2:id/eq");
	
}
