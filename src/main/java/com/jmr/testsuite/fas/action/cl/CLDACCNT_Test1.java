package com.jmr.testsuite.fas.action.cl;

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
import com.jmr.testsuite.fas.page.cl.CLDACCNT_Page1;
import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class CLDACCNT_Test1 extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "CLDACCNT";
	private final String screenName = "Account Details";

	private List<CLDACCNT_Page1> dataList1;
	private List<CLDACCNT_Page1> resultList1;
	
	private String testCaseId;



	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList1 = fcubs.loadDataFromExcel(CLDACCNT_Page1.class, screenId);
		resultList1 = new ArrayList<>();

	}


	@Test()
	public void executeTestCase() throws Exception {
		
	for (CLDACCNT_Page1 data : dataList1) {
			try {
				this.testCaseId = data.getTestCaseId();
				System.out.println("Executing Test Case ====>" + this.testCaseId);
				fcubs.setTestCaseId(testCaseId);
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					
					if (data.getNewbutton().equalsIgnoreCase("Yes")) {

					fcubs.clickNew();
					
					fcubs.populateTextById("BLK_ACCOUNT_MASTER__PROD", data.getProduct());
					/*
					 * if(data.getType().equalsIgnoreCase("I")) {
					 * fcubs.clickButtonByXpath("//label[contains(text(),'Individual')]"); }else
					 * if(data.getType().equalsIgnoreCase("C")) {
					 * fcubs.clickButtonByXpath("//label[contains(text(),'Corporate')]"); }else
					 * if(data.getType().equalsIgnoreCase("B")) {
					 * fcubs.clickButtonByXpath("//label[contains(text(),'Bank')]"); }
					 */

					if(data.getMaintab().equalsIgnoreCase("Yes")) {
						
						fcubs.switchTab("Main");
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__CUSTID", data.getCustid());
					
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__CCY", data.getCcy());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__AMTFINANCEDI", data.getAmtfinanced());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__VALDTI", data.getValuedate());
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_DEFAULT", data.getProductdefault());
						try {
						fcubs.closeOverridePopUp();
						}
						catch(Exception ex) {
							System.out.println("No Override popup exists");
						}
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__NOOFINSI", data.getNumberofinstallment());
						fcubs.selectDropdownByText("BLK_ACCOUNT_MASTER__FREQUNIT", data.getUnit());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__FREQI", data.getFrequency());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__INSSTDTI", data.getInstallmentstartdate());
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_EDITUDE", data.getEditudedetail());
						fcubs.clearField("BLK_UDE_VALS__UDEVALIRC2", data.getInterestrate());
						fcubs.populateTextById("BLK_UDE_VALS__UDEVALIRC2", data.getInterestrate());
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_ENRICH", data.getEnrich());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__EMIAMTI", data.getEmi());
					}
					
					//=========================================Linkage Tab==========================================//
					
					
					if(data.getLinkagedetailtab().equalsIgnoreCase("Yes")) {
						
						
					fcubs.switchTab("Linkage Details");
					
					if(data.getAddbtn().equalsIgnoreCase("Yes")) {

					fcubs.clickButtonById("cmdAddRow_BLK_COLL_LINKAGES");
					fcubs.selectDropdownByText("BLK_COLL_LINKAGES__LINKAGE_TYPE", data.getLinkagetype());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKED_REFERENCE_NO", data.getLinkagerefno());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKAGE_BRANCH", data.getLinkagebranch());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKAGE_CURRENCY", data.getLinkagecurrency());
					fcubs.populateTextById("BLK_COLL_LINKAGES__OVERALL_AMOUNTI", data.getLinkageoverallamt());
					fcubs.populateTextById("BLK_COLL_LINKAGES__CATEGORY_NAME", data.getLinkagecollateralcategory());
					fcubs.populateTextById("BLK_COLL_LINKAGES__HAIRCUT", data.getLinkagehaircut());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LIMIT_AMOUNTI", data.getLinkagelimitamt());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKED_PERCENT_NUMBERI", data.getLinkagelinkedpercentage());
					fcubs.populateTextById("BLK_COLL_LINKAGES__UTIL_ORDERI", data.getUtilizationorderno());
						
					}

					}
					
					//=========================================Preferences Tab==========================================//
					
					if(data.getPreferencetab().equalsIgnoreCase("Yes")) {
						
						fcubs.switchTab("Preferences");
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__LIQDBACKVALUESCH", data.getLiqbackdate());
					
					}
					
					
					
					//=========================================Payment Mode==========================================//
					
					if(data.getPaymentmodetab().equalsIgnoreCase("Yes")) {
				
						fcubs.openChildScreenByTitle("Payment Mode Details");
						
						fcubs.selectFlag("TAB_CREDIT", data.getCreditpaymentmodetab());
						fcubs.clearField("BLK_ACCOUNT_MASTER__CRACCBRN", data.getCreditaccountbranch());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__CRACCBRN", data.getCreditaccountbranch());
						
						fcubs.clearField("BLK_ACCOUNT_MASTER__UI_CRPRODAC", data.getCreditproductAccount());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__UI_CRPRODAC", data.getCreditproductAccount());
						
						fcubs.selectFlag("TAB_DEBIT", data.getDebitsettlemtnmodetab());
					//	fcubs.selectFlagXpath("//span[contains(text(),'Debit Settlement Mode')]", data.getDebitsettlemtnmodetab());
						fcubs.clearField("BLK_ACCOUNT_MASTER__DRACCBRN", data.getDebitaccountbranch());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__DRACCBRN", data.getDebitaccountbranch());
						
						fcubs.clearField("BLK_ACCOUNT_MASTER__UI_DRPRODAC", data.getDebitproductAccount());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__UI_DRPRODAC", data.getDebitproductAccount());
						fcubs.closeChildScreen();

					}
					
					
					
					
//=========================================Holiday Tab==========================================//
							
					
					if(data.getHolidaytab().equalsIgnoreCase("Yes")) {
						
						fcubs.switchTab("Holiday Preferences");
						fcubs.selectFlag("BLK_HOL_PREF__IGNORE_HOLIDAYS", data.getIgnoreholiday1());
						fcubs.selectFlag("BLK_HOL_PREF__IGNORE_HOLIDAYS_MAT_VAL_DT", data.getIgnoreholiday2());	
					}
					
					

					fcubs.clickSave();
					
				
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
						
															
					}	
					
//============================================Authorise Record=================================================
					
				/*	if (data.getAuthorise().equalsIgnoreCase("Yes")) {
						fcubs.clickEnterQuery();
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__ACCNO", data.getAccountnumber());
						fcubs.clickExecuteQuery();

						fcubs.clickButtonByXpath("//a[contains(text(),'Authorize')]");
						fcubs.switchtosubscreensframe();
						fcubs.clickButtonById("BLK_ACCOUNTDETAILS__BTN_AUTH");
						fcubs.closeOverridePopUp1();
						//fcubs.Authokbutton();
						fcubs.popupalert1();
						fcubs.closeScreen();
									
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
			for(CLDACCNT_Page1 data:resultList1) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}


}
