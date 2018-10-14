package com.example.admin.smartvote;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Home_smart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_smart);

        final EditText passport = findViewById(R.id.num_editText);
        Button check = findViewById(R.id.Check_button);
        check.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String id = passport.getText().toString();

                if (id.length()!=13){
                    Toast t = Toast.makeText(Home_smart.this, "กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก", Toast.LENGTH_LONG);
                    t.show();
                }
                else {
                    String print = "";
                    boolean check = checkID(id);
                    if (check == true) {
                        print = "คุณเป็นผู้มีสิทธิเลือกตั้ง";
                    } else {
                        print = "คุณไม่มีสิทธิเลือกตั้ง";
                    }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(Home_smart.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.setCancelable(true);
                    dialog.show();


                }




            }
            private boolean checkID(String number) {
                char c = number.charAt(0);
                int lenght = number.length();
                int count = 0;
                for (int i = 0; i < lenght; i++) {
                    if (number.charAt(i) == c) {
                        count++;
                    }
                }
                if (count == lenght)
                    return true;
                else
                    return false;
            }
        });

    }
}


