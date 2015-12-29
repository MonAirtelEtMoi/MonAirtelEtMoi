package lab.synah.cd.monairteletmoi.gui;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.ui.FirebaseListAdapter;

import lab.synah.cd.monairteletmoi.R;
import lab.synah.cd.monairteletmoi.model.Ussd;


public class TestFirebaseActivity extends ListActivity {

    private Firebase mFireBaseRef; //Firebase reference
    FirebaseListAdapter<Ussd> mListAdapter; //To be used when retreiving data in the list
    public ListView mainListView;


   // Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        Firebase.setAndroidContext(this);

        mFireBaseRef = new Firebase("https://MonAirtelEtMoi.firebaseio.com");

        /*
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TypedValue typedValueColorPrimaryDark = new TypedValue();
        TestFirebaseActivity.this.getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValueColorPrimaryDark, true);
        final int colorPrimaryDark = typedValueColorPrimaryDark.data;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(colorPrimaryDark);
        }
        */
        //mainListView = (ListView) findViewById(R.id.list);

        final EditText textEdit = (EditText) this.findViewById(R.id.text_edit);
        Button sendButton = (Button) this.findViewById(R.id.send_button);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textEdit.getText().toString();
                /*
                // This method is used in case we have not a class model

                Map<String,Object> values=new HashMap<>();
                values.put("name","Code USSD");
                values.put("text",text);

                */

                Ussd codeussd = new Ussd("Code Ussd", text);
                mFireBaseRef.push().setValue(codeussd);
                textEdit.setText((""));
            }
        });

        mListAdapter = new FirebaseListAdapter<Ussd>(this, Ussd.class, android.R.layout.two_line_list_item, mFireBaseRef) {
            @Override
            protected void populateView(View v, Ussd model) {
                ((TextView) v.findViewById(android.R.id.text1)).setText(model.getName());
                ((TextView) v.findViewById(android.R.id.text2)).setText(model.getText());
            }
        };
        setListAdapter(mListAdapter);
      // mainListView.setAdapter(mListAdapter);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mListAdapter.cleanup();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inbox, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
