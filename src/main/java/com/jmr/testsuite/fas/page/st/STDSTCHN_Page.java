package com.jmr.testsuite.fas.page.st;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "STDSTCHN")
public class STDSTCHN_Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "AccountNumber")
	private String accountnumber;
	
	@SheetColumn(value = "NewStatus")
	private String newstatus;

	@SheetColumn(value = "NoDebit")
	private String nodebit;
	
	@SheetColumn(value = "NoCredit")
	private String nocredit;
	
	@SheetColumn(value = "Frozen")
	private String frozen;
	
	@SheetColumn(value = "PostingAllowed")
	private String postingallowed;
	
	@SheetColumn(value = "StatusChangeAutomatic")
	private String statuschangeautomatic;

	@SheetColumn(value = "Dormant")
	private String dormant;
	
	@SheetColumn(value = "DebitOverride")
	private String debitoverride;
	
	@SheetColumn(value = "CreditOverride")
	private String creditoverride;
	
	@SheetColumn(value = "Delete")
	private String delete;
	
	@SheetColumn(value = "New")
	private String newdata;
	
	

	public String getNewdata() {
		return newdata;
	}

	public void setNewdata(String newdata) {
		this.newdata = newdata;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

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

	public String getNewstatus() {
		return newstatus;
	}

	public void setNewstatus(String newstatus) {
		this.newstatus = newstatus;
	}

	public String getNodebit() {
		return nodebit;
	}

	public void setNodebit(String nodebit) {
		this.nodebit = nodebit;
	}

	public String getNocredit() {
		return nocredit;
	}

	public void setNocredit(String nocredit) {
		this.nocredit = nocredit;
	}

	public String getFrozen() {
		return frozen;
	}

	public void setFrozen(String frozen) {
		this.frozen = frozen;
	}

	public String getPostingallowed() {
		return postingallowed;
	}

	public void setPostingallowed(String postingallowed) {
		this.postingallowed = postingallowed;
	}

	public String getStatuschangeautomatic() {
		return statuschangeautomatic;
	}

	public void setStatuschangeautomatic(String statuschangeautomatic) {
		this.statuschangeautomatic = statuschangeautomatic;
	}

	public String getDormant() {
		return dormant;
	}

	public void setDormant(String dormant) {
		this.dormant = dormant;
	}

	public String getDebitoverride() {
		return debitoverride;
	}

	public void setDebitoverride(String debitoverride) {
		this.debitoverride = debitoverride;
	}

	public String getCreditoverride() {
		return creditoverride;
	}

	public void setCreditoverride(String creditoverride) {
		this.creditoverride = creditoverride;
	}

	@Override
	public String toString() {
		return "STDSTCHN_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId + ", runMode=" + runMode
				+ ", accountnumber=" + accountnumber + ", newstatus=" + newstatus + ", nodebit=" + nodebit
				+ ", nocredit=" + nocredit + ", frozen=" + frozen + ", postingallowed=" + postingallowed
				+ ", statuschangeautomatic=" + statuschangeautomatic + ", dormant=" + dormant + ", debitoverride="
				+ debitoverride + ", creditoverride=" + creditoverride + ", delete=" + delete + ", newdata=" + newdata
				+ "]";
	}


	
}
