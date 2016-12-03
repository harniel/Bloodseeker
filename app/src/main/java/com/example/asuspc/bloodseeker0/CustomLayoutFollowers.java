package com.example.asuspc.bloodseeker0;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CustomLayoutFollowers extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;
    private final String[] bloodtype;
    private final String[] date;


    public CustomLayoutFollowers(Activity context, String[] itemname, Integer[] imgid, String[] bloodtype, String[] date) {
        super(context, R.layout.customlayoutfollowers, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
        this.bloodtype = bloodtype;
        this.date = date;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.customlayoutfollowers, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView bt = (TextView) rowView.findViewById(R.id.bloodtype);
        TextView dt = (TextView) rowView.findViewById(R.id.date);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        bt.setText("Blood Type: "+bloodtype[position]);
        dt.setText("Last Donated: " + date[position]);
        return rowView;

    };
}