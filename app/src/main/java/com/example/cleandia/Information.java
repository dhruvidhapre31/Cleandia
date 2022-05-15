package com.example.cleandia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import adapters.InformationAdapter;
import models.InformationModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Information#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Information extends Fragment {
    //The fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    InformationAdapter adapter;
    ArrayList<InformationModel> list;
    public Information() {
        //Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Information.
     */
    public static Information newInstance(String param1, String param2) {
        Information fragment = new Information();
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
        View view = inflater.inflate(R.layout.fragment_information, container, false);
        //Inflate the layout for this fragment
        list = new ArrayList<>();
        list.add(new InformationModel("Agricultural", R.drawable.agricultural));
        list.add(new InformationModel("Chemical", R.drawable.chemical));
        list.add(new InformationModel("Electronic", R.drawable.electronic));
        list.add(new InformationModel("Liquid", R.drawable.liquid));
        list.add(new InformationModel("Kitchen", R.drawable.kitchen));
        list.add(new InformationModel("Medical", R.drawable.medical));
        list.add(new InformationModel("Sewage", R.drawable.sewage));
        list.add(new InformationModel("Industrial", R.drawable.industrial));

        RecyclerView Recycler = view.findViewById(R.id.waste_recycler);
        adapter = new InformationAdapter(list, getActivity());
        GridLayoutManager layoutManager=new GridLayoutManager(getActivity(),2);
        Recycler.setLayoutManager(layoutManager);
        Recycler.setAdapter(adapter);
        return view;
    }
}