package com.jmr.testsuite.fas.action.cl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToFrame;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jmr.testsuite.fas.AppConfig;
import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.cl.CLDACSTC_Page;
import com.jmr.testsuite.fas.page.common.ScreenShotUtil;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class CLDACSTCTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "CLDACSTC";
	private final String screenName = "Account Details";

	private List<CLDACSTC_Page> dataList1;
	private List<CLDACSTC_Page> resultList1;
	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList1 = fcubs.loadDataFromExcel(CLDACSTC_Page.class, screenId);
		resultList1 = new ArrayList<>();

	}

	@Test()
	public void executeTestCase() throws Exception {

		for (CLDACSTC_Page data : dataList1) {
			try {
				this.testCaseId = data.getTestCaseId();
				System.out.println("Executing Test Case ====>" + this.testCaseId);
				fcubs.setTestCaseId(testCaseId);
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					
					fcubs.clickEnterQuery();					
					fcubs.populateTextById("BLK_ACC_MASTER__ACCNO", data.getAccountnumber());				// Account Number		
					fcubs.clickExecuteQuery();
					
					
					
					
					
					try {
						errorMsg = fcubs.getAllErrorMsgAndClose(data.getTestCaseId());
						System.out.println("Error Message  " + errorMsg);
						data.setTestCaseResult(errorMsg);
						if (fcubs.validInput(errorMsg)) {
							resultList1.add(data);
							continue;
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					//fcubs.closeOverridePopUp();
					data.setTestCaseResult("SUCCESS");
					resultList1.add(data);
					// on successful save action confirm and close window for next test case
					/*fcubs.closeInfoPopUp();
					fcubs.closeScreen();*/

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
				resultList1.add(data);
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
			for(CLDACSTC_Page data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}


}
