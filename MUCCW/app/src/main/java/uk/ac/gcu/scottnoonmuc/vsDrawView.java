package uk.ac.gcu.scottnoonmuc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;

import uk.ac.gcu.scottnoonmuc.R;


public class vsDrawView extends View {
//declares bitmap for saltire to be displayed
    private Bitmap saltire;

    public vsDrawView(Context context) {
        super(context);
        //sets saltire to image from resources using BitmapFactory
        saltire = BitmapFactory.decodeResource(getResources(), R.drawable.ic_saltire);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        //draws bitmap saltire to canvas with a black background
        canvas.drawColor(Color.BLACK);
        canvas.drawBitmap(saltire, 10, 10, null);
    }
}