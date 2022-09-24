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

import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.Restaurant;
import com.example.madassignment_1_1.Restaurants.RestaurantList;
import com.example.madassignment_1_1.Restaurants.RestaurantsFrag;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountSingleOrder#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountSingleOrder extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentManager fm = getParentFragmentManager();

    public AccountSingleOrder() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountSingleOrder.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountSingleOrder newInstance(String param1, String param2) {
        AccountSingleOrder fragment = new AccountSingleOrder();
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
        View view = inflater.inflate(R.layout.fragment_account_single_order, container, false);
        RecyclerView rv = view.findViewById(R.id.rvSingleOrder);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        RestaurantsFrag.RestaurantAdapter adapter = new RestaurantsFrag.RestaurantAdapter(resList);
//        rv.setAdapter(adapter);
        return view;
    }







    public class SingleOrderViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textAddress;
        ImageView img;

        public SingleOrderViewHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            textName = itemView.findViewById(R.id.resName);
            textAddress = itemView.findViewById(R.id.resAddr);
            img = itemView.findViewById(R.id.imgResIcon);

        }
    }





    public class SingleOrderAdapter extends RecyclerView.Adapter<AccountSingleOrder.SingleOrderViewHolder> {

        RestaurantList data;

        public SingleOrderAdapter(RestaurantList data){
            this.data = data;
        }

        @NonNull
        @Override
        public AccountSingleOrder.SingleOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.order_entry,parent,false);
            AccountSingleOrder.SingleOrderViewHolder myViewHolder = new AccountSingleOrder.SingleOrderViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull AccountSingleOrder.SingleOrderViewHolder holder, int position) {
//            Restaurant restaurant = resList.get(position);
//            holder.img.setImageResource(restaurant.getDrawableID());
//            holder.textName.setText(restaurant.getName());
//            holder.textAddress.setText(restaurant.getAddress());

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(view.getContext(), "clicked menu item", Toast.LENGTH_SHORT).show();
                    //THIS IS WHERE THE "ACTION" HAPPENS
                    //fm.beginTransaction().remove(thisFrag).commit();
                    //fm.beginTransaction().add(R.id.frameLayout, new AccountSingleOrder()).commit();
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}