package com.example.rsofinder;

import android.app.Activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sanjeev k Saroj on 28/2/17.
 */

public class CustomAdapter extends BaseAdapter {

    Activity activity;
    ArrayList<RSO> customListDataModelArrayList = new ArrayList<RSO>();
    LayoutInflater layoutInflater = null;

    public CustomAdapter(Activity activity, ArrayList customListDataModelArray){
        this.activity=activity;
        this.customListDataModelArrayList = customListDataModelArray;
        layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return customListDataModelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return customListDataModelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class ViewHolder{
        ImageView image_view;
        TextView tv_name,tv_discription;

    }
    ViewHolder viewHolder = null;


    // this method  is called each time for arraylist data size.
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View vi=view;
        final int pos = position;
        if(vi == null){

            // create  viewholder object for list_rowcell View.
            viewHolder = new ViewHolder();
            // inflate list_rowcell for each row
            vi = layoutInflater.inflate(R.layout.list_row,null);
            viewHolder.image_view = (ImageView) vi.findViewById(R.id.image_view);
            viewHolder.tv_name = (TextView) vi.findViewById(R.id.tv_name);
            viewHolder.tv_discription = (TextView) vi.findViewById(R.id.tv_discription);
            /*We can use setTag() and getTag() to set and get custom objects as per our requirement.
            The setTag() method takes an argument of type Object, and getTag() returns an Object.*/
            vi.setTag(viewHolder);
        }else {

             // We recycle a View that already exists /
                    viewHolder= (ViewHolder) vi.getTag();
        }

        //viewHolder.image_view.setText(customListDataModelArrayList.get(pos).org_name);
        viewHolder.tv_name.setText(customListDataModelArrayList.get(pos).description);
        viewHolder.tv_discription.setText(customListDataModelArrayList.get(pos).org_name);


        return vi;
    }
}