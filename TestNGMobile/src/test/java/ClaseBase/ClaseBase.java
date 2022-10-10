package ClaseBase;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.itextpdf.text.DocumentException;

import Utilidades.GenerarReportePdf;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class ClaseBase {
@SuppressWarnings("rawtypes")
protected  AppiumDriver driver;
	
    //CONSTRUCTOR DE LA CLASE 
	public ClaseBase(AppiumDriver<MobileElement> driver) {
		super();
	}
	// METODO DE NAVEGADOR
	@SuppressWarnings("rawtypes")
	public static AppiumDriver appiumDriverConnection(String platformName,String deviceName, String platformVersion, String appPackage,
			String appActivity, String noReset,String autoGrantPermissions) {
		
		AppiumDriver driver = null;
		try {
			DesiredCapabilities caps= new DesiredCapabilities ();
			caps.setCapability("platformName",platformName);
			caps.setCapability("deviceName",deviceName);
			caps.setCapability("platformVersion",platformVersion);
			caps.setCapability("appPackage",appPackage);
			caps.setCapability("appActivity",appActivity);
			caps.setCapability("noReset",noReset);
			caps.setCapability("autoGrantPermissions",autoGrantPermissions);
			
			//INSTANCIAR APPIUM DRIVER
			 try {
				System.out.println("cargandocapabiliy de appium, por favor esperar ...");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		return driver;
		} catch (Exception e) {
			System.out.println(e);
		}
		return driver;
	}
	// METODO CLICK
		public void click(By locator, File rutaCarpeta, String generarEvidencia , String mensaje) throws Exception {
			try {
				captureScreen(rutaCarpeta, locator, generarEvidencia,mensaje);
				driver.findElement(locator).click();
				tiempoEspera(2000);
				
			} catch (Exception e) {
				captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
				//throw new InterruptedException();
			}
		}

		// METODO BORRAR
		public void borrar(By locator, File rutaCarpeta, String generarEvidencia,String mensaje) throws Exception {
			try {
				driver.findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				// driver.findElement(locator).clear();
				captureScreen(rutaCarpeta, locator, generarEvidencia, mensaje);
			} catch (Exception e) {
				captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
				//throw new InterruptedException();
			}
		}

		// METODO ENVIAR TEXTO
		public void sendkey(String inputText, By locator, File rutaCarpeta, String generarEvidencia,String mensaje)
				throws Exception {
		try {
			driver.findElement(locator).sendKeys(inputText);
			captureScreen(rutaCarpeta, locator, generarEvidencia,mensaje);
		} catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, generarEvidencia, e.toString());
			//throw new InterruptedException();
		}
		}

		// METODO ENTER SUBMIN
		public void submit(By locator, File rutaCarpeta, String generarEvidencia,String mensaje) throws IOException, DocumentException {
			driver.findElement(locator).submit();
			captureScreen(rutaCarpeta, locator, generarEvidencia,mensaje);
		}

		// METODO TIEMPO DE ESPERA
		public void tiempoEspera(long tiempo) throws InterruptedException {
			Thread.sleep(tiempo);
		}

		// METODO FECHA HORA
		public static String fechaHora() {

			// TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();

			// DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");

			// DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}

		// METODO FECHA HORA 2
		public static String fechaHora2() {

			// TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();

			// DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			// DAR FORMATO A LA FECHA DEL SISTEMA
			String formatFecha = fecha.format(fechaSistema);
			return formatFecha;
		}

		// METODO ELIMINAR ARCHIVO
		public void eliminarArchivo(String rutaImagen) {

			File fichero = new File(rutaImagen);
			fichero.delete();
		}

		// METODO CAPTURAR PANTALLA
		public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia, String mensaje)
				throws IOException, DocumentException {

			if (generarEvidencia.equals("Si")) {
				String hora = HoraSistema();
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcFile, new File(rutaCarpeta + "\\" + hora + ".png"));
				String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

				// INSTANCIAMOS LA CLASE GENERAR PDF
				GenerarReportePdf informePdf = new GenerarReportePdf();

				// INSERTAR LOCALIZADOR DE IMAGEN EN EL PDF
				informePdf.crearBody(locator, rutaImagen, mensaje);

				// ELIMINAR IMAGEN CREADA
				eliminarArchivo(rutaImagen);
			}

		}

		// METODO ERROR AL CAPTURAR PANTALLA
		public void captureScreenError(File rutaCarpeta, By locator, String generarEvidencia, String msnError)
				throws Exception {
			if (generarEvidencia.equals("Si")) {
				String hora = HoraSistema();
				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
				String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

				// INSTACIAMOS LA CLASE GENERAR PDF
				GenerarReportePdf informePdf = new GenerarReportePdf();
				// SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
				informePdf.crearbodyError(locator, rutaImagen, msnError);
				// ELIMINAR IMAGEN CREADA

				eliminarArchivo(rutaImagen);
			}
		}

		// METODO HORA DEL SISTEMA
		public String HoraSistema() {

			// TOMAMOS LA FECHA DEL SISTEMA
			LocalTime horaSistema = LocalTime.now();

			// DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

			// DAR FORMATO A LA FECHA DEL SISTEMA
			String hora = fecha.format(horaSistema);
			return hora;
		}
