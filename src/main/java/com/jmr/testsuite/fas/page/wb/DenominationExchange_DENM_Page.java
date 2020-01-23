package com.jmr.testsuite.fas.page.wb;

import org.springframework.stereotype.Component;

import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
@Component
@Sheet(value = "DENM")


public class DenominationExchange_DENM_Page {
	
	private String testCaseResult;
	
	@SheetColumn(value = "Test Case Id")
	private String testCaseId;
	
	@SheetColumn(value = "RunMode")
	private String runMode;
	
	@SheetColumn(value = "TransactionCurrency")
	private String transccy;
	
	@SheetColumn(value = "PGK100")
	private String pgk100;
	
	@SheetColumn(value = "PGK50")
	private String pgk50;
	
	@SheetColumn(value = "PGK20")
	private String pgk20;


	@SheetColumn(value = "PGK10")
	private String pgk10;
	
	
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

	public String getTransccy() {
		return transccy;
	}

	public void setTransccy(String transccy) {
		this.transccy = transccy;
	}

	public String getPgk100() {
		return pgk100;
	}

	public void setPgk100(String pgk100) {
		this.pgk100 = pgk100;
	}

	public String getPgk50() {
		return pgk50;
	}

	public void setPgk50(String pgk50) {
		this.pgk50 = pgk50;
	}

	public String getPgk20() {
		return pgk20;
	}

	public void setPgk20(String pgk20) {
		this.pgk20 = pgk20;
	}

	public String getPgk10() {
		return pgk10;
	}

	public void setPgk10(String pgk10) {
		this.pgk10 = pgk10;
	}

	@Override
	public String toString() {
		return "DenominationExchange_DENM_Page [testCaseResult=" + testCaseResult + ", testCaseId=" + testCaseId
				+ ", runMode=" + runMode + ", transccy=" + transccy + ", pgk100=" + pgk100 + ", pgk50=" + pgk50
				+ ", pgk20=" + pgk20 + ", pgk10=" + pgk10 + "]";
	}

	

}
