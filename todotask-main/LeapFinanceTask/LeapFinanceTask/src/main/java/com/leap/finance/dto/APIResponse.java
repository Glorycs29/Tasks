package com.leap.finance.dto;

public class APIResponse {

	public int status;
	public String reason;
	public Object result;

	public APIResponse(int aStatus, String aReason, Object aResult) {
		super();
		status = aStatus;
		reason = aReason;
		result = aResult;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int aStatus) {
		status = aStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String aReason) {
		reason = aReason;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object aResult) {
		result = aResult;
	}

	@Override
	public String toString() {
		return "APIResponse [status=" + status + ", reason=" + reason + ", result=" + result + "]";
	}

}
