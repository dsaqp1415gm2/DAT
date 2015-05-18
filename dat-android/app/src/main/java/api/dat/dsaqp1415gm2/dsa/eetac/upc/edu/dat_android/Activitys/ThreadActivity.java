package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Post;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.PostAdapter;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 18/05/2015.
 */
public class ThreadActivity extends ActionBarActivity{
    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView list;
    private PostAdapter adapter;
    ArrayList<Post> postList;
    private int tema;
    private int thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = (int) getIntent().getExtras().get("tema");
        thread = (int) getIntent().getExtras().get("thread");
        setContentView(R.layout.postlist_layout);
        //añadir lista
        postList = new ArrayList<Post>();
        adapter = new PostAdapter(ThreadActivity.this, postList);
        list=(ListView) findViewById(R.id.post_list);
        list.setAdapter(adapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle("Thread");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //añadir actualizar
        setSwipeRefresh();
        (new FetchStingsTask()).execute();
        //añadir opcion al pulsar item de lista
        list.setOnItemClickListener(new ListItemClickListener());
    }

    private void setSwipeRefresh()
    {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutListener());
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
    }
    private class FetchStingsTask extends
            AsyncTask<Void, Void, Threadx> {
        private ProgressDialog pd;

        @Override
        protected Threadx doInBackground(Void... params) {
            Threadx threadx = null;

            try {
                threadx = ThreadAPI.getInstance(ThreadActivity.this).getPosts(tema, thread);
            } catch (AppException e) {
                e.printStackTrace();
            }
            return threadx;
        }
        @Override
        protected void onPostExecute(Threadx result) {
            addPosts(result);
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

    private void addPosts(Threadx threadx){
        postList.addAll(threadx.getPosts());
        adapter.notifyDataSetChanged();
    }
    private class ListItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView arg0, View arg1, int posicion, long arg3)
        {
            Toast.makeText(ThreadActivity.this, "Pulsado", Toast.LENGTH_SHORT).show();
        }
    }

    private class SwipeRefreshLayoutListener implements SwipeRefreshLayout.OnRefreshListener {
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
    }
}
