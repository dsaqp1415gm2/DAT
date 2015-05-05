package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.PostResource;

public class Thread {
	public class PostCollection {
		@InjectLinks({
			@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "create-sting", title = "Create sting", type = MediaType.DAT_API_POST),
			@InjectLink(value = "/stings?before={before}", style = Style.ABSOLUTE, rel = "previous", title = "Previous stings", type = MediaType.DAT_API_THREAD, bindings = { @Binding(name = "before", value = "${instance.oldestTimestamp}") }),
			@InjectLink(value = "/stings?after={after}", style = Style.ABSOLUTE, rel = "current", title = "Newest stings", type = MediaType.DAT_API_THREAD, bindings = { @Binding(name = "after", value = "${instance.newestTimestamp}") }) })
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}
	private String subject;
	private String content;
	private int idthread;
	private int idpost;
	private List<Post> posts;
	private String imagen;
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdthread() {
		return idthread;
	}
	public void setIdthread(int idthread) {
		this.idthread = idthread;
	}
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	}
}
