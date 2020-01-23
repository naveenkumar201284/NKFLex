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
import com.jmr.testsuite.fas.page.cl.CLDACCNT_Page;
import io.github.millij.poi.ss.reader.XlsxReader;

@ContextConfiguration(classes = SpringConfiguration.class)
public class CLDACCNT_Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "CLDACCNT";
	private final String screenName = "Account Details";

	private List<CLDACCNT_Page> dataList;
	private List<CLDACCNT_Page> resultList;
	
	private String testCaseId;



	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
		dataList = fcubs.loadDataFromExcel(CLDACCNT_Page.class, screenId);
		resultList = new ArrayList<>();

	}


	@Test()
	public void executeTestCase() throws Exception {
		
	for (CLDACCNT_Page data : dataList) {
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
						
			//			fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_DEFAULT", data.getProductdefault());
						Thread.sleep(3000);
						fcubs.clickButtonById("BLK_ACCOUNT_MASTER__BTN_DEFAULT");  // to click on product default
						try {
				//		fcubs.closeInfoPopUp();
						fcubs.closeOverridePopUp();
						}
						catch(Exception ex) {
							System.out.println("Override popup closed successfully");
						}
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__NOOFINSI", data.getNumberofinstallment());
						fcubs.selectDropdownByText("BLK_ACCOUNT_MASTER__FREQUNIT", data.getUnit());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__FREQI", data.getFrequency());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__INSSTDTI", data.getInstallmentstartdate());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__EMIAMTI", data.getEmi());
						Thread.sleep(3000);
						
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_ENRICH", data.getEnrich()); // not working for padma
//						fcubs.clickButtonById("BLK_ACCOUNT_MASTER__BTN_ENRICH");// to click on enrich button //working for padma

				    	fcubs.selectFlag("BLK_ACCOUNT_MASTER__BTN_EDITUDE", data.getEditudedetail());
//						fcubs.clickButtonById("BLK_ACCOUNT_MASTER__BTN_EDITUDE");  // to click on edit ude details button
						Thread.sleep(3000);
						fcubs.clearField("BLK_UDE_VALS__UDEVALIRC2", data.getInterestrate());
						Thread.sleep(2000);
						fcubs.populateTextById("BLK_UDE_VALS__UDEVALIRC2", data.getInterestrate());
				
						
					}
					
					//=========================================Linkage Tab==========================================//
					/*try {
						errorMsg = fcubs.getAllErrorMsgAndClose(data.getTestCaseId());
						fcubs.clearMultiEntryList(multiEntryElementIdText, multiEntryElementValueText,
								multiEntryElementType);
						System.out.println("Error Message  " + errorMsg);
						data.setTestCaseResult(errorMsg);
						// to update the status as failed
						//fcubs.updateTestCaseExecutionAsFailed();
						if (fcubs.validInput(errorMsg)) {
							resultList.add(data);
							continue;
						}
					} catch (Exception ex) {

					}*/
					
					if(data.getLinkagedetailtab().equalsIgnoreCase("Yes")) {
						
						
					fcubs.switchTab("Linkage Details");
					
					if(data.getAddbtn().equalsIgnoreCase("Yes")) {

					fcubs.clickButtonById("cmdAddRow_BLK_COLL_LINKAGES");
					fcubs.selectDropdownByText("BLK_COLL_LINKAGES__LINKAGE_TYPE", data.getLinkagetype());
				    
                    fcubs.LOVData("//input[@id='BLK_COLL_LINKAGES__LINKED_REFERENCE_NO']/../button[@class='BTNimg']/span[@class='ICOlov']", 
                    		"//label[text()=' Linked Reference']//following::input[1]", "//label[text()=' Linked Reference']//following::input[1]",
                    		"//button[contains(text(),'Fetch')]", "//div[@id='LovDiv']//tr[1]//td[2]//div[1]", data.getLinkagerefno());
					fcubs.switchToActiveFrame();

					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKAGE_BRANCH", data.getLinkagebranch());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKAGE_CURRENCY", data.getLinkagecurrency());
					fcubs.populateTextById("BLK_COLL_LINKAGES__OVERALL_AMOUNTI", data.getLinkageoverallamt());
					fcubs.populateTextById("BLK_COLL_LINKAGES__CATEGORY_NAME", data.getLinkagecollateralcategory());
					fcubs.populateTextById("BLK_COLL_LINKAGES__HAIRCUT", data.getLinkagehaircut());
					fcubs.populateTextById("BLK_COLL_LINKAGES__LIMIT_AMOUNTI", data.getLinkagelimitamt());
				
					fcubs.populateTextById("BLK_COLL_LINKAGES__LINKED_PERCENT_NUMBERI", data.getLinkagelinkedpercentage());
					
					fcubs.populateTextById("BLK_COLL_LINKAGES__UTIL_ORDERI", data.getUtilizationorderno());
					Thread.sleep(5000);	
					}

					}
					
					//=========================================Preferences Tab==========================================//
					
					if(data.getPreferencetab().equalsIgnoreCase("Yes")) {
						
						fcubs.switchTab("Preferences");
						Thread.sleep(2000);	
						fcubs.selectFlag("BLK_ACCOUNT_MASTER__LIQDBACKVALUESCH", data.getLiqbackdate());
						Thread.sleep(2000);	

					}
					
					
					
					//=========================================Payment Mode Tab==========================================//
					
					if(data.getPaymentmodetab().equalsIgnoreCase("Yes")) {
				
						fcubs.openChildScreenByTitle("Payment Mode Details");
						
						fcubs.selectFlag("TAB_CREDIT", data.getCreditpaymentmode());
						fcubs.clearField("BLK_ACCOUNT_MASTER__CRACCBRN", data.getCreditaccountbranch());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__CRACCBRN", data.getCreditaccountbranch());
						
						fcubs.clearField("BLK_ACCOUNT_MASTER__UI_CRPRODAC", data.getCreditproductAccount());
						fcubs.populateTextById("BLK_ACCOUNT_MASTER__UI_CRPRODAC", data.getCreditproductAccount());
						Thread.sleep(2000);
						fcubs.clickButtonByXpath("//span[contains(text(),'Debit Settlement Mode')]");
		//				fcubs.selectFlag("TAB_DEBIT", data.getDebitsettlemtnmode());
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
			      //  fcubs.closeOverridePopUp();
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
			for(CLDACCNT_Page data:resultList) {
				System.out.println(data.getTestCaseId()+"\t"+data.getTestCaseResult().replace("\n", ";"));
			}
		}


}