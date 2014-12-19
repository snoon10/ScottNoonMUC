package uk.ac.gcu.scottnoonmuc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

//class to control the datepicker for the user to enter their dob
public class vsDatePicker extends Activity implements View.OnClickListener{


    //declare date picker and submit button variables
    DatePicker dpBDay;
    Button submitBtn;


    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //point class to datepicker layout
        setContentView(R.layout.datepicker_layout);

        //set datepicker to its ID within the layout
        dpBDay = (DatePicker) findViewById(R.id.datePickerBDay);

        //sets button to its ID within the layout
        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        legendsChooser vsYourDay = new legendsChooser(dpBDay.getDayOfMonth(),dpBDay.getMonth(),dpBDay.getYear());

        //sets new intent for the output screen for the datepicker
        Intent vsOutput_Screen = new Intent(getApplicationContext(), vsOutputScreen.class);

        //sets output message
        vsOutput_Screen.putExtra("vsOutputMsg", vsYourDay.getsOutputMsg());

        Log.e("n", vsYourDay.getsOutputMsg());

        //starts output screen activity
        startActivity(vsOutput_Screen);
    }


}
