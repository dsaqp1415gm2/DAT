package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;

public class Theme {
	@InjectLinks({
		@InjectLink(value = "/Theme/Tecnologia", style = Style.ABSOLUTE, rel = "tecnologia", title = "tema tecnologia", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Deportes", style = Style.ABSOLUTE, rel = "deportes", title = "tema deportes", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Motor", style = Style.ABSOLUTE, rel = "motor", title = "tema motor", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Videojuegos", style = Style.ABSOLUTE, rel = "videojuegos", title = "tema videojuegos", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Tecnologia/id", style = Style.ABSOLUTE, rel = "tecnothread", title = "threads tecnologia", type = MediaType.DAT_API_THREAD),
		//@InjectLink(value = "/Theme/Tecnologia/?idhilo={idhilo}", style = Style.ABSOLUTE, rel = "idhilo", title = "tecno idhilo", type = MediaType.DAT_API_THREAD, bindings = { @Binding(name = "idhilo", value = "${idhilo}") }),
		@InjectLink(value = "/Theme/Deportes/id", style = Style.ABSOLUTE, rel = "depthread", title = "threads depotes", type = MediaType.DAT_API_THREAD),
		@InjectLink(value = "/Theme/Motor/id", style = Style.ABSOLUTE, rel = "motorthread", title = "threads motor", type = MediaType.DAT_API_THREAD),
		@InjectLink(value = "/Theme/Videojuegos/id", style = Style.ABSOLUTE, rel = "videothread", title = "threads videojuegos", type = MediaType.DAT_API_THREAD)})
	private List<Link> links;

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
	
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
