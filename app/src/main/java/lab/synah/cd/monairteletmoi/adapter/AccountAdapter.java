package lab.synah.cd.monairteletmoi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.ArrayList;

import lab.synah.cd.monairteletmoi.R;
import lab.synah.cd.monairteletmoi.model.Commande;
import lab.synah.cd.monairteletmoi.utils.Config;

/**
 * Created by Michelo on 04/01/16.
 */
public class AccountAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Commande> commandes;

    public AccountAdapter(Context context, ArrayList<Commande> commandes){
        this.context=context;
        this.commandes=commandes;
    }

    public static class ViewHolder{
        public final ImageView account_image;
        public final TextView account_name;
        public final TextView account_description;

        public ViewHolder(View v){
            account_image=(ImageView) v.findViewById(R.id.account_image);
            account_name=(TextView)v.findViewById(R.id.account_name);
            account_description=(TextView)v.findViewById(R.id.account_description);

        }
    }

    @Override
    public int getCount() {
        return commandes.size();
    }

    @Override
    public Object getItem(int i) {
        return commandes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup){

        Commande commande=commandes.get(i);
        View v = view;

        final ViewHolder vH;
        if(v==null){
            v= LayoutInflater.from(context).inflate(R.layout.account_items,viewGroup,false);
            vH=new ViewHolder(v);
            v.setTag(vH);
        }else{
            vH=(ViewHolder)v.getTag();
        }

        vH.account_name.setText(commande.getName());
        vH.account_description.setText(commande.getDescription());
        Glide.with(context)
                .load(Config.BACKEND_IMAGES_PATH + commande.getImage())
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.ic_action_moncompte)
                .into(new BitmapImageViewTarget(vH.account_image){

                    @Override
                    protected void setResource(Bitmap resource){
                        RoundedBitmapDrawable circularBitmapDrawable=
                                RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                        circularBitmapDrawable.setCircular(true);
                        vH.account_image.setImageDrawable(circularBitmapDrawable);
                    }

                });
        return v;
    }


}
