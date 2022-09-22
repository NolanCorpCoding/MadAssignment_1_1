package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.madassignment_1_1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountMainPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountMainPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String fNameText;
    private String lNameText;
    private String emailText;
    private String passText;

    private EditText fName;
    private EditText lName;
    private EditText email;
    private EditText pass;

    private Button updateDetails;



    public AccountMainPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountMainPage.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountMainPage newInstance(String param1, String param2) {
        AccountMainPage fragment = new AccountMainPage();
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

        View view = inflater.inflate(R.layout.fragment_account_main_page, container, false);

        fName = (EditText) view.findViewById(R.id.editTextFName);
        lName = (EditText) view.findViewById(R.id.editTextLName);
        email = (EditText) view.findViewById(R.id.editTextEmail);
        pass = (EditText) view.findViewById(R.id.editTextPass);
        updateDetails = (Button) view.findViewById(R.id.updateButton);

        fName.setText(AccountFrag.getFName());
        lName.setText(AccountFrag.getLName());
        email.setText(AccountFrag.getEmail());
        pass.setText(AccountFrag.getPass());

        updateDetails.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String fNameText = fName.getText().toString();
                String lNameText = lName.getText().toString();
                String emailText = email.getText().toString();
                String passText = pass.getText().toString();
                AccountFrag.setDetails(fNameText, lNameText, emailText, passText);
            }
        });

        return view;
    }
}