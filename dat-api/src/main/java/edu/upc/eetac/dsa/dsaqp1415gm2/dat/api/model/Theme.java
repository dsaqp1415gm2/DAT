package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Link;

import org.glassfish.jersey.linking.Binding;
import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.glassfish.jersey.linking.InjectLink.Style;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.MediaType;
import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.PostResource;

public class Theme {
	@InjectLinks({
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "create-sting", title = "Create thread", type = MediaType.DAT_API_POST_COLLECTION)})
private List<Link> links;

public List<Link> getLinks() {
	return links;
}

public void setLinks(List<Link> links) {
	this.links = links;
}

private List<PostCollection> threads;


public Theme() {
	super();
	threads = new ArrayList<>();
}

public List<PostCollection> getThreads() {
	return threads;
}

public void setThreads(List<PostCollection> threads) {
	this.threads = threads;
}

public void addThread(PostCollection thread) {
	threads.add(thread);
}
}
