package com.jmr.testsuite.fas.page.wb;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "8203")

public class FXSaleWalIn_8203_Page {
	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "CurrencyBrought")
	private String currencybought;
	
	@SheetColumn(value = "CurrenctSold")
	private String currenctsold;
	
	@SheetColumn(value = "AmountBought")
	private String amountbought;
	
	@SheetColumn(value = "UserID")
	private String userid;
	
	@SheetColumn(value = "TellerRemarks")
	private String tellerremark;
	
	@SheetColumn(value = "Fastpath")
	private String fastpath;
	
	@SheetColumn(value = "New")
	private String newdata;
	
	@SheetColumn(value = "Authorize")
	private String authorize;
	
	
	@SheetColumn(value = "ReferenceNumber")
	private String referencenumber;
	
	@SheetColumn(value = "ExchangeRate")
	private String exchangerate;
	
	@SheetColumn(value = "Waivercharge")
	private String waiver;
	
	@SheetColumn(value = "ChargeAmount")
	private String chargeamount;
	
	
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

	public String getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(String exchangerate) {
		this.exchangerate = exchangerate;
	}

	public String getWaiver() {
		return waiver;
	}

	public void setWaiver(String waiver) {
		this.waiver = waiver;
	}

	public String getChargeamount() {
		return chargeamount;
	}

	public void setChargeamount(String chargeamount) {
		this.chargeamount = chargeamount;
	}

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

	public String getCurrencybought() {
		return currencybought;
	}

	public void setCurrencybought(String currencybought) {
		this.currencybought = currencybought;
	}

	public String getCurrenctsold() {
		return currenctsold;
	}

	public void setCurrenctsold(String currenctsold) {
		this.currenctsold = currenctsold;
	}

	public String getAmountbought() {
		return amountbought;
	}

	public void setAmountbought(String amountbought) {
		this.amountbought = amountbought;
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
	
	
	

	public String getReferencenumber() {
		return referencenumber;
	}

	public void setReferencenumber(String referencenumber) {
		this.referencenumber = referencenumber;
	}

	@Override
	public String toString() {
		return "FXSaleWalIn_8203_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId + ", runMode="
				+ runMode + ", currencybought=" + currencybought + ", currenctsold=" + currenctsold + ", amountbought="
				+ amountbought + ", userid=" + userid + ", tellerremark=" + tellerremark + ", fastpath=" + fastpath
				+ ", newdata=" + newdata + ", authorize=" + authorize + ", referencenumber=" + referencenumber
				+ ", exchangerate=" + exchangerate + ", waiver=" + waiver + ", chargeamount=" + chargeamount + ", save="
				+ save + ", hold=" + hold + "]";
	}

	


	
	
}