package PagsObjets;

import java.io.File;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetAlertsToolsQA;

public class PagObjetAlertsToolsQA extends MapObjetAlertsToolsQA {

	

	//CONSTRUCTOR DE LA CLASE
	public PagObjetAlertsToolsQA(WebDriver driver) {
		super(driver);
	}

	//METODO ALERTAS TOOLSQA
	public void alertasToolsQA(File rutaCarpeta, String generarEvidencia,String prueba) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
		
	    // INGRESAR CLICK EN  ALERTAS
		click(linkAlerts, rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);
		
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
		
	    //SELECCIONAR ALERTA
		click(btnAlert,rutaCarpeta,generarEvidencia);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA CON TIEMPO DE ESPERA
		click(btnTimeAlert, rutaCarpeta,generarEvidencia);
		tiempoEspera(6000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA CON ACEPTAR O 
		click(btnconfirmButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
		
		//SELECCIONAR ALERTA CON CANCELAR
		click(btnconfirmButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		driver.switchTo().alert().dismiss();
	    tiempoEspera(2000);
	    
		//SELECCIONAR ALERTA CON TEXTO
	try {
		click(btnpromtButton, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		driver.switchTo().alert().sendKeys(prueba);
		
		tiempoEspera(2000);
		driver.switchTo().alert().accept();
		tiempoEspera(2000);
	} catch (Exception e) {
		System.out.println(e);
	}
		
	}
}
