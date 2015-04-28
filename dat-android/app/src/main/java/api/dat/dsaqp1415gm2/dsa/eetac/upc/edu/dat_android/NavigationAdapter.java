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
    ArrayList<Drawer_items> arrayitms;

    public NavigationAdapter(Activity activity,ArrayList<Drawer_items>  listarry) {
        super();
        this.activity = activity;
        this.arrayitms=listarry;
    }
    //Retorna objeto Item_objct del array list
    @Override
    public Object getItem(int position) {
        return arrayitms.get(position);
    }
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayitms.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    //Declaramos clase estatica la cual representa a la fila
    public static class Fila
    {
        TextView titulo_itm;
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
            Drawer_items itm=arrayitms.get(position);
            convertView = inflator.inflate(R.layout.drawer_list, null);
            //Titulo
            view.titulo_itm = (TextView) convertView.findViewById(R.id.title_drawer_list);
            //Seteo en el campo titulo el nombre correspondiente obtenido del objeto
            view.titulo_itm.setText(itm.getTitle());
            //Icono
            view.icono = (ImageView) convertView.findViewById(R.id.icon_drawer_list);
            //Seteo el icono
            view.icono.setImageResource(itm.getIcon());
            convertView.setTag(view);
        }
        else
        {
            view = (Fila) convertView.getTag();
        }
        return convertView;
    }
}