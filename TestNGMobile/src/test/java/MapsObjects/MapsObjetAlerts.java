package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapsObjetAlerts extends ClaseBase {

	public MapsObjetAlerts(AppiumDriver<MobileElement> driver) {
		super(driver);
		
	}
	
	//SELECCIONAR ALERTAS
	protected By btnAlertButton = By.xpath("//android.widget.Button[@resource-id='alertButton']");
	protected By btnAceptar = By.xpath("//android.widget.Button[@text='Aceptar']");
	protected By btnTimerAlertButton = By.xpath("//android.widget.Button[@resource-id='timerAlertButton']");
	protected By btnConfirmButton = By.xpath("//android.widget.Button[@resource-id='confirmButton']");
	protected By btnNegative = By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/negative_button']");
	protected By btnPositive = By.xpath("//android.widget.Button[@resource-id='com.android.chrome:id/positive_button']");
	protected By btnpromtButton = By.xpath("//android.widget.Button[@resource-id='promtButton']");
	protected By txtpromtButton = By.xpath("//android.widget.EditText[@resource-id='com.android.chrome:id/js_modal_dialog_prompt']");
   
}
