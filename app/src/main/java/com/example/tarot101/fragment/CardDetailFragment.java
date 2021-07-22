package com.example.tarot101.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tarot101.R;
import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;
import com.example.tarot101.network.CardApi;
import com.example.tarot101.network.CardRetrofit;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardDetailFragment extends Fragment {

    private Card cardKey;
    private static final String CARD_KEY = "card";
    private FragmentInterface fragmentInterface;
    private TextView detailCardType;
    private TextView detailCardName;
    private TextView detailCardSuit;
    private TextView detailCardNormal;
    private TextView detailCardReversed;
    private TextView detailCardDesc;



    public CardDetailFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CardDetailFragment newInstance(String card) {
        CardDetailFragment fragment = new CardDetailFragment();
        Bundle args = new Bundle();
        args.putString(CARD_KEY, card);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            String json = getArguments().getString(CARD_KEY);
            cardKey = new Gson().fromJson(json, Card.class);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        detailCardType = view.findViewById(R.id.detail_card_type);
        detailCardName = view.findViewById(R.id.detail_card_name);
        detailCardSuit = view.findViewById(R.id.detail_card_suit);
        detailCardNormal = view.findViewById(R.id.detail_card_normal);
        detailCardReversed = view.findViewById(R.id.detail_card_reversed);
        detailCardDesc = view.findViewById(R.id.detail_card_desc);

        detailCardType.setText(getArguments().getString(cardKey.getType()));
        detailCardName.setText(cardKey.getName());
        detailCardSuit.setText(cardKey.getSuit());

        if(cardKey.getSuit()==null){
            detailCardSuit.setText(view.getContext().getString(R.string.detail_null_suit));

        }
        detailCardNormal.setText(cardKey.getMeaning_up());
        detailCardReversed.setText(cardKey.getMeaning_rev());
        detailCardDesc.setText(cardKey.getDesc());
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString() +
                    " must implement fragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        fragmentInterface = null;
    }
}