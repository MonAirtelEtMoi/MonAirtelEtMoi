package lab.synah.cd.monairteletmoi.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import lab.synah.cd.monairteletmoi.R;
import lab.synah.cd.monairteletmoi.utils.ItemClickListener;

/**
 * Created by Michelo on 05/01/16.
 */
public class AccountHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public final ImageView icone;
    public final TextView ussd;
    public final TextView description;
    public final ProgressBar progressBar;
    public ItemClickListener clickListener;


    public AccountHolder(View itemView){
        super(itemView);
        icone = (ImageView) itemView.findViewById(R.id.logo);
        ussd = (TextView) itemView.findViewById(R.id.ussd);
        description = (TextView) itemView.findViewById(R.id.description);
        progressBar = (ProgressBar) itemView.findViewById(R.id.progress);
        itemView.setOnClickListener(this);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    @Override
    public void onClick(View v) {
        clickListener.onClick(v, getPosition(), false);
    }


}
