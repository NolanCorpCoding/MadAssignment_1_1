package com.example.madassignment_1_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.madassignment_1_1.Account.AccountFrag;
import com.example.madassignment_1_1.Cart.CartFrag;
import com.example.madassignment_1_1.LandingPage.LandingPageFrag;
import com.example.madassignment_1_1.Meals.MealsFrag;
import com.example.madassignment_1_1.Restaurants.RestaurantsFrag;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;

    private LandingPageFrag fragLand;
    private RestaurantsFrag fragRes;
    private MealsFrag fragMeals;
    private CartFrag fragCart;
    private AccountFrag fragAcc;

    private Fragment fragCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        Log.d("debug Sam", "test main");


        FragmentManager fm = getSupportFragmentManager();
        fragLand = (LandingPageFrag) fm.findFragmentById(R.id.frameLayout);
        fragRes = (RestaurantsFrag) fm.findFragmentById(R.id.frameLayout);
        fragMeals = (MealsFrag) fm.findFragmentById(R.id.frameLayout);
        fragCart = (CartFrag) fm.findFragmentById(R.id.frameLayout);
        fragAcc = (AccountFrag) fm.findFragmentById(R.id.frameLayout);


        if (fragLand == null)
        {
            fragLand = new LandingPageFrag();
            fragCurrent = fragLand;
            fm.beginTransaction().add(R.id.frameLayout, fragLand).commit();
        }

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragLand == null)
                {
                    fragLand = new LandingPageFrag();
                }
                fm.beginTransaction().remove(fragCurrent).commit();
                fragCurrent = fragLand;
                fm.beginTransaction().add(R.id.frameLayout, fragLand).commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragRes == null)
                {
                    fragRes = new RestaurantsFrag();
                }
                fm.beginTransaction().remove(fragCurrent).commit();
                fragCurrent = fragRes;
                fm.beginTransaction().add(R.id.frameLayout, fragRes).commit();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragCart == null)
                {
                    fragCart = new CartFrag();
                }
                fm.beginTransaction().remove(fragCurrent).commit();
                fragCurrent = fragCart;
                fm.beginTransaction().add(R.id.frameLayout, fragCart).commit();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragAcc == null)
                {
                    fragAcc = new AccountFrag();
                }
                fm.beginTransaction().remove(fragCurrent).commit();
                fragCurrent = fragAcc;
                fm.beginTransaction().add(R.id.frameLayout, fragAcc).commit();
            }
        });
    }
}