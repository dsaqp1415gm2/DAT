package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.Post;


@Path("/theme")
public class ThemeResource {


	@GET
	@Produces("application/json")
	public Post getSting() {
		// Create CacheControl
	 
		Post post = new Post();
		post.setContent("hola");
		post.setIdpost(1);
		post.setIdthema(2);

	 
		return post;
	}
	
	
}
