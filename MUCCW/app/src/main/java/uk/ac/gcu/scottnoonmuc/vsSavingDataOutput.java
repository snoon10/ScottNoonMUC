package uk.ac.gcu.scottnoonmuc;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class vsSavingDataOutput extends Activity implements View.OnClickListener{

//declares variables
    SharedPreferences vsSharedPrefs;
    Button btnBack;
    TextView vsSDODOW;
    TextView vsSDOMonth;
    TextView vsSDOLegend;

    protected void onCreate(Bundle savedInstanceState){
        //sets layout for activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vs_display_shared_prefs);

        //sets button to match in layout
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        //sets textviews to those in layout
        vsSDODOW = (TextView) findViewById(R.id.tvDOW);
        vsSDOMonth = (TextView) findViewById(R.id.tvMonth);
        vsSDOLegend = (TextView) findViewById(R.id.tvLegend);

        //runs the loading of saved preferences
        vsSharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        LoadSavedPreferences();
        Log.e("n","SDOutput msg");

    }

    //loads preferences into valuess
    private void LoadSavedPreferences() {
        vsSDODOW.setText(vsSDODOW.getText() + String.valueOf(vsSharedPrefs.getInt("vs_DOW", 1)));
        vsSDOMonth.setText(vsSDOMonth.getText() + String.valueOf(vsSharedPrefs.getInt("vs_Month", 1)));
        vsSDOLegend.setText(vsSDOLegend.getText() + String.valueOf(vsSharedPrefs.getString("vs_Legend", "John Logie Baird")));
    }


    @Override
    public void onClick(View view) {
        //on click displays results
        setResult(Activity.RESULT_OK);
        finish();
    }
}
