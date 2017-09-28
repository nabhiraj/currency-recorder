package com.example.nabhiraj.currencyrecoder;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;

public class MainActivity extends AppCompatActivity {
    Button newbutton,refresbutton,find;
    TextView console;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newbutton=(Button)findViewById(R.id.addnew);
        refresbutton=(Button)findViewById(R.id.refreshbutton);
        find=(Button)findViewById(R.id.find);
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //now we will make a new dilog fragment
                FragmentManager fragmentManager=getSupportFragmentManager();
                FindDilogFragment findDilogFragment=new FindDilogFragment();
                findDilogFragment.show(fragmentManager,"find");
             //   console.setText(Logic.data);
            }
        });
        console=(TextView)findViewById(R.id.consoleid);
        dataReformer();
        newbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getSupportFragmentManager();
                NewAdder newAdder=new NewAdder();
                newAdder.show(fragmentManager,"newadder");
            }
        });

        //now code for refresh button.
       // final StringBuffer stringBuffer=new StringBuffer();
        refresbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 StringBuffer stringBuffer=new StringBuffer();
                Logic l=Logic.getLogic();
                for(int i=0;i<l.mylist.size();i++){
                    stringBuffer.append("name : "+l.mylist.elementAt(i).name+"\nrollnumber : "+l.mylist.elementAt(i).rollnumber+"\nsemester : "+l.mylist.elementAt(i).semester+"\nsection : "+l.mylist.elementAt(i).section+"\nnote number : "+l.mylist.elementAt(i).moneyserial+"\n\n\n\n");
                }
                console.setText(stringBuffer.toString());
            }
        });

    }
    public void onPause(){
        super.onPause();
        Logic l=Logic.getLogic();
        OutputStream outputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try {
             outputStream=openFileOutput("jo.txt",MODE_PRIVATE);
             objectOutputStream=new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(l);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(objectOutputStream!=null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public void dataReformer(){
        InputStream inputStream=null;
        ObjectInputStream objectInputStream=null;
        try {
             inputStream=openFileInput("jo.txt");
             objectInputStream=new ObjectInputStream(inputStream);
            Logic.getLogic().putLogic((Logic) objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (StreamCorruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}