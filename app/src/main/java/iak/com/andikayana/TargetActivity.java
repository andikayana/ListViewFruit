package iak.com.andikayana;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.SocketHandler;

/**
 * Created by M13x5aY on 13/05/2017.
 */

public class TargetActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_target);
        ImageView icon = (ImageView) findViewById(R.id.img);
        TextView title = (TextView) findViewById(R.id.txt);
        TextView item = (TextView) findViewById(R.id.itm);


        Bundle bundle=getIntent().getExtras();
        String text = bundle.getString("title");
        int image = bundle.getInt("icon");
       String subitem = bundle.getString("item");

        icon.setImageResource(image);
        title.setText(text);
       item.setText(subitem);

        //Toast.makeText(getApplicationContext(),"title",Toast.LENGTH_SHORT).show();


    }

}
