package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.TaskListPage;

@Listeners(com.actitime.generic.ListenerImplimentation.class)
public class CoustomerModule extends BaseClass{
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException {
		
		String customerName = f.getExcelData("CoustomerModule",2,2);
		String customerDescription = f.getExcelData("customerName",2,3);
		Reporter.log("CreateCustomer",true);
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setTaskTab();
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustOptions().click();
		t.getEnterCustNameTbx().sendKeys(customerName);
		t.getEnterCustDescTbx().sendKeys(customerDescription);
		t.getSelectCustDD().click();
		t.getOurCompany().click();
		t.getCreateCustBtn().click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElement(t.getActualCustomer(), customerName));
		String actualCustText = t.getActualCustomer().getText();
		Assert.assertEquals(actualCustText, customerName);
	}
	}

	/*
	@Test(priority = 1,invocationCount = 2)
	public void EditCustomer() {
		Reporter.log("EditCustomer",true);
	}
	@Test()
	public void RegisterCustomer() {
		Reporter.log("RegisterCustomer",true);
	}
	@Test()
	public void deleteCustomer() {
		Reporter.log("deleteCustomer",true);
	}*/
	
