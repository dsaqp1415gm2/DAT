package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Manel on 12/05/2015.
 */
public class Theme {
    private List<Threadx> threads;
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

}
