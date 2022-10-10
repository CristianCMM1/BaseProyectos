package MapsObjects;

import org.openqa.selenium.By;
import ClaseBase.ClaseBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MapobjecthHomeMercadolibre extends ClaseBase {

	public MapobjecthHomeMercadolibre(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	//ELEMENTOS DE LA CLASE PRINCIPAL MERCADO LIBRE
	protected By txtBuscadorMercadolibre = By.xpath("//android.widget.EditText[@resource-id='cb1-edit']");
	protected By linkprimerObjeto = By.xpath("//android.view.View[@resource-id='root-app']/android.widget.ListView[2]/android.view.View[1]");
	protected By btnAhoraNo = By.xpath("//android.widget.Button[@text='Ahora no']");
	protected By btnComprar = By.xpath("//android.widget.Button[@text='Comprar ahora']");
	protected By btnCrearcuenta= By.xpath("//android.widget.TextView[@text='Crear cuenta']");
}
