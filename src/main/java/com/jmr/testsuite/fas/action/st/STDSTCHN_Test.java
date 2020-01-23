package com.jmr.testsuite.fas.action.st;

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
import com.jmr.testsuite.fas.page.st.STDSTCHN_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class STDSTCHN_Test extends AbstractTestNGSpringContextTests{
	
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "STDSTCHN";
	private final String screenName="Manual Status Change Input";

	private List<STDSTCHN_Page> dataList;
	private List<STDSTCHN_Page> resultList;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList = fcubs.loadDataFromExcel(STDSTCHN_Page.class, screenId);
		resultList = new ArrayList<>();

	}


	@Test()
	public void executeTestCase() throws Exception {

		for (STDSTCHN_Page data : dataList) {
			try {
				this.testCaseId = data.getTestCaseId();
				System.out.println("Executing Test Case ====>" + this.testCaseId);
				fcubs.setTestCaseId(testCaseId);
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					
					if (data.getNewdata().equalsIgnoreCase("Yes")) {

					fcubs.clickNew();
				
					fcubs.LOVData("//label[contains(text(),'Account No')]//following::button[1]","//label[contains(text(),'Account No')]//following::input[1]","//label[contains(text(),'Account No')]//following::input[1]","//button[contains(text(),'Fetch')]","//div[@id='LovDiv']//tr[1]//td[2]//div[1]",data.getAccountnumber());
					//fcubs.populateTextById("BLK_STTMS_AC_STAT_CHANGE__CUST_AC_NO", data.getAccountnumber());
					fcubs.switchToActiveFrame();

					fcubs.LOVData("//label[contains(text(),'New Status')]//following::button[1]","//label[contains(text(),'Account Status')]//following::input[1]","//label[contains(text(),'Account Status')]//following::input[1]","//button[contains(text(),'Fetch')]","//div[@id='LovDiv']//tr[1]//td[2]//div[1]",data.getNewstatus());
					fcubs.switchToActiveFrame();
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_NO_DR", data.getNodebit());
					
					//String text=fcubs.gettextdata(name);
					
					
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_NO_CR", data.getNocredit());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_FROZEN", data.getFrozen());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_DE_POST", data.getPostingallowed());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_CHG_AUTO", data.getStatuschangeautomatic());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__DORMANT", data.getDormant());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_DR_OVD", data.getDebitoverride());
					fcubs.selectFlag("BLK_STTMS_AC_STAT_CHANGE__AC_STAT_CR_OVD", data.getCreditoverride());
					fcubs.clickSave();
					
					
					try {
						fcubs.closeOverridePopUp(); 
						}
						catch(Exception ex) {
							System.out.println("No remark pop up exists");
						}
					}	
					
				if (data.getDelete().equalsIgnoreCase("Yes")) {
					
					fcubs.clickEnterQuery();
					fcubs.LOVData("//label[contains(text(),'Account No')]//following::button[1]","//label[contains(text(),'Account No')]//following::input[1]","//label[contains(text(),'Account No')]//following::input[1]","//button[contains(text(),'Fetch')]","//div[@id='LovDiv']//tr[1]//td[2]//div[1]",data.getAccountnumber());
					fcubs.switchToActiveFrame();
					fcubs.LOVData("//label[contains(text(),'New Status')]//following::button[1]","//label[contains(text(),'Account Status')]//following::input[1]","//label[contains(text(),'Account Status')]//following::input[1]","//button[contains(text(),'Fetch')]","//div[@id='LovDiv']//tr[1]//td[2]//div[1]",data.getNewstatus());
					fcubs.switchToActiveFrame();
					fcubs.clickExecuteQuery();
					
					try {
						fcubs.closeInfoPopUp();
					} catch (Exception e) {
						System.out.println("No pop up exists");
					}
					fcubs.clickDelete();
					fcubs.closeConfirmaPopUp();
					
				}
					// added to close remark screen/alert
					/*try {
					fcubs.closeOverridePopUp();
					}
					catch(Exception e) {
						System.out.println("Override pop up doesnot exists");
					}
					
					try {
						fcubs.closeInfoPopUp();
						}
						catch(Exception e) {
							System.out.println("close all screens");
						}*/
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
					fcubs.closeInfoPopUp();
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
				resultList.add(data);
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
		for (STDSTCHN_Page data : resultList) {
			System.out.println(data.getTestCaseId() + "\t" + data.getTestCaseResult().replace("\n", ";"));
		}
	}

}
