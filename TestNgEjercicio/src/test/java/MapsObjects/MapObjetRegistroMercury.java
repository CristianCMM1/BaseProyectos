package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ClaseBase.ClasesBase;

public class MapObjetRegistroMercury extends ClasesBase{

	//CONSTRUCTOR DE LA CLASE
	public MapObjetRegistroMercury(WebDriver driver) {
		super(driver);
	}

	//ELEMENTOS PARA REGISTRARSE
	protected By txtfirstName = By.name("firstName");
	protected By txtLastName = By.name("lastName");
	protected By txtPhone = By.name("phone");
	protected By txtEmail = By.id("userName");
	protected By txtAddress = By.name("address1");
	protected By txtCity = By.name("city");
	protected By txtState = By.name("state");
	protected By txtPostalCode = By.name("postalCode");
    protected By txtCountry = By.name("country");
	protected By txtUserName = By.id("email");
	protected By txtPassword = By.name("password");
	protected By txtconfirmPassword = By.name("confirmPassword");
	protected By btnEnviar = By.xpath("//input[@src='images/submit.gif']");
	
}