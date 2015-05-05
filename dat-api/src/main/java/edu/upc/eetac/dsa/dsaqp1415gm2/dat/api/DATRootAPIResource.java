package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import edu.upc.eetac.dsa.dsaqp1415gm2.dat.api.model.DATRootAPI;



public class DATRootAPIResource {
	@Path("/")
	public class BeeterRootAPIResource {
		@GET
		public DATRootAPI getRootAPI() {
			DATRootAPI api = new DATRootAPI();
			return api;
		}
	}
}
