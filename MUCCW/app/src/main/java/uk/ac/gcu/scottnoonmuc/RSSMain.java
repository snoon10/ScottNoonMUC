package uk.ac.gcu.scottnoonmuc;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

//main activity for the RSS display
public class RSSMain extends Activity {


    private RSSMain local;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // point to feed view
        setContentView(R.layout.vs_feed_view);

        // Set reference to this activity
        local = this;

        GetRSSDataTask task = new GetRSSDataTask();

        // Start download from URL
        task.execute("http://mediacentre.visitscotland.org/rss/current_news/56308");

        }

    //asynctask used for background thread loading
    private class GetRSSDataTask extends AsyncTask<String, Void, List<RssItem> > {
        @Override
        protected List<RssItem> doInBackground(String... urls) {

            try {
                // Creates new RSS reader
                RssReader rssReader = new RssReader(urls[0]);

                // Parses RSS feed and gets RSS items
                return rssReader.getItems();

            } catch (Exception e) {
                Log.e("vsRssReader", e.getMessage());
            }

            return null;
        }

        @Override
        protected void onPostExecute(List<RssItem> result) {

            // Get the ListView from the layout
            ListView vsItems = (ListView) findViewById(R.id.RSSList);

            // Creates a list adapter
            ArrayAdapter<RssItem> adapter = new ArrayAdapter<RssItem>(local,android.R.layout.simple_list_item_1, result);
            // Set list adapter for the ListView
            vsItems.setAdapter(adapter);

            // Sets ListView onclick listener
            vsItems.setOnItemClickListener(new ListListener(result, local));
        }
    }
}
