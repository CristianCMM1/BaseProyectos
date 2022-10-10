package PagesObjects;

import java.io.File;
import java.io.IOException;
import MapsObjects.MapObjetHomeToolsQA;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjetHomeToolsQA extends MapObjetHomeToolsQA {

	public PagObjetHomeToolsQA(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver=(AppiumDriver<MobileElement>) driver;
	}
	
	//METODO HOME TOOLS ALERTAS
	public void homeToolsQAAlerts( File rutaCarpeta, String nomTest,String generarEvidencia) throws Exception, InterruptedException, IOException
	{
	
		//DESPLAZAR Y ENTRAR EN ALERTARS FRAME & WINDOWS
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 90, 2000, 259,2);
		click(linkAlertsFrameWindows, rutaCarpeta,generarEvidencia,"ingresar en alertas");
		tiempoEspera(2000);
		
		//INGRESAR A ALERTAS
		scrollVertical(rutaCarpeta, 90, 1500, 400, 1);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 10, 700, 2000,2);
		tiempoEspera(2000);
		click(linkAlerts, rutaCarpeta,generarEvidencia,"ingresar en ALerts" );
			
	}
	
	//METODO TOOLS WIDGEST
	public void homeToolsQAWidgest( File rutaCarpeta, String nomTest,String generarEvidencia) throws Exception, InterruptedException, IOException
	{
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 90, 2000, 259,3);
		click(linkWidgets, rutaCarpeta,generarEvidencia,"ingresar a widgest");
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 90, 1500, 400, 1);
		tiempoEspera(2000);
		scrollVertical(rutaCarpeta, 10, 600, 2000,2);
		tiempoEspera(2000);
		click(linkDatePicker, rutaCarpeta,generarEvidencia,"ingresar a Date Picker");
		
	}
}
