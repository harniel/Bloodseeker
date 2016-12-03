package com.example.asuspc.bloodseeker0;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by AsusPc on 11/30/2016.
 */

public class FeedFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView list;
    private FeedAdapter feedAdapter;
    String[] date ={
            "",
            "",
            "",
            "",
    };
    String[] bloodtype ={
            "10 minutes ago",
            "6 hours ago",
            "23 hours ago",
            "1 day ago",
    };

    String[] desc ={
            "Come and join us as we have our Million Volunteer Run. Run and save lives.",
            "Harniel Salmeron earned 50 blood points by donating blood. What are you waiting for? Donate blood, earn points and save lives!",
            "Kiks Quinio attend Cebu Doctors Hospital's Bloodletting campaign.",
            "Mark Antonino redeemed a reward from Happy Fit Gym. Congratulatioins, Mark!",
    };

    String[] itemname ={
            "Philippine Red Cross",
            "Harniel Salmeron",
            "Kiks Quinio",
            "Mark Antonino",
    };


    Integer[] pics= {
            R.drawable.m,
            R.drawable.h4,
            R.drawable.h5,
            R.drawable.h6,
    };

    Integer[] imgid={
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p4,
            R.drawable.p5,




//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.l,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.o,
//            R.drawable.m,
//            R.drawable.n,
//            R.drawable.k,
//            R.drawable.p,
    };
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfeed, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        NotificationAdapter adapter = new NotificationAdapter(getActivity(), itemname, imgid, bloodtype, date);
//        setListAdapter(list);
//        getListView().setOnItemClickListener(this);
        displayListView();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    private void displayListView() {
        // create an ArrayAdaptar from the String Array
        feedAdapter = new FeedAdapter(getActivity(), itemname, imgid, bloodtype, date, pics, desc);
        ListView listView = (ListView) getActivity()
                .findViewById(R.id.listFeed);
        // Assign adapter to ListView
        listView.setAdapter(feedAdapter);
    }
}
