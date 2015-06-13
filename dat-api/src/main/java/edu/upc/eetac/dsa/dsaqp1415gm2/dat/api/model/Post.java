package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;

public class Post {
	@InjectLinks({
		@InjectLink(value = "/thread/post/{idpost}", style = Style.ABSOLUTE, rel = "idpost", title = "post link", type = MediaType.DAT_API_THREAD,bindings = { @Binding(name = "idpost", value = "${instance.idpost}")})})
	private String content;
	private int idpost;
	private int idthema;
	private int idhilo;
	private String imagelink;
	private List<Link> links;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	public int getIdthema() {
		return idthema;
	}
	public void setIdthema(int idthema) {
		this.idthema = idthema;
	}
	public int getIdhilo() {
		return idhilo;
	}
	public void setIdhilo(int idhilo) {
		this.idhilo = idhilo;
	}
	public String getImagelink() {
		return imagelink;
	}
	public void setImagelink(String imagelink) {
		this.imagelink = imagelink;
	}
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	
}
