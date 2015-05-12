package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.ArrayList;
import java.util.List;

public class Theme {
	private int idtheme;
	private String nametheme;
	private String linktheme;
	
	private List<Threadx> threads;

	public Theme() {
		super();
		threads = new ArrayList<>();
	}
	
	public List<Threadx> getThreads() {
		return threads;
	}
	
	public void setThreads(List<Threadx> threads) {
		this.threads = threads;
	}
	
	public void addThread(Threadx thread) {
		threads.add(thread);
	}

	public int getIdtheme() {
		return idtheme;
	}

	public void setIdtheme(int idtheme) {
		this.idtheme = idtheme;
	}

	public String getNametheme() {
		return nametheme;
	}

	public void setNametheme(String nametheme) {
		this.nametheme = nametheme;
	}

	public String getLinktheme() {
		return linktheme;
	}

	public void setLinktheme(String linktheme) {
		this.linktheme = linktheme;
	}
}
