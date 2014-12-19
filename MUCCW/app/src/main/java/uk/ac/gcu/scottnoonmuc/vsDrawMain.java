package uk.ac.gcu.scottnoonmuc;

import android.app.Activity;
import android.os.Bundle;

public class vsDrawMain extends Activity {
    @Override
    //sets activity to drawView
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new vsDrawView(this));
    }
}


