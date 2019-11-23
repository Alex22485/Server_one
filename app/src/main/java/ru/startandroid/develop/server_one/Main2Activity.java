package ru.startandroid.develop.server_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    //Добавлено
    ListView lv2;
    List<String> basa=new ArrayList<String>(  );
    ArrayAdapter ad;

    String[] array={"Alex","Jon","Kate"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Добавил
        lv2=findViewById( R.id.lv2 );
        basa=new ArrayList<String>( Arrays.asList( array ) );
        ad= new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,basa );
        lv2.setAdapter( ad );




       //  final ListView lvMain2 = ( ListView ) findViewById( R.id.lv2 );


        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

        DatabaseReference usersdRef = rootRef.child("Пользователь");

        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {



                  String data = ds.child("дата").getValue(String.class);
                  String flight = ds.child("рейс").getValue(String.class);
                  String phone  = ds.child("phone").getValue(String.class);


                    Log.d("TAG", data+"  "+"Рейс номер"+flight+"  "+phone);
                    //edit_text.setText(phone+"  "+data+"  "+"Рейс номер"+flight);


                    basa.add( data+"  "+"Рейс номер"+flight+"  "+phone );
                    Collections.sort(basa);
                    ad.notifyDataSetChanged();



                }
               // ArrayAdapter<String> adapter = new ArrayAdapter(Main2Activity.this, android.R.layout.simple_list_item_1,array);
                //lvMain2.setAdapter(adapter);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        usersdRef.addListenerForSingleValueEvent(valueEventListener);
    }

    public void next_list2(View view){
        Intent n = new Intent(this,Main3Activity.class);
        startActivity(n);



    }





    }

