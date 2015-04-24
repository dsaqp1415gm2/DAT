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
		@InjectLink(resource = PostResource.class, style = Style.ABSOLUTE, rel = "create-sting", title = "Create thread", type = MediaType.DAT_API_THREAD),
		@InjectLink(value = "/threads?before={before}", style = Style.ABSOLUTE, rel = "previous", title = "Previous thread", type = MediaType.DAT_API_THEME, bindings = { @Binding(name = "before", value = "${instance.oldestTimestamp}") }),
		@InjectLink(value = "/thread?after={after}", style = Style.ABSOLUTE, rel = "current", title = "Newest thread", type = MediaType.DAT_API_THEME, bindings = { @Binding(name = "after", value = "${instance.newestTimestamp}") }) })
private List<Link> links;

public List<Link> getLinks() {
	return links;
}

public void setLinks(List<Link> links) {
	this.links = links;
}

private List<Thread> threads;
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

public Theme() {
	super();
	threads = new ArrayList<>();
}

public List<Thread> getThreads() {
	return threads;
}

public void setThreads(List<Thread> threads) {
	this.threads = threads;
}

public void addThread(Thread thread) {
	threads.add(thread);
}
}
