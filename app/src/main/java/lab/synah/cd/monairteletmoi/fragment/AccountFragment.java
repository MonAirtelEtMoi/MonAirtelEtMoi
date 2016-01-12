package lab.synah.cd.monairteletmoi.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.FirebaseRecyclerViewAdapter;

import lab.synah.cd.monairteletmoi.PrimoActivity;
import lab.synah.cd.monairteletmoi.R;
import lab.synah.cd.monairteletmoi.adapter.AccountHolder;
import lab.synah.cd.monairteletmoi.model.Commande;

/**
 * Created by Michelo on 29/12/15.
 */
public class AccountFragment extends Fragment {


    private RecyclerView list;
    private FirebaseRecyclerViewAdapter<Commande,AccountHolder> adapter;
    ProgressDialog dialog;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //inflate here
        final View view=inflater.inflate(R.layout.fragment_compte,container,false);
        ((PrimoActivity)getActivity()).getSupportActionBar().setTitle("Mon Compte Airtel");






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
