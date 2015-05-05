package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLink.Style;
import org.glassfish.jersey.linking.InjectLinks;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.DATRootAPIResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.PostResource;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.ThreadResource;


public class DATRootAPI {
	@InjectLinks({
		@InjectLink(resource = DATRootAPIResource.class, style = Style.ABSOLUTE, rel = "self bookmark home", title = "DAT Root API"),
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "collection", title = "Show posts", type = MediaType.DAT_API_THREAD),
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "create-post", title = "Create new post", type = MediaType.DAT_API_POST),
	    @InjectLink(resource = ThreadResource.class, style = Style.ABSOLUTE, rel = "collection", title = "Show threads", type = MediaType.DAT_API_THEME),
	    @InjectLink(resource = ThreadResource.class, style = Style.ABSOLUTE, rel = "create-thread", title = "Create new thread", type = MediaType.DAT_API_THREAD) })
	private List<Link> links;

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}
}
