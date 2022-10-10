package MapsObjects;

import org.openqa.selenium.By;
import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjectCrearCuentaMercadolibre extends ClaseBase {

	public MapObjectCrearCuentaMercadolibre(AppiumDriver<MobileElement> driver) {
		super(driver);
	
	}

	//ELEMENTOS DE PARA CREAR CUENTA
	protected By txtfirstName= By.xpath("//android.widget.EditText[@resource-id='firstName']");
	protected By txtlastName= By.xpath("//android.widget.EditText[@resource-id='lastName']");
	protected By btnDocumento = By.xpath("//android.view.View[@text='DNI']");
	protected By btnSelecDocumento = By.xpath("//android.widget.CheckedTextView[@index='1']");
	protected By txtDocumento= By.xpath("//android.widget.EditText[@resource-id='identification']");
	protected By txtemail= By.xpath("//android.widget.EditText[@resource-id='email']");
	protected By txtpassword= By.xpath("//android.widget.EditText[@resource-id='password']");
	protected By checkbox = By.xpath("//android.widget.CheckBox[@resource-id='tyc_checkbox']");
}
