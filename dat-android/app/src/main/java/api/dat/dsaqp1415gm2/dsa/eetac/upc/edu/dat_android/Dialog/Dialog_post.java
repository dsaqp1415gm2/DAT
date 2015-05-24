package api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.AppException;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.ThreadAPI;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.Api.Threadx;
import api.dat.dsaqp1415gm2.dsa.eetac.upc.edu.dat_android.R;

/**
 * Created by Manel on 07/05/2015.
 */
public class Dialog_post extends Dialog implements android.view.View.OnClickListener {
    public Activity c;
    public Dialog d;
    public Button post, cancel;
    public EditText subject;
    public EditText urlImagen;
    public EditText content;
    public RadioGroup radioGroup;
    public int idx;
    int radioButtonID;

    public Dialog_post(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.posting_thread_layout);
        subject= (EditText) findViewById(R.id.post_et1);
        urlImagen=(EditText) findViewById(R.id.post_et2);
        content= (EditText) findViewById(R.id.post_et3);
        radioGroup =(RadioGroup) findViewById(R.id.RadioGroup);
        radioButtonID = radioGroup.getCheckedRadioButtonId();
        View radioButton = radioGroup.findViewById(radioButtonID);
        idx = radioGroup.indexOfChild(radioButton);
        idx = idx + 2;
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
                try {
                    ThreadAPI.getInstance(getOwnerActivity()).createThread(idx,subject.getText().toString(),content.getText().toString(),
                            urlImagen.getText().toString());
                } catch (AppException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
        dismiss();
    }
}
