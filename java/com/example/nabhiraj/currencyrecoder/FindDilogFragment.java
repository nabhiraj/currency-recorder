package com.example.nabhiraj.currencyrecoder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

/**
 * Created by nabhiraj on 11/12/2016.
 */
public class FindDilogFragment extends DialogFragment {
    EditText noteno=null;
    TextView textView=null;
    Button button=null;
    public Dialog onCreateDialog(final Bundle bundle){
        View v= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_find,null);
        textView=(TextView)v.findViewById(R.id.textviewmy);
        noteno=(EditText)v.findViewById(R.id.editText);
        button=(Button)v.findViewById(R.id.findbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logic l = Logic.getLogic();
                Vector<People> m = l.mylist;
                String d=null;
                n:for (int i = 0; i < m.size(); i++) {
                    if (m.elementAt(i).moneyserial.equals(noteno.getText().toString())) {
                        d="name : "+m.elementAt(i).name+"\nrollnumber :"+m.elementAt(i).rollnumber+"\nsemester : "+m.elementAt(i).semester+"\nsection : "+m.elementAt(i).section+"\nnotenumber : "+m.elementAt(i).moneyserial;
                        break n;
                    }
                }
                // Toast.makeText(getActivity(),d,Toast.LENGTH_LONG).show();
                textView.setText(d);
                textView.setVisibility(View.VISIBLE);
                noteno.setVisibility(View.GONE);
                button.setVisibility(View.GONE);
            }
        });
        return new AlertDialog.Builder(getActivity()).setView(v).setTitle("enter the note number...").setNegativeButton("ok", null).create();
    }

}
