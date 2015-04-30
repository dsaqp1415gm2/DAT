package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

public class Tema {
	private String Title;
	private List<Thread> threads;

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public List<Thread> getThreads() {
		return threads;
	}
	public void setThreads(List<Thread> threads) {
		this.threads = threads;
	}
}
