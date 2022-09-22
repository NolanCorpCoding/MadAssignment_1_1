package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madassignment_1_1.R;


public class AccountFrag extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private static String currFName;
    private static String currLName;
    private static String currEmail;
    private static String currPass;

    public static void setDetails(String fName, String lName, String email, String pass){
        currFName = fName;
        currLName = lName;
        currEmail = email;
        currPass = pass;
    }

    public static String getFName(){
        return currFName;
    }

    public static String getLName(){
        return currLName;
    }

    public static String getEmail(){
        return currEmail;
    }

    public static String getPass(){
        return currPass;
    }


    public AccountFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountFrag newInstance(String param1, String param2) {
        AccountFrag fragment = new AccountFrag();
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
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Fragment childFragment = new AccountCreateFrag();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.subMenu_frag_container, childFragment).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.parent_fragment_account, container, false);
    }
}