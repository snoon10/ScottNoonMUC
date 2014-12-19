package uk.ac.gcu.scottnoonmuc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

import java.util.List;


public class ListListener implements AdapterView.OnItemClickListener {
    // listener contains a reference to the list of RSS Items
    // List item's reference
    List<RssItem> listItems;

    // Calling activity reference

    Activity activity;

    public ListListener(List<RssItem> aListItems, Activity anActivity) {
        listItems = aListItems;
        activity  = anActivity;
    }

    //starts browser for relative URL to RSS Item
    public void onItemClick(AdapterView parent, View view, int pos, long id) {

        Intent link = new Intent(Intent.ACTION_VIEW);
        // We have to set data for our new Intent

        link.setData(Uri.parse(listItems.get(pos).getLink()));

        // start intent for items to link to mobile browser
        activity.startActivity(link);
    }


}
