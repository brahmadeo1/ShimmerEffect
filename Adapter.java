package mytest.xigmapro.com.shimmereffect;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<ShopDetails> {

    private Context context;
    private int resource;
    private List<ShopDetails> shopDetailsList = new ArrayList<>();
    public Adapter(@NonNull Context context, int resource, List<ShopDetails> shopDetailsList) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.shopDetailsList = shopDetailsList;
    }

    @Override
    public int getCount() {
        return shopDetailsList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        ViewHolder holder;
        if (v == null){

            holder = new ViewHolder();
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            v = inflater.inflate(resource, parent, false);

            holder.name = (TextView) v.findViewById(R.id.name);
            //holder.name.setText(shopDetailsList.get(position).getName());

            holder.rank = (TextView) v.findViewById(R.id.rank);
            //holder.rank.setText(shopDetailsList.get(position).getId());

            holder.thumbnail = (ImageView)v.findViewById(R.id.thumbnail);
            holder.thumbnail.setBackgroundResource(shopDetailsList.get(position).getImage());


            v.setTag(holder);
        }else {
            holder = (ViewHolder)v.getTag();
        }
        return v;
    }

    public class ViewHolder{
        TextView name, rank;
        ImageView thumbnail;
    }
}
