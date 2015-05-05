package edu.upc.eetac.dsa.dsaqp1415gm2.dat.api;

import org.glassfish.jersey.linking.DeclarativeLinkingFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class DATApplication extends ResourceConfig{
	public DATApplication(){//cambio para commit
		super();
		register(DeclarativeLinkingFeature.class);
	}
}
