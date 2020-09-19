package jp.co.axa.apidemo.common;

import lombok.Data;

//@Data
public final class CommonResult<T> {
	//success or failure
	private int status = 1;
	//fail code
	private String errorCode = "";
	//fail message
	private String errorMsg = "";
	//return data
	private T resultBody;
	
	public CommonResult() {
		
	}
	
	public CommonResult(T resultBody) {
		this.resultBody = resultBody;
	}

	public CommonResult(int status, String errorCode, String errorMsg, T resultBody) {
		super();
		this.status = status;
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.resultBody = resultBody;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getResultBody() {
		return resultBody;
	}

	public void setResultBody(T resultBody) {
		this.resultBody = resultBody;
	}

	@Override
	public String toString() {
		return "CommonResult [status=" + status + ", errorCode=" + errorCode + ", errorMsg=" + errorMsg
				+ ", resultBody=" + resultBody + "]";
	}
	
}
