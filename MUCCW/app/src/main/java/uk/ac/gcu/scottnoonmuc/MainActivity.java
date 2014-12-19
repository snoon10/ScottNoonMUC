package uk.ac.gcu.scottnoonmuc;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

//Main menu - buttons and intents organised here
public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    //declaring variables - buttons and fragment manager for about dialogue
    Button button_picker;
    Button button_feeds;
    Button button_maps;
    Button button_canvas;

    FragmentManager fmAboutDialogue;



    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//set activity to main layout view
        setContentView(R.layout.activity_main);

//attach variables to specific buttons from the layout
        button_picker = (Button) findViewById(R.id.pickerBtn);
        button_maps = (Button) findViewById(R.id.mapsBtn);
        button_feeds = (Button) findViewById(R.id.feedsBtn);
        button_canvas = (Button) findViewById(R.id.canvasBtn);

        button_picker.setOnClickListener(this);
        button_maps.setOnClickListener(this);
        button_feeds.setOnClickListener(this);
        button_canvas.setOnClickListener(this);


        fmAboutDialogue = this.getFragmentManager();
        Log.e("n", "message");

    }

    public boolean onCreateOptionsMenu(Menu menu) {
//creates options menu from the vs_menu layout file
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vs_menu, menu);
        return true;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public boolean onOptionsItemSelected(MenuItem item) {
//sets up options menu to quit app or display about dialogue
        switch (item.getItemId()) {
            case R.id.mQuit:
                finish();
                return true;
            case R.id.mAbout:

                DialogFragment vsAboutDlg = new vsAboutDialogue();
                vsAboutDlg.show(fmAboutDialogue, "vs_About_Dlg");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


//various Intent starters for buttons

    private void button_Picker(){

        startActivity(new Intent("uk.ac.gcu.scottnoonmuc.vsDatePicker"));

    }

    private void button_Feeds(){

        startActivity(new Intent("uk.ac.gcu.scottnoonmuc.RSSMain"));

    }

    private void button_Maps(){

        startActivity(new Intent("uk.ac.gcu.scottnoonmuc.mapActivity"));

    }

    private void button_Canvas(){

        startActivity(new Intent("uk.ac.gcu.scottnoonmuc.vsDrawMain"));

    }

    @Override
    public void onClick(View v) {
//sets onClick situation for the buttons
        switch (v.getId()){

            case R.id.pickerBtn:
                button_Picker();
                break;
            case R.id.feedsBtn:
                button_Feeds();
                break;
            case R.id.mapsBtn:
                button_Maps();
                break;
            case R.id.canvasBtn:
                button_Canvas();
                break;



        }
    }


    }




