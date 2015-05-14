package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;

public class Theme {
	@InjectLinks({
		@InjectLink(value = "/Tecnologia", style = Style.ABSOLUTE, rel = "tecnologia", title = "tema tecnologia", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Deportes", style = Style.ABSOLUTE, rel = "deportes", title = "tema deportes", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Motor", style = Style.ABSOLUTE, rel = "motor", title = "tema motor", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Videojuegos", style = Style.ABSOLUTE, rel = "videojuegos", title = "tema videojuegos", type = MediaType.DAT_API_THEME)})
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
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
