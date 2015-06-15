package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.DATRootAPIResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.PostResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.ThemeResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.ThreadResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.UserResource;

public class DATRootAPI {
	@InjectLinks({
        @InjectLink(resource = DATRootAPIResource.class, style = Style.ABSOLUTE, rel = "self bookmark home", title = "DAT Root API"),
        @InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "post", title = "post", type = MediaType.DAT_API_POST),
    	@InjectLink(resource = ThreadResource.class, style = Style.ABSOLUTE, rel = "thread", title = "post collecction", type = MediaType.DAT_API_THREAD),
    	@InjectLink(resource = UserResource.class, style = Style.ABSOLUTE, rel = "user", title = "users", type = MediaType.DAT_API_USER),
    	@InjectLink(resource = ThemeResource.class, style = Style.ABSOLUTE, rel = "theme", title = "thread collection", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/users/login", style = Style.ABSOLUTE, rel = "login", title = "Login Users", type = MediaType.DAT_API_USER),
		@InjectLink(value = "/thread/post", style = Style.ABSOLUTE, rel = "posting", title = "create post", type = MediaType.DAT_API_POST),
		@InjectLink(value = "/Theme/Tecnologia", style = Style.ABSOLUTE, rel = "tecnologia", title = "tema tecnologia", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Deportes", style = Style.ABSOLUTE, rel = "deportes", title = "tema deportes", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Motor", style = Style.ABSOLUTE, rel = "motor", title = "tema motor", type = MediaType.DAT_API_THEME),
		@InjectLink(value = "/Theme/Videojuegos", style = Style.ABSOLUTE, rel = "videojuegos", title = "tema videojuegos", type = MediaType.DAT_API_THEME)
})
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
