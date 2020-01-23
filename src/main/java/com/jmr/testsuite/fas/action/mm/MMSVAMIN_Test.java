package com.jmr.testsuite.fas.action.mm;

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

import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.mm.MMSVAMIN_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class MMSVAMIN_Test extends AbstractTestNGSpringContextTests{

	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "MMSVAMIN";
	private final String screenName="Money Market Value Dated Changes Input Summary";

	private List<MMSVAMIN_Page> dataList;
	private List<MMSVAMIN_Page> resultList;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList = fcubs.loadDataFromExcel(MMSVAMIN_Page.class, screenId);
		resultList = new ArrayList<>();

	}

	@Test()
		
		public void executeTestCase() throws Exception {
			
			for (MMSVAMIN_Page data : dataList) {
				try {
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					
					fcubs.populateTextById("BLK_SUMMARY__CONTRACT_REF_NO", data.getContractreferencenumber());
					fcubs.selectDropdownByText("BLK_SUMMARY__TXTASTAT", data.getAuthorizestatus());
					fcubs.selectDropdownByText("BLK_SUMMARY__TXTCSTAT", data.getContractstatus());
					
					fcubs.populateTextById("BLK_SUMMARY__UREF", data.getUserreference());
					fcubs.populateTextById("BLK_SUMMARY__PRD", data.getProduct());
					fcubs.populateTextById("BLK_SUMMARY__CPTY", data.getCounterparty());
					fcubs.populateTextById("BLK_SUMMARY__CCY", data.getCurrency());
					fcubs.populateTextById("BLK_SUMMARY__AMTI", data.getAmount());

					fcubs.populateTextById("BLK_SUMMARY__BOOKDTI", data.getBookingdate());
					fcubs.populateTextById("BLK_SUMMARY__MATDTI", data.getMaturitydate());
					fcubs.populateTextById("BLK_SUMMARY__VALDTI", data.getValuedate());

	
					fcubs.clickSearchButton();
					
					try {
					fcubs.clickButtonByXpath("//div[@id='QryRslts']//tr[1]//td[1]//div[1]//label[1]//div[1]");
					fcubs.clickdetail();
					}
					catch(Exception ex) {
						System.out.println("No record to select");
					}

					try {
					fcubs.closeInfoPopUp();
					}
					catch (Exception ex){
						System.out.println("Record exists");
					}
				
					try {
						errorMsg = fcubs.getAllErrorMsgAndClose(data.getTestCaseId());
						System.out.println("Error Message  " + errorMsg);
						data.setTestCaseResult(errorMsg);
						if (fcubs.validInput(errorMsg)) {
							resultList.add(data);
							continue;
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					//fcubs.closeOverridePopUp();
					data.setTestCaseResult("SUCCESS");
					resultList.add(data);
					// on successful save action confirm and close window for next test case
				//	fcubs.closeInfoPopUp();
				//	fcubs.closeScreen();

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
				resultList.add(data);
				// to update the status as failed
				// fcubs.updateTestCaseExecutionAsFailed();
			}

		}

	}
	
	@AfterClass
	public void destroy() throws Exception {
		System.out.println("before destroying opened session");
		//fcubs.destroy();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		System.out.println("inside after method");
		if (!result.isSuccess()) {
			fcubs.takeScreenShot("UNHANDLED_EXCEPTION_" + testCaseId);
		}
		System.out.println("Test Case Id\tResult");
		for (MMSVAMIN_Page data : resultList) {
			System.out.println(data.getTestCaseId() + "\t" + data.getTestCaseResult().replace("\n", ";"));
		}
	}


}
