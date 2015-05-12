package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;


public class Threadx {
	private String subject;
	private String content;
	private int idthread;
	private int idtema;
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
	public int getIdtema() {
		return idtema;
	}
	public void setIdtema(int idtema) {
		this.idtema = idtema;
	}

}
