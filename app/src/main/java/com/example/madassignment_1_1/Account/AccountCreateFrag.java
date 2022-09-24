package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.madassignment_1_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountCreateFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountCreateFrag extends Fragment {

    private UserAccountList useracctList;
    private EditText fName;
    private EditText lName;
    private EditText email;
    private EditText pass;
    private Button next;
    private Button logIn;
    private AccountMainPage mainPage;
    private AccountCreateFrag thisFrag = this;

    public AccountCreateFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountCreateFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountCreateFrag newInstance(String param1, String param2) {
        AccountCreateFrag fragment = new AccountCreateFrag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_account_create, container, false);

        fName = (EditText) view.findViewById(R.id.editTextFName);
        lName = (EditText) view.findViewById(R.id.editTextLName);
        email = (EditText) view.findViewById(R.id.editTextEmail);
        pass = (EditText) view.findViewById(R.id.editTextPass);
        next = (Button) view.findViewById(R.id.logOutMain);
        logIn = (Button) view.findViewById(R.id.logInButton);


        FragmentManager fm = getParentFragmentManager();

        //mainPage = (AccountMainPage) fm.findFragmentById(R.id.subMenu_frag_container);


        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if (mainPage == null)
                {
                    mainPage = new AccountMainPage();
                }
                String fNameText = fName.getText().toString();
                String lNameText = lName.getText().toString();
                String emailText = email.getText().toString();
                String passText = pass.getText().toString();

                UserAccount tempAccount = useracctList.findUser(fNameText, lNameText, emailText, passText);
                AccountFrag.setDetails(tempAccount);

                fm.beginTransaction().remove(thisFrag).commit();
                //fragCurrent = fragRes;

                fm.beginTransaction().add(R.id.subMenu_frag_container, mainPage).commit();
            }
        }
        );

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction().remove(thisFrag).commit();
                //fragCurrent = fragRes;

                fm.beginTransaction().add(R.id.subMenu_frag_container, new AccountLogIn()).commit();
            }
        });




        return view;
    }
}