package lab.synah.cd.monairteletmoi.adapter;

/**
 * Created by Michelo on 05/01/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import lab.synah.cd.monairteletmoi.R;

public class RecyclerAdapter extends Adapter<RecyclerAdapter.ViewHolder> {
    private String[] mDataset;
    private Context mContext;

    public RecyclerAdapter(String[] dataset, Context context) {
        mDataset = dataset;
        mContext = context;
    }

    // Not use static
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text);
            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            mContext,
                            "onItemClick - " + getPosition() + " - "
                                    + mTextView.getText().toString() + " - "
                                    + mDataset[getPosition()], 0).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recycle_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }
}
