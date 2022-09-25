package com.example.madassignment_1_1.Cart;

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
import com.example.madassignment_1_1.Account.UserAccount;
import com.example.madassignment_1_1.Account.UserAccountDBModel;
import com.example.madassignment_1_1.CartMenuItem.CartMenuItem;
import com.example.madassignment_1_1.MainActivity;
import com.example.madassignment_1_1.Meals.Meals;
import com.example.madassignment_1_1.Meals.MealsFrag;
import com.example.madassignment_1_1.Meals.MealsList;
import com.example.madassignment_1_1.R;

import org.w3c.dom.Text;

import java.util.List;

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
    private CartFrag thisFrag;

    private List<CartMenuItem> currentCartItems;
    private int currentCartId;
    private CartList cartList;
    private Cart currCart;

    private MealsList mealsList;

    private TextView totalPriceCart;

    UserAccountDBModel useraccountDBModel;

    CartDBModel cartDBModel;


    public CartFrag() {
        // Required empty public constructor
    }

//    public CartFrag(List<CartMenuItem> currentCartItems){
//        this.currentCartItems = currentCartItems;
//    }

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

        thisFrag = this;
        MainActivity.setFragCurrent(thisFrag);


        currentCartId = AccountFrag.returnDetails().getCurrentCartId();
        cartList = new CartList();
        cartList.load(getContext());

        currCart = cartList.getCart(currentCartId);

        currentCartItems = currCart.getMenuItemList();

        mealsList = new MealsList(getContext());
        mealsList.load(getContext());

        useraccountDBModel = new UserAccountDBModel();
        useraccountDBModel.load(getContext());

        cartDBModel = new CartDBModel();
        cartDBModel.load(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentManager fm = getParentFragmentManager();
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        checkOutButton = (Button) view.findViewById(R.id.payButton);
        totalPriceCart = (TextView) view.findViewById(R.id.cartTotal);
        RecyclerView rv = view.findViewById(R.id.rvCart);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        CartItemAdapter adapter = new CartItemAdapter(currentCartItems);
        // add in the proper list here
        rv.setAdapter(adapter);

        checkOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserAccount user = AccountFrag.returnDetails();
                if(user.getCurrentCart().getMenuItemList() != null)
                {
//                    Cart oldCart = user.getCurrentCart();

//                    user.setPreviousCart(oldCart);

                    Cart newCart = new Cart(0, user.getId());
                    user.setCurrentCart(newCart);
                    user.setCurrentCartID(newCart.getId());

                    cartDBModel.addCart(newCart);

                    useraccountDBModel.updateUserAccount(user, user.getFirstname(), user.getLastname(), user.getEmail(), user.getCurrentCartId(), user.getPass());

                    user.loadPrevCarts(getActivity());

                    Log.d("DEBUG USER CART", "Starting user cart list");

                        for(Cart cartLooping : user.getPreviousCarts())
                        {
                            Log.d("DEBUG USER CART", "User " + user.getId() + " " + user.getFirstname() + " " + user.getLastname() + " has used the cart " + cartLooping.getId() + " and the cart has" +
                                    " a size of " + cartLooping.getMenuItemList().size());
                            for(CartMenuItem menuItem : cartLooping.getMenuItemList())
                            {
                                Meals tempMeal = mealsList.findMeal(menuItem.getMenuItemID());

                                for(int i = 0; i < menuItem.getQuantity(); i++)
                                {
                                    Log.d("DEBUG USER CART", "Meal " + tempMeal.getId() + " " + tempMeal.getName()  + " is in the cart " + menuItem.getCartID());
                                }
                            }
                        }
                        Log.d("DEBUG USER CART",
                                "User " + user.getId() + " " +
                                        user.getFirstname() + " " +
                                        user.getLastname() + " has the current cart of " +
                                        user.getCurrentCartId());

                    }

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
//        TextView totalPrice;
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
//            totalPrice = (TextView)itemView.findViewById(R.id.cartTotal);
        }
    }


    public class CartItemAdapter extends RecyclerView.Adapter<CartFrag.CartItemViewHolder> {

        List<CartMenuItem> data;

        public CartItemAdapter(List<CartMenuItem> data) {
            this.data = data;
        }

        @NonNull
        @Override
        public CartFrag.CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.meal_entry, parent, false);
            CartItemViewHolder myViewHolder = new CartItemViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull CartFrag.CartItemViewHolder holder, int position) {
            int currAdapterPos = position;

            if (AccountFrag.returnDetails() != null)
            {
                CartMenuItem cartMenuItem = currCart.getMenuItemList().get(currAdapterPos);
                Meals currMealItem = mealsList.findMeal(cartMenuItem.getMenuItemID());

                int currentCartId = AccountFrag.returnDetails().getCurrentCartId();
                Cart cart = cartList.getCart(currentCartId);
                cart.calculateTotalPrice(getActivity());
                double totalPrice = cart.getTotalPrice();
                Log.d("FINDOUT", "CART: id=" + cart.getId() + " price=" + totalPrice);

                int quantityShow = cartList.getCartMealItem(currentCartId, currMealItem.getId()).getQuantity();

                holder.mealName.setText(currMealItem.getName());
                holder.mealPrice.setText(String.valueOf(currMealItem.getPrice()));
                holder.img.setImageResource(currMealItem.getDrawableId());
                holder.mealNum.setText(String.valueOf(quantityShow));
                totalPriceCart.setText(String.valueOf(totalPrice));
            }
            else
            {
                holder.mealNum.setText("-100");
            }

            holder.plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // need to update database here
                    // this is probably a dumb way of doing this for now, add a dedicated variable somewhere later

                    if (AccountFrag.returnDetails() != null)
                    {
                        int quantity = Integer.valueOf(holder.mealNum.getText().toString()) + 1;
                        Cart currCart = cartList.getCart(currentCartId);

                        CartMenuItem cartMenuItem = currCart.getMenuItemList().get(currAdapterPos);
                        Meals currMealItem = mealsList.findMeal(cartMenuItem.getMenuItemID());

                        cartList.addMeal(currCart, currMealItem, quantity, getActivity());

                        holder.mealNum.setText(String.valueOf(quantity));

                        totalPriceCart.setText(String.valueOf(currCart.getTotalPrice()));

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
                        Cart currCart = cartList.getCart(currentCartId);

                        CartMenuItem cartMenuItem = currCart.getMenuItemList().get(currAdapterPos);
                        Meals currMealItem = mealsList.findMeal(cartMenuItem.getMenuItemID());

                        cartList.addMeal(currCart, currMealItem, quantity, getActivity());

                        holder.mealNum.setText(String.valueOf(quantity));

                        totalPriceCart.setText(String.valueOf(currCart.getTotalPrice()));

                        Toast.makeText(view.getContext(), "Current cart price = " + currCart.getTotalPrice(), Toast.LENGTH_LONG).show();
                    } else
                    {
                        Toast.makeText(view.getContext(), "Go log into your account to add to your cart", Toast.LENGTH_LONG).show();
                        //link to account sign up/in page
                    }
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
            //return 0;
        }
    }
}