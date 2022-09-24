package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madassignment_1_1.Meals.MealsFrag;
import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.Restaurant;
import com.example.madassignment_1_1.Restaurants.RestaurantList;
import com.example.madassignment_1_1.Restaurants.RestaurantsFrag;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountOrderHistory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountOrderHistory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AccountOrderHistory thisFrag = this;
    private FragmentManager fm = getParentFragmentManager();

    public AccountOrderHistory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountOrderHistory.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountOrderHistory newInstance(String param1, String param2) {
        AccountOrderHistory fragment = new AccountOrderHistory();
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
        //return inflater.inflate(R.layout.fragment_restaurants, container, false);
        View view = inflater.inflate(R.layout.fragment_account_order_history, container, false);
        RecyclerView rv = view.findViewById(R.id.rvOrders);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        OrderAdapter adapter = new OrderAdapter(resList);
//        rv.setAdapter(adapter);
        return view;
    }




    public class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textNum;
        TextView textPrice;
        ImageView img;

        public OrderViewHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            textName = itemView.findViewById(R.id.mealName);
            textNum = itemView.findViewById(R.id.mealNum);
            textPrice = itemView.findViewById(R.id.mealPrice);
            img = itemView.findViewById(R.id.imgMealIcon);

        }
    }





    public class OrderAdapter extends RecyclerView.Adapter<AccountOrderHistory.OrderViewHolder> {

        RestaurantList data;

        public OrderAdapter(RestaurantList data){
            this.data = data;
        }

        @NonNull
        @Override
        public AccountOrderHistory.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.orderhistoryentry,parent,false);
            AccountOrderHistory.OrderViewHolder myViewHolder = new AccountOrderHistory.OrderViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull AccountOrderHistory.OrderViewHolder holder, int position) {
//            Restaurant restaurant = resList.get(position);
//            holder.img.setImageResource(restaurant.getDrawableID());
//            holder.textName.setText(restaurant.getName());
//            holder.textAddress.setText(restaurant.getAddress());

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "clicked menu item", Toast.LENGTH_SHORT).show();
                    //THIS IS WHERE THE "ACTION" HAPPENS
                    fm.beginTransaction().remove(thisFrag).commit();
                    fm.beginTransaction().add(R.id.frameLayout, new AccountSingleOrder()).commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}