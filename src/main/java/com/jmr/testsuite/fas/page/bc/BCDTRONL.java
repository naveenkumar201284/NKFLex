package com.jmr.testsuite.fas.page.bc;

import org.springframework.stereotype.Component;
import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;

@Component
@Sheet(value = "BCDTRONL")
public class BCDTRONL {
	
	@SheetColumn("RunMode")
	private String runMode;
	
	@SheetColumn("Test Case Id")
	private String testCaseID;
	
	@SheetColumn("PRODUCT_CODE")
	private String productCode;
	
	@SheetColumn("LC_CUSTOMER")
	private String lcCustomer;
	
	@SheetColumn("LC_REFERENCE_NO")
	private String lcReferenceNumber;
	
	@SheetColumn("CUSTOMER_ID")
	private String customerID;

	@SheetColumn("AMOUNT")
	private String amount;
	

	@SheetColumn("VALUE_DATE")
	private String valueDate;
	
	@SheetColumn("BASE_DATE")
	private String baseDate;
	
	@SheetColumn("DEBIT_VALUE_DATE")
	private String debitValueDate;
	
	@SheetColumn("CREDIT_VALUE_DATE")
	private String creditValueDate;
	
	@SheetColumn("TENOR_DAYS")
	private String tenorDays;
	
	@SheetColumn("ALLOW_PREPAYMENT")
	private String allowPrepayment;
	
	@SheetColumn("FROM_DATE")
	private String fromDate;
	
	@SheetColumn("TO_DATE")
	private String toDate;
	
	@SheetColumn("AUTO_LIQUIDATE")
	private String autoLiquidate;
	
	@SheetColumn("ALLOW_ROLLOVER")
	private String allowRollover;
	
	@SheetColumn("AUTO_STATUS_CONTROL")
	private String autoStatusControl;
	
	@SheetColumn("DRAWEE_PARTY_ID")
	private String draweePartyId;
	
	@SheetColumn("DRAWEE_REFERENCE")
	private String draweeReference;
	
	@SheetColumn("DRAWER_REFERENCE")
	private String drawerReference;
	
	@SheetColumn("DRAWER_PARTY_ID")
	private String drawerPartyId;
	
	@SheetColumn("CODE")
	private String code;
	
	@SheetColumn("DOCUMENT_DATE")
	private String documentDate;
	
	@SheetColumn("GOODS_CODE")
	private String goodsCode;
	
	@SheetColumn("NUMBER_OF_UNITS")
	private String numberOfUnits;
	
	@SheetColumn("PRICE_PER_UNIT")
	private String pricePerUnit;
	
	@SheetColumn("INTEREST_LIQUIDATION_MODE")
	private String interestLiquidationMode;
	
	@SheetColumn("COMPANY_CODE")
	private String companyCode;
	
	@SheetColumn("PURCHASE_AMOUNT")
	private String purchaseAmount;
	
	@SheetColumn("RATE")
	private String rate;
	
	@SheetColumn("CONSIDER_AS_DISCOUNT")
	private String considerAsDiscount;
	
	@SheetColumn("WAIVER")
	private String waiver;
	
	@SheetColumn("CHARGES_ACCRUAL_REQUIRED")
	private String chargesAccrualRequired;
	
	@SheetColumn("COST_CTR")
	private String costCTR;

	
	public String getRunMode() {
		return runMode;
	}	

	public void setRunMode(String runMode) {
		this.runMode = runMode;
	}
	
	public String getTestCaseID() {
		return testCaseID;
	}

	public void setTestCaseID(String testCaseID) {
		this.testCaseID = testCaseID;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getLcCustomer() {
		return lcCustomer;
	}

	public void setLcCustomer(String lcCustomer) {
		this.lcCustomer = lcCustomer;
	}

	public String getLcReferenceNumber() {
		return lcReferenceNumber;
	}

	public void setLcReferenceNumber(String lcReferenceNumber) {
		this.lcReferenceNumber = lcReferenceNumber;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getValueDate() {
		return valueDate;
	}

	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

	public String getBaseDate() {
		return baseDate;
	}

	public void setBaseDate(String baseDate) {
		this.baseDate = baseDate;
	}

	public String getDebitValueDate() {
		return debitValueDate;
	}

	public void setDebitValueDate(String debitValueDate) {
		this.debitValueDate = debitValueDate;
	}

	public String getCreditValueDate() {
		return creditValueDate;
	}

	public void setCreditValueDate(String creditValueDate) {
		this.creditValueDate = creditValueDate;
	}

	public String getTenorDays() {
		return tenorDays;
	}

	public void setTenorDays(String tenorDays) {
		this.tenorDays = tenorDays;
	}

	public String getAllowPrepayment() {
		return allowPrepayment;
	}

	public void setAllowPrepayment(String allowPrepayment) {
		this.allowPrepayment = allowPrepayment;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getAutoLiquidate() {
		return autoLiquidate;
	}

	public void setAutoLiquidate(String autoLiquidate) {
		this.autoLiquidate = autoLiquidate;
	}

	public String getAllowRollover() {
		return allowRollover;
	}

	public void setAllowRollover(String allowRollover) {
		this.allowRollover = allowRollover;
	}

	public String getAutoStatusControl() {
		return autoStatusControl;
	}

	public void setAutoStatusControl(String autoStatusControl) {
		this.autoStatusControl = autoStatusControl;
	}

	public String getDraweePartyId() {
		return draweePartyId;
	}
	
	public void setDraweePartyId(String draweePartyId) {
		this.draweePartyId = draweePartyId;
	}
	
	public String getDraweeReference() {
		return draweeReference;
	}

	public void setDraweeReference(String draweeReference) {
		this.draweeReference = draweeReference;
	}
	
	public String getDrawerPartyId() {
		return drawerPartyId;
	}

	public void setDrawerPartyId(String drawerPartyId) {
		this.drawerPartyId = drawerPartyId;
	}
	
	public String getDrawerReference() {
		return drawerReference;
	}

	public void setDrawerReference(String drawerReference) {
		this.drawerReference = drawerReference;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDocumentDate() {
		return documentDate;
	}

	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getNumberOfUnits() {
		return numberOfUnits;
	}

	public void setNumberOfUnits(String numberOfUnits) {
		this.numberOfUnits = numberOfUnits;
	}

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getInterestLiquidationMode() {
		return interestLiquidationMode;
	}

	public void setInterestLiquidationMode(String interestLiquidationMode) {
		this.interestLiquidationMode = interestLiquidationMode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getConsiderAsDiscount() {
		return considerAsDiscount;
	}

	public void setConsiderAsDiscount(String considerAsDiscount) {
		this.considerAsDiscount = considerAsDiscount;
	}

	public String getWaiver() {
		return waiver;
	}

	public void setWaiver(String waiver) {
		this.waiver = waiver;
	}

	public String getChargesAccrualRequired() {
		return chargesAccrualRequired;
	}

	public void setChargesAccrualRequired(String chargesAccrualRequired) {
		this.chargesAccrualRequired = chargesAccrualRequired;
	}

	public String getCostCTR() {
		return costCTR;
	}

	public void setCostCTR(String costCTR) {
		this.costCTR = costCTR;
	}
	
}
