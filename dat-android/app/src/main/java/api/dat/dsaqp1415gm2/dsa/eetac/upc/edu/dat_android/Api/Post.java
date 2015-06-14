package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Manel on 12/05/2015.
 */
public class Post {
    private String content;
    private String image;
    public Map<String, Link> getLinks() {
        return links;
    }

    public void setLinks(Map<String, Link> links) {
        this.links = links;
    }

    private Map<String, Link> links = new HashMap<String, Link>();

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    private int idpost;
    private int idthema;
    private int idhilo;
}
