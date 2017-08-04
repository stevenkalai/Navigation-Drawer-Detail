package com.example.mobile.slideshow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public GroupFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroupFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroupFragment newInstance(String param1, String param2) {
        GroupFragment fragment = new GroupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_group, container, false);

        final ArrayList<Grouplist> group=new ArrayList<>();

        Grouplist m1=new Grouplist("Namakal");
        Grouplist m2=new Grouplist("CHENNAI");
        Grouplist m3=new Grouplist("SALEM");
        Grouplist m4=new Grouplist("DINDUKAL");
        Grouplist m5=new Grouplist("CUDDALORE");
        Grouplist m6=new Grouplist("KARUR");
        Grouplist m7=new Grouplist("MADURAI");

        group.add(m1);
        group.add(m2);
        group.add(m3);
        group.add(m4);
        group.add(m5);
        group.add(m6);
        group.add(m7);


        BindDictionary<Grouplist> dictionary=new BindDictionary<>();
        dictionary.addStringField(R.id.textname,new StringExtractor<Grouplist>()

        {
            public String getStringValue(Grouplist group1,int position){
                return group1.getName();
            }
        });


        FunDapter dapter =new FunDapter(GroupFragment.this.getActivity(),group,R.layout.group,dictionary);

        ListView listView=(ListView) view.findViewById(R.id.listviewgroup);
        listView.setAdapter(dapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Grouplist selecteditem= group.get(position);
                Toast.makeText(GroupFragment.this.getActivity(),selecteditem.getName(),Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

}
