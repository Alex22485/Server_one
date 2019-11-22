package ru.startandroid.develop.server_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String [] basa={"1","2","3","4","5"};
   // Button btn;
    //TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ListView lvMain =(ListView)findViewById(R.id.lv);

        final TextView txt=(TextView)findViewById(R.id.txt);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,basa);
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txt.setText(basa[position]);


            }
        });
    }

    public void next_list(View view){
        Intent i = new Intent(this,Main2Activity.class);
        startActivity(i);

    }
}
