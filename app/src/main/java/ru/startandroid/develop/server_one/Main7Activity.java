package ru.startandroid.develop.server_one;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
import java.util.Collections;
import java.util.List;

public class Main7Activity extends AppCompatActivity {

    TextView number,mussiv;
    //ADD ListView
    /*ListView lv3;
    List<String> basa=new ArrayList<String>(  );
    ArrayAdapter ad;
    String[] array={};*/

    ListView lv3;
    List<Integer> num=new ArrayList<Integer>(  );
    ArrayAdapter nu;
    Integer[] ar={};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main7 );

        //Добавил
        /*lv3=findViewById( R.id.lv3 );
        basa=new ArrayList<String>( Arrays.asList( array ) );
        ad= new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,basa );
        lv3.setAdapter( ad );*/


        lv3=findViewById( R.id.lv3 );
        num=new ArrayList<Integer>( Arrays.asList( ar ) );
        nu= new ArrayAdapter<>( this,android.R.layout.simple_list_item_1,num );
        lv3.setAdapter( nu );


        number= findViewById( R.id.number );
        mussiv= findViewById( R.id.mussiv );

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Заявки")
                .child("Аэропорт-Красноярск")
                .child( "9 12 2019" )
                .child( "Маршрут 1" );
        DatabaseReference usersdRef = rootRef.child( "Рейс номер 3" );
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {



                    int xxx=0;
                    int flight = ds.child("число").getValue(Integer.class);
                    int a=xxx+flight;
                    num.add( a );
                    int sum=0;

                    for (int counter=0;counter<num.size();counter++){
                        sum+= num.get(counter);
                    }
                    number.setText(" "+sum);
                    //num.add(flight);
                    //nu.notifyDataSetChanged();
                   /* int absSum = 0;
                    for ( int i = 0; i < listView1.Items.Count; i++ )
                        absSum += int.Parse( listView1.Items[i].SubItems[1].Text );

                    int bbb[]={flight};
                    int sum=0;
                    for (int element:bbb)
                        sum+=element;
                    System.out.println( sum );*/
                    /*int sum=0;
                    for(int i=0;i<bbb.length;++i)
                        sum +=bbb[i];
                    System.out.println( sum );*/
                    /*int a=0;
                    int b=a+s;
                    System.out.println( b );*/
                    //int[] s = {flight};

                    //System.out.println( s );
                    /*String strArr[]=flight.split( "" );
                    int numArr[]=new int[strArr.length];
                    for(int i=0; i<strArr.length;i++){

                        numArr[i]=Integer.parseInt( strArr[i] );
                        //System.out.println( numArr[i] );
                    }*/
                   // Log.d("TAG", flight);
                    //mussiv.setText( flight );
                   /*int[] numArr=Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();

                    basa.add(flight);
                    Collections.sort(basa);
                    ad.notifyDataSetChanged();


                    int b = Integer.parseInt(flight);
                    a=7;
                    c=a+b;
                    String f=Integer.toString(c);
                    number.setText( f );



                    Log.d("TAG", flight);*/
                    //number.setText(flight);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };usersdRef.addListenerForSingleValueEvent(valueEventListener);

        // ЭТО пример массива из 5-1=4-х чисел
         /*int[]x=new int[5];
        for(int i=0; i<x.length;i++){
          x[i]= i*2;

          int sss[]={1,1,1};

            mussiv.setText("Результат массива   "+x[i]);
        }*/


    }

   /* public static void main (String[] args){

        int array[]={1,1,1,1};
        int sum= Arrays.stream(array)
    }*/
}
