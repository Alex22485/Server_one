package ru.startandroid.develop.server_one;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main5Activity extends AppCompatActivity {

    EditText pushText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main5 );

        pushText=findViewById( R.id.pushText );
    }

    public  void showDialog(View view){
        AlertDialog.Builder builder= new AlertDialog.Builder(  Main5Activity.this);

        builder.setTitle( "Server_ONE" )
                .setMessage( "Варианты маршрутов" )
                .setCancelable( false )
                .setNeutralButton( "Маршрут 1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        pushText.setText( "Маршрут 1" );

                    }
                } )
                .setPositiveButton( "Маршрут 2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        pushText.setText( "Маршрут 2" );

                    }
                } )
                .setNegativeButton( "Маршрут 3", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        pushText.setText( "Маршрут 3" );

                    }
                } );
        AlertDialog alert=builder.create();
        alert.show();

    }

    public void NextList_6 (View view){

        Intent Next_list_6=new Intent( this,Main6Activity.class );
        startActivity( Next_list_6 );
    }
}
