package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

public class DATError {
	private int status;
	private String message;

	public DATError() {
		super();
	}

	public DATError(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
