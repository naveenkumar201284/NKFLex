package com.jmr.testsuite.fas.page.wb;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "1060")
public class MiscellaneousGL_1060_Page {
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "GLCurrency")
	private String glccy;
		
	@SheetColumn(value = "GLAccount")
	private String glaccount;
	
	@SheetColumn(value = "TransactionCurrency")
	private String transactionccy;
	
	@SheetColumn(value = "Narrative")
	private String narrative;
		
	@SheetColumn(value = "TransactionAmount")
	private String trasnactionamount;
	
	@SheetColumn(value = "UserID")
	private String userid;
	
	@SheetColumn(value = "TellerRemarks")
	private String tellerremark;
		
	@SheetColumn(value = "Save")
	private String save;
	
	@SheetColumn(value = "Hold")
	private String hold;
	
	@SheetColumn(value = "D100")
	private String d100;
	
	@SheetColumn(value = "D50")
	private String d50;
	
	@SheetColumn(value = "D20")
	private String d20;
	
	@SheetColumn(value = "D10")
	private String d10;
	
	@SheetColumn(value = "D5")
	private String d5;
	
	@SheetColumn(value = "D2")
	private String d2;

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

	public String getGlccy() {
		return glccy;
	}

	public void setGlccy(String glccy) {
		this.glccy = glccy;
	}

	public String getGlaccount() {
		return glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public String getTransactionccy() {
		return transactionccy;
	}

	public void setTransactionccy(String transactionccy) {
		this.transactionccy = transactionccy;
	}

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public String getTrasnactionamount() {
		return trasnactionamount;
	}

	public void setTrasnactionamount(String trasnactionamount) {
		this.trasnactionamount = trasnactionamount;
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

	public String getD100() {
		return d100;
	}

	public void setD100(String d100) {
		this.d100 = d100;
	}

	public String getD50() {
		return d50;
	}

	public void setD50(String d50) {
		this.d50 = d50;
	}

	public String getD20() {
		return d20;
	}

	public void setD20(String d20) {
		this.d20 = d20;
	}

	public String getD10() {
		return d10;
	}

	public void setD10(String d10) {
		this.d10 = d10;
	}

	public String getD5() {
		return d5;
	}

	public void setD5(String d5) {
		this.d5 = d5;
	}

	public String getD2() {
		return d2;
	}

	public void setD2(String d2) {
		this.d2 = d2;
	}

	@Override
	public String toString() {
		return "MiscellaneousGL_1060_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId
				+ ", runMode=" + runMode + ", glccy=" + glccy + ", glaccount=" + glaccount + ", transactionccy="
				+ transactionccy + ", narrative=" + narrative + ", trasnactionamount=" + trasnactionamount + ", userid="
				+ userid + ", tellerremark=" + tellerremark + ", save=" + save + ", hold=" + hold + ", d100=" + d100
				+ ", d50=" + d50 + ", d20=" + d20 + ", d10=" + d10 + ", d5=" + d5 + ", d2=" + d2 + "]";
	}
	
}
