package com.example.nabhiraj.currencyrecoder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by nabhiraj on 11/12/2016.
 */
public class NewAdder extends DialogFragment {
EditText name,rollnumber,noteno,semester,section;
    Button save;
public Dialog onCreateDialog(Bundle bundle){
    View v= LayoutInflater.from(getActivity()).inflate(R.layout.fragment_newadder,null);
    name=(EditText)v.findViewById(R.id.name);
    rollnumber=(EditText)v.findViewById(R.id.rollnumber);
    section=(EditText)v.findViewById(R.id.section);
    semester=(EditText)v.findViewById(R.id.semester);
    noteno=(EditText)v.findViewById(R.id.notenumber);
    //save=(Button)v.findViewById(R.id.savebutton);
    return new AlertDialog.Builder(getActivity()).setTitle("enter the details...").setView(v).setNegativeButton("do nothing",null).setPositiveButton("save", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Logic logic=Logic.getLogic();
            People people=new People();
            people.name=name.getText().toString();
            people.rollnumber=rollnumber.getText().toString();
            people.semester=semester.getText().toString();
            people.section=section.getText().toString();
            people.moneyserial=noteno.getText().toString();
            logic.mylist.add(people);
            Toast.makeText(getActivity(),"datasaved",Toast.LENGTH_SHORT).show();
        }
    }).create();
    }
  }
