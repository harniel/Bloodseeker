package com.example.asuspc.bloodseeker0;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by AsusPc on 12/2/2016.
 */

public class SecondFeedAdapter extends ArrayAdapter<String> {
private final Activity context;
private final String[] itemname;
private final Integer[] imgid;
private final String[] bloodtype;
private final String[] date;
private final Integer[] pics;
private final String[] desc;


public SecondFeedAdapter(Activity context, String[] itemname, Integer[] imgid, String[] bloodtype, String[] date, Integer[] pics, String[] desc) {
        super(context, R.layout.feedsecondlayout, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.bloodtype = bloodtype;
        this.date = date;
        this.pics = pics;
        this.desc = desc;
        }

    public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.feedsecondlayout, null,true);


            TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
            TextView bt = (TextView) rowView.findViewById(R.id.bloodtype);
            TextView dt = (TextView) rowView.findViewById(R.id.date);
            TextView des = (TextView) rowView.findViewById(R.id.tvdesc);
            ImageView im = (ImageView) rowView.findViewById(R.id.imPic);


            txtTitle.setText(itemname[position]);
            imageView.setImageResource(imgid[position]);
            bt.setText(bloodtype[position]);
            dt.setText(date[position]);
            im.setImageResource(pics[position]);
            des.setText(desc[position]);

            return rowView;



    };
}