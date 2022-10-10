package MapsObjects;

import org.openqa.selenium.By;

import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapObjetGoogle extends ClaseBase {

	public MapObjetGoogle(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	//CREAR UNA PESTAÑA NUEVA DE GOOGLE
	protected By btnOpciones=By.id("com.android.chrome:id/menu_button");
	protected By btnNuevaPestaña=By.xpath("//android.widget.TextView[@text='Nueva pestaña']");
	protected By txtbuscador = By.xpath("//android.widget.EditText[@text='Busca o escribe la dirección web']");
}
