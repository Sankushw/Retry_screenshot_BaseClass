package BasicGoogleTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class Base {

	static Properties prop;
	static public WebDriver driver=null;

	public static void Initialize() throws IOException{

		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config.properties");
		prop.load(ip);

		if(prop.getProperty("browser").equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"\\geckodriver.exe");
			FirefoxOptions options=new FirefoxOptions();
			options.setHeadless(true);
			driver=new FirefoxDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
	}
}
