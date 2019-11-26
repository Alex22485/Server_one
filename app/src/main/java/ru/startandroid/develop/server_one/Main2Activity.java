package ru.startandroid.develop.server_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    //ADD ListView
    ListView lv2;
    List<String> basa=new ArrayList<String>(  );
    ArrayAdapter ad;
    TextView txt;


    // ADD Calendar
    Button choisData;
    int year;
    int month;
    int dayOfmonth;
    Calendar calendar;
    DatePickerDialog datePickerDialog;

    String[] array={};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Добавил
        lv2=findViewById( R.id.lv2 );
        basa=new ArrayList<String>( Arrays.asList( array ) );
        ad= new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,basa );
        lv2.setAdapter( ad );
        txt=findViewById(R.id.txt);


        choisData=findViewById(R.id.choisData);
        txt=findViewById(R.id.txt);




        choisData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar= Calendar.getInstance();
                year=calendar.get(Calendar.YEAR);
                month=calendar.get(Calendar.MONTH);
                dayOfmonth=calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(Main2Activity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                txt.setText(day + " " + (month + 1) + " " + year);
                            }
                        }, year,month,dayOfmonth);
                datePickerDialog.show();
            }
        });







       // DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Заявки").child("Дата").child("В Красноярск");
     //   DatabaseReference usersdRef = rootRef.child( txt.getText().toString() );
      //  ValueEventListener valueEventListener = new ValueEventListener() {
      //      @Override
       //     public void onDataChange(DataSnapshot dataSnapshot) {

       //         for (DataSnapshot ds : dataSnapshot.getChildren()) {

       //           String data = ds.child("дата").getValue(String.class);
       //           String flight = ds.child("рейс").getValue(String.class);
       //           String phone  = ds.child("phone").getValue(String.class);

         //           Log.d("TAG", data+"  "+"Рейс номер"+""+flight+"  "+phone);
          //          basa.add( data+"  "+"Рейс номер"+""+flight+"  "+phone );
          //          Collections.sort(basa);
         //           ad.notifyDataSetChanged();
        //        }
        //    }

      //      @Override
     //       public void onCancelled(DatabaseError databaseError) {
      //      }
    //    };
        //usersdRef.addListenerForSingleValueEvent(valueEventListener);
    }

    public void next_list2(View view){
        Intent n = new Intent(this,Main3Activity.class);
        startActivity(n);
    }

    public void btnInsert (View view){
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Заявки").child("Дата").child("В Красноярск");
        DatabaseReference usersdRef = rootRef.child( txt.getText().toString() );
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {

                    String data = ds.child("дата").getValue(String.class);
                    String flight = ds.child("рейс").getValue(String.class);
                    String phone  = ds.child("phone").getValue(String.class);

                    Log.d("TAG", data+"  "+"Рейс номер"+""+flight+"  "+phone);
                    basa.add(flight+"  "+"Рейс"+"  "+"Телефон"+"  "+phone+"  "+data );
                    Collections.sort(basa);
                    ad.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };usersdRef.addListenerForSingleValueEvent(valueEventListener);


    }
    }

