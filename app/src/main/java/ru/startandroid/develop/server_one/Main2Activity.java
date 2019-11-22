package ru.startandroid.develop.server_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    String[] array={};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




         final ListView lvMain2 = ( ListView ) findViewById( R.id.lv2 );


        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

        DatabaseReference usersdRef = rootRef.child("Пользователь");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {



                  String data = ds.child("дата").getValue(String.class);
                  String flight = ds.child("рейс").getValue(String.class);
                  String phone  = ds.child("phone").getValue(String.class);


                    Log.d("TAG", phone+"  "+data+"  "+"Рейс номер"+flight);
                    //edit_text.setText(phone+"  "+data+"  "+"Рейс номер"+flight);


                }
                ArrayAdapter<String> adapter = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_1,array);
                lvMain2.setAdapter(adapter);

               //ArrayList<String> myList=new ArrayList<String>(  );
                //myList.add( data );

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        usersdRef.addListenerForSingleValueEvent(valueEventListener);
    }



    }

