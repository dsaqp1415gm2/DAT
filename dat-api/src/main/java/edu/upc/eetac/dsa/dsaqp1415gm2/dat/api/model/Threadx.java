package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;



public class Threadx {
	@InjectLinks({
		@InjectLink(value = "/Theme/{tema}/{idthread}", style = Style.ABSOLUTE, rel = "idthreadbytheme", title = "threads link by theme", type = MediaType.DAT_API_THREAD,bindings = { @Binding(name = "tema", value = "${instance.tema}"),@Binding(name = "idthread", value = "${instance.idthread}")}),
		@InjectLink(value = "/thread/{idthread}", style = Style.ABSOLUTE, rel = "idthread", title = "threads link", type = MediaType.DAT_API_THREAD,bindings = { @Binding(name = "tema", value = "${instance.tema}"),@Binding(name = "idthread", value = "${instance.idthread}")})})

	private List<Link> links;
	private String subject;
	private String content;
	private int idthread;
	private int idtema;
	private List<Post> posts;
	private String imagen;
	private String tema;
	public Threadx() {
		super();
		posts = new ArrayList<>();
	}
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
	public int getIdtema() {
		return idtema;
	}
	public void setIdtema(int idtema) {
		this.idtema = idtema;
		if (idtema==1)
		{
			setTema("Tecnologia");
		}
		if (idtema==2)
		{
			setTema("Deportes");
		}
		if (idtema==3)
		{
			setTema("Motor");
		}
		if (idtema==4)
		{
			setTema("Videojuegos");
		}
	}
	public void addPost(Post post) {
		posts.add(post);
	}
	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
}
