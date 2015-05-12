package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.TabPager;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Theme;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPITecnologia;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAdapter;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

public class FragmentTab extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private ThreadAdapter adapter;
    ArrayList<Threadx> threadList;
    private ProgressDialog pd;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttabxml
        View view = inflater.inflate(R.layout.fragmenttab, container, false);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
        listView = (ListView) listView.findViewById(R.id.list);
        threadList = new ArrayList<Threadx>();
        adapter = new ThreadAdapter(getActivity(),threadList);
        listView.setAdapter(adapter);
        return view;
    }
    @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 2500);
    }
    private class FetchStingsTask extends
            AsyncTask<Void, Void, Theme> {


        @Override
        protected Theme doInBackground(Void... params) {
            Theme theme = null;
            try {
                theme = ThreadAPITecnologia.getInstance(getActivity()).getThreads();
            } catch (AppException e) {
                e.printStackTrace();
            }
            return theme;
        }
        @Override
        protected void onPostExecute(Theme result) {
            addThreads(result);
            if (pd != null) {
                pd.dismiss();
            }
        }
    }

    private void addThreads(Theme theme){
        threadList.addAll(theme.getThreads());
        adapter.notifyDataSetChanged();
    }
}