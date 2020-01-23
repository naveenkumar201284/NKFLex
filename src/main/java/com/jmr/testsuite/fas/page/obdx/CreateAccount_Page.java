package com.jmr.testsuite.fas.page.obdx;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "PCDTRONL")
public class CreateAccount_Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "TransferType")
	private String transfertype;
	
	@SheetColumn(value = "Payee")
	private String payee;
	
	@SheetColumn(value = "Transferfrom")
	private String transferfrom;


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

	public String getTransfertype() {
		return transfertype;
	}

	public void setTransfertype(String transfertype) {
		this.transfertype = transfertype;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getTransferfrom() {
		return transferfrom;
	}

	public void setTransferfrom(String transferfrom) {
		this.transferfrom = transferfrom;
	}

	@Override
	public String toString() {
		return "CreateAccount_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId + ", runMode="
				+ runMode + ", transfertype=" + transfertype + ", payee=" + payee + ", transferfrom=" + transferfrom
				+ "]";
	}

	
	
}
