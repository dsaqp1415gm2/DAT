package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.PostResource;


public class Post {
	@InjectLinks({
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "posts", title = "Latest postss", type = MediaType.DAT_API_POST_COLLECTION),
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "self edit", title = "Post", type = MediaType.DAT_API_POST, method = "getPost", bindings = @Binding(name = "idpost", value = "${instance.idpost}")) })
	
	private List<Link> links;
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	private String content;
	private int idpost;
	private int npost;
	private String image_link;
	private String user_default;
	
	
	public String getUser_default() {
		return user_default;
	}
	public void setUser_default(String user_default) {
		this.user_default = user_default;
	}
	public String getImage_link() {
		return image_link;
	}
	public void setImage_link(String image_link) {
		this.image_link = image_link;
	}
	public int getNpost() {
		return npost;
	}
	public void setNpost(int npost) {
		this.npost = npost;
	}
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
	
}
