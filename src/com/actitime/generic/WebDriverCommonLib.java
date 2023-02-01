package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	/**
	 * Generic method for Implicit wait
	 * @param driver
	 */
		public void waitForPageLoadImplicit(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		/**
		 * Generic method for Explicit wait
		 * @param driver
		 * @param title
		 */
		public void waitForPageLoadExplicit(WebDriver driver,String title) {
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.titleIs(title));
		}
		/**
		 * Generic method for Custom wait
		 * @param element
		 */
		public void customWaitForElementDisplayed(WebElement element) {
			int i=0;
			while(i<100) {
				try {
					element.isDisplayed();
					break;
				}
				catch(Exception e) {
					i++;
				}
			}
		}
		/**
		 * Generic method for select the options from listbox using index
		 * @param element
		 * @param i
		 */
		public void selectValue(WebElement element,int i) {
			Select s=new Select(element);
			s.selectByIndex(i);
		}
		/**
		 * Generic method for select the options from listbox using visible text
		 * @param element
		 * @param text
		 */
		public void selectValue(WebElement element,String text) {
			Select s=new Select(element);
			s.selectByVisibleText(text);
		}
}
