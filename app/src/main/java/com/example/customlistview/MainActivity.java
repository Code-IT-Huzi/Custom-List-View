package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook", "WhatsApp", "Twitter", "Instagram" , "YouTube"};
    String mDescription[] = {"Facebook Description","WhatsApp Description","Twitter Description","Instagram Description","YouTube Description"};
    int images[]= {R.drawable.fb,R.drawable.wa, R.drawable.tw, R.drawable.ins, R.drawable.yt };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0) {
                    Toast.makeText(MainActivity.this, "Facebook Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 1){
                    Toast.makeText(MainActivity.this, "WhatsApp Description", Toast.LENGTH_SHORT) .show();
                }if (position == 2){
                    Toast.makeText(MainActivity.this, "Twitter Description", Toast.LENGTH_SHORT) .show();
                }if (position == 3){
                    Toast.makeText(MainActivity.this, "Instagram Description", Toast.LENGTH_SHORT) .show();
                }if (position == 4){
                    Toast.makeText(MainActivity.this, "Youtube Description", Toast.LENGTH_SHORT) .show();
                }
            }
        });
    }


class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String rTitle[];
    String rDescription[];
    int rImages[];

    MyAdapter (Context c, String title[], String Description[], int images[]) {
        super(c , R.layout.row, R.id.Tv1 , title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = Description;
        this.rImages = images;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.row, parent, false);
        ImageView images = row.findViewById(R.id.image);
        TextView myTitle = row.findViewById(R.id.Tv1);
        TextView myDescription = row.findViewById(R.id.tv2);
        images.setImageResource(rImages[position]);
        myTitle.setText(rTitle[position]);
        myDescription.setText(rDescription[position]);


        return row;
    }
}
}
