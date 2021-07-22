package com.example.tarot101.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;

import com.example.tarot101.R;
import com.example.tarot101.models.Card;
import com.example.tarot101.models.CardKey;
import com.example.tarot101.network.CardApi;
import com.example.tarot101.network.CardRetrofit;
import com.example.tarot101.rv.CardAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "CardListFragment";
    private RecyclerView cardRecyclerView;
    private FragmentInterface fragmentInterface;
    private CardAdapter cardAdapter;
    private List<Card> cardNameList = new ArrayList<>();
    private String mParam1;
    private String mParam2;

    public CardListFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CardListFragment newInstance() {
        CardListFragment fragment = new CardListFragment();
//        Bundle args = new Bundle();
//
//        fragment.setArguments(args);
        return new CardListFragment();
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
        return inflater.inflate(R.layout.fragment_card_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardRecyclerView = view.findViewById(R.id.card_list_recyclerview);

        final Retrofit retrofit = CardRetrofit.getCardRetrofit();
        CardApi cardApi = retrofit.create(CardApi.class);


        Call<CardKey> resultCall = cardApi.getCardInfo();
        resultCall.enqueue(new Callback<CardKey>() {
            @Override
            public void onResponse(Call<CardKey> call, Response<CardKey> response) {
                cardNameList = response.body().getCards();
                cardAdapter = new CardAdapter(cardNameList,fragmentInterface);
                cardRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
                cardRecyclerView.setAdapter(cardAdapter);

            }

            @Override
            public void onFailure(Call<CardKey> call, Throwable t) {

            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = (FragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement FragmentInterface");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}