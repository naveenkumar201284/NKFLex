package com.jmr.testsuite.fas.page.ft;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "FTSRCST")
public class FTSTRONL_Page {
	
	private String testCaseResult;

	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "Fastpath")
	private String fastpath;
	
	@SheetColumn(value = "Product")
	private String product;
	
	@SheetColumn(value = "ContractRefNumber")
	private String contractrefno;
	
	
	@SheetColumn(value = "ContractStatus")
	private String constractstatus;
	
	@SheetColumn(value = "AuthorizeStatus")
	private String authorizestatus;
	
	@SheetColumn(value = "DebitCurrency")
	private String debitcurrency;
	
	@SheetColumn(value = "TransferCurrency")
	private String transfercurrency;
	
	@SheetColumn(value = "DebitAmount")
	private String debitamount;
	
	@SheetColumn(value = "TransferAmount")
	private String transferamount;
	
	@SheetColumn(value = "SourceRefnumber")
	private String sourcerefnumb;
	
	@SheetColumn(value = "Receiver")
	private String receiver;
	
	@SheetColumn(value = "ConsolidateAccountRefnumber")
	private String consolidateaccrefno;
	
	@SheetColumn(value = "SourceCode")
	private String sourcecode;
	
	
	@SheetColumn(value = "UserReference")
	private String userref;
	
	@SheetColumn(value = "Branch")
	private String branch;
	
	@SheetColumn(value = "ProcessStatus")
	private String processstatus;
	
	@SheetColumn(value = "DebitConsolidateRefnum")
	private String debitconslidaterefnum;

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

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getContractrefno() {
		return contractrefno;
	}

	public void setContractrefno(String contractrefno) {
		this.contractrefno = contractrefno;
	}

	public String getConstractstatus() {
		return constractstatus;
	}

	public void setConstractstatus(String constractstatus) {
		this.constractstatus = constractstatus;
	}

	public String getAuthorizestatus() {
		return authorizestatus;
	}

	public void setAuthorizestatus(String authorizestatus) {
		this.authorizestatus = authorizestatus;
	}

	public String getDebitcurrency() {
		return debitcurrency;
	}

	public void setDebitcurrency(String debitcurrency) {
		this.debitcurrency = debitcurrency;
	}

	public String getTransfercurrency() {
		return transfercurrency;
	}

	public void setTransfercurrency(String transfercurrency) {
		this.transfercurrency = transfercurrency;
	}

	public String getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(String debitamount) {
		this.debitamount = debitamount;
	}

	public String getTransferamount() {
		return transferamount;
	}

	public void setTransferamount(String transferamount) {
		this.transferamount = transferamount;
	}

	public String getSourcerefnumb() {
		return sourcerefnumb;
	}

	public void setSourcerefnumb(String sourcerefnumb) {
		this.sourcerefnumb = sourcerefnumb;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getConsolidateaccrefno() {
		return consolidateaccrefno;
	}

	public void setConsolidateaccrefno(String consolidateaccrefno) {
		this.consolidateaccrefno = consolidateaccrefno;
	}

	public String getSourcecode() {
		return sourcecode;
	}

	public void setSourcecode(String sourcecode) {
		this.sourcecode = sourcecode;
	}

	public String getUserref() {
		return userref;
	}

	public void setUserref(String userref) {
		this.userref = userref;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getProcessstatus() {
		return processstatus;
	}

	public void setProcessstatus(String processstatus) {
		this.processstatus = processstatus;
	}

	public String getDebitconslidaterefnum() {
		return debitconslidaterefnum;
	}

	public void setDebitconslidaterefnum(String debitconslidaterefnum) {
		this.debitconslidaterefnum = debitconslidaterefnum;
	}
	
	

	public String getFastpath() {
		return fastpath;
	}

	public void setFastpath(String fastpath) {
		this.fastpath = fastpath;
	}

	@Override
	public String toString() {
		return "FTSTRONL_Page [testCaseResult=" + testCaseResult + ", runMode=" + runMode + ", testCaseId=" + testCaseId
				+ ", fastpath=" + fastpath + ", product=" + product + ", contractrefno=" + contractrefno
				+ ", constractstatus=" + constractstatus + ", authorizestatus=" + authorizestatus + ", debitcurrency="
				+ debitcurrency + ", transfercurrency=" + transfercurrency + ", debitamount=" + debitamount
				+ ", transferamount=" + transferamount + ", sourcerefnumb=" + sourcerefnumb + ", receiver=" + receiver
				+ ", consolidateaccrefno=" + consolidateaccrefno + ", sourcecode=" + sourcecode + ", userref=" + userref
				+ ", branch=" + branch + ", processstatus=" + processstatus + ", debitconslidaterefnum="
				+ debitconslidaterefnum + "]";
	}

	
	


}
