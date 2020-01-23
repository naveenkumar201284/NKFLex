package com.jmr.testsuite.fas.action.st;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.jmr.testsuite.fas.AppConfig;
import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.st.CustomerReport_STRCUSRPpage;
import com.jmr.testsuite.fas.page.st.STDACSTC_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class STRCUSRP_Test extends AbstractTestNGSpringContextTests{
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "STRCUSRP";
	private final String screenName = "Bill Payment Query";

	private List<CustomerReport_STRCUSRPpage> dataList1;
	private List<CustomerReport_STRCUSRPpage> resultList1;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		dataList1 = fcubs.loadDataFromExcel(CustomerReport_STRCUSRPpage.class, screenId);
		resultList1 = new ArrayList<>();
		
	}
	
	@Test()
	public void executeTestCase() throws Exception {

		
		for (CustomerReport_STRCUSRPpage data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				fcubs.launchScreen(screenId);
				
				fcubs.populateTextById("BLK_CSTB_UI_COLUMNS__PM_CUSTNUM", data.getAccountnumber());
				fcubs.clickButtonById("BTN_OK");
				fcubs.closeScreen();
				fcubs.closeConfirmaPopUp();
				
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
			//	fcubs.closeInfoPopUp();
				fcubs.closeScreen();

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
		for(CustomerReport_STRCUSRPpage data:resultList1) {
			System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
		}
	}


}
