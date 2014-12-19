package uk.ac.gcu.scottnoonmuc;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;

         public class vsSaveData extends Activity {
    

             SharedPreferences vsSharedPrefs;

             //declares variables
             private int vsSDDOW;
             private int vsSDMonth;
             private String vsSDLegend;


            //getters and setters for variables
             private void setvsSDDOW(int isDOW)
     {
         this.vsSDDOW = isDOW;
         }
    
             public int getvsSDDOW()
     {
         return vsSDDOW;
         }
    
             private void setvsSDMonth(int isMonth)
     {
         this.vsSDMonth = isMonth;

         }
    
             public int getvsSDMonth()
     {
         return vsSDMonth;
         }
    
             private void setvsSDLegend(String isLegend)
     {
         this.vsSDLegend = isLegend;
         }
    
             public String getvsSDLegend()
     {
         return vsSDLegend;
         }
    

             public vsSaveData(SharedPreferences vsSDPrefs){
         setvsSDDOW(1);
         setvsSDMonth(1);
         setvsSDLegend("John Logie Baird");
         try {
             this.vsSharedPrefs = vsSDPrefs;
             }
         catch (Exception e)
         {
             Log.e("n","Pref Manager is NULL" );
             }
         setDefaultPrefs();
         }

             public void savePreferences(String key, boolean value) {
         SharedPreferences.Editor editor = vsSharedPrefs.edit();

         editor.putBoolean(key, value);
         editor.commit();
         }
    
             public void savePreferences(String key, String value) {
         SharedPreferences.Editor editor = vsSharedPrefs.edit();
         editor.putString(key, value);
         editor.commit();
         }
    
             public void savePreferences(String key, int value) {
         SharedPreferences.Editor editor = vsSharedPrefs.edit();
         editor.putInt(key, value);
         editor.commit();
         }


             //sets default values for preferences
             public void setDefaultPrefs(){
         savePreferences("vs_DOW", 1);
         savePreferences("vs_Month", 1);
         savePreferences("vs_Legend", "Empty");
         }
     }
