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
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Theme;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAdapter;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

public class FragmentTab extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView list;
    private ThreadAdapter adapter;
    ArrayList<Threadx> threadList;

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

        threadList = new ArrayList<Threadx>();
        adapter = new ThreadAdapter(getActivity(),threadList);
        list=(ListView) view.findViewById(R.id.list);
        list.setAdapter(adapter);
        (new FetchStingsTask()).execute();
        list.setOnItemClickListener(new ListItemClickListener());
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
        private ProgressDialog pd;

        @Override
        protected Theme doInBackground(Void... params) {
            Theme theme = null;
            try {
                theme = ThreadAPI.getInstance(getActivity()).getThreads();
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
        /*@Override
        protected void onPreExecute() {
            pd = new ProgressDialog(getActivity());
            pd.setTitle("Searching...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }*/
    }

    private void addThreads(Theme theme){
        threadList.addAll(theme.getThreads());
        adapter.notifyDataSetChanged();
    }
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView arg0, View arg1, int posicion, long arg3)
        {
            Toast.makeText(getActivity(),"Pulsado",Toast.LENGTH_SHORT).show();
        }
    }
}