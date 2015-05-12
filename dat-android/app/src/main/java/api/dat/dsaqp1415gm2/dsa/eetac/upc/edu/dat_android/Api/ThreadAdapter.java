package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
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
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        String subject = data.get(position).getSubject();
        String content = data.get(position).getContent();
        viewHolder.tvSubject.setText(subject);
        viewHolder.tvContent.setText(content);
        return convertView;
    }
}
