package ru.startandroid.develop.server_one;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main6Activity extends AppCompatActivity {

    EditText pushMap,pushflight;
    String[] listItems1 = {"Маршрут 1","Маршрут 2","Маршрут 3","Маршрут 4"};
    String[] listItems2 = {"Рейс номер 1","Рейс номер 2","Рейс номер 3","Рейс номер 4"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main6 );

        pushMap=findViewById( R.id.pushMap );
        pushflight=findViewById( R.id.pushflight );

    }
    public void showDialog_6 (View view){

        AlertDialog.Builder builder=new AlertDialog.Builder( Main6Activity.this );
        builder.setTitle( "Выбирите Маршрут");
        builder.setCancelable( false );
        builder.setItems( listItems1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                pushMap.setText(listItems1[which]);

            }
        } );
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    public void showDialog_7 (View view){

        AlertDialog.Builder builder=new AlertDialog.Builder( Main6Activity.this );
        builder.setTitle( "Выбирите Номер рейса");
        builder.setCancelable( false );
        builder.setItems( listItems2, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                pushflight.setText(listItems2[which]);

            }
        } );
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void btn7(View view){
        Intent intent = new Intent( this,Main7Activity.class );
        startActivity( intent );

    }










   /* public  void showDialog_6(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(  Main6Activity.this);

        builder.setTitle( "Выбирите Маршрут" )
                .setMessage( "Варианты маршрутов" )
                .setCancelable( false )
                .setItems( Map_vois, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        pushMap.setText( Map_vois[which] );


                    }
                } );

       builder.create().show();

    }

    public void NextList_6 (View view){

        Intent Next_list_6=new Intent( this,Main6Activity.class );
        startActivity( Next_list_6 );
    }*/
}



