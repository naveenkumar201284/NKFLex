package com.jmr.testsuite.fas.page.wb;


import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "1008")

public class MiscellaneousCustDbt_1008Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "New")
	private String newdata;
	
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
	
	@SheetColumn(value = "AccountCurrency")
	private String accountccy;
	
	@SheetColumn(value = "GLBranch")
	private String glbranch;
	
	@SheetColumn(value = "GLCurrency")
	private String glccy;
	
	@SheetColumn(value = "Authorize")
	private String authorize;

	@SheetColumn(value = "ReferenceNumber")
	private String referencenumber;
	

	
	
	public String getNewdata() {
		return newdata;
	}

	public void setNewdata(String newdata) {
		this.newdata = newdata;
	}

	public String getAuthorize() {
		return authorize;
	}

	public void setAuthorize(String authorize) {
		this.authorize = authorize;
	}

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	public String getAccountccy() {
		return accountccy;
	}

	public void setAccountccy(String accountccy) {
		this.accountccy = accountccy;
	}

	public String getGlbranch() {
		return glbranch;
	}

	public void setGlbranch(String glbranch) {
		this.glbranch = glbranch;
	}

	public String getGlccy() {
		return glccy;
	}

	public void setGlccy(String glccy) {
		this.glccy = glccy;
	}

	@SheetColumn(value = "Save")
	private String save;
	
	@SheetColumn(value = "Hold")
	private String hold;
		

	
	
	

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

	public String getBrachcode() {
		return brachcode;
	}

	public void setBrachcode(String brachcode) {
		this.brachcode = brachcode;
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

	public String getFastpath() {
		return fastpath;
	}

	public void setFastpath(String fastpath) {
		this.fastpath = fastpath;
	}

	@Override
	public String toString() {
		return "MiscellaneousCustDbt_1008Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId
				+ ", runMode=" + runMode + ", newdata=" + newdata + ", accountnumber=" + accountnumber + ", brachcode="
				+ brachcode + ", accountamount=" + accountamount + ", glaccountnumber=" + glaccountnumber + ", userid="
				+ userid + ", tellerremark=" + tellerremark + ", fastpath=" + fastpath + ", accountccy=" + accountccy
				+ ", glbranch=" + glbranch + ", glccy=" + glccy + ", authorize=" + authorize + ", referencenumber="
				+ referencenumber + ", save=" + save + ", hold=" + hold + "]";
	}

	
}
