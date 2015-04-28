package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class DatMainActivity extends ActionBarActivity{
    //declaro el drawer y su listview
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] titulos;
    private ArrayList<Drawer_items> DwItems;
    private TypedArray DwIcons;
    NavigationAdapter NavAdapter;
    // declaro el boton para cambiarle la fuente
    protected Button customButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_main);
        //añado la toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DAT");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        //añado el drawer (menu lateral)
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.list_view);
        //Declarar el header
        View header = getLayoutInflater().inflate(R.layout.drawer_header, null);
        listView.addHeaderView(header);
        //Coger iconos i titulos
        DwIcons = getResources().obtainTypedArray(R.array.draw_icons);
        titulos = getResources().getStringArray(R.array.draw_titles);
        DwItems = new ArrayList<Drawer_items>();
        //Agregar los titulos e iconos a la lista del drawer
        DwItems.add(new Drawer_items(titulos[0], DwIcons.getResourceId(0, -1)));
        DwItems.add(new Drawer_items(titulos[1], DwIcons.getResourceId(1, -1)));
        DwItems.add(new Drawer_items(titulos[2], DwIcons.getResourceId(2, -1)));
        DwItems.add(new Drawer_items(titulos[3], DwIcons.getResourceId(3, -1)));
        DwItems.add(new Drawer_items(titulos[4], DwIcons.getResourceId(4, -1)));
        NavAdapter = new NavigationAdapter(this,DwItems);
        listView.setAdapter(NavAdapter);
        listView.setOnItemClickListener(new DrawerItemClickListener());
        //codigo para cambiarle la fuente al boton por la que he añadido en assets
        //tambien le añado un borde al texto con "shadow"
        customButton = (Button)findViewById(R.id.bt1);
        Typeface font = Typeface.createFromAsset(getAssets(),"BAUHS93.TTF");
        customButton.setTypeface(font);
        customButton.setShadowLayer(35, 0, 0, Color.WHITE);
        //repito con los demas (la fuente ahora esta en la variable "font")
        customButton = (Button)findViewById(R.id.bt2);
        customButton.setTypeface(font);
        customButton.setShadowLayer(35, 0, 0, Color.WHITE);
        customButton = (Button)findViewById(R.id.bt3);
        customButton.setTypeface(font);
        customButton.setShadowLayer(35, 0, 0, Color.WHITE);
        customButton = (Button)findViewById(R.id.bt4);
        customButton.setTypeface(font);
        customButton.setShadowLayer(35, 0, 0, Color.WHITE);

    }
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView arg0, View arg1, int arg2,
                                long arg3) {
            Toast.makeText(DatMainActivity.this, "Item: " + titulos[arg2-1],
                    Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
        }
    }
    //metodo para cerrar el drawer al pulsar el boton de ATRAS
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(listView)){ //replace this with actual function which returns if the drawer is open
            drawerLayout.closeDrawers();     // replace this with actual function which closes drawer
        }
        else{
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dat_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.home)
        {
            if (drawerLayout.isDrawerOpen(listView)) {
                drawerLayout.closeDrawers();
            } else {
                drawerLayout.openDrawer(listView);
            }
            return true;
        }
        if (id == R.id.action_about){
            Intent i = new Intent(this, About.class);
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void clickMe(View v) {
        Intent i = new Intent(this, TemaActivity.class);
        startActivity(i);
    }
    public void clickMe2(View v) {
        Intent i = new Intent(this, TemaActivity.class);
        startActivity(i);
    }
    public void clickMe3(View v) {
        Intent i = new Intent(this, TemaActivity.class);
        startActivity(i);
    }
    public void clickMe4(View v) {
        Intent i = new Intent(this, TemaActivity.class);
        startActivity(i);
    }

}
