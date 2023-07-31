package com.example.group13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
            {
                    {"Doctor Name : Dr. Maria Santos", "Hospital Address : Nephrology Center of Manila", "", "Mobile No:09096854357", "Available on Monday, Wednesday, and Saturday"},
                    {"Doctor Name : Dr. Jose Ramirez", "Hospital Address : Makati Medical Center", "", "Mobile No:09096854357", "Available on Monday, Tuesday, and Friday"},
                    {"Doctor Name : Dr. Sofia Cruz", "Hospital Address : Pasig Doctors Medical Center", "", "Mobile No:09096854357", "Available on Tuesday, Wednesday, and Saturday"},
                    {"Doctor Name : Dr. Miguel Reyes", "Hospital Address : Diliman Doctors Hospital", "", "Mobile No:09096854357", "Available on Wednesday, Saturday, and Monday"},
                    {"Doctor Name : Dr. Isabella Fernandez", "Hospital Address : East Avenue Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},


            };
    private String[][] doctor_details2 =
            {
                    {"Doctor Name : Dr. Angelo dela Cruz", "Hospital Address : Saint Jude Hospital and Medical Center", "", "Mobile No:09096854357", "Available on Monday, Wednesday, and Saturday"},
                    {"Doctor Name : Dr. Bianca Reyes", "Hospital Address : Ospital ng Maynila Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Saturday, and Monday"},
                    {"Doctor Name : Dr. Luis Santos", "Hospital Address : United Doctors Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},
                    {"Doctor Name : Dr. Marianne Gonzales", "Hospital Address : Marikina Doctors Hospital and Medical Center", "", "Mobile No:09096854357", "Available on Monday, Tuesday, and Friday"},
                    {"Doctor Name : Dr. Paolo dela Rosa", "Hospital Address : Marikina Valley Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},


            };
    private String[][] doctor_details3 =
            {
                    {"Doctor Name : Dr. Eduardo Fernandez", "Hospital Address : Ospital ng Maynila Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Saturday, and Monday"},
                    {"Doctor Name : Dr. Sophia Lim", "Hospital Address : Nephrology Center of Manila", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Gabriel Cruz", "Hospital Address : Saint Jude Hospital and Medical Center", "", "Mobile No:09096854357", "Available on Monday, Tuesday, and Friday"},
                    {"Doctor Name : Dr. Isabella Santos", "Hospital Address : Marikina Valley Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},
                    {"Doctor Name : Dr. Rafael dela Cruz", "Hospital Address : East Avenue Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},

            };
    private String[][] doctor_details4 =
            {
                    {"Doctor Name : Dr. Andrea Gonzales", "Hospital Address : East Avenue Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},
                    {"Doctor Name : Dr. Juanito Reyes", "Hospital Address : United Doctors Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Carla Santos", "Hospital Address : Pasig Doctors Medical Center", "", "Mobile No:09096854357", "Available on Monday, Tuesday, and Friday"},
                    {"Doctor Name : Dr. Roberto Lim", "Hospital Address : East Avenue Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Lorna dela Cruz", "Hospital Address : Nephrology Center of Manila", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},

            };
    private String[][] doctor_details5 =
            {
                    {"Doctor Name : Dr. Ricardo Cruz", "Hospital Address : United Doctors Medical Center", "", "Mobile No:09096854357", "Available on Monday, Tuesday, and Friday"},
                    {"Doctor Name : Dr. Maria Hernandez", "Hospital Address : Saint Jude Hospital and Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Miguel dela Rosa", "Hospital Address : Marikina Doctors Hospital and Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Sofia Reyes", "Hospital Address : Marikina Valley Medical Center", "", "Mobile No:09096854357", "Available on Monday,Wednesday, and Thursday"},
                    {"Doctor Name : Dr. Carlo Santos", "Hospital Address : Makati Medical Center", "", "Mobile No:09096854357", "Available on Wednesday, Thursday, and Friday"},

            };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewHADTitle);
        btn = findViewById(R.id.buttonHADBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", doctor_details[i][4]);
            list.add( item );
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView lst = findViewById(R.id.listViewHA);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text5",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });

    }
}