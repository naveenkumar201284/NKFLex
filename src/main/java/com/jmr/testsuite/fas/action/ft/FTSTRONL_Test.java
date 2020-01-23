package com.jmr.testsuite.fas.action.ft;

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
import com.jmr.testsuite.fas.page.ft.FTSTRONL_Page;

import io.github.millij.poi.ss.reader.XlsxReader;


@ContextConfiguration(classes = SpringConfiguration.class)
public class FTSTRONL_Test extends AbstractTestNGSpringContextTests{
	
	@Autowired
	private FlexcubeCommon fcubs;
	@Autowired
	private XlsxReader xlsReader;

	private String errorMsg = "";

	private final String screenId = "FTSTRONL";
	private final String screenName="Funds Transfer Contract Summary ";

	private List<FTSTRONL_Page> dataList;
	private List<FTSTRONL_Page> resultList;
	

	private String testCaseId;

	@PostConstruct
	public void initSetup() throws Exception {
		fcubs.setScreenDetails(screenId, screenName);
		fcubs.launchApp();
//		dataList1 = xlsReader.read(CFDFLTRI.class, new File(AppConfig.testFileLocation), 13);
		dataList = fcubs.loadDataFromExcel(FTSTRONL_Page.class, screenId);
		resultList = new ArrayList<>();

	}


	@Test()
	public void executeTestCase() throws Exception {

		for (FTSTRONL_Page data : dataList) {
			try {
				this.testCaseId = data.getTestCaseId();
				System.out.println("Executing Test Case ====>" + this.testCaseId);
				fcubs.setTestCaseId(testCaseId);
				if (data.getRunMode().equalsIgnoreCase("Yes") || data.getRunMode().equalsIgnoreCase("Y")) {
					fcubs.launchScreen(screenId);
					
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__PROD", data.getProduct());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__CONTREFNO", data.getContractrefno());
					fcubs.selectDropdownByText("BLK_SUMMARY_DETAILS__CONTSTAT", data.getConstractstatus());
					fcubs.selectDropdownByText("BLK_SUMMARY_DETAILS__AUTHSTAT", data.getAuthorizestatus());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__DRCCY",data.getDebitcurrency());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__CRCCY",data.getTransfercurrency());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__DRAMT",data.getDebitamount());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__CRAMT",data.getTransferamount());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__SOURCEREFNO", data.getSourcerefnumb());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__SOURCEREFNO", data.getReceiver());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__CONSOLACREF", data.getConsolidateaccrefno());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__SOURCECD", data.getSourcecode());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__USERREFNO", data.getUserref());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__BRN", data.getBranch());
					fcubs.selectDropdownByText("BLK_SUMMARY_DETAILS__STATUS", data.getProcessstatus());
					fcubs.populateTextById("BLK_SUMMARY_DETAILS__CONSOL_DEBIT_REFERENCE_NO", data.getDebitconslidaterefnum());


					fcubs.clickSearchButton();
					
					try {
					fcubs.clickButtonByXpath("//div[@id='QryRslts']//tr[1]//td[1]//div[1]//label[1]//div[1]");
					fcubs.clickdetail();
					}
					catch(Exception ex) {
					}
				

					try {
					fcubs.closeInfoPopUp();
					}
					catch (Exception ex){
					}
					
					try {
						
						fcubs.closeScreen();
						}
						catch (Exception ex){
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
		for (FTSTRONL_Page data : resultList) {
			System.out.println(data.getTestCaseId() + "\t" + data.getTestCaseResult().replace("\n", ";"));
		}
	}



}
