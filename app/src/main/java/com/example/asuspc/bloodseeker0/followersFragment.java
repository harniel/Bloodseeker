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

public class followersFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView list;
    private CustomLayoutFollowers customLayoutFollowers;
    String[] date ={
            "December 1, 2015",
            "September 27, 2015",
            "January 19, 2010",
            "May 25, 2014",
            "June 25, 2008",
            "November 30, 2013",
            "February 14, 2015",
            "January 1, 2010",
            "March 31, 2012",
            "April 22, 2012",
            "July 24, 2011",
            "August 13, 2014",
            "October 1, 2009",
            "December 25, 2015",
            "May 22, 2011",
            "March 5, 2006"
    };
    String[] itemname ={
            "Sept Lozada",
            "Allyza Villahermosa",
            "Harniel Salmeron",
            "Kiks Quinio",
            "Mark Antonino",
            "Kimberly Javier",
            "Lorna Miro",
            "Juv-Juv Cuizon",
            "Gene Abello",
            "Carmel Tejana",
            "Glende Brazil",
            "Vicente Patalita",
            "Roderick Bandalan",
            "Roy Salares",
            "Marissa Mahilom",
            "Geoffrey Gudio"
    };
    String[] bloodtype ={
            "O",
            "A+",
            "B",
            "A",
            "AB",
            "O+",
            "AB+",
            "O",
            "A",
            "B",
            "B+",
            "O",
            "O+",
            "A+",
            "AB",
            "O"
    };

    Integer[] imgid={
            R.drawable.a,
            R.drawable.d,
            R.drawable.b,
            R.drawable.c,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.l,
            R.drawable.i,
            R.drawable.j,
            R.drawable.o,
            R.drawable.m,
            R.drawable.n,
            R.drawable.k,
            R.drawable.p,
    };
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfollwer, container, false);
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
        customLayoutFollowers = new CustomLayoutFollowers(getActivity(), itemname, imgid, bloodtype, date);
        ListView listView = (ListView) getActivity()
                .findViewById(R.id.listFollower);
        // Assign adapter to ListView
        listView.setAdapter(customLayoutFollowers);
    }
}
