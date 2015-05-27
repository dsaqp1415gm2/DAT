package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

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
    private String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tema = (int) getIntent().getExtras().get("tema");
        thread = (int) getIntent().getExtras().get("thread");
        url = (String) getIntent().getExtras().get("url");
        setContentView(R.layout.postlist_layout);
        //añadir lista
        setList();
        //añadir toolbar
        setToolbar();
        //añadir actualizar
        setSwipeRefresh();
        //empezar tareas
        new FetchThreadTask().execute();
    }
    private void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle("Thread #" + thread);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private void setList()
    {
        postList = new ArrayList<Post>();
        adapter = new PostAdapter(ThreadActivity.this, postList);
        list=(ListView) findViewById(R.id.post_list);
        list.setAdapter(adapter);
    }
    private void setSwipeRefresh()
    {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout2);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutListener());
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light);
    }
    private class FetchThreadTask extends
            AsyncTask<Void, Void, Threadx> {
        private ProgressDialog pd;

        @Override
        protected Threadx doInBackground(Void... params) {
            Threadx threadx = null;

            try {
                threadx = ThreadAPI.getInstance(ThreadActivity.this).getPosts(url);
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
        @Override
        protected void onPreExecute() {
            pd = new ProgressDialog(ThreadActivity.this);
            pd.setTitle("Cargando Posts...");
            pd.setCancelable(true);
            pd.setIndeterminate(true);
            pd.show();
        }
    }
    private void addPosts(Threadx threadx){
        postList.addAll(threadx.getPosts());
        adapter.notifyDataSetChanged();
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
    public void clickPostingPost (View view)
    {
        
    }
}
