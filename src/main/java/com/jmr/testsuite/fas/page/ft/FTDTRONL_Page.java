package com.jmr.testsuite.fas.page.ft;
import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "FTDTRONL")
public class FTDTRONL_Page {
	
	private String testCaseResult;

	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "Product")
	private String product;
	
	@SheetColumn(value = "DebitCurrency")
	private String debitcurrenct;
	
	@SheetColumn(value = "DebitBranch")
	private String debitBranch;
	
	@SheetColumn(value = "DebitAccount")
	private String debitaccount;
	
	@SheetColumn(value = "DebitAmount")
	private String debitamount;
	
	@SheetColumn(value = "DebitValueDate")
	private String debitvaluedate;
	
	@SheetColumn(value = "CreditCurrency")
	private String creditcurrency;
	
	@SheetColumn(value = "CreditBranch")
	private String creditbranch;
	
	@SheetColumn(value = "CreditAccount")
	private String creditaccount;
	
	@SheetColumn(value = "CreditAmount")
	private String creditamount;
		
	@SheetColumn(value = "CreditValueDate")
	private String creditvaluedate;
	
	@SheetColumn(value = "ExchangeRate")
	private String exchangerate;
	
	@SheetColumn(value = "UltimateBeneficiaryDetails")
	private String ultimatebeneficiarydetails;
	
	@SheetColumn(value = "ChargeBearer")
	private String chargebearer;
	
	@SheetColumn(value = "Waiver")
	private String waiver;	
	
	@SheetColumn(value = "OrderCustomer")
	private String ordercustomer;	
	
	@SheetColumn(value = "UltimateBeneificaryDetail1")
	private String ultimatebefdetail1;	
	
	@SheetColumn(value = "Intermediary")
	private String intermediary;	
	
	@SheetColumn(value = "Hold")
	private String hold;
	
	@SheetColumn(value = "Delete")
	private String delete;
	
	@SheetColumn(value = "Save")
	private String save;
	
	@SheetColumn(value = "ByAccountInst1")
	private String byAccountInst;
	
	@SheetColumn(value = "AccountWithInstitution")
	private String accountwithinstitution;
	

	@SheetColumn(value = "PartyTab")
	private String party;
	

	@SheetColumn(value = "Ultimatebeneficiary1")
	private String ultimatebenficiary1;
	
	@SheetColumn(value = "ByOrderDetail1")
	private String byorderdetail1;
	
	@SheetColumn(value = "ChargesTab")
	private String chargestab;
	
	@SheetColumn(value = "ChargeAmount")
	private String chargeamount;
	
	@SheetColumn(value = "Waived")
	private String waived;
	
	
	public String getChargestab() {
		return chargestab;
	}

	public void setChargestab(String chargestab) {
		this.chargestab = chargestab;
	}

	public String getChargeamount() {
		return chargeamount;
	}

	public void setChargeamount(String chargeamount) {
		this.chargeamount = chargeamount;
	}

	public String getWaived() {
		return waived;
	}

	public void setWaived(String waived) {
		this.waived = waived;
	}

	public String getByAccountInst() {
		return byAccountInst;
	}

	public void setByAccountInst(String byAccountInst) {
		this.byAccountInst = byAccountInst;
	}

	public String getSave() {
		return save;
	}

	public void setSave(String save) {
		this.save = save;
	}

	public String getByorderdetail1() {
		return byorderdetail1;
	}

	public void setByorderdetail1(String byorderdetail1) {
		this.byorderdetail1 = byorderdetail1;
	}

	public String getUltimatebenficiary1() {
		return ultimatebenficiary1;
	}

	public void setUltimatebenficiary1(String ultimatebenficiary1) {
		this.ultimatebenficiary1 = ultimatebenficiary1;
	}

	public String getParty() {
		return party;
	}

	public void setParty(String party) {
		this.party = party;
	}

	@SheetColumn(value = "Enrich")
	private String enrich;
	
	@SheetColumn(value = "CustomerCoverDetailTab")
	private String customercoverdetailtab;
	
	

	public String getCustomercoverdetailtab() {
		return customercoverdetailtab;
	}

	public void setCustomercoverdetailtab(String customercoverdetailtab) {
		this.customercoverdetailtab = customercoverdetailtab;
	}

	public String getEnrich() {
		return enrich;
	}

	public void setEnrich(String enrich) {
		this.enrich = enrich;
	}

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

	public String getDebitcurrenct() {
		return debitcurrenct;
	}

	public void setDebitcurrenct(String debitcurrenct) {
		this.debitcurrenct = debitcurrenct;
	}

	public String getDebitBranch() {
		return debitBranch;
	}

	public void setDebitBranch(String debitBranch) {
		this.debitBranch = debitBranch;
	}

	public String getDebitaccount() {
		return debitaccount;
	}

	public void setDebitaccount(String debitaccount) {
		this.debitaccount = debitaccount;
	}

	public String getDebitamount() {
		return debitamount;
	}

	public void setDebitamount(String debitamount) {
		this.debitamount = debitamount;
	}

	public String getDebitvaluedate() {
		return debitvaluedate;
	}

	public void setDebitvaluedate(String debitvaluedate) {
		this.debitvaluedate = debitvaluedate;
	}

	public String getCreditcurrency() {
		return creditcurrency;
	}

	public void setCreditcurrency(String creditcurrency) {
		this.creditcurrency = creditcurrency;
	}

	public String getCreditbranch() {
		return creditbranch;
	}

	public void setCreditbranch(String creditbranch) {
		this.creditbranch = creditbranch;
	}

	public String getCreditaccount() {
		return creditaccount;
	}

	public void setCreditaccount(String creditaccount) {
		this.creditaccount = creditaccount;
	}

	public String getCreditamount() {
		return creditamount;
	}

	public void setCreditamount(String creditamount) {
		this.creditamount = creditamount;
	}

	public String getCreditvaluedate() {
		return creditvaluedate;
	}

	public void setCreditvaluedate(String creditvaluedate) {
		this.creditvaluedate = creditvaluedate;
	}

	public String getExchangerate() {
		return exchangerate;
	}

	public void setExchangerate(String exchangerate) {
		this.exchangerate = exchangerate;
	}

	public String getUltimatebeneficiarydetails() {
		return ultimatebeneficiarydetails;
	}

	public void setUltimatebeneficiarydetails(String ultimatebeneficiarydetails) {
		this.ultimatebeneficiarydetails = ultimatebeneficiarydetails;
	}

	public String getChargebearer() {
		return chargebearer;
	}

	public void setChargebearer(String chargebearer) {
		this.chargebearer = chargebearer;
	}

	public String getWaiver() {
		return waiver;
	}

	public void setWaiver(String waiver) {
		this.waiver = waiver;
	}

	public String getOrdercustomer() {
		return ordercustomer;
	}

	public void setOrdercustomer(String ordercustomer) {
		this.ordercustomer = ordercustomer;
	}

	public String getUltimatebefdetail1() {
		return ultimatebefdetail1;
	}

	public void setUltimatebefdetail1(String ultimatebefdetail1) {
		this.ultimatebefdetail1 = ultimatebefdetail1;
	}

	public String getIntermediary() {
		return intermediary;
	}

	public void setIntermediary(String intermediary) {
		this.intermediary = intermediary;
	}

	public String getAccountwithinstitution() {
		return accountwithinstitution;
	}

	public void setAccountwithinstitution(String accountwithinstitution) {
		this.accountwithinstitution = accountwithinstitution;
	}
	
	public String getHold() {
		return hold;
	}

	public void setHold(String hold) {
		this.hold = hold;
	}
	
	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	@Override
	public String toString() {
		return "FTDTRONL_Page [testCaseResult=" + testCaseResult + ", runMode=" + runMode + ", testCaseId=" + testCaseId
				+ ", product=" + product + ", debitcurrenct=" + debitcurrenct + ", debitBranch=" + debitBranch
				+ ", debitaccount=" + debitaccount + ", debitamount=" + debitamount + ", debitvaluedate="
				+ debitvaluedate + ", creditcurrency=" + creditcurrency + ", creditbranch=" + creditbranch
				+ ", creditaccount=" + creditaccount + ", creditamount=" + creditamount + ", creditvaluedate="
				+ creditvaluedate + ", exchangerate=" + exchangerate + ", ultimatebeneficiarydetails="
				+ ultimatebeneficiarydetails + ", chargebearer=" + chargebearer + ", waiver=" + waiver
				+ ", ordercustomer=" + ordercustomer + ", ultimatebefdetail1=" + ultimatebefdetail1 + ", intermediary="
				+ intermediary + ", hold=" + hold + ", delete=" + delete + ", save=" + save + ", byAccountInst="
				+ byAccountInst + ", accountwithinstitution=" + accountwithinstitution + ", party=" + party
				+ ", ultimatebenficiary1=" + ultimatebenficiary1 + ", byorderdetail1=" + byorderdetail1
				+ ", chargestab=" + chargestab + ", chargeamount=" + chargeamount + ", waived=" + waived + ", enrich="
				+ enrich + ", customercoverdetailtab=" + customercoverdetailtab + "]";
	}


}
