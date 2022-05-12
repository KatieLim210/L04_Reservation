package sg.edu.rp.c346.id21023701.l04problemstatment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
TextView name;
TextView noofpax;
TextView number;
TextView date;
TextView time;
TextView table;

EditText etname;
EditText etpax;
EditText etnumber;

RadioGroup rdgrp;

Button cfm;
Button reset;

DatePicker dp;
TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.textname);
        noofpax = findViewById(R.id.textsize);
        number = findViewById(R.id.textmobilenumber);
        date = findViewById(R.id.tvdate);
        time = findViewById(R.id.tvtime);
        table = findViewById(R.id.tvtablearea);
        etname = findViewById(R.id.etname);
        etpax = findViewById(R.id.etsize);
        etnumber = findViewById(R.id.etmobilenumber);
        rdgrp = findViewById(R.id.rdgrp);

        cfm = findViewById(R.id.btnconfirm);
        reset = findViewById(R.id.btnreset);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

cfm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int checkedRadioId = rdgrp.getCheckedRadioButtonId();
        int day = dp.getDayOfMonth();
        int month = dp.getMonth()+1;
        int year = dp.getYear();
        int hour = tp.getCurrentHour();
        int minute = tp.getCurrentMinute();
        String nameString="Name: "+etname.getText().toString();
        String time = String.format("Selected timing is %d:%d",hour, minute);
        String date = String.format("Selected Date is %d/%d/%d",day,month,year);
        String paxString="No of Pax: "+etpax.getText().toString();
        String numberString="Mobile Number"+etnumber.getText().toString();
        if (etname.getText().length() != 0 && etnumber.getText().length() != 0 && etpax.getText().length() != 0) {
            if(checkedRadioId == R.id.rdsmoking){
                Toast.makeText(MainActivity.this,nameString+"\n"+paxString+"\n"+numberString+"\n"+date+"\n"+time+"\n"+"Table area: smoking", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(MainActivity.this,nameString+"\n"+paxString+"\n"+numberString+"\n"+date+"\n"+time+"\n"+"Table area: non-smoking", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(MainActivity.this,"Please fill up the empty fields", Toast.LENGTH_LONG).show();
        }



        }
});
reset.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        etname.setText("");
        etnumber.setText("");
        etpax.setText("");
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        tp.setIs24HourView(true);
        dp.updateDate(2020,5,1);
    }
});
    }
}
