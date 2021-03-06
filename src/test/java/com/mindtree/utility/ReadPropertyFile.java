package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertyFile {
	static Properties prop;
	public static WebDriver driver;

	public ReadPropertyFile() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("./testdata/config.properties");
		prop.load(fis);

	}

	public WebDriver getBrowser() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromeDriver"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("disable-popup-blocking");
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);

		} else if (browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxDriver"));
			driver = new FirefoxDriver();

		} else if (browserName.equals("edge")) {

			System.setProperty("webdriver.edge.driver", prop.getProperty("EdgeDriver"));
			driver = new EdgeDriver();

		}

		return driver;
	}

	public String getUrl() {
		String url = prop.getProperty("url");
		return url;

	}

	public String getExtentReportPath() {
		String extentReportPath = prop.getProperty("ExtentReportPath");

		return extentReportPath;

	}
}
