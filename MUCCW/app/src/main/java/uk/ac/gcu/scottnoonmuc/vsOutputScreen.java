package uk.ac.gcu.scottnoonmuc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//activity to define output screen from datepicker selection
public class vsOutputScreen extends Activity implements View.OnClickListener{

//declares two buttons as variables
        Button btnDatePick;
        Button btnSavedData;

        @Override
        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            //sets view to appropriate layout
            setContentView(R.layout.vs_output_screen);
            //sets buttons to their corresponding button from layout
            btnDatePick = (Button) findViewById(R.id.btnPickDate);
            btnDatePick.setOnClickListener((View.OnClickListener) this);
            btnSavedData = (Button) findViewById(R.id.btnSaveData);
            btnSavedData.setOnClickListener((View.OnClickListener) this);

            //sets TextView to its match in layout
            TextView vsOutput = (TextView) findViewById(R.id.tvOutputMsg);

            //sets intent
            Intent iMainAct = getIntent();
            vsOutput.setText(iMainAct.getStringExtra("vsOutputMsg"));

        }

          public void onClick(View v) {
              //if statement that sets the intents of the two buttons to either view
              //saved data or to pick another date
            if (v == btnDatePick) {
                // return to datepicker
                Intent datepicker = new Intent(v.getContext(), vsDatePicker.class);
                startActivity(datepicker);
            } else if (v == btnSavedData) {
                // move to saved data
                Intent saveddata = new Intent(v.getContext(), vsSavingDataOutput.class);
                startActivity(saveddata);
                setResult(Activity.RESULT_OK);
                   finish();
            }

        }

    }



