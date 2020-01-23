package com.jmr.testsuite.fas.page.cl;
import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "CLDMNROL")
public class ManualRollOverPage {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "Fastpath")
	private String fastpath;
	
	@SheetColumn(value = "AccountNumber")
	private String accountnumber;
	
	@SheetColumn(value = "MainTab")
	private String maintab;
	
	@SheetColumn(value = "ValueDate")
	private String valuedate;

	@SheetColumn(value = "ExecutionValue")
	private String executionvalue;
	
	@SheetColumn(value = "PopulateOutStanding")
	private String populatebutton;
	
	@SheetColumn(value = "LiquidationAmount")
	private String liqamount;
	
	@SheetColumn(value = "Addbutton")
	private String addbutton;
	
	@SheetColumn(value = "SettlementAmount")
	private String settlementamount;
	
	@SheetColumn(value = "SettlementCurrency")
	private String settlementcurrency;
	
	@SheetColumn(value = "SettlementAccount")
	private String settlementaccount;
	
	@SheetColumn(value = "AllocateButton")
	private String allocatebutton;
	
	@SheetColumn(value = "DefaultButton")
	private String defaultbutton;
	
	@SheetColumn(value = "EditUDEdetailButton")
	private String editUDEbutton;
	
	@SheetColumn(value = "InterestRate")
	private String interestrate;
	
	@SheetColumn(value = "EnrichButton")
	private String enrichbutton;
	
	@SheetColumn(value = "PrinciInterest")
	private String princiinterest;
	
	

	public String getPrinciinterest() {
		return princiinterest;
	}

	public void setPrinciinterest(String princiinterest) {
		this.princiinterest = princiinterest;
	}

	public String getMaintab() {
		return maintab;
	}

	public void setMaintab(String maintab) {
		this.maintab = maintab;
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

	public String getFastpath() {
		return fastpath;
	}

	public void setFastpath(String fastpath) {
		this.fastpath = fastpath;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getValuedate() {
		return valuedate;
	}

	public void setValuedate(String valuedate) {
		this.valuedate = valuedate;
	}

	public String getExecutionvalue() {
		return executionvalue;
	}

	public void setExecutionvalue(String executionvalue) {
		this.executionvalue = executionvalue;
	}

	public String getPopulatebutton() {
		return populatebutton;
	}

	public void setPopulatebutton(String populatebutton) {
		this.populatebutton = populatebutton;
	}

	public String getLiqamount() {
		return liqamount;
	}

	public void setLiqamount(String liqamount) {
		this.liqamount = liqamount;
	}

	public String getAddbutton() {
		return addbutton;
	}

	public void setAddbutton(String addbutton) {
		this.addbutton = addbutton;
	}

	public String getSettlementamount() {
		return settlementamount;
	}

	public void setSettlementamount(String settlementamount) {
		this.settlementamount = settlementamount;
	}

	public String getSettlementcurrency() {
		return settlementcurrency;
	}

	public void setSettlementcurrency(String settlementcurrency) {
		this.settlementcurrency = settlementcurrency;
	}

	public String getSettlementaccount() {
		return settlementaccount;
	}

	public void setSettlementaccount(String settlementaccount) {
		this.settlementaccount = settlementaccount;
	}

	public String getAllocatebutton() {
		return allocatebutton;
	}

	public void setAllocatebutton(String allocatebutton) {
		this.allocatebutton = allocatebutton;
	}

	public String getDefaultbutton() {
		return defaultbutton;
	}

	public void setDefaultbutton(String defaultbutton) {
		this.defaultbutton = defaultbutton;
	}

	public String getEditUDEbutton() {
		return editUDEbutton;
	}

	public void setEditUDEbutton(String editUDEbutton) {
		this.editUDEbutton = editUDEbutton;
	}

	public String getInterestrate() {
		return interestrate;
	}

	public void setInterestrate(String interestrate) {
		this.interestrate = interestrate;
	}

	public String getEnrichbutton() {
		return enrichbutton;
	}

	public void setEnrichbutton(String enrichbutton) {
		this.enrichbutton = enrichbutton;
	}

	@Override
	public String toString() {
		return "ManualRollOverPage [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId + ", runMode="
				+ runMode + ", fastpath=" + fastpath + ", accountnumber=" + accountnumber + ", maintab=" + maintab
				+ ", valuedate=" + valuedate + ", executionvalue=" + executionvalue + ", populatebutton="
				+ populatebutton + ", liqamount=" + liqamount + ", addbutton=" + addbutton + ", settlementamount="
				+ settlementamount + ", settlementcurrency=" + settlementcurrency + ", settlementaccount="
				+ settlementaccount + ", allocatebutton=" + allocatebutton + ", defaultbutton=" + defaultbutton
				+ ", editUDEbutton=" + editUDEbutton + ", interestrate=" + interestrate + ", enrichbutton="
				+ enrichbutton + ", princiinterest=" + princiinterest + "]";
	}

	

}
