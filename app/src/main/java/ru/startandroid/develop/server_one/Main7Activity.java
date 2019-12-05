package ru.startandroid.develop.server_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main7Activity extends AppCompatActivity {

    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main7 );

        number= findViewById( R.id.number );

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference("Заявки")
                .child("Аэропорт-Красноярск")
                .child( "6 12 2019" )
                .child( "Маршрут 1" );
        DatabaseReference usersdRef = rootRef.child( "Рейс номер 2" );
        ValueEventListener valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {


                    String flight = ds.child("рейс").getValue(String.class);



                    Log.d("TAG", flight);
                    number.setText(flight);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };usersdRef.addListenerForSingleValueEvent(valueEventListener);




    }
}
