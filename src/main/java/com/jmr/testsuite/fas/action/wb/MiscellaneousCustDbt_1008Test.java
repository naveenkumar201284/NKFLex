package com.jmr.testsuite.fas.action.wb;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import com.jmr.testsuite.fas.page.wb.MiscelaneousGLCredit_1460Page;
import com.jmr.testsuite.fas.page.wb.MiscellaneousCustDbt_1008Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class MiscellaneousCustDbt_1008Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";
	private WebDriver driver;

	private final String screenId = "1008";
	private final String screenName = "Miscellaneous Customer Debit";

	private List<MiscellaneousCustDbt_1008Page> dataList1;
	private List<MiscellaneousCustDbt_1008Page> resultList1;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		dataList1 = fcubs.loadDataFromExcel(MiscellaneousCustDbt_1008Page.class, screenId);
		resultList1 = new ArrayList<>();
		
	}
	
	@Test()
	public void executeTestCase() throws Exception {
		
		for (MiscellaneousCustDbt_1008Page data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				
			//	if (data.getNewdata().equalsIgnoreCase("Yes")) {

				fcubs.launchScreen(screenId);
				
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__UI_TXN_ACC", data.getAccountnumber());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNCCY", data.getAccountccy());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNAMTI", data.getAccountamount());
				
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETACC", data.getGlaccountnumber());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETBRN", data.getGlbranch());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETCCY", data.getGlccy());
				fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__BTN_RECALC");
				
				
				fcubs.openChildScreenByTitle("Charge");
				Thread.sleep(3000);
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
					
					
			//	}		
					
					//============================================Authorise Record=================================================
				/*	
					if (data.getAuthorize().equalsIgnoreCase("Yes")) {
						
						fcubs.clickButtonById("DBoardWorkFlow");
						fcubs.clickButtonById("btnWrkFlwReset");
						
						fcubs.populateTextById("XREFID", data.getReferencenumber());
						fcubs.clickButtonById("btnWrkFlwSearch");
						fcubs.clickButtonByXpath("//a[@name='Assigned']");
						fcubs.clickButtonById("anchorRT(Retail Teller)");
						fcubs.clickButtonByXpath("//span[@id='RT(Retail Teller)']");
						fcubs.switchframes();
						//fcubs.clickButtonByXpath("//div[@id='tableContainer']//tr[1]//td[3]//div[1]");
					
						fcubs.clickButtonByXpath("//a[@name='XREFID']");
						
						
						//fcubs.WBAuthorize();
						WebElement frame=driver.findElement(By.xpath("//iframe[@src='TempForward.jsp?action=SMSStartLogServlet&funcid=8004']"));
						driver.switchTo().frame(frame);
						fcubs.defaultframe();
						fcubs.switchToFrameByTitle(screenId);
						WebDriverWait waitDriver=new WebDriverWait(driver,20);
						waitDriver.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.switchTo().activeElement()));

						fcubs.clickButtonByXpath("//a[contains(text(),'Authorize')]");
						fcubs.switchtosubscreensframe();
						Thread.sleep(3000);
						fcubs.clickButtonById("BTN_OK");
						fcubs.popupalert1();
						try{
							fcubs.closeScreen();
						}catch(Exception e) {
							
						}
									
					}*/		
				
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
			for(MiscellaneousCustDbt_1008Page data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}


}
