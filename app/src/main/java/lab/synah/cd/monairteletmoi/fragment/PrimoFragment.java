package lab.synah.cd.monairteletmoi.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import lab.synah.cd.monairteletmoi.PrimoActivity;
import lab.synah.cd.monairteletmoi.R;

/**
 * Created by Michelo on 29/12/15.
 */
public class PrimoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate here
        final View view=inflater.inflate(R.layout.main_fragment,container,false);
        ((PrimoActivity)getActivity()).getSupportActionBar().setTitle("Mon Airtel et Moi");

        Button buttonChangeText=(Button)view.findViewById(R.id.buttonFragmentInbox);
        final TextView textViewStudentFragment=(TextView) view.findViewById(R.id.textViewInboxFragment);

        buttonChangeText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                textViewStudentFragment.setText("Ceci marche très bien");
                textViewStudentFragment.setTextColor(getResources().getColor(R.color.md_blue_A100));

            }
        });

        return view;

    }

}
