package com.example.lovely;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

Toolbar bar;
TextView output;
    TextInputEditText inputtext,counttext;
    AppCompatButton btn1,btn2;
    ImageButton copybtn;
    ImageButton sharebtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputtext=findViewById(R.id.writerid);
        counttext=findViewById(R.id.counterid);
        counttext.setText("0");
        output=findViewById(R.id.tv);
        btn1=findViewById(R.id.resultbtn);
        btn2=findViewById(R.id.resetbtn);
        copybtn=findViewById(R.id.copyid);
        sharebtn=findViewById(R.id.shareid);
        bar=findViewById(R.id.toolbar);
        setSupportActionBar(bar);


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputtext.setText("");
                counttext.setText("0");
                output.setText("");
            }
        });
        copybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip= ClipData.newPlainText("TextView", output.getText().toString());
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this,"Text is Coppied.",Toast.LENGTH_LONG).show();
            }
        });
btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String str=inputtext.getText().toString();
        int n=Integer.parseInt(counttext.getText().toString());


        if(((str.length())>0) && (n>0)){
            StringBuilder builder=new StringBuilder();
            for(int i=1;i<=n;i++){
                builder.append(String.valueOf(str));
                builder.append("\n");
            }
            output.setText(builder.toString());
        }else{
            Toast.makeText(MainActivity.this,"দয়াকরে আপনি উপরের ফরম পূরণ করুন ধন্যবাদ",Toast.LENGTH_LONG).show();
        }
    }
});

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items,menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();
        if(item_id==R.id.Home){
            Toast.makeText(MainActivity.this,"Developere By Md Soman Mia BSC IN CSE.",Toast.LENGTH_LONG).show();

        }else if(item_id==R.id.exit){

            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("আপনি কি এ্যাপ্স থেকে বের হতে চান?");
            builder.setIcon(R.mipmap.ic_launcher_foreground);
            builder.setCancelable(false);
            builder.setNegativeButton("না", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });

            builder.setPositiveButton("হ্যা", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();;
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();

        }
        return true;
    }




}