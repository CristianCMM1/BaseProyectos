package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapObjetCrearCuenta extends ClasesBase {

	// CONSTRUCTOR DE LA CLASE
	public MapObjetCrearCuenta(WebDriver driver) {
		super(driver);
	}
	//ELEMENTOS PARA CREAR CUENTA
	protected By checkAceptarTerminos = By.id("terms-and-conds");
	protected By btnaceptarTerminos = By.xpath("//span[@class='andes-button__content']");
	protected By btnvalidarEmail = By.xpath("//span[@class='andes-button__text']");
	protected By txtingresarCorreo = By.xpath("//input[@class='andes-form-control__field']");
}

