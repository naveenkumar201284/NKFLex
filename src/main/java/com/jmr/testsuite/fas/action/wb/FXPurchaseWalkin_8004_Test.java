package com.jmr.testsuite.fas.action.wb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.jmr.testsuite.fas.page.cl.CLDCMTMT_Page;
import com.jmr.testsuite.fas.page.wb.FXPurchaseWalkin_8004_Page;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)

public class FXPurchaseWalkin_8004_Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";
	private WebDriver driver;

	private final String screenId = "8004";
	private final String screenName="FX Purchase Walk in : Branch Date 2019-03-01";

	private List<FXPurchaseWalkin_8004_Page> dataList1;
	private List<FXPurchaseWalkin_8004_Page> resultList1;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList1 = fcubs.loadDataFromExcel(FXPurchaseWalkin_8004_Page.class, screenId);
		resultList1 = new ArrayList<>();

	}
	
	@Test()
	public void executeTestCase() throws Exception {
		
		for (FXPurchaseWalkin_8004_Page data : dataList1) {
			try {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				
				if (data.getNewdata().equalsIgnoreCase("Yes")) {

				
				fcubs.launchScreen(screenId);

				
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNCCY", data.getCurrencybought());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__OFFSETCCY", data.getCurrenctsold());
				fcubs.populateTextById("BLK_TRANSACTION_DETAILS__TXNAMTI", data.getAmountbought());
				
				
				/*fcubs.switchTab1("FX Denomination Details");
				fcubs.switchtosubscreensframe();
				fcubs.clickButtonById("BLK_DENOMINATION_FXSE__DEFAULT");
				fcubs.clickBtnOk();
				fcubs.switchframes();*/
				
				
				fcubs.openChildScreenByTitle("FX Denomination Details");
				fcubs.clickButtonById("BLK_DENOMINATION_FXSE__DEFAULT");
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS_FX__UNITSI", data.getD100());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS_FX__UNITSIRC1", data.getD50());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS_FX__UNITSIRC2", data.getD20());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS_FX__UNITSIRC3", data.getD10());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS_FX__UNITSIRC4", data.getD5());
				fcubs.closeChildScreen();
				fcubs.switchToActiveFrame();
				
				fcubs.clickButtonById("BLK_TRANSACTION_DETAILS__BTN_RECALC");
				fcubs.popupalert();//frames need to adde here
				
				/*fcubs.switchTab1("Denomination");
				fcubs.switchtosubscreensframe();
				Thread.sleep(3000);
				fcubs.clickButtonByXpath("//button[text()='Populate']");
				fcubs.clickBtnOk();
				fcubs.switchframes();*/
				
				
				fcubs.openChildScreenByTitle("Denomination");
				Thread.sleep(3000);
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSI", data.getD100());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC1", data.getD50());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC2", data.getD20());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC3", data.getD10());
				fcubs.populateTextById("BLK_DENOMINATION_DETAILS__UNITSIRC4", data.getD5());
				fcubs.clickButtonByXpath("//button[text()='Populate']");
				fcubs.closeChildScreen();
				
				fcubs.switchToActiveFrame();
				
				
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
				
				
			}
				
				//============================================Authorise Record=================================================
				
				if (data.getAuthorize().equalsIgnoreCase("Yes")) {
					
					fcubs.clickButtonById("DBoardWorkFlow");
					fcubs.clickButtonById("btnWrkFlwReset");
					
					fcubs.populateTextById("XREFID", data.getReferencenumber());
					fcubs.clickButtonById("btnWrkFlwSearch");
					fcubs.clickButtonByXpath("//a[@name='Assigned']");
					fcubs.clickButtonById("anchorRT(Retail Teller)");
					fcubs.clickButtonByXpath("//span[@id='RT(Retail Teller)']");
					fcubs.switchframes();
					fcubs.clickButtonByXpath("//a[@name='XREFID']");
					
					fcubs.defaultframe();
					Thread.sleep(3000);
					fcubs.switchToActiveFrame();
					/*WebElement frame=driver.findElement(By.xpath("//iframe[starts-with(@id,'ifr_LaunchWin')]"));
					driver.switchTo().frame(frame);*/
					fcubs.clickButtonByXpath("//a[contains(text(),'Authorize')]");
					fcubs.switchtosubscreensframe();
					Thread.sleep(3000);
					fcubs.clickButtonByIdbutton("BTN_OK");
					fcubs.switchToActiveFrame();
					fcubs.popupalert1();
					fcubs.defaultframe();
					fcubs.clickButtonByXpath("//span[@class='tabClosedGIF']");
				
								
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
			for(FXPurchaseWalkin_8004_Page data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}


}
