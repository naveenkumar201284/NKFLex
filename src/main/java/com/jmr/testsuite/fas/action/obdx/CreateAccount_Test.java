package com.jmr.testsuite.fas.action.obdx;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.jmr.testsuite.fas.FlexcubeData;
import com.jmr.testsuite.fas.SpringConfigurationObdx;
import com.jmr.testsuite.fas.page.obdx.CreateAccount_Page;

import io.github.millij.poi.ss.reader.XlsxReader;


@ContextConfiguration(classes = SpringConfigurationObdx.class)

public class CreateAccount_Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeData fcubs;
	

	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";
	private WebDriver driver;

	private final String screenId = "Transfer Money";

	private List<CreateAccount_Page> dataList1;
	private List<CreateAccount_Page> resultList1;

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.launchApp();
		dataList1 = fcubs.loadDataFromExcel(CreateAccount_Page.class, screenId);
		resultList1 = new ArrayList<>();

	}
	
	@Test()
	public void executeTestCase() throws Exception {
		
		for (CreateAccount_Page data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				//fcubs.launchScreen("//div[contains(text(),'Transfer Money')]");
				fcubs.openMenu("Accounts>Current and Savings>View Statement");

				fcubs.selectRadioBtn("//span[contains(text(),'Existing Payee')]",data.getTransfertype());
				fcubs.selectRadioBtn("//span[contains(text(),'New Payee')]",data.getTransfertype());
				fcubs.selectRadioBtn("//span[contains(text(),'My Accounts')]",data.getTransfertype());
				
				
				fcubs.clickButtonByXpath("//span[contains(text(),'Please Select')]");

				try {
					fcubs.clickButtonByXpath("//label[contains(text(),'Payee')]//following::li[1]");
				}catch(Exception e){}
				
				
				
			try {
					errorMsg = fcubs.getAllErrorMsgAndClose(data.getTestCaseId());
					System.out.println("Error Message  " + errorMsg);
					data.setTestCaseResult(errorMsg);
					if (fcubs.validInput(errorMsg)) {
						//resultList1.add(data);
						continue;
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				//fcubs.closeOverridePopUp();
				data.setTestCaseResult("SUCCESS");
				//resultList1.add(data);
				// on successful save action confirm and close window for next test case
				//fcubs.closeInfoPopUp();
				//fcubs.closeScreen();

				data.setTestCaseResult("SUCCESS");
			}
		} catch (Exception ex) {
			errorMsg = fcubs.checkUIFormatError();
			if (fcubs.validInput(errorMsg)) {
				data.setTestCaseResult(errorMsg);
			} else if (fcubs.validInput(ex.getMessage())) {
				data.setTestCaseResult(ex.getMessage());
			}
			ex.printStackTrace();
		//	resultList1.add(data);
			// to update the status as failed
			// fcubs.updateTestCaseExecutionAsFailed();
		}

	}

}


		@AfterClass
		public void destroy() throws Exception {
			System.out.println("before destroying opened session");
			
			fcubs.destroy();
		}
		
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			System.out.println("inside after method");
			if (!result.isSuccess()) {
				fcubs.takeScreenShot("UNHANDLED_EXCEPTION_" + testCaseId);
			}
			System.out.println("Test Case Id\tResult");
			//for(CreateAccount_Page data:resultList1) {
				//System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			//}
		}

}
