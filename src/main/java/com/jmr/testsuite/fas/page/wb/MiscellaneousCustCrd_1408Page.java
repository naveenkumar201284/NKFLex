package com.jmr.testsuite.fas.page.wb;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "1408")

public class MiscellaneousCustCrd_1408Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "AccountNumber")
	private String accountnumber;
	
	@SheetColumn(value = "BranchCode")
	private String brachcode;
	
	
	@SheetColumn(value = "AccountAmount")
	private String accountamount;
	
	@SheetColumn(value = "GLAccountNumber")
	private String glaccountnumber;
	
	@SheetColumn(value = "UserID")
	private String userid;
	
	@SheetColumn(value = "TellerRemarks")
	private String tellerremark;
	
	@SheetColumn(value = "Fastpath")
	private String fastpath;
	
	@SheetColumn(value = "GLCurrency")
	private String glccy;
	
	@SheetColumn(value = "Save")
	private String save;
	
	@SheetColumn(value = "Hold")
	private String hold;
	
	
	

	public String getGlccy() {
		return glccy;
	}

	public void setGlccy(String glccy) {
		this.glccy = glccy;
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getTellerremark() {
		return tellerremark;
	}

	public void setTellerremark(String tellerremark) {
		this.tellerremark = tellerremark;
	}

	public String getBrachcode() {
		return brachcode;
	}

	public void setBrachcode(String brachcode) {
		this.brachcode = brachcode;
	}

	public String getFastpath() {
		return fastpath;
	}

	public void setFastpath(String fastpath) {
		this.fastpath = fastpath;
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

	public String getAccountamount() {
		return accountamount;
	}

	public void setAccountamount(String accountamount) {
		this.accountamount = accountamount;
	}

	public String getGlaccountnumber() {
		return glaccountnumber;
	}

	public void setGlaccountnumber(String glaccountnumber) {
		this.glaccountnumber = glaccountnumber;
	}

	@Override
	public String toString() {
		return "MiscellaneousCustCrd_1408Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId
				+ ", runMode=" + runMode + ", accountnumber=" + accountnumber + ", brachcode=" + brachcode
				+ ", accountamount=" + accountamount + ", glaccountnumber=" + glaccountnumber + ", userid=" + userid
				+ ", tellerremark=" + tellerremark + ", fastpath=" + fastpath + ", glccy=" + glccy + ", save=" + save
				+ ", hold=" + hold + "]";
	}

	
}
