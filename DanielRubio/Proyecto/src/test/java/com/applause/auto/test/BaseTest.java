package com.applause.auto.test;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.applause.auto.framework.pageframework.util.drivers.DriverWrapper;
import com.applause.auto.framework.pageframework.util.drivers.DriverWrapperManager;
import com.applause.auto.framework.pageframework.util.environment.EnvironmentUtil;
import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.util.queryhelpers.WebElementQueryHelper;
import com.applause.auto.framework.pageframework.util.synchronization.WebSyncHelper;
import com.applause.auto.framework.pageframework.web.PageFactory;
import com.applause.auto.framework.test.listeners.TestListener;
import com.applause.auto.pageframework.Chunks.LoginChunk;
import com.applause.auto.pageframework.pages.HomePage;
import com.applause.auto.pageframework.testdata.CustomerConfig;
import com.applause.auto.pageframework.testdata.TestConstants.TestData;

@Listeners(TestListener.class)
public class BaseTest {

	protected static final LogController LOGGER;

	@SuppressWarnings("unused")
	private static CustomerConfig config;

	protected static DriverWrapper driverWrapper;
	protected static WebDriver driver;
	protected static WebSyncHelper syncHelper;
	protected static WebElementQueryHelper queryHelper;
	protected static EnvironmentUtil env;

	static {
		config = new CustomerConfig();
		env = EnvironmentUtil.getInstance();
		LOGGER = new LogController(MethodHandles.lookup().lookupClass());
	}

	/**
	 * Get a new WebDriver at the start of each test.
	 */
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		String runId = String.format("%s:%s", method.getName(), System.currentTimeMillis());
		LOGGER.debug(String.format("Setting runId to %s", runId));
		System.setProperty("runId", runId);
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");

		driverWrapper = new DriverWrapper(EnvironmentUtil.getDriver(), env.getDriverProvider());
		driver = (WebDriver) driverWrapper.getDriver();
		syncHelper = (WebSyncHelper) driverWrapper.getSyncHelper();
		queryHelper = (WebElementQueryHelper) driverWrapper.getQueryHelper();

		// Maximize the browser for desktop platforms
		if (!env.getIsMobileWebTest()) {
			driver.manage().window().maximize();
		}

		LOGGER.info("Test case setup complete.");
	}

	/**
	 * Destroy the WebDriver at the end of the test.
	 */
	@AfterMethod(alwaysRun = true)
	public void afterMethod() {
		driver.quit();
		DriverWrapperManager.getInstance().deregisterDriver(driverWrapper);
		LOGGER.info("Test case teardown complete.");
	}

	/*
	 * Platform Agnostic Test Helpers
	 */
	protected LoginChunk loginToRvbiPage() {
		driver.navigate().to(TestData.RVBI_PAGE_URL);
		return PageFactory.create(LoginChunk.class);
	}

	protected HomePage homePageRvbi() {
		return PageFactory.create(HomePage.class);
	}
}