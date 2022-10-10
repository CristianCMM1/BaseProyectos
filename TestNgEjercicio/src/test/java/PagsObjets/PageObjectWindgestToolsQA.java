package PagsObjets;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapsObjects.MapObjetWidgwestToolsQA;


public class PageObjectWindgestToolsQA extends MapObjetWidgwestToolsQA {

	public PageObjectWindgestToolsQA(WebDriver driver) {
		super(driver);
	}

	public void widgestToolsQAOptimizado(File rutaCarpeta,String generarEvidencia) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,400)");
	    
		// SELECCIONAR DATE PICKER
		tiempoEspera(2000);
		click(linkDatePicker, rutaCarpeta,generarEvidencia);
		tiempoEspera(1000);
		
		 // This  will scroll down the page by  1000 pixel vertical        
	    js.executeScript("window.scrollBy(0,200)");
	    
		// SELECCIONAR SELECT DATE
		borrar(selectDate, rutaCarpeta,generarEvidencia);

		tiempoEspera(2000);
		
		
		// LLAMADA AL METODO FECHA SISTEMA
		String fecha2 = fechaSistema();
		String[] fechaVector = fecha2.split("-");
		
		int dia = Integer.parseInt(fechaVector[0]);
		int mes = Integer.parseInt(fechaVector[1]); 
		int year = Integer.parseInt(fechaVector[2]); 
		
		dia= dia-1;
		mes= mes-1;
		year= year-1;
		
		fecha2 = mes+"/"+dia+"/"+year;
		
		//INGRESAR LA FECHA A AGREGAR
		borrar(selectDate, rutaCarpeta,generarEvidencia);
		sendkey(fecha2,selectDate, rutaCarpeta,generarEvidencia);
		
		//LIMPIAR CAJA DE TEXTO
		tiempoEspera(2000);
		borrar(dateAndTime,rutaCarpeta,generarEvidencia);
		
		//DISMINUIR UN MES Y TRAE EL MES EN LETRAS
		Month mes1= LocalDate.now().minusMonths(1).getMonth();
		fecha2 = mes1+"/"+dia+"/"+year;
		
		//INGRESAR LA FECHA
		sendkey(fecha2,dateAndTime, rutaCarpeta,generarEvidencia);
		tiempoEspera(2000);
		
		//INGRESAR LA HORA

		List<WebElement> hora = listaElementos(horaDateAndTime);
		// INGRESAR MES
		hora.get(39).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta, dateAndTime, fecha2);		
	}
}
