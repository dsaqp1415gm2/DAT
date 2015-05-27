package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Manel on 12/05/2015.
 */
public class Threadx {
    private int idthread;
    private int idtema;
    private String subject;
    private String content;
    private List<Post> posts;

    public Map<String, Link> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    private Map<String, Link> links = new HashMap<String, Link>();

    public Threadx() {
        super();
        posts = new ArrayList<Post>();
    }
    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    private String imagen;

}
