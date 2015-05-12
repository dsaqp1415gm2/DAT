package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.DATRootAPI;

@Path("/")
public class DATRootAPIResource {
	@GET
	public DATRootAPI getRootAPI() {
		DATRootAPI api = new DATRootAPI();
		return api;
	}
}
