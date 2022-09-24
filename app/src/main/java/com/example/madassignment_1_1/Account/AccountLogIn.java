package com.example.madassignment_1_1.Account;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.madassignment_1_1.R;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountLogIn#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountLogIn extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private EditText email;
    private EditText pass;
    private Button next;
    private AccountLogIn thisFrag = this;

    private UserAccountList useracctList;

    public AccountLogIn() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AccountLogIn.
     */
    // TODO: Rename and change types and number of parameters
    public static AccountLogIn newInstance(String param1, String param2) {
        AccountLogIn fragment = new AccountLogIn();
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

        useracctList = new UserAccountList();
        useracctList.load(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account_log_in, container, false);



        email = (EditText) view.findViewById(R.id.editTextEmail);
        pass = (EditText) view.findViewById(R.id.editTextPass);
        next = (Button) view.findViewById(R.id.logOutMain);


        FragmentManager fm = getParentFragmentManager();

        //mainPage = (AccountMainPage) fm.findFragmentById(R.id.subMenu_frag_container);


        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    String emailText = email.getText().toString();
                    String passText = pass.getText().toString();

                    UserAccount tempAccount = useracctList.findUser(emailText, passText);
                    AccountFrag.setDetails(tempAccount);
                    Toast.makeText(view.getContext(), "************************ ", Toast.LENGTH_LONG).show();

                    fm.beginTransaction().remove(thisFrag).commit();
                    //fragCurrent = fragRes;

                    // DO THE DB VALIDATION HERE, GET THE FIRST/LAST NAME AS WELL IF POSSIBLE

                    fm.beginTransaction().add(R.id.subMenu_frag_container, new AccountMainPage()).commit();
                }
                catch(IllegalArgumentException e)
                {
                    Toast.makeText(view.getContext(), "Failed to log into account with those details ... try again", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}