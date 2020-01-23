package com.jmr.testsuite.fas.action.wb;

import java.io.File;
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
import com.jmr.testsuite.fas.AppConfig;
import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.wb.FXPurchaseWalkin_8004_Page;
import com.jmr.testsuite.fas.page.wb.MiscelaneousGLCredit_1460Page;
import com.jmr.testsuite.fas.page.wb.TellerTotal_TLTT_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class MiscelaneousGLCredit_1460Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";
	private WebDriver driver;

	private final String screenId = "1460";
	private final String screenName = "Miscellaneous GL Credit : Branch Date 2019-03-01";

	private List<MiscelaneousGLCredit_1460Page> dataList1;
	private List<MiscelaneousGLCredit_1460Page> resultList1;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		dataList1 = fcubs.loadDataFromExcel(MiscelaneousGLCredit_1460Page.class, screenId);
		resultList1 = new ArrayList<>();
		
	}
	
	@Test()
	public void executeTestCase() throws Exception {
		
		for (MiscelaneousGLCredit_1460Page data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				fcubs.launchScreen(screenId);
				
			/*	fcubs.LOVButton();
				fcubs.switchtosubscreensframe();
				driver.findElement(By.xpath("//label[contains(text(),'Account Number')]/following::input[1]")).sendKeys(data.getAccountnumber());
				driver.findElement(By.xpath("//label[contains(text(),'Branch Code')]/following::input[1]")).sendKeys(data.getBrachcode());
				fcubs.clickButtonByXpath("//button[@class='BTNtext']");
				fcubs.clickButtonByXpath("//a[contains(text(),'Account Number')]/following::tbody[1]//tr[1]");*/
				
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNCCY", data.getGlccy());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNACC", data.getGlaccount());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETCCY", data.getTransactionccy());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__NARRATIVE", data.getNarrative());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETAMTI", data.getTrasnactionamount());

				fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__BTN_RECALC");
				fcubs.popupalert();//frames need to adde here
				
				
				fcubs.openChildScreenByTitle("Denomination");
				Thread.sleep(3000);
				fcubs.clickButtonById("BLK_DENOMINATION_SE__DEFAULT");
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSI", data.getD100());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC1", data.getD50());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC2", data.getD20());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC3", data.getD10());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC4", data.getD5());
				fcubs.closeChildScreen();
				try {
					fcubs.switchToActiveFrame();
					}catch(Exception e) {
						
					}
							
				if (data.getSave().equalsIgnoreCase("Yes")) {
					
					fcubs.clickSave();
						

				try {
						fcubs.closeOverridePopUp();
						fcubs.switchToActiveFrame();//newly added
					} catch (Exception e) {
					}
					
					
					//fcubs.switchframes();
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
				
				
				/*fcubs.switchTab1("Denomination");
				fcubs.switchtosubscreensframe();
				fcubs.clickButtonById("BLK_DENOMINATION_SE__DEFAULT");
				fcubs.clickBtnOk();
				fcubs.switchframes();*/
					
					
			/*	fcubs.clickSave();
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
			for(MiscelaneousGLCredit_1460Page data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}

}
