package com.applause.auto.pageframework.Chunks;

import com.applause.auto.framework.pageframework.web.AbstractPage;
import com.applause.auto.framework.pageframework.web.WebElementLocator;
import com.applause.auto.framework.pageframework.web.factory.WebDesktopImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebPhoneImplementation;
import com.applause.auto.framework.pageframework.web.factory.WebTabletImplementation;
import com.applause.auto.framework.pageframework.webcontrols.Text;

@WebDesktopImplementation(DesktopAccountChunk.class)
@WebTabletImplementation(TabletAccountChunk.class)
@WebPhoneImplementation(MobileAccountChunk.class)

public class LoginPaymentsChunk  extends AbstractPage{

	@Override
	protected void waitUntilVisible() {
		syncHelper.waitForElementToAppear(getUsernameText());
	}
	/**
	 * Get Text of userName
	 * 
	 * @return Username text
	 */
	public String getUsernameText() {

		return getUsername().getText();
	}
	/*
	 * Protected Getters
	 */
	@WebElementLocator(webDesktop = "div > h2", webTablet = "div > h2", webMobile = "div > h2")
	protected Text getUsername() {
		return new Text(this, getLocator(this, "getUsername"));
	}
}
	/**
	 * 
	 * Desktop Implementation for LoginPayments Chunk
	 */
	class DesktopLoginPaymentsChunk extends LoginPaymentsChunk {

	}

	/**
	 * Tablet Implementation for LoginPayments chunk
	 *
	 */
	class TabletLoginPaymentsChunk extends LoginPaymentsChunk {

	}

	/**
	 * Mobile Implementation for LoginPayments Chunk
	 *
	 */
	class MobileLoginPaymentsChunk extends LoginPaymentsChunk {

	}

