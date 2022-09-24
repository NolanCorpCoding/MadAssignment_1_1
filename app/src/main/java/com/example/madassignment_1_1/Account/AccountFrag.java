package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.FragmentTransaction;

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


public class AccountFrag extends Fragment {

    private UserAccountList useracctList;
    private TextView title;
    private RecyclerView rv;
    private LinearLayoutManager rvLayout;

    private static UserAccount loggedInUserAccount;

    public static void setDetails(UserAccount pUserAccount){
        loggedInUserAccount = pUserAccount;
    }

    public static void updateDetails(String pFirstname, String pLastname, String pEmail, String pPass)
    {
        loggedInUserAccount.updateFirstname(pFirstname);
        loggedInUserAccount.updateLastname(pLastname);
        loggedInUserAccount.updateEmail(pEmail);
        loggedInUserAccount.updatePass(pPass);
    }

    public static void loggoutAccount()
    {
        loggedInUserAccount = null;
    }

    public static String getFName(){
        return loggedInUserAccount.getFirstname();
    }

    public static String getLName(){
        return loggedInUserAccount.getLastname();
    }

    public static String getEmail(){ return loggedInUserAccount.getEmail(); }

    public static String getPass(){
        return loggedInUserAccount.getPass();
    }


    public AccountFrag() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static AccountFrag newInstance(String param1, String param2) {
        AccountFrag fragment = new AccountFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) { }
        useracctList = new UserAccountList();
        useracctList.load(getActivity());
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
//        return inflater.inflate(R.layout.fragment_account, container, false);
        View view = inflater.inflate(R.layout.parent_fragment_account, container, false);
//        RecyclerView rv = view.findViewById(R.id.rvUserAcct);
//        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        UserAccountAdapter adapter = new UserAccountAdapter(useracctList);
//        rv.setAdapter(adapter);
        return view;
    }

//    public class UserAccountViewHolder extends RecyclerView.ViewHolder {
//        TextView textName;
//        TextView textEmail;
//        TextView textPass;
//
//        public UserAccountViewHolder(@NonNull View itemView, ViewGroup parent) {
//            super(itemView);
//            textName = itemView.findViewById(R.id.tempUserName);
//            textEmail = itemView.findViewById(R.id.tempUserEmail);
//            textPass = itemView.findViewById(R.id.tempUserPassword);
//
//        }
//    }


//    public class UserAccountAdapter extends RecyclerView.Adapter<AccountFrag.UserAccountViewHolder> {
//
//        UserAccountList data;
//
//        public UserAccountAdapter(UserAccountList data){
//            this.data = data;
//        }
//
//        @NonNull
//        @Override
//        public AccountFrag.UserAccountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            Log.d("adapter: ", "on create view");
//            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//            View view = layoutInflater.inflate(R.layout.temp_account_entry,parent,false);
//            AccountFrag.UserAccountViewHolder myViewHolder = new AccountFrag.UserAccountViewHolder(view, parent);
//            return myViewHolder;
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull AccountFrag.UserAccountViewHolder holder, int position) {
//            UserAccount userAccount = useracctList.get(position);
//            holder.textName.setText(userAccount.getFirstname() + " " + userAccount.getLastname());
//            holder.textEmail.setText(userAccount.getEmail());
//            holder.textPass.setText(userAccount.getPass());
//        }
//
//        @Override
//        public int getItemCount() {
//            return data.size();
//        }
//    }
}