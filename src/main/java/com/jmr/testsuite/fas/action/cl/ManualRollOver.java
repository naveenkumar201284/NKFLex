package com.jmr.testsuite.fas.action.cl;

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
import com.jmr.testsuite.fas.page.cl.CLDACCNT_Page1;
import com.jmr.testsuite.fas.page.cl.ManualRollOverPage;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class ManualRollOver extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "CLDMNROL";
	private final String screenName = "Manual Rollover";

	private List<ManualRollOverPage> dataList1;
	private List<ManualRollOverPage> resultList1;
	
	private String testCaseId;



	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList1 = fcubs.loadDataFromExcel(ManualRollOverPage.class, screenId);
		resultList1 = new ArrayList<>();

	}


	@Test()
	public void executeTestCase() throws Exception {
		
			for (ManualRollOverPage data : dataList1) {
			try {
				this.testCaseId = data.getTestCaseId();
				System.out.println("Executing Test Case ====>" + this.testCaseId);
				fcubs.setTestCaseId(testCaseId);
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					

					fcubs.clickNew();
					
					fcubs.populateTextById("BLK_ACCOUNT_MASTER__ACCNO", data.getAccountnumber());
					fcubs.populateTextById("BLK_ACCOUNT_ROLL__EXECUTION_DATEI", data.getExecutionvalue());
					fcubs.populateTextById("BLK_ACCOUNT_ROLL__VALUE_DATEI", data.getValuedate());	
					fcubs.selectFlag("BLK_ACCOUNT_ROLL__BTN_POPULATE", data.getPopulatebutton());
					
					fcubs.closeInfoPopUp();
					

					fcubs.populateTextById("BLK_ROLL_COMPONENTS__AMOUNT_TO_LIQUIDATEIRC1", data.getLiqamount());
					fcubs.clickButtonById("cmdAddRow_BLK_DROLL_SETTLEMENTS");
					
					if (data.getPrinciinterest().equalsIgnoreCase("Yes")) {

					fcubs.gettextdata("BLK_ROLL_COMPONENTS__AMOUNT_OUTSTANDING","BLK_ROLL_COMPONENTS__AMOUNT_TO_LIQUIDATEI","BLK_DROLL_SETTLEMENTS__AMTSTTLI");

					}
					
					fcubs.populateTextById("BLK_DROLL_SETTLEMENTS__STTLCCY", data.getSettlementcurrency());
					fcubs.populateTextById("BLK_DROLL_SETTLEMENTS__AMTSTTLI", data.getSettlementamount());
					fcubs.populateTextById("BLK_DROLL_SETTLEMENTS__UI_STTLACC", data.getSettlementaccount());
					fcubs.selectFlag("BLK_ACCOUNT_ROLL__BTN_ALLOCATE", data.getAllocatebutton());
					fcubs.closeInfoPopUp();
					fcubs.selectFlag("BLK_ACCOUNT_ROLL__BTN_DEFAULT",data.getDefaultbutton());
					fcubs.closeInfoPopUp();
					
					if (data.getMaintab().equalsIgnoreCase("Yes")) {

					
					fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_EDITUDE",data.getEditUDEbutton());
					fcubs.populateTextById("BLK_UDE_VALS__UDEVALIRC2", data.getInterestrate());
					fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_ENRICH", data.getEnrichbutton());
					}

					fcubs.clickSave();
					
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
					
				
					try {
						fcubs.closeRemarkPopUp();
						}
						catch(Exception ex) {
							System.out.println("No Remark popup exists");
						}
						
						
						try {
							fcubs.closeOverridePopUp();
							}
							catch(Exception ex) {
								System.out.println("No Remark popup exists");
							}
						
						
						try {
							fcubs.closeInfoPopUp();
							}
							catch(Exception ex) {
								System.out.println("No Remark popup exists");
							}
						
						
						try {
							fcubs.closeScreen();
							}
							catch(Exception ex) {
								System.out.println("No Remark popup exists");
							}
					

									
					
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
			for(ManualRollOverPage data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}



}
