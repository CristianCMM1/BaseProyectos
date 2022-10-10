package Run;

import org.testng.annotations.Test;

import ClaseBase.ClaseBase;
import PagesObjects.PagObjectCrearCuentaMercadolibre;
import PagesObjects.PagObjectGoogle;
import PagesObjects.PagObjetAlerts;
import PagesObjects.PagObjetCalculadoraProcedimientos;
import PagesObjects.PagObjetHomeMercadolibre;
import PagesObjects.PagObjetHomeToolsQA;
import PagesObjects.PagObjetWidgest;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;

public class Run {
	private AppiumDriver<MobileElement> driver;
	GenerarReportePdf generarReportePdf;
	ClaseBase claseBase;
	PagObjetCalculadoraProcedimientos calculadora;
	PagObjectGoogle google;
	PagObjetHomeMercadolibre homeMercadolibre;
	PagObjectCrearCuentaMercadolibre crearCuenta;
	PagObjetHomeToolsQA homeTools;
	PagObjetAlerts alerts;
	PagObjetWidgest widgest;

	String rutaMercadolibre;
	String rutaTools;
	String rutaCalculadora;
	String platformName;
	String deviceName;
	String platformVersion;
	String noReset;
	String autoGrantPermissions;

	@BeforeClass
	@Parameters({ "rutaImagenReporte", "rutaImagenReporteTQA", "rutaImagenReporteMT", "platformName", "deviceName",
			"platformVersion", "noReset", "autoGrantPermissions" })
	public void beforeClass(@Optional("default") String rutaImagenReporte,
			@Optional("default") String rutaImagenReporteTQA, @Optional("default") String rutaImagenReporteMT,
			@Optional("default") String platformName1, @Optional("default") String deviceName1,
			@Optional("default") String platformVersion1, @Optional("default") String noReset1,
			@Optional("default") String autoGrantPermissions1) {

	

		// INSTANCIAR GENERAR REPORTE
		generarReportePdf = new GenerarReportePdf();


		// INSTANCIAR VARIABLES DE IMAGEN
		rutaMercadolibre = rutaImagenReporte;
		rutaTools = rutaImagenReporteTQA;
		rutaCalculadora = rutaImagenReporteMT;
		platformName = platformName1;
		deviceName = deviceName1;
		platformVersion = platformVersion1;
		noReset = noReset1;
		autoGrantPermissions = autoGrantPermissions1;

	}

