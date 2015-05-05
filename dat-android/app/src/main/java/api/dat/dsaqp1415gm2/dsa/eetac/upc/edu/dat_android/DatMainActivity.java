package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class DatMainActivity extends ActionBarActivity {
    //declaro el drawer y su listview
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private ListView listView;
    private String[] titulos;
    private ArrayList<Drawer_items> DwItems;
    private TypedArray DwIcons;
    NavigationAdapter NavAdapter;
    private ViewPager viewPager;
    private Toolbar toolbar;
    SlidingTabLayout tabs;
    ViewPagerAdapter adapterViewPager;
    // declaro el boton para cambiarle la fuente
    protected Button customButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_main);
        //añado la toolbar
        setToolbar();
        //añado el drawer (menu lateral)
        setDrawerLayout();
        //añadir el viewPager con los tabs
        setViewPager();
        //añadir el refresh

    }
    //coge la toolbar del xml y le añade titulo y algun boton
    public void setToolbar()
    {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("DAT");
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //coge el drawer creado en el activity_main y le añade el header y la lista
    public void setDrawerLayout()
    {
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
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,  R.string.app_name, R.string.app_name) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);

                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };


        // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(drawerToggle);

        drawerToggle.syncState();
    }
    //coge el viewPager creado en el activity_main y le añade las tabs creadas
    public void setViewPager()
    {
        // Locate the viewpager in activity_main.xml
        viewPager = (ViewPager) findViewById(R.id.pager);
        // Set the ViewPagerAdapter into ViewPager
        adapterViewPager = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tab_strip);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.accent_color);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(viewPager);
    }



    //define que sucede al clicar en un item del drawer
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView arg0, View arg1, int posicion, long arg3)
        {
            if (posicion-1 < 0)
            {
                drawerLayout.closeDrawers();
            }
            else
            {
                itemDrawerPulsado(posicion - 1);
                drawerLayout.closeDrawers();
            }
        }
    }
    //opciones al clickar en un item del drawer
    private void itemDrawerPulsado (int opcion)
    {
        switch (opcion)
        {
            case 0:
                viewPager.setCurrentItem(opcion);
                break;
            case 1:
                viewPager.setCurrentItem(opcion);
                break;
            case 2:
                viewPager.setCurrentItem(opcion);
                break;
            case 3:
                viewPager.setCurrentItem(opcion);
                break;
            case 4:
                Intent i4 = new Intent(this, About.class);
                startActivity(i4);
                break;

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
    //crea el menu de la derecha
    @Override
    //crea el menu de opciones a la derecha de la toolbar
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dat_main, menu);
        return true;
    }
    //opciones al clikar en los items de menu
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
}
