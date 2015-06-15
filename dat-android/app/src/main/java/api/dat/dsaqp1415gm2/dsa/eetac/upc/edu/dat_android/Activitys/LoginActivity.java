package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Activitys;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Post;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.User;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 09/06/2015.
 */
public class LoginActivity extends ActionBarActivity {
    public Activity c;
    public Dialog d;
    public EditText user;
    public EditText pass;
    String username;
    String password;
    private final static String TAG = LoginActivity.class.getName();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        setToolbar();
        user = (EditText) findViewById(R.id.log_et1);
        pass = (EditText) findViewById(R.id.log_et2);
        SharedPreferences prefs = getSharedPreferences("dat-profile",
                Context.MODE_PRIVATE);
        String username = prefs.getString("username", null);
        String password = prefs.getString("password", null);
    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    //crea el menu de opciones a la derecha de la toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    //opciones al clikar en los items de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logear) {

            if ((user.getText().toString().equals("")) || (pass.getText().toString().equals(""))) {
                Toast.makeText(this, "Faltan campos por rellenar", Toast.LENGTH_SHORT).show();
            } else {
                username = user.getText().toString();
                password = pass.getText().toString();
                new FetchLoginTask().execute();

            }

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class FetchLoginTask extends
            AsyncTask<Void, Void, User> {
        private ProgressDialog pd;

        @Override
        protected User doInBackground(Void... params) {
            User user = null;

            try {
                user = ThreadAPI.getInstance(LoginActivity.this).loginUser(username, password);
            } catch (AppException e) {
                e.printStackTrace();
            }
            return user;
        }
        @Override
        protected void onPostExecute(User result) {
            setLog(result);
            if (pd != null) {
                pd.dismiss();
            }
        }
    }
    private void setLog(User user){
        if (user.isLoginSuccesful()==true)
        {
            SharedPreferences prefs = getSharedPreferences("dat-profile",
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.clear();
            editor.putString("username", username);
            editor.putString("password", password);
            boolean done = editor.commit();
            if (done) {
                Log.d(TAG, "preferences set");
                Intent i = new Intent(this, DatMainActivity.class);
                startActivity(i);
            } else{
                Log.d(TAG, "preferences not set. THIS A SEVERE PROBLEM");
            }
        } else{
            Toast.makeText(LoginActivity.this, "Contraseña o Usuario incorrecto", Toast.LENGTH_SHORT).show();
        }
    }
}