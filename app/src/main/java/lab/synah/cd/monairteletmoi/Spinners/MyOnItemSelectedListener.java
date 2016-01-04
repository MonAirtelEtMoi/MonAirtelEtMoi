package lab.synah.cd.monairteletmoi.Spinners;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by DieuvainMusaghi on 04/01/16.
 */
public  class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent,
                               View view, int pos, long id) {
        Toast.makeText(parent.getContext(), "Item is " +
                parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}