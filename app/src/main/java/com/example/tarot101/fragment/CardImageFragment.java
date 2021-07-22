package com.example.tarot101.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tarot101.R;
import com.example.tarot101.rv.ImageViewPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardImageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardImageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView cardImageView;
    private List<Fragment> fragmentList = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CardImageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CardImageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardImageFragment newInstance(Integer image) {
        CardImageFragment fragment = new CardImageFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM2, String.valueOf(image));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_image, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cardImageView = view.findViewById(R.id.card_image);
        fragmentList.add(CardImageFragment.newInstance(R.drawable.themagician_01));

        //ViewPager viewPager = findViewById(R.id.image_viewpager);
        //viewPager.setAdapter(new ImageViewPagerAdapter(getSupportFragmentManager(),fragmentList));


    }
}