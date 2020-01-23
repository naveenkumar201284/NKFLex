package com.jmr.testsuite.fas.action.bc;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import com.jmr.testsuite.fas.FlexcubeCommon;
import com.jmr.testsuite.fas.SpringConfiguration;
import com.jmr.testsuite.fas.page.bc.BCDTRONL;
import com.jmr.testsuite.fas.page.common.ScreenShotUtil;

import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class BCDTRONLTest extends AbstractTestNGSpringContextTests{

	@Autowired
	private WebDriver driver;
	private WebDriverWait driverWait;
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;
	@Autowired
	private ScreenShotUtil screenShotUtil;
	
	private BCDTRONL data;
	private final String screenId = "BCDTRONL";
	private final String screenName = "Bills and Collection Contract Detailed ";

	private List<BCDTRONL> dataList;
	private List<BCDTRONL> resultList;
	
	@Test(priority = 0)
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		fcubs.launchScreen(screenId);
//		dataList = xlsReader.read(BCDTRONL.class, new File(AppConfig.testFileLocation), 5);
		dataList = fcubs.loadDataFromExcel(BCDTRONL.class, screenId);
		resultList = new ArrayList<>();
		driverWait = new WebDriverWait(driver, 5);
	}
	
	@Test(priority = 1)
	public void executeTestCase() throws Exception {
		for (BCDTRONL data : dataList) {
			if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
				fcubs.clickNew();
				
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__PRDCD", data.getProductCode());							// Product Code
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__OURLCAPP", data.getLcCustomer());							// LC Customer
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__OURLCREF", data.getLcReferenceNumber());					// LC Reference Number
//				fcubs.clickLcDefaultBtn();																				// LC Default Button
//				fcubs.closeOverrideScreen();																			// Accept button
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__CUSTID", data.getCustomerID());							// Customer ID
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__BILLAMTI", data.getAmount());								// Amount
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__VALDTI", data.getValueDate());							// Value Date
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__BASDTI", data.getBaseDate());							// Base Date
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__DRVALDTI", data.getDebitValueDate());					// Debit Value Date
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__CRVALDTI", data.getCreditValueDate());					// Credit Value Date
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__TENRDSI", data.getTenorDays());							// Tenor Days
				fcubs.switchTab("Details");																				// Details Tab
				fcubs.clickButtonByXpath("//label[contains(text(),'Allow Prepayment')]");								// Allow Prepayment
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__ACPFRMDTI", data.getFromDate());							// From Date
				fcubs.populateDateField("BLK_CONTRACT_DETAILS__ACPTODTI", data.getToDate());							// To Date
				fcubs.switchTab("Additional");																			// Additional Tab
				
				fcubs.clickButtonByXpath("//label[contains(text(),'Auto Liquidate')]");									// AUTO_LIQUIDATE
				fcubs.clickButtonByXpath("//label[contains(text(),'Allow Rollover')]");									// ALLOW_ROLLOVER
				fcubs.clickButtonByXpath("//label[contains(text(),'Auto Status Control')]");										// AUTO_STATUS_CONTROL
				fcubs.switchTab("Parties");																				// Parties Tab
							
				fcubs.populateTextById("BLK_CONTRACT_PARTIES__PARTID", data.getDraweePartyId());						// Drawee Party ID
				
				fcubs.populateTextById("BLK_CONTRACT_PARTIES__PARTREFNO", data.getDraweeReference());					// Drawee Reference Number				
				
				fcubs.populateTextById("BLK_CONTRACT_PARTIES__PARTIDRC1", data.getDrawerPartyId());						// Drawer Party ID
				
				fcubs.populateTextById("BLK_CONTRACT_PARTIES__PARTREFNORC1", data.getDrawerReference());				// Drawer Reference Number		
				
				fcubs.switchTab("Documents");																			// Documents
				fcubs.clickButtonById("cmdAddRow_BLK_DOCUMENT_DETAILS");												// Add Row in Document Details
				fcubs.populateTextById("BLK_DOCUMENT_DETAILS__DOCCOD", data.getCode());									// Code
				fcubs.populateTextById("BLK_DOCUMENT_DETAILS__DOCDATEI", data.getDocumentDate());						// Document Date
				fcubs.switchTab("Goods");																				// Goods Tab
				fcubs.clickButtonById("cmdAddRow_BLK_CONTRACT_GOODS_DETAILS");									 		// Add Row in Goods Details
				fcubs.populateTextById("BLK_CONTRACT_GOODS_DETAILS__GOODS_CODE", data.getGoodsCode()); 					// Goods Code
				fcubs.populateTextById("BLK_CONTRACT_GOODS_DETAILS__NO_OF_UNITSI", data.getNumberOfUnits()); 			// Number of Units
				fcubs.populateTextById("BLK_CONTRACT_GOODS_DETAILS__PRICE_PER_UNITI", data.getPricePerUnit()); 			// Price Per Unit
				fcubs.switchTab("Rollover");							 												// Rollover Tab
				
				fcubs.selectDropdownByText("BLK_ROLL_PREF__INTLIQDMOD", data.getInterestLiquidationMode()); 			// Interest Liquidation Mode
				fcubs.switchTab("Insurance");							 												// Insurance Tab
				fcubs.populateTextById("BLK_INSURANCE_MASTER__INSCOMPCOD", data.getCompanyCode()); 						// Company Code
				fcubs.switchTab("Purchase Details"); 																	// Purchase Details Tab
				fcubs.populateTextById("BLK_CONTRACT_DETAILS__PURAMTI", data.getPurchaseAmount());						// Purchase Amount
				fcubs.clickButtonByXpath("//li[@id='CFCTRIHG']//a[@class='Abutton'][contains(text(),'Interest')]"); 				// Interest Tab
				driver.switchTo().frame(1);
//				fcubs.closeOverrideScreen(); 																			// Accept Button
				fcubs.populateTextById("BLK_INTREST_DETAILS__RATEI", data.getRate()); 									// Rate
				fcubs.clickBtnOk();
/*				fcubs.clicktext("//li[@id='CFCTRCHG']//a[@class='Abutton'][contains(text(),'Charges')]"); 				// Charges
				fcubs.populateTextById("", data.getConsiderAsDiscount());
				fcubs.populateTextById("", data.getWaiver());
				fcubs.populateTextById("", data.getChargesAccrualRequired());
				fcubs.clicktext("//a[contains(text(),'MIS')]");															// MIS Sub Tab
				fcubs.populateTextById("", data.getCostCTR());*/

				fcubs.clickSave();
				fcubs.closeOverridePopUp(); 																			// Override Message Accept Button
				fcubs.clickBtnOk();
								
			}
		}
	}
}