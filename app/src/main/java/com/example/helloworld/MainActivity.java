package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private String TAG = "First Demo";
    public static String MESSAGE = "Message";
    public static int MESSAGE_RECEIVE = 1;

   ///@BindView(R.id.button)
    //Button button;
    //private Button button;

    @BindView(R.id.received_message)
    TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Log.d(TAG,"onCreate"+"This is the first LOG");*/

        /*button = findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG,"Click Button!");
                    }
                }
        );*/

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button)
    public void outputLog(){
       // Log.d(TAG,"Click Button!");

        //Explicit Intents
     /*   Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(MESSAGE, "Hello from the first activity.");
        startActivity(intent);*/

        //implicit Intents
       /* Intent intent = new Intent();
        intent.setAction("SecondActivity");
        intent.putExtra(MESSAGE, "Hello from the first activity.");
        startActivity(intent);*/

       //start activity for results
        Intent intent = new Intent();
        intent.setAction("SecondActivity");
        intent.putExtra(MESSAGE,"Hello from the first activity");
        startActivityForResult(intent,MESSAGE_RECEIVE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        //check which request we're responding to
        if(requestCode == MESSAGE_RECEIVE){
            if(resultCode == RESULT_OK){
                message.setText(data.getStringExtra(Main2Activity.RECEIVED_MESSAGE));
            }
        }
    }
}
