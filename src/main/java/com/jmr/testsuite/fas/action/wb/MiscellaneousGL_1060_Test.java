package com.jmr.testsuite.fas.action.wb;

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

import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.wb.MiscellaneousCustCrd_1408Page;
import com.jmr.testsuite.fas.page.wb.MiscellaneousGL_1060_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class MiscellaneousGL_1060_Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";
	private WebDriver driver;

	private final String screenId = "1060";
	private final String screenName = "Miscellaneous GL Debit";

	private List<MiscellaneousGL_1060_Page> dataList1;
	private List<MiscellaneousGL_1060_Page> resultList1;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		dataList1 = fcubs.loadDataFromExcel(MiscellaneousGL_1060_Page.class, screenId);
		resultList1 = new ArrayList<>();
		
	}
	
	@Test()
	public void executeTestCase() throws Exception {
		
		for (MiscellaneousGL_1060_Page data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				fcubs.launchScreen(screenId);
			
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__UI_TXN_ACC", data.getGlccy());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNAMTI", data.getGlaccount());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETACC", data.getTransactionccy());
				fcubs.populateTextById("", data.getNarrative());
				fcubs.populateTextById("", data.getTrasnactionamount());
				fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__BTN_RECALC");
				
				
				fcubs.openChildScreenByTitle("Charge");
				Thread.sleep(2000);
				//fcubs.selectFlag("BLK_CHARGE_DETAILS__WAIVER", data.getWaiver());
				//fcubs.populateTextById("BLK_CHARGE_DETAILS__CHGAMTI", data.getChargeamount());
				fcubs.closeChildScreen();
				
				try {
				fcubs.switchToActiveFrame();
				}catch(Exception e) {
					
				}
				
				
				if (data.getSave().equalsIgnoreCase("Yes")) {
					
					fcubs.clickSave();
					try {
						fcubs.closeOverridePopUp1();
						fcubs.switchframes();
					} catch (Exception e) {
					}
					
					
					fcubs.populateTextById("BLK_TRANSACTION_DETAILS__ASSIGNTO", data.getUserid());
					fcubs.populateTextById("BLK_TRANSACTION_DETAILS__MAKREM", data.getTellerremark());
					fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__ASSIGN");
					fcubs.assignframe();
					fcubs.clickBtnOk();
					
					}	
					
			
					
					if (data.getHold().equalsIgnoreCase("Yes")) {
						
						fcubs.clickHold();
						try {
							fcubs.closeConfirmaPopUp();
							fcubs.switchframes();

							fcubs.closeInfoPopUp();
						} catch (Exception e) {
						}
						
						
						
				}	
				
				
				/*
				fcubs.clickSave();
				fcubs.closeOverridePopUp1();
				fcubs.switchframes();
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__ASSIGNTO", data.getUserid());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__MAKREM", data.getTellerremark());
				fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__ASSIGN");
				fcubs.assignframe();
				fcubs.clickBtnOk();*/
				
		
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
			for(MiscellaneousGL_1060_Page data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}
}
