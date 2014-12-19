package uk.ac.gcu.scottnoonmuc;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
//class to define about dialogue for main menu

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class vsAboutDialogue extends DialogFragment {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //creates dialog
        AlertDialog.Builder vsAboutDialog = new AlertDialog.Builder(getActivity());
        //sets message for dialog
        vsAboutDialog.setMessage("This app provides Visit Scotland entertainment and information")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        //gives dialog box a title and an icon
        vsAboutDialog.setTitle("About");
        vsAboutDialog.setIcon(R.drawable.ic_menu_action_about);

        return vsAboutDialog.create();
    }

}


