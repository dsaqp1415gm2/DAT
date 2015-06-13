package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.TabPager;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys.About;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys.ThreadActivity;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Post;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Theme;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAdapter;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

public class FragmentTab extends Fragment{
    private final static String TAG = FragmentTab.class.getName();
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView list;
    private ThreadAdapter adapter;
    ArrayList<Threadx> threadList;
    public static final int RESULT_OK = -1;
    public int nthread;
    private int id;
    private String username;
    private String password;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Get the view from fragmenttabxml
        View view = inflater.inflate(R.layout.fragmenttab, container, false);
        //a�adir actualizar
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutListener());
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
        //a�adir lista
        threadList = new ArrayList<Threadx>();
        adapter = new ThreadAdapter(getActivity(),threadList);
        list=(ListView) view.findViewById(R.id.list);
        list.setAdapter(adapter);
        SharedPreferences prefs = getActivity().getSharedPreferences("dat-profile",
                Context.MODE_PRIVATE);
        username = prefs.getString("username", null);
        password = prefs.getString("password", null);
        new FetchThemeTask().execute();
        //a�adir opcion al pulsar item de lista
        list.setOnItemClickListener(new ListItemClickListener());
        if((username!=null)&&(password!=null)) {
            list.setOnItemLongClickListener(new ListItemLongClickListener());
        }
        return view;
    }

    private class FetchThemeTask extends
            AsyncTask<Void, Void, Theme> {
        private ProgressDialog pd;

        @Override
        protected Theme doInBackground(Void... params) {
            Theme theme = null;
            try {
                theme = ThreadAPI.getInstance(getActivity()).getThreads(id);
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
        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(getActivity());
            pd.setTitle("Cargando Threads...");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }
    }

    private void addThreads(Theme theme){
        threadList.addAll(theme.getThreads());
        adapter.notifyDataSetChanged();
    }
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView arg0, View arg1, int posicion, long arg3)
        {
            String idthread = ((TextView) arg1.findViewById(R.id.tvIdthread)).getText().toString();
            nthread = Integer.parseInt(idthread);
            Threadx threadx = threadList.get(posicion);
            //Toast.makeText(getActivity(),"Pulsado "+id+" y "+ntrhead,Toast.LENGTH_SHORT).show();
            Intent q = new Intent(getActivity(), ThreadActivity.class);
            q.putExtra("tema", id);
            q.putExtra("thread", nthread);
            q.putExtra("url", threadx.getLinks().get("idthread").getTarget());
            startActivityForResult(q, WRITE_ACTIVITY);
        }
    }
    private class ListItemLongClickListener implements ListView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView arg0, View arg1, int posicion, long arg3)
        {
            String idthread = ((TextView) arg1.findViewById(R.id.tvIdthread)).getText().toString();
            nthread = Integer.parseInt(idthread);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Eliminarás este thread").setMessage("Estás seguro?").setPositiveButton("Si", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    new FetchDeleteTask().execute();
                    threadList.clear();
                    adapter.notifyDataSetChanged();
                    new FetchThemeTask().execute();
                }
            }).setNegativeButton("No", null).show();
            return true;
        }
    }
    public void setID(int i)
    {
        id = i;
    }

    private class SwipeRefreshLayoutListener implements SwipeRefreshLayout.OnRefreshListener {
        @Override
        public void onRefresh() {
            swipeRefreshLayout.setRefreshing(true);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    threadList.clear();
                    adapter.notifyDataSetChanged();
                    new FetchThemeTask().execute();
                    swipeRefreshLayout.setRefreshing(false);
                }
            }, 2500);
        }
    }

    //para actualizar los threads despues de crear uno
    private final static int WRITE_ACTIVITY = 0;
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case WRITE_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    /*Bundle res = data.getExtras();
                    String jsonThread = res.getString("json-thread");
                    Threadx threadx = new Gson().fromJson(jsonThread, Threadx.class);
                    threadList.add(0, threadx);
                    adapter.notifyDataSetChanged();*/
                    threadList.clear();
                    adapter.notifyDataSetChanged();
                    new FetchThemeTask().execute();
                }
                break;
        }
    }
    private class FetchDeleteTask extends
            AsyncTask<Void, Void, Theme> {
        private ProgressDialog pd;

        @Override
        protected Theme doInBackground(Void... params) {
            Theme theme = new Theme();
            try {
                ThreadAPI.getInstance(getActivity()).deleteThread(nthread);
            } catch (AppException e) {
                e.printStackTrace();
            }
            return theme;
        }
    }
}