package com.example.cleandia;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import adapters.PostAdapter;
import models.PostModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    //The fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    PostAdapter adapter;
    ArrayList<PostModel> list;

    public Home() {
        //Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        //Inflate the layout for this fragment
        list = new ArrayList<>();
        list.add(new PostModel(R.drawable.post1,"Isha Joshi","2","Tejas society, Shashtrinagar ","77"));
        list.add(new PostModel(R.drawable.post2,"Siddharth Shah" , "3" ,"Narolgam, Ahmedabad","45"));
        list.add(new PostModel(R.drawable.post3,"Abhinav Gupta" , "3" ,"Poojya Apt, Akhbarnagar","24"));
        list.add(new PostModel(R.drawable.post4,"Divya Kumari" , "4" ,"Nehrunagar","80"));
        list.add(new PostModel(R.drawable.post5, "Pallavi Parekh","5","Mahavir Society, Gota","78"));

        RecyclerView Recycler = view.findViewById(R.id.post_recycler);
        adapter = new PostAdapter(list, getActivity());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        Recycler.setLayoutManager(layoutManager);
        Recycler.setAdapter(adapter);
        return view;
    }
}