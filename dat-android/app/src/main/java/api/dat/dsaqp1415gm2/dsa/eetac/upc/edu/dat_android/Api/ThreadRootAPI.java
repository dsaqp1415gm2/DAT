package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

/**
 * Created by Manel on 09/04/2015.
 */
import java.util.HashMap;
import java.util.Map;

public class ThreadRootAPI {

    private Map<String, Link> links;

    public ThreadRootAPI() {
        links = new HashMap<String, Link>();
    }

    public Map<String, Link> getLinks() {
        return links;
    }

}