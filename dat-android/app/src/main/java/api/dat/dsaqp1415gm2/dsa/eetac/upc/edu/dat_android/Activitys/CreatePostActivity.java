package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Post;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 27/05/2015.
 */
public class CreatePostActivity extends ActionBarActivity {
    public Activity c;
    public Dialog d;
    public EditText urlImagen;
    public EditText content;
    public int idthread;
    public int idtema;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posting_post_layout);
        setToolbar();
        idtema = (int) getIntent().getExtras().get("idtema");
        idthread = (int) getIntent().getExtras().get("idthread");
        urlImagen=(EditText) findViewById(R.id.post_et2);
        content= (EditText) findViewById(R.id.post_et3);
    }
    private void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle("Responder");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    //crea el menu de opciones a la derecha de la toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_create_thread, menu);
        return true;
    }
    //opciones al clikar en los items de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_create){
            if ((content.getText().toString().equals("")) || (urlImagen.getText().toString().equals("")))
            {
                Toast.makeText(this,"Faltan campos por rellenar",Toast.LENGTH_SHORT).show();
            }
            else {
                new FetchCreateThreadTask().execute();
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class FetchCreateThreadTask extends
            AsyncTask<Void, Void, Post> {
        private ProgressDialog pd;

        @Override
        protected Post doInBackground(Void... params) {
            Post post = null;

            try {
                ThreadAPI.getInstance(CreatePostActivity.this).createPost(idtema, idthread, content.getText().toString(),
                        urlImagen.getText().toString());
            } catch (AppException e) {
                e.printStackTrace();
            }
            return post;
        }
        @Override
        protected void onPostExecute(Post result) {
            showPost(result);
            if (pd != null) {
                pd.dismiss();
            }
        }

    }
    private void showPost(Post result) {
        String json = new Gson().toJson(result);
        Bundle data = new Bundle();
        data.putString("json-post", json);
        Intent intent = new Intent();
        intent.putExtras(data);
        setResult(RESULT_OK, intent);
        finish();
    }
}