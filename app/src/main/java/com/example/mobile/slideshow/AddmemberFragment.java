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
 * Use the {@link AddmemberFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddmemberFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public AddmemberFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddmemberFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddmemberFragment newInstance(String param1, String param2) {
        AddmemberFragment fragment = new AddmemberFragment();
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
        View view=inflater.inflate(R.layout.fragment_addmember, container, false);

        final ArrayList<Memberlist> member=new ArrayList<>();

        Memberlist m1=new Memberlist("Name *");
        Memberlist m2=new Memberlist("Date of Birth *");
        Memberlist m3=new Memberlist("Father Name *");
        Memberlist m4=new Memberlist("Phone/Mobile *");
        Memberlist m5=new Memberlist("Job/Business");
        Memberlist m6=new Memberlist("Email *");
        Memberlist m7=new Memberlist("Blood Group");
        Memberlist m8=new Memberlist("Address");
        Memberlist m9=new Memberlist("Pin Code *");
        Memberlist m10=new Memberlist("Upload Your Picture");

        member.add(m1);
        member.add(m2);
        member.add(m3);
        member.add(m4);
        member.add(m5);
        member.add(m6);
        member.add(m7);
        member.add(m8);
        member.add(m9);
        member.add(m10);



        BindDictionary<Memberlist> dictionary=new BindDictionary<>();
        dictionary.addStringField(R.id.textname,new StringExtractor<Memberlist>()

        {
            public String getStringValue(Memberlist member1,int position){
                return member1.getName();
            }
        });


        FunDapter dapter =new FunDapter(AddmemberFragment.this.getActivity(),member,R.layout.member,dictionary);

        ListView listView=(ListView) view.findViewById(R.id.listviewmember);
        listView.setAdapter(dapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Memberlist selecteditem= member.get(position);
                Toast.makeText(AddmemberFragment.this.getActivity(),selecteditem.getName(),Toast.LENGTH_LONG).show();

            }
        });


        return view;
    }

}
