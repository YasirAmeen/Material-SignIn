package app.materialsignup;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.github.siyamed.shapeimageview.CircularImageView;

/**
 * Created by hp on 10/2/2016.
 */

public class ListAdapter extends BaseAdapter {


    private Context context;
    private LayoutInflater inflater = null;

    String[] titles = {"New subpage for Janet","Catch up with John","Dinner with Yasir"};
    String[] desc = {"08 - 10am","10 - 12pm", "02 - 04pm"};
    int[] images = {R.drawable.janet,R.drawable.john,R.drawable.my_dp};


    ListAdapter(Context con) {

        this.context = con;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return titles.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {



        ViewHolder holder;
        if(convertview == null) {

            convertview =inflater.inflate(R.layout.list_item_layout,null);
            holder = new ViewHolder();

            holder._dp = (CircularImageView) convertview.findViewById(R.id.iv_dp);
            holder._title = (TextView) convertview.findViewById(R.id.txt_title);
            holder._desc = (TextView) convertview.findViewById(R.id.txt_desc);

            convertview.setTag(holder);

        } else {
            holder = (ViewHolder) convertview.getTag();
        }


        holder._title.setText(titles[i]);
        holder._desc.setText(desc[i]);
        holder._dp.setImageResource(images[i]);




        return convertview;
    }



    public class ViewHolder {



        CircularImageView _dp;
        TextView _title;
        TextView _desc;



    }
}