/*
		public void captureScreen(File rutaCarpeta) throws IOException {

			String hora = HoraSistema();
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File(rutaCarpeta + "\\" + hora + ".png"));
		}
*/
		public File crearCarpeta(String nomTest) {

			// ALMACENAMOS LA FECHA DEL SISTEMA
			String fecha = fechaHora();

			// CREAMOS EL NOMBRE DE LA CARPETA
			String nomCarpeta = nomTest + "-" + fecha;

			// OBTENEMOS LA RUTA DE ALOJAMMIENTO DE SALIDA Y EL NOMBRE DEL TEST A EJECUTAR
			File directorio = new File("./output/" + nomCarpeta);

			// CREAMOS LA CARPETA
			directorio.mkdir();
			return directorio;

		}

		//METODO LISTA DE ELEMENTOS
		@SuppressWarnings("unchecked")
		public List<MobileElement> listaElementos(By locator) throws Exception
	    {
	      
	        List<MobileElement> elemento=driver.findElements(locator);
	        return elemento;
	        
	    }

		// METODO HORA DEL SISTEMA
		public String fechaSistema() {

			// TOMAMOS LA FECHA DEL SISTEMA
			LocalDateTime fechaSistema = LocalDateTime.now();

			// DEFINIR FORMATO FECHA
			DateTimeFormatter fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// DAR FORMATO A LA FECHA DEL SISTEMA
			String formatfecha = fecha.format(fechaSistema);
			return formatfecha;
		}
	
	//LOCALIZADOR VARIABLE
		public By localizadorVariable(By locator,String valor) {
			
			String jj = locator.toString().replace("{0}", valor);
			String kk = jj.replace("By.xpath:", "");
			By localizador=By.xpath(kk);
			return localizador;	
		}
		//METODO PARA INGRESAR NUMEROS GRANDES EN LA CALCULADORA
		public void variosNumeros(String nomTest,String numeros, By locator,File runCarpeta,String generarEvidencia)throws Exception
		{
			
			String[] num =new String[numeros.length()] ;
			
			for (int i=0; i<numeros.length(); i++) {
				num[i]=String.valueOf(numeros.charAt(i));
				click(localizadorVariable(locator, num[i]),runCarpeta,generarEvidencia,"se ingresan los numeros");
			}
		
		}
		
		 public void tocarPantalla(int x, int y) 
		    {
		     @SuppressWarnings("rawtypes")
		     TouchAction touch = new TouchAction(driver);
		     touch.press(PointOption.point(x,y)).release().perform();
		        
		    }
		 
		   public void scrollVertical(File rutaCarpeta, int xini,int yini, int yfinal, int iteraciones) throws Exception
		    {
		        
		        for (int i = 1 ;i<=iteraciones;i++)
		        {
		            @SuppressWarnings("rawtypes")
		            TouchAction touch = new TouchAction(driver);
		            touch.press(PointOption.point(xini,yini))
		            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		            .moveTo(PointOption.point(xini,yfinal))
		            .release().perform();
		          
		        }
		   
		    }
		 @SuppressWarnings("unchecked")
		public void enter(File rutaCarpeta)throws Exception
	     {
	         @SuppressWarnings("unused")
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
	         ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	         tiempoEspera(2000);
	     }
}
