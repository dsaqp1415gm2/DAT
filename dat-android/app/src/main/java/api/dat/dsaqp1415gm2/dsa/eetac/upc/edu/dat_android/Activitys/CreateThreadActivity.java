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
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.gson.Gson;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 27/05/2015.
 */
public class CreateThreadActivity extends ActionBarActivity {
    public Activity c;
    public Dialog d;
    public Button post, cancel;
    public EditText subject;
    public EditText urlImagen;
    public EditText content;
    public RadioGroup radioGroup;
    public int idx;
    int radioButtonID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posting_thread_layout);
        setToolbar();
        subject= (EditText) findViewById(R.id.post_et1);
        urlImagen=(EditText) findViewById(R.id.post_et2);
        content= (EditText) findViewById(R.id.post_et3);
        radioGroup =(RadioGroup) findViewById(R.id.RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                //RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                //String text = checkedRadioButton.getText().toString();
                idx = checkedId;
            }
        });
    }
    private void setToolbar()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle("Crear Thread");
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
            if ((subject.getText().toString().equals(""))||(content.getText().toString().equals(""))
                    || (urlImagen.getText().toString().equals(""))||(idx==0))
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
            AsyncTask<Void, Void, Threadx> {
        private ProgressDialog pd;

        @Override
        protected Threadx doInBackground(Void... params) {
            Threadx threadx = null;

            try {
                ThreadAPI.getInstance(CreateThreadActivity.this).createThread(idx, subject.getText().toString(), content.getText().toString(),
                        urlImagen.getText().toString());
            } catch (AppException e) {
                e.printStackTrace();
            }
            return threadx;
        }
        @Override
        protected void onPostExecute(Threadx result) {
            //Toast.makeText(getOwnerActivity(),"THREAD CREADO",Toast.LENGTH_SHORT).show();
            showThread(result);
            if (pd != null) {
                pd.dismiss();
            }
        }

    }
    private void showThread(Threadx result) {
        String json = new Gson().toJson(result);
        Bundle data = new Bundle();
        data.putString("json-sting", json);
        Intent intent = new Intent();
        intent.putExtras(data);
        setResult(RESULT_OK, intent);
        finish();
    }
}