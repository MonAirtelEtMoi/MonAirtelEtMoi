package lab.synah.cd.monairteletmoi.Spinners;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import lab.synah.cd.monairteletmoi.R;

/**
 * Created by DieuvainMusaghi on 04/01/16.
 */
public class MainSpinner extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqs);

        Spinner spinner = (Spinner) findViewById(R.id.Spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.problems, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

        Button myButton =(Button)findViewById(R.id.btnenvoy);
        myButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                Spinner sp =	(Spinner)findViewById(R.id.Spinner);
                String spinnerString = null;
                spinnerString = sp.getSelectedItem().toString();
                int nPos = sp.getSelectedItemPosition();


                Toast.makeText(getApplicationContext(), "getSelectedItem=" + spinnerString,
                        Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(), "getSelectedItemPosition=" + nPos,
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
