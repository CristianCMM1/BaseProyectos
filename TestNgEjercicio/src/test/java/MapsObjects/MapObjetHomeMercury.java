package MapsObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ClaseBase.ClasesBase;

public class MapObjetHomeMercury extends ClasesBase {
	
	//CONSTRUCTOR DE LA CLASE
	public MapObjetHomeMercury(WebDriver driver) {
		super(driver);
	}
	//ELEMENTOS DE LA CLASE PRINCIPAL
	protected By linkregistro = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a");
}
