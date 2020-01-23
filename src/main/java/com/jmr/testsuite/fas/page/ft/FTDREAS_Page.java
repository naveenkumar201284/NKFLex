package com.jmr.testsuite.fas.page.ft;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "FTDREAS")
public class FTDREAS_Page {
	
	private String testCaseResult;

	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "ContractRefnumber")
	private String contractrefnumber;
	
	@SheetColumn(value = "NewUserIdentification")
	private String newuseridentification;

	public String getTestCaseResult() {
		return testCaseResult;
	}

	public void setTestCaseResult(String testCaseResult) {
		this.testCaseResult = testCaseResult;
	}

	public String getRunMode() {
		return runMode;
	}

	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}

	public String getTestCaseId() {
		return testCaseId;
	}

	public void setTestCaseId(String testCaseId) {
		this.testCaseId = testCaseId;
	}

	public String getContractrefnumber() {
		return contractrefnumber;
	}

	public void setContractrefnumber(String contractrefnumber) {
		this.contractrefnumber = contractrefnumber;
	}

	public String getNewuseridentification() {
		return newuseridentification;
	}

	public void setNewuseridentification(String newuseridentification) {
		this.newuseridentification = newuseridentification;
	}

	@Override
	public String toString() {
		return "FTDREAS_Page [testCaseResult=" + testCaseResult + ", runMode=" + runMode + ", testCaseId=" + testCaseId
				+ ", contractrefnumber=" + contractrefnumber + ", newuseridentification=" + newuseridentification + "]";
	}

	
	
}
