package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.apache.http.client.methods.HttpGet;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;


/**
 * Created by Manel on 21/04/2015.
 */
public class ThreadAdapter extends BaseAdapter {
    ArrayList<Threadx> data;
    LayoutInflater inflater;
    private Context context;
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
        TextView threadid;
        TextView letrasthread;
        ImageView imagen;
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
            viewHolder.letrasthread = (TextView) convertView
                    .findViewById(R.id.tvletrasthread);
            viewHolder.threadid = (TextView) convertView
                    .findViewById(R.id.tvIdthread);
            viewHolder.imagen = (ImageView) convertView
                    .findViewById(R.id.image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String subject = data.get(position).getSubject();
        String content = data.get(position).getContent();
        String imagen = data.get(position).getImagen();
        int idt= data.get(position).getIdthread();
        String id=Integer.toString(idt);
        viewHolder.tvSubject.setText(subject);
        viewHolder.tvContent.setText(content);
        viewHolder.letrasthread.setText("Thread ID: ");
        viewHolder.threadid.setText(id);
        new DownloadImageTask(viewHolder.imagen).execute(imagen);
        //Picasso.with(context).load("http://matrallune.com/images/imagen_corporativa.jpg").into(viewHolder.imagen);
        /*Bitmap bitmap = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL("www.matrallune.com/images/imagen_corporativa.jpg");
            //bitmap = BitmapFactory.decodeStream((InputStream)new URL("www.matrallune.com/images/imagen_corporativa.jpg").getContent());
            //bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.setUseCaches(false);
            urlConnection.connect();
            InputStream is = urlConnection.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        viewHolder.imagen.setImageBitmap(bitmap);*/
        return convertView;
    }
    public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        private ImageView imageView;
        private Bitmap image;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                image = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                image = null;
            }
            return image;
        }

        @SuppressLint("NewApi")
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                imageView.setImageBitmap(result);
            }
        }
    }
}
