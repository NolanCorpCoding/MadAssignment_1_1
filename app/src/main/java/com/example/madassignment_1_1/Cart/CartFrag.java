package com.example.madassignment_1_1.Cart;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.madassignment_1_1.Meals.Meals;
import com.example.madassignment_1_1.Meals.MealsFrag;
import com.example.madassignment_1_1.Meals.MealsList;
import com.example.madassignment_1_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button checkOutButton;
    private CartFrag thisFrag = this;

    public CartFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static CartFrag newInstance(String param1, String param2) {
        CartFrag fragment = new CartFrag();
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
        FragmentManager fm = getParentFragmentManager();
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        checkOutButton = (Button) view.findViewById(R.id.payButton);
        RecyclerView rv = view.findViewById(R.id.rvCart);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        MealsFrag.MealAdapter adapter = new MealsFrag.MealAdapter(mealsList);
        // add in the proper list here
        rv.setAdapter(adapter);

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().remove(thisFrag).commit();
                //fragCurrent = fragRes;

                fm.beginTransaction().add(R.id.frameLayout, new PaidFrag()).commit();
            }
        });


        return view;
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {
        TextView mealName;
        TextView mealPrice;
        TextView mealNum;
        ImageView img;
        Button plus;
        Button minus;

        public CartItemViewHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            mealName = itemView.findViewById(R.id.mealName);
            mealPrice = itemView.findViewById(R.id.mealPrice);
            mealNum = itemView.findViewById(R.id.mealNum);
            img = itemView.findViewById(R.id.imgMealIcon);
            plus = itemView.findViewById(R.id.plusButton);
            minus = itemView.findViewById(R.id.minusButton);

        }
    }





    public class CartItemAdapter extends RecyclerView.Adapter<CartFrag.CartItemViewHolder> {

        MealsList data;

        public CartItemAdapter(MealsList data){
            this.data = data;
        }

        @NonNull
        @Override
        public CartFrag.CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.meal_entry,parent,false);
            CartFrag.CartItemViewHolder myViewHolder = new CartFrag.CartItemViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CartFrag.CartItemViewHolder holder, int position) {
//            Restaurant restaurant = resList.get(position);
//            holder.img.setImageResource(restaurant.getDrawableID());
//            holder.textName.setText(restaurant.getName());
//            holder.textAddress.setText(restaurant.getAddress());

//            holder.img.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "clicked menu item", Toast.LENGTH_SHORT).show(); //doesnt work
//                    //Menu.setSelected(structure);
//                    //THIS IS WHERE THE "ACTION" HAPPENS
//                }
//            });
            Meals meal = mealsList.get(position);
            holder.mealName.setText(meal.getName());
            holder.mealPrice.setText(String.valueOf(meal.getPrice()));
            holder.img.setImageResource(meal.getDrawableId());

            holder.mealNum.setText("0");
            // the number of meals in the cart needs to gotten from the cart i believe

            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // need to update database here
                    holder.mealNum.setText( Double.toString(Double.parseDouble(holder.mealNum.getText().toString()) + 1));
                    // this is probably a dumb way of doing this for now, add a dedicated variable somewhere later
                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // need to update database here
                    if (Double.parseDouble(holder.mealNum.getText().toString()) >= 1.0)
                    {
                        holder.mealNum.setText( Double.toString(Double.parseDouble(holder.mealNum.getText().toString()) - 1));
                    }
                    // this is probably a dumb way of doing this for now, add a dedicated variable somewhere later
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
            //return 0;
        }
}