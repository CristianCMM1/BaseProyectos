package PagsObjets;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import MapsObjects.MapObjetHomeToolsQA;

public class PagObjetHomeToolsQA extends MapObjetHomeToolsQA {

	public PagObjetHomeToolsQA(WebDriver driver) {
		super(driver);
	}

	// METODO INICIAL
	public void urlAcceso(String url) throws IOException {
		driver.get(url);
	}

	// METODO LINK ALERTAS
	public void homeAlertsToolsQA( File rutaCarpeta,String generarEvidencia)
			throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
	    
		click(linkAlertaFrameswindows, rutaCarpeta, generarEvidencia);
		tiempoEspera(2000);	
	}
	// METODO LINK WIDGETS
		public void homeWidgetsToolsQA(File rutaCarpeta, String generarEvidencia)
				throws Exception {
			JavascriptExecutor js = (JavascriptExecutor) driver;
		    // This  will scroll down the page by  1000 pixel vertical        
		    js.executeScript("window.scrollBy(0,200)");
			click(linkWidgets, rutaCarpeta,generarEvidencia);
			tiempoEspera(2000);	
		}
	
	
}