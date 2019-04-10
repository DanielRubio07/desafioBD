package com.applause.auto.pageframework.pages;

import java.lang.invoke.MethodHandles;

import com.applause.auto.framework.pageframework.util.logger.LogController;
import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Button;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(ActivityProductMainPage.class)
@WebTabletImplementation(ActivityProductMainPage.class)
@WebPhoneImplementation(ActivityProductMainPage.class)

public class ActivityProductMainPage extends AbstractPage {
	protected final static LogController LOGGER = new LogController(MethodHandles.lookup().getClass());

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getFiltreTitle());
	}

	/*
	 * Public Actions
	 */
	/**
	 * Returns the URL with String format
	 */
	public String GetURL() {
		return getDriver().getCurrentUrl();
	}

	/**
	 * Taps the search button and expects to land at Search Results Page
	 * 
	 * @return a SearchResultsPage
	 */
	/*
	 * Protected Getters
	 */

	@WebElementLocator(webDesktop = "//i[@text()='Add'and @class='material-icons']")
	protected Button getAddActivitiButton() {
		return new Button(this, getLocator(this, "getAddActivitiButton"));
	}

	@WebElementLocator(webDesktop = "//p[@class='titulo-filtro']")
	protected Text getFiltreTitle() {
		return new Text(this, getLocator(this, "getFiltreTitle"));
	}

	/*
	 * Private Helpers
	 */
}

/**
 * Desktop Implementation for LandingPage
 */
class DesktopActivityProductMainPage extends ActivityProductMainPage {

}

/**
 * Tablet Implementation for LandingPage
 */
class TabletActivityProductMainPage extends ActivityProductMainPage {
}

/**
 * Phone Implementation for LandingPage
 */
class PhoneActivityProductMainPage extends ActivityProductMainPage {

}