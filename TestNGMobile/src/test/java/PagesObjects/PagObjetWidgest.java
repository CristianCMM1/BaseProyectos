package PagesObjects;

import java.io.File;
import java.io.IOException;
import MapsObjects.MapObjetWidgest;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PagObjetWidgest extends MapObjetWidgest {

	public PagObjetWidgest(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = (AppiumDriver<MobileElement>) driver;
	}
	public void widgest(File rutaCarpeta, String generarEvidencia,String selecDate, String dateTime)
	throws Exception, InterruptedException, IOException{
	 
		/*
	//LINK DIRECTO A WIDGETS
	click(nomTest, btnOpciones, rutaCarpeta,1);
	click(nomTest, btnNuevaPesta�a, rutaCarpeta,1);
	tiempoEspera(3);
	sendkey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "toolsqa", 1, 4), urlwidgest,
				rutaCarpeta, 2);
	enter(rutaCarpeta);
	 */
		
	scrollVertical(rutaCarpeta, 90, 1500, 1000, 1);
	tiempoEspera(2000);
	
	//LLENAR LOS CAMPOS
	sendkey(selecDate, txtSelectDate,rutaCarpeta, generarEvidencia,"seleccionar fecha ");
	tiempoEspera(2000);
	sendkey(dateTime, txtDateAndTime,rutaCarpeta, generarEvidencia,"seleccionar fecha y hora");
	tiempoEspera(2000);
	
	click( clickfuera, rutaCarpeta, generarEvidencia,"click fuera de fecha");
	tiempoEspera(2000);
	}
	
}
