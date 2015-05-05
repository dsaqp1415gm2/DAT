package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavigationAdapter extends BaseAdapter {
    private Activity activity;
    ArrayList<Drawer_items> arrayitems;

    public NavigationAdapter(Activity activity, ArrayList<Drawer_items>  listarray) {
        super();
        this.activity = activity;
        this.arrayitems=listarray;
    }
    //Retorna objeto Item_objct del array list
    @Override
    public Object getItem(int position) {
        return arrayitems.get(position);
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayitems.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    //Declaramos clase estatica la cual representa a la fila
    public static class Fila
    {
        TextView titulo;
        ImageView icono;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Fila view;
        LayoutInflater inflator = activity.getLayoutInflater();
        if(convertView==null)
        {
            view = new Fila();
            //Creo objeto item y lo obtengo del array
            Drawer_items item=arrayitems.get(position);
            convertView = inflator.inflate(R.layout.drawer_list, null);
            //Titulo
            view.titulo = (TextView) convertView.findViewById(R.id.title_drawer_list);
            //Seteo en el campo titulo el nombre correspondiente obtenido del objeto
            view.titulo.setText(item.getTitle());
            //Icono
            view.icono = (ImageView) convertView.findViewById(R.id.icon_drawer_list);
            //Seteo el icono
            view.icono.setImageResource(item.getIcon());
            convertView.setTag(view);
        }
        else
        {
            view = (Fila) convertView.getTag();
        }
        return convertView;
    }
}