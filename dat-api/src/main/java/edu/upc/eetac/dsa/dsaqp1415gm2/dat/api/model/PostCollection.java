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

public class PostCollection {
	@InjectLinks({
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "create-sting", title = "Create sting", type = MediaType.DAT_API_POST),
		@InjectLink(value = "/stings?before={before}", style = Style.ABSOLUTE, rel = "previous", title = "Previous stings", type = MediaType.DAT_API_POST_COLLECTION, bindings = { @Binding(name = "before", value = "${instance.oldestTimestamp}") }),
		@InjectLink(value = "/stings?after={after}", style = Style.ABSOLUTE, rel = "current", title = "Newest stings", type = MediaType.DAT_API_POST_COLLECTION, bindings = { @Binding(name = "after", value = "${instance.newestTimestamp}") }) })
private List<Link> links;

public List<Link> getLinks() {
	return links;
}

public void setLinks(List<Link> links) {
	this.links = links;
}

private List<Post> posts;
private long newestTimestamp;
private long oldestTimestamp;

public long getNewestTimestamp() {
	return newestTimestamp;
}

public void setNewestTimestamp(long newestTimestamp) {
	this.newestTimestamp = newestTimestamp;
}

public long getOldestTimestamp() {
	return oldestTimestamp;
}

public void setOldestTimestamp(long oldestTimestamp) {
	this.oldestTimestamp = oldestTimestamp;
}

public PostCollection() {
	super();
	posts = new ArrayList<>();
}

public List<Post> getPosts() {
	return posts;
}

public void setPosts(List<Post> posts) {
	this.posts = posts;
}

public void addPost(Post post) {
	posts.add(post);
}
}
