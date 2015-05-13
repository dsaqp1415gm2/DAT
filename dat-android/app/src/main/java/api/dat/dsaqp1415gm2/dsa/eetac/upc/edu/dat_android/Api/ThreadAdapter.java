package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.TabPager.FragmentTab;

/**
 * Created by Manel on 21/04/2015.
 */
public class ThreadAdapter extends BaseAdapter {
    ArrayList<Threadx> data;
    LayoutInflater inflater;
    public ThreadAdapter(Context context, ArrayList<Threadx> data) {
        super();
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private static class ViewHolder {
        TextView tvSubject;
        TextView tvContent;
        ImageView image;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_row_thread, null);
            viewHolder = new ViewHolder();
            viewHolder.tvSubject = (TextView) convertView
                    .findViewById(R.id.tvSubject);
            viewHolder.tvContent = (TextView) convertView
                    .findViewById(R.id.tvContent);
            viewHolder.image = (ImageView) convertView
                    .findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String subject = data.get(position).getSubject();
        String content = data.get(position).getContent();
        String imagen = data.get(position).getImagen();
        viewHolder.tvSubject.setText(subject);
        viewHolder.tvContent.setText(content);
      /*  URL url = new URL(imagen);
        //try this url = "http://0.tqn.com/d/webclipart/1/0/5/l/4/floral-icon-5.jpg"
        HttpGet httpRequest = null;

        httpRequest = new HttpGet(url.toURI());

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response = (HttpResponse) httpclient
                .execute(httpRequest);

        HttpEntity entity = response.getEntity();
        BufferedHttpEntity b_entity = new BufferedHttpEntity(entity);
        InputStream input = b_entity.getContent();

        Bitmap bitmap = BitmapFactory.decodeStream(input);
        viewHolder.image.setImageBitmap(bitmap);*/
        return convertView;
    }
}
