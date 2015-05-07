package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 07/05/2015.
 */
public class Dialog_post extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button post, cancel;

    public Dialog_post(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.post_layout);
        post = (Button) findViewById(R.id.post_bt2);
        cancel = (Button) findViewById(R.id.post_bt1);
        post.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.post_bt1:
                dismiss();
                break;
            case R.id.post_bt2:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
