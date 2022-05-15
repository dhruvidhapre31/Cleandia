package com.example.cleandia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import adapters.NotificationAdapter;
import models.NotificationModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notification extends Fragment {

    //The fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    NotificationAdapter adapter;
    ArrayList<NotificationModel> list;
    public Notification() {
        //Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Notification.
     */
    public static Notification newInstance(String param1, String param2) {
        Notification fragment = new Notification();
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
        View view =  inflater.inflate(R.layout.fragment_notification, container, false);
        //Inflate the layout for this fragment
        list = new ArrayList<>();
        list.add(new NotificationModel("25","Jun","Swachhta - Cleanliness drive","Prerna Foundation"));
        list.add(new NotificationModel("02","Jul" , "Lakshya Campaign" ,"SBA NGO"));
        list.add(new NotificationModel("19","Jul" , "'Say no to plastic'" ,"Ujjwala Sanstha"));
        list.add(new NotificationModel("15","Aug" , "Swachhta Rally" ,"Bharat Foundation"));
        list.add(new NotificationModel("19", "Aug","Disposal of Household waste","Keshav NGO"));
        list.add(new NotificationModel("31", "Aug","Mission Clean Gujarat","Nirmala Foundation"));
        list.add(new NotificationModel("02", "Sep","Nirmal Bharat Abhiyaan","Jyoti NGO"));

        RecyclerView Recycler = view.findViewById(R.id.notification_recycler);
        adapter = new NotificationAdapter(list, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        Recycler.setLayoutManager(layoutManager);
        Recycler.setAdapter(adapter);
        return view;
    }
}