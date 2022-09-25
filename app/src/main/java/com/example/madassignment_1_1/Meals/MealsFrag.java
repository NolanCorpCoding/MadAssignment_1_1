package com.example.madassignment_1_1.Meals;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madassignment_1_1.Account.AccountFrag;
import com.example.madassignment_1_1.Cart.Cart;
import com.example.madassignment_1_1.Cart.CartFrag;
import com.example.madassignment_1_1.Cart.CartList;
import com.example.madassignment_1_1.CartMenuItem.CartMenuItem;
import com.example.madassignment_1_1.MainActivity;
import com.example.madassignment_1_1.R;
import com.example.madassignment_1_1.Restaurants.Restaurant;
import com.example.madassignment_1_1.Restaurants.RestaurantList;
import com.example.madassignment_1_1.Restaurants.RestaurantsFrag;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MealsFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MealsFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MealsList mealsList;

    private Button checkOutButton;

    private MealsFrag thisFrag;

    private FragmentManager fm;

    private CartList cartList;


    public MealsFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static MealsFrag newInstance(String param1, String param2) {
        MealsFrag fragment = new MealsFrag();
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

        thisFrag = this;
        MainActivity.setFragCurrent(thisFrag);

        fm = getParentFragmentManager();

        cartList = new CartList();
        cartList.load(getContext());

        mealsList = new MealsList(getContext());
        mealsList.load(getContext());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        checkOutButton = (Button) view.findViewById(R.id.checkOutButton);
        RecyclerView rv = view.findViewById(R.id.rvFood);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        MealsFrag.MealAdapter adapter = new MealsFrag.MealAdapter(mealsList);
        rv.setAdapter(adapter);

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AccountFrag.returnDetails() != null) {
                    fm.beginTransaction().remove(thisFrag).commit();
                    Log.d("debug Sam", thisFrag.toString());

                    fm.beginTransaction().add(R.id.frameLayout, new CartFrag()).commit();
                }
                else
                {
                    Toast.makeText(view.getContext(), "Please make an account first", Toast.LENGTH_LONG).show();
                }
            }
        });


        return view;
    }

    public class MealViewHolder extends RecyclerView.ViewHolder {
        TextView mealName;
        TextView mealPrice;
        TextView mealNum;
        ImageView img;
        Button plus;
        Button minus;
        Button checkout;

        public MealViewHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            mealName = itemView.findViewById(R.id.mealName);
            mealPrice = itemView.findViewById(R.id.mealPrice);
            mealNum = itemView.findViewById(R.id.mealNum);
            img = itemView.findViewById(R.id.imgMealIcon);
            plus = itemView.findViewById(R.id.plusButton);
            minus = itemView.findViewById(R.id.minusButton);
            checkout = itemView.findViewById(R.id.checkOutButton);

        }
    }





    public class MealAdapter extends RecyclerView.Adapter<MealsFrag.MealViewHolder> {

        MealsList data;

        public MealAdapter(MealsList data){
            this.data = data;
        }

        @NonNull
        @Override
        public MealsFrag.MealViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.meal_entry,parent,false);
            MealsFrag.MealViewHolder myViewHolder = new MealsFrag.MealViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MealsFrag.MealViewHolder holder, int position) {
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


            try {
                int currentCartId = AccountFrag.returnDetails().getCurrentCartId();

                int quantityShow = cartList.getCartMealItem(currentCartId, meal.getId()).getQuantity();
                holder.mealNum.setText(String.valueOf(quantityShow));
            }
            catch(NullPointerException e)
            {
                holder.mealNum.setText("0");
            }

            // the number of meals in the cart needs to gotten from the cart i believe

            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // need to update database here ***********************************
                    if (AccountFrag.returnDetails() != null) {
                        int quantity = Integer.valueOf(holder.mealNum.getText().toString()) + 1;
                        int currentCartId = AccountFrag.returnDetails().getCurrentCartId();
                        Cart currCart = cartList.getCart(currentCartId);

                        cartList.addMeal(currCart, meal, quantity, getActivity());

                        holder.mealNum.setText(String.valueOf(quantity));


                        Toast.makeText(view.getContext(), "Current cart price = " + currCart.getTotalPrice(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(view.getContext(), "Go log into your account to add to your cart", Toast.LENGTH_LONG).show();
                        //link to account sign up/in page
                    }

                }
            });

            holder.minus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (AccountFrag.returnDetails() != null)
                    {
                        int quantity = Integer.valueOf(holder.mealNum.getText().toString()) - 1;
                        int currentCartId = AccountFrag.returnDetails().getCurrentCartId();
                        Cart currCart = cartList.getCart(currentCartId);

                        cartList.addMeal(currCart, meal, quantity, getActivity());

                        holder.mealNum.setText(String.valueOf(quantity));


                        Toast.makeText(view.getContext(), "Current cart price = " + currCart.getTotalPrice(), Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(view.getContext(), "Go log into your account to add to your cart", Toast.LENGTH_LONG).show();
                        //link to account sign up/in page
                    }
                 }
            });

//            holder.checkout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(view.getContext(), "WORKING", Toast.LENGTH_LONG).show();
//                }
//            });

        }

        @Override
        public int getItemCount() {
            return data.size();
            //return 0;
        }
    }
}