	@DataProvider(name = "calculadora")
	public Object[][] datos() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba1.xlsx", "calculadora");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Test(dataProvider = "calculadora", priority = 1)
	public void calculadora(String ejecutar, String num1, String num2, String condicion, String appPackage,
			String appActivity, String generarEvidencia) throws Exception {

		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnection(platformName, deviceName, platformVersion, appPackage,
					appActivity, noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);

			// INSTANCIAR LA CLASE HOME TOOLSQA
			calculadora = new PagObjetCalculadoraProcedimientos(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			if (generarEvidencia.equals("Si")) {
				
				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaCalculadora);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				calculadora.calculadora( rutaCarpeta, nomTest, num1, condicion,num2, generarEvidencia);
				
				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
				calculadora.calculadora( rutaCarpeta, nomTest, num1, condicion,num2, generarEvidencia);
			}
		} else {
			System.out.println("El test no se ejecutara");
		}

	}
	
	@DataProvider(name = "mercadolibre")
	public Object[][] datosMercadolibre() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/prueba1.xlsx", "mercadolibre");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "mercadolibre", priority = 2)
	public void testMercadolibre(String ejecutar,String appPackage, String appActivity,String url,
			String producto,String nombre,String apellido,String documento, String email,String clave,String generarEvidencia) throws InterruptedException, Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnection(platformName, deviceName, platformVersion, appPackage,
					appActivity, noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);

			//INSTANCIAR CREAR NUEVA PESTAÑA DE GOOGLE
			google= new PagObjectGoogle(driver);
			
			// INSTANCIAR LA PAGINA DE INICIO DE MERCADOLIBRE
			 homeMercadolibre = new PagObjetHomeMercadolibre(driver);
			 
			 //INSTANCIAR CREAR CUENTA MERCADOLIBRE
			 crearCuenta= new PagObjectCrearCuentaMercadolibre(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			if (generarEvidencia.equals("Si")) {
				
				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaMercadolibre);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE MERCADOLIBRE
				homeMercadolibre.homeMercadolibre(rutaCarpeta, generarEvidencia, producto);
				
				//CREAR CUENTA EN MERCADO LIBRE
				crearCuenta.crearCuenta(rutaCarpeta, nomTest, nombre, apellido, documento, email, clave, generarEvidencia);
				
				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
				
				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE MERCADOLIBRE
				homeMercadolibre.homeMercadolibre(rutaCarpeta, generarEvidencia, producto);
				
				//CREAR CUENTA EN MERCADO LIBRE
				crearCuenta.crearCuenta(rutaCarpeta, nomTest, nombre, apellido, documento, email, clave, generarEvidencia);
				
			}
		} else {
			System.out.println("El test no se ejecutara");
		}

	}
	

	@DataProvider(name = "toolsQAAlerts")
	public Object[][] datosToolsQA() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/ToolsQA.xlsx", "alerts");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "toolsQAAlerts", priority = 3)
	public void testToolsQAAlerts(String url,String comentario,String ejecutar ,String generarEvidencia,String appPackage, String appActivity) throws InterruptedException, Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnection(platformName, deviceName, platformVersion, appPackage,
					appActivity, noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);

			//INSTANCIAR CREAR NUEVA PESTAÑA DE GOOGLE
			google= new PagObjectGoogle(driver);
			
			// INSTANCIAR LA PAGINA DE INICIO DE MERCADOLIBRE
			 homeTools = new PagObjetHomeToolsQA(driver);
			 
			 //INSTANCIAR CREAR CUENTA MERCADOLIBRE
			 alerts= new PagObjetAlerts(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			if (generarEvidencia.equals("Si")) {
				
				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaTools);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE TOOLS QA
				homeTools.homeToolsQAAlerts(rutaCarpeta, nomTest, generarEvidencia);
				
				//INGRESAR A WIDGEST DE TOOLS QA
				alerts.alerts(comentario, rutaCarpeta, generarEvidencia);
				
				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
				
				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE TOOLS QA
				homeTools.homeToolsQAAlerts(rutaCarpeta, nomTest, generarEvidencia);
				
				//INGRESAR A WIDGEST DE TOOLS QA
				alerts.alerts(comentario, rutaCarpeta, generarEvidencia);
				
			}
		} else {
			System.out.println("El test no se ejecutara");
		}
	}
	@DataProvider(name = "toolsQAWidgest")
	public Object[][] datosToolsQAw() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/ToolsQA.xlsx", "widgest");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	@Test(dataProvider = "toolsQAWidgest", priority = 4)
	public void testToolsQAwidgest(String url,String selecDate,String dateTime,String ejecutar ,String generarEvidencia,String appPackage, String appActivity) throws InterruptedException, Exception {
		
		if (ejecutar.equals("Si")) {
			driver = ClaseBase.appiumDriverConnection(platformName, deviceName, platformVersion, appPackage,
					appActivity, noReset, autoGrantPermissions);
			claseBase = new ClaseBase(driver);

			//INSTANCIAR CREAR NUEVA PESTAÑA DE GOOGLE
			google= new PagObjectGoogle(driver);
			
			// INSTANCIAR LA PAGINA DE INICIO DE MERCADOLIBRE
			 homeTools = new PagObjetHomeToolsQA(driver);
			 
			 //INSTANCIAR CREAR CUENTA MERCADOLIBRE
			 widgest= new PagObjetWidgest(driver);
			// OBTENER EL NOMBRE DEL METODO A EJECUTAR
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

			// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
			File rutaCarpeta = claseBase.crearCarpeta(nomTest);
			
			if (generarEvidencia.equals("Si")) {
				
				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaTools);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE TOOLS QA
				homeTools.homeToolsQAWidgest(rutaCarpeta, nomTest, generarEvidencia);
				
				//INGRESAR A ALERTAS DE TOOLS QA
				widgest.widgest(rutaCarpeta, generarEvidencia, selecDate, dateTime);
				
				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
				
				//ABRIR UNA NUEVA PESTAÑA DE CHROME
				google.buscador(rutaCarpeta, nomTest, generarEvidencia, url);
				
				//ENTRAR AL HOME DE TOOLS QA
				homeTools.homeToolsQAWidgest(rutaCarpeta, nomTest, generarEvidencia);
				
				//INGRESAR A ALERTAS DE TOOLS QA
				widgest.widgest(rutaCarpeta, generarEvidencia, selecDate, dateTime);
				
			}
		} else {
			System.out.println("El test no se ejecutara");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
