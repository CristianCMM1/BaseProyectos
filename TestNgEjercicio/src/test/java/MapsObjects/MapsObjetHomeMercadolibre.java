package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapsObjetHomeMercadolibre extends ClasesBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapsObjetHomeMercadolibre(WebDriver driver) {
		super(driver);
	}
	
	//ELEMENTOS PAGINA PRINCIPAL
	protected By txtbusqueda = By.xpath("//input[@class='nav-search-input']");
	protected By cerrarubicacion = By.xpath("//button[@class='andes-tooltip-button-close']");
	protected By linkproducto= By.xpath("/html/body/main/div/div[2]/section/ol/li[1]/div/div/div[1]/a/div/div/div/div/div/img");
	protected By cerrarCookies = By.xpath("//button[@class='cookie-consent-banner-opt-out__action cookie-consent-banner-opt-out__action--primary cookie-consent-banner-opt-out__action--key-accept']");
	protected By linkcarrito = By.xpath("/html/body/main/div[2]/div[3]/div[1]/div[2]/div/div[1]/form/div[6]/div/button[2]/span");
	protected By btncrearCuenta = By.xpath("//*[@id=\"registration-link\"]/span");
	protected By linkCrearCuenta = By.xpath("//*[@id=\"nav-header-menu\"]/a[1]");
	
}
