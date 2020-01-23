package com.jmr.testsuite.fas.page.wb;



import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "9007")
public class TransferCashFromVault_9007_Page {

	
private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "TransferCurrency")
	private String transferccy;

	@SheetColumn(value = "Transferamount")
	private String transferamt;
	
	
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



	public String getTestCaseResult() {
		return testCaseResult;
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

	public String getTransferccy() {
		return transferccy;
	}

	public void setTransferccy(String transferccy) {
		this.transferccy = transferccy;
	}

	public String getTransferamt() {
		return transferamt;
	}

	public void setTransferamt(String transferamt) {
		this.transferamt = transferamt;
	}



	@Override
	public String toString() {
		return "TransferCashFromVault_9007_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId
				+ ", runMode=" + runMode + ", transferccy=" + transferccy + ", transferamt=" + transferamt + ", save="
				+ save + ", hold=" + hold + ", d100=" + d100 + ", d50=" + d50 + ", d20=" + d20 + ", d10=" + d10
				+ ", d5=" + d5 + ", d2=" + d2 + "]";
	}



	
	
}
