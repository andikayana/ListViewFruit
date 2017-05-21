package iak.com.andikayana;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);

        final ArrayList<Weather> data = new ArrayList<>();
        data.add(new Weather(R.drawable.apple,"Aplle","Fruit Number 1"));
        data.add(new Weather(R.drawable.bananan,"Banana","Fruit Number 2"));
        data.add(new Weather(R.drawable.belingbing,"Belingbing","Fruit Number 3"));
        data.add(new Weather(R.drawable.chery,"Chery","Fruit Number 4"));
        data.add(new Weather(R.drawable.dragonfruit,"Dragon fruit","Fruit Number 5"));
        data.add(new Weather(R.drawable.strawbery,"Strawberry","Fruit Number 6"));
        data.add(new Weather(R.drawable.tomato,"Tomato","Fruit Number 7"));
        data.add(new Weather(R.drawable.watermelon,"Watermelon","Fruit Number 8"));



        WeatherAdapter adapter = new WeatherAdapter(this, R.layout.list_view, data);

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Weather weather=data.get(position);
                Intent toTarget = new Intent(getApplicationContext(),TargetActivity.class);
                toTarget.putExtra("title", weather.title);
                toTarget.putExtra("icon", weather.icon);
                toTarget.putExtra("item", weather.item);
                startActivity(toTarget);

            }
        });
    }
}
