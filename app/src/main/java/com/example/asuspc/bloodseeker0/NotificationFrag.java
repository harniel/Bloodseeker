package com.example.asuspc.bloodseeker0;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by AsusPc on 11/30/2016.
 */

public class NotificationFrag extends Fragment implements AdapterView.OnItemClickListener {
    private ListView list;
    private NotificationAdapter notificationAdapter;
    String[] date ={
            "1 km away",
            "",
            "",
            "",
            "",
            "",
            "1.5 km away",
            "",
            "2 km away",
            "",
            "",
            "2 km away",
            "",
            "",
            "",
            "",
    };
    String[] bloodtype ={
            "Just now",
            "10 minutes ago",
            "24 minutes ago",
            "10 hours ago",
            "12 hours ago",
            "12 hours ago",
            "2 days ago",
            "2 days ago",
            "1 week ago",
            "1 week ago",
            "1 week ago+",
            "9 days ago",
            "9 days ago",
            "10 days ago",
            "16 days ago",
            "17 days ago"
    };
    String[] itemname ={
            "Somebody needs your blood right now. Are you willing to donate?",
            "Sept Lozada started following you.",
            "Allyza Villahermosa started following you.",
            "It has been 30 days since you donated. You can now donate and save lives!",
            "You have unlocked new reward. Check and redeem your reward now!",
            "Congratulations! You have earned 25 points. You have now 100 points.",
            "Philippine Red Cross added a new event. You should never miss this. Join now!",
            "Kiks Quinio started following you.",
            "Manila Doctors' Hospital added a new Event. Join and earn some rewards!",
            "You have unlocked new reward. Check and redeem your reward now!",
            "Congratulations! You have earned 25 points. You have now 75 points.",
            "St. Luke's Hospital added a new event. Don't miss the chance to help others!",
            "Roderick Bandalan started following you",
            "Roy Salares started following you",
            "30 days left before you can donate. Feeling excited?",
            "Geoffrey Gudio started following you."
    };


    Integer[] imgid={
            R.drawable.n4,
            R.drawable.n1,
            R.drawable.n2,
            R.drawable.n8,
            R.drawable.n6,
            R.drawable.n5,
            R.drawable.n3,
            R.drawable.kiks,
            R.drawable.n7,
            R.drawable.n6,
            R.drawable.n5,
            R.drawable.n9,
            R.drawable.rod,
            R.drawable.roy,
            R.drawable.n10,
            R.drawable.geof,




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
        View view = inflater.inflate(R.layout.fragment_notification, container, false);
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
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

    private void displayListView() {

        // create an ArrayAdaptar from the String Array
        notificationAdapter = new NotificationAdapter(getActivity(), itemname, imgid, bloodtype, date);
        ListView listView = (ListView) getActivity()
                .findViewById(R.id.list);
        // Assign adapter to ListView
        listView.setAdapter(notificationAdapter);
    }

}
