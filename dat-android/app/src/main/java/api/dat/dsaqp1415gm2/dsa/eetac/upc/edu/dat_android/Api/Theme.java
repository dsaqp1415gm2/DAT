package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Manel on 12/05/2015.
 */
public class Theme {
    private List<Threadx> threads;
    private Map<String, Link> links;
    public Theme() {
        super();
        threads = new ArrayList<Threadx>();
    }

    public List<Threadx> getThreads() {
        return threads;
    }

    public void setThreads(List<Threadx> threads) {
        this.threads = threads;
    }

    public void addThread(Threadx thread) {
        threads.add(thread);
    }
    public Map<String, Link> getLinks() {
        return links;
    }

}
