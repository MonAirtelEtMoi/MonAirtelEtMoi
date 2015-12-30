package lab.synah.cd.monairteletmoi.controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

import lab.synah.cd.monairteletmoi.R;

/**
 * Created by DieuvainMusaghi on 29/12/15.
 */

public class MonAirtelListViewAdapter extends Activity {

    public MonAirtelDBAdapter dbHelper;
    public SimpleCursorAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);

        dbHelper = new MonAirtelDBAdapter(this);
        dbHelper.open();

        //Clean all data
        dbHelper.deleteSubscriber();
        //Add some data
        dbHelper.insertSomeSubscriber();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {


        Cursor cursor = dbHelper.fetchAllSubscriber();

        // The desired columns to be bound
        String[] columns = new String[] {
                MonAirtelDBAdapter.KEY_TOWN,
                MonAirtelDBAdapter.KEY_NAME,
                MonAirtelDBAdapter.KEY_PHONE
        };

        // the XML defined views which the data will be bound to

        /*int[] to = new int[] {
                R.id.town,
                R.id.fullname,
                R.id.Phonenumber,
        };*/

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
      /*  dataAdapter = new SimpleCursorAdapter(
               this, R.layout.subscribers,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.list);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view,
                                    int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String countryCode =
                        cursor.getString(cursor.getColumnIndexOrThrow("fullname"));
                Toast.makeText(getApplicationContext(),
                        countryCode, Toast.LENGTH_SHORT).show();

            }
        });*/

       /* EditText myFilter = (EditText) findViewById(R.id.myFilter);
        myFilter.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                dataAdapter.getFilter().filter(s.toString());
            }
        });

        dataAdapter.setFilterQueryProvider(new FilterQueryProvider() {
            public Cursor runQuery(CharSequence constraint) {
                return dbHelper.fetchSubscriberByName(constraint.toString());
            }
        });
*/
    }






}
