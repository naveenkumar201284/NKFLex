package com.jmr.testsuite.fas.page.de;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "DESQUERY")
public class DESQUERY_Page {
	
	private String testCaseResult;

	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "ExternalRefNumber")
	private String externalrefnumber;
	
	@SheetColumn(value = "BranchCode")
	private String branchcode;
	
	@SheetColumn(value = "ContractRefNumber")
	private String contractrefnumber;
	
	@SheetColumn(value = "AdditionalRefNumber")
	private String additionalrefnumber;

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

	public String getExternalrefnumber() {
		return externalrefnumber;
	}

	public void setExternalrefnumber(String externalrefnumber) {
		this.externalrefnumber = externalrefnumber;
	}

	
	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	public String getContractrefnumber() {
		return contractrefnumber;
	}

	public void setContractrefnumber(String contractrefnumber) {
		this.contractrefnumber = contractrefnumber;
	}

	public String getAdditionalrefnumber() {
		return additionalrefnumber;
	}

	public void setAdditionalrefnumber(String additionalrefnumber) {
		this.additionalrefnumber = additionalrefnumber;
	}

	@Override
	public String toString() {
		return "DESQUERY_Page [testCaseResult=" + testCaseResult + ", runMode=" + runMode + ", testCaseId=" + testCaseId
				+ ", externalrefnumber=" + externalrefnumber + ", branchcode=" + branchcode + ", contractrefnumber="
				+ contractrefnumber + ", additionalrefnumber=" + additionalrefnumber + "]";
	}



}
