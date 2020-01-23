package com.jmr.testsuite.fas.page.ac;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "ACDABLQY")

public class ACDABLQY_Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "AccountNumber")
	private String accountnumber;
	
	@SheetColumn(value = "LinkedCustomer")
	private String linkedcustomer;
	
	@SheetColumn(value = "LinkedAccount")
	private String linkedaccount;

	public String getTestCaseResult() {
		return testCaseResult;
	}

	public void setTestCaseResult(String testCaseResult) {
		this.testCaseResult = testCaseResult;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getRunMode() {
		return runMode;
	}

	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getLinkedcustomer() {
		return linkedcustomer;
	}

	public void setLinkedcustomer(String linkedcustomer) {
		this.linkedcustomer = linkedcustomer;
	}

	public String getLinkedaccount() {
		return linkedaccount;
	}

	public void setLinkedaccount(String linkedaccount) {
		this.linkedaccount = linkedaccount;
	}

	@Override
	public String toString() {
		return "ACDABLQY_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId + ", runMode=" + runMode
				+ ", accountnumber=" + accountnumber + ", linkedcustomer=" + linkedcustomer + ", linkedaccount="
				+ linkedaccount + "]";
	}
	
	
	

	

}
