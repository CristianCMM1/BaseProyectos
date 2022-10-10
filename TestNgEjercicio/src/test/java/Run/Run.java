package Run;

import org.testng.annotations.Test;

import ClaseBase.ClasesBase;
import PagsObjets.PagObjetAlertsToolsQA;
import PagsObjets.PagObjetCrearCuenta;
import PagsObjets.PagObjetHomeMercury;
import PagsObjets.PagObjetHomeToolsQA;
import PagsObjets.PagObjetRegistroMercury;
import PagsObjets.PageObjecInicio;
import PagsObjets.PageObjectWindgestToolsQA;
import Utilidades.ExcelUtilidades;
import Utilidades.GenerarReportePdf;
import Utilidades.MyScreenRecorder;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Run {
	PageObjecInicio inicioMercadoLibre;
	ClasesBase claseBase;
	WebDriver driver;
	PagObjetCrearCuenta crearCuenta;
	GenerarReportePdf generarReportePdf;
	PagObjetHomeToolsQA homeToolsQA;
	PagObjetAlertsToolsQA alertaToolsQA;
	PageObjectWindgestToolsQA widgestToolsQA;
	PagObjetHomeMercury homeMercury;
	PagObjetRegistroMercury registroMercury;

	String rutaMercadolibre;
	String rutaTools;
	String rutaMercury;

	@BeforeClass
	@Parameters({ "rutaImagenReporte", "rutaImagenReporteTQA","rutaImagenReporteMT" })
	public void beforeClass(@Optional("default") String rutaImagenReporte,
			@Optional("default") String rutaImagenReporteTQA,
			@Optional("default") String rutaImagenReporteMT) {

		// ASIGNAMOS LAS OPCIONES Y LA CONFIGURACION DEL NAVEGADOR A LA VARIABLE DRIVER
		driver = ClasesBase.chomeDriverConnection();

		// INSTANCIAR CLASE BASE
		claseBase = new ClasesBase(driver);

		// INSTANCIAR LA PAGINA DE INICIO DE MERCADOLIBRE
		inicioMercadoLibre = new PageObjecInicio(driver);

		// INSTANCIAR LA PAGINA CREAR CUENTA EN MERCADOLIBRE
		crearCuenta = new PagObjetCrearCuenta(driver);

		// INSTANCIAR GENERAR REPORTE
		generarReportePdf = new GenerarReportePdf();

		// INSTANCIAR EL HOME DE TOOLSQA
		homeToolsQA = new PagObjetHomeToolsQA(driver);

		// INSTANCIAR ALERTS DE TOOLSQA
		alertaToolsQA = new PagObjetAlertsToolsQA(driver);

		// INSTANCIAR WIDGEST DE TOOLSQA
		widgestToolsQA = new PageObjectWindgestToolsQA(driver);

		// INSTANCIAR EL HOME DE MERCURT TOURS
		homeMercury = new PagObjetHomeMercury(driver);

		// INSTANCIAR EL REGISTRO DE MERCURY
		registroMercury = new PagObjetRegistroMercury(driver);

		// INSTANCIAR VARIABLES DE IMAGEN
		rutaMercadolibre = rutaImagenReporte;
		rutaTools = rutaImagenReporteTQA;
		rutaMercury= rutaImagenReporteMT;
	}

	@DataProvider(name = "busqueda")
	public Object[][] datos() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/pruebaTestNg.xlsx", "homeMercadolibre");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Test(dataProvider = "busqueda", priority = 2)

	public void pruebaInicialTestNG(String producto, String correo, String url, String generarEvidencia,
			String ejecutar) throws Exception {

		if (ejecutar.equals("Si")) {
			if (generarEvidencia.equals("Si")) {
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaMercadolibre);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER A LA URL DE MERCADOLIBRE
				inicioMercadoLibre.urlAcceso(url);

				// INGRESAR EL TIPO DE PRODUCTO A BUSCAR
				inicioMercadoLibre.busquedaInicial(producto, rutaCarpeta, generarEvidencia);

				// CREAR UNA CUENTA EN MERCADOLIBRE
				crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);

				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");

			}

		} else {
			System.out.println("El test no se ejecutara");
		}
	}

	@DataProvider(name = "crearCuenta")
	public Object[][] datoscrarCuenta() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/pruebaTestNg.xlsx", "crearcuenta");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Test(dataProvider = "crearCuenta", priority = 4)

	public void pruebaInicialTestNG2(String url, String correo, String generarEvidencia, String ejecutar)
			throws Exception {

		if (ejecutar.equals("Si")) {
			if (generarEvidencia.equals("Si")) {
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaMercadolibre);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER A LA URL DE MERCADOLIBRE
				inicioMercadoLibre.urlAcceso(url);

				// INGRESAR EL TIPO DE PRODUCTO A BUSCAR
				inicioMercadoLibre.linkCrearCuenta(rutaCarpeta, generarEvidencia);

				// CREAR UNA CUENTA EN MERCADOLIBRE
				crearCuenta.crearCuenta(correo, rutaCarpeta, generarEvidencia);

				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
			}
		} else {
			System.out.println("El test no se ejecutara");
		}
	}

	@DataProvider(name = "toolsQAAl")
	public Object[][] datos1() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/ToolsQA.xlsx", "toolsqaAl");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Test(dataProvider = "toolsQAAl", priority = 1)

	public void testToolsQAAlerts(String url, String generarEvidencia, String ejecutar, String prueba)
			throws Exception {

		if (ejecutar.equals("Si")) {
			if (generarEvidencia.equals("Si")) {
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);

				// INSTANCIAR LA RUTA DE LA IMAGEN
				generarReportePdf.setRutaImagen(rutaTools);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER A LA URL DE TOOLSQA
				homeToolsQA.urlAcceso(url);

				// CREAR UNA CUENTA EN MERCADOLIBRE
				homeToolsQA.homeAlertsToolsQA(rutaCarpeta, generarEvidencia);

				// INGRESAR A ALERTAS
				alertaToolsQA.alertasToolsQA(rutaCarpeta, generarEvidencia, prueba);

				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
			}
		} else {
			System.out.println("El test no se ejecutara");
		}

	}

	@DataProvider(name = "toolsQAWi")
	public Object[][] datos2() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/ToolsQA.xlsx", "toolsqaWi");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Test(dataProvider = "toolsQAWi", priority = 3)

	public void testToolsQAWidgest(String url, String generarEvidencia, String ejecutar) throws Exception {

		if (ejecutar.equals("Si")) {
			if (generarEvidencia.equals("Si")) {
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);

				generarReportePdf.setRutaImagen(rutaTools);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER A LA URL DE TOOLSQA
				homeToolsQA.urlAcceso(url);

				// CREAR UNA CUENTA EN MERCADOLIBRE
				homeToolsQA.homeWidgetsToolsQA(rutaCarpeta, generarEvidencia);

				// INGRESAR A ALERTAS
				widgestToolsQA.widgestToolsQAOptimizado(rutaCarpeta, generarEvidencia);

				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();

			} else {
				System.out.println("no se tomara capture");
			}

		} else {
			System.out.println("El test no se ejecutara");
		}

	}
	
	@DataProvider(name = "mercury")
	public Object[][] datos3() throws Exception {
		try {
			Object[][] arreglo = ExcelUtilidades.getTableArray("./Data/mercury.xlsx", "mercury");
			return arreglo;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Test(dataProvider = "mercury", priority = 5)

	public void testmercury(String url, String firstName, String lastName, String phone, String email, String address,
			String city, String state, String postalCode, String country, String usserName, String password,
			String confirmPassword, String ejecutar, String generarEvidencia) throws Exception {

		if (ejecutar.equals("Si")) {
			if (generarEvidencia.equals("Si")) {
				// OBTENER EL NOMBRE DEL METODO A EJECUTAR
				String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

				// CREAR CARPETA PARA ALMACENAMIENTO DE IMAGENES
				File rutaCarpeta = claseBase.crearCarpeta(nomTest);

				generarReportePdf.setRutaImagen(rutaMercury);

				// INICIA GRABACION DE VIDEO
				MyScreenRecorder.starRecording(nomTest, rutaCarpeta);

				// GENERAR PDF
				generarReportePdf.crearPlantilla(nomTest, rutaCarpeta);

				// ACCEDER A LA URL DE MERCURY
				homeMercury.urlAcceso(url);

				// HOME MERCURY
				homeMercury.linkRegristro(rutaCarpeta, generarEvidencia);

				// INGRESAR A REGISTRO
				registroMercury.registrarseMercury(rutaCarpeta, generarEvidencia, firstName, lastName,
						phone, email, address, city,state, postalCode, country, usserName, 
						password, confirmPassword);
				
				assertEquals(confirmPassword, "123456miloo");
				System.out.println("password igual Assert pased");

				// DETENER LA GRABACION
				MyScreenRecorder.StopRecording();

				// CERRAR EL PDF
				generarReportePdf.cerrarPlantilla();
			} else {
				System.out.println("no se tomara capture");
			}
		} else {
			System.out.println("El test no se ejecutara");
		}

	}
	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}
