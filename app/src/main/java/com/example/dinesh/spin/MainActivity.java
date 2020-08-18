package com.example.dinesh.spin;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bluehomestudio.luckywheel.LuckyWheel;
import com.bluehomestudio.luckywheel.OnLuckyWheelReachTheTarget;
import com.bluehomestudio.luckywheel.WheelItem;
import com.bluehomestudio.luckywheel.WheelView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] name=new String[]{"*", "2", "7", "25", "11", "5", "3", "1", "4", "8", "6", "9"};
    int[] select=new int[]{
            1,1,1,1,1,1,2,1,2,
            2,2,2,2,2,2,2,2,2,
            1,1,1,1,1,1,1,1,1,
            3,3,3,3,3,3,3,3,3,
            1,1,1,1,1,1,1,1,1,
            1,1,1,1,4,1,1,1,1,
            1,1,1,1,1,1,1,1,1,
            1,5,1,5,1,5,1,5,1,
            1,1,1,1,1,1,1,1,1,
            6,6,6,6,6,6,6,6,6,
            1,1,1,1,1,1,1,1,1,
            7,7,7,7,7,7,7,7,7,
            8,8,8,8,8,8,8,8,8,
            1,1,1,1,1,1,1,1,1,
            9,9,9,9,9,9,9,9,9,
            1,1,1,1,1,1,1,1,1,
            10,10,10,10,10,10,10,10,10,
            1,1,1,1,1,1,1,1,1,
            11,11,11,11,11,11,11,11,11,
            1,1,1,1,1,1,1,1,1,
            12,1,12,1,12,1,12,1,12,
            1,1,1,1,1,1,1,1,1
    };

    int number=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LuckyWheel wheelView=findViewById(R.id.lwv);
        final TextView button=findViewById(R.id.spin);

        final List<WheelItem> wheelItems = new ArrayList<>();

        int orange = getResources().getColor(R.color.orange);

        int blue = getResources().getColor(R.color.blue);

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.star)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.two)));

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.seven)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.twofive)));

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.eleone)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.five)));

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.three)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.one)));

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.four)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.eight)));

        wheelItems.add(new WheelItem(orange, BitmapFactory.decodeResource(getResources(), R.drawable.six)));

        wheelItems.add(new WheelItem(blue, BitmapFactory.decodeResource(getResources(), R.drawable.nine)));

        wheelView.addWheelItems(wheelItems);
       // wheelView.rotateWheelTo(1);

        wheelView.setLuckyWheelReachTheTarget(new OnLuckyWheelReachTheTarget() {
            @Override
            public void onReachTarget() {
                Toast.makeText(MainActivity.this, name[number-1], Toast.LENGTH_SHORT).show();
                button.setTag("SPIN");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button.getTag().toString().equalsIgnoreCase("spin")){
                    Random random =new Random();
                    int n=random.nextInt(select.length);
                    number=select[n];
                    wheelView.rotateWheelTo(number);
                    button.setTag("Wait");
                    Toast.makeText(MainActivity.this, name[number-1], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
