package com.example.madassignment_1_1.Restaurants;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RestaurantsFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RestaurantsFrag extends Fragment {

    private RestaurantList resList;
    private TextView title;
    private RecyclerView rv;
    private LinearLayoutManager rvLayout;


    public RestaurantsFrag() {
        // Required empty public constructor
    }

    public RestaurantsFrag(RestaurantList data) {this.resList = data;}

    // TODO: Rename and change types and number of parameters
    public static RestaurantsFrag newInstance(String param1, String param2) {
        RestaurantsFrag fragment = new RestaurantsFrag();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }

        resList = new RestaurantList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_restaurants, container, false);
        View view = inflater.inflate(R.layout.fragment_restaurants, container, false);
        RecyclerView rv = view.findViewById(R.id.rvRes);
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        RestaurantAdapter adapter = new RestaurantAdapter(resList);
        rv.setAdapter(adapter);
        return view;
    }







    public class RestaurantViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        ImageView img;

        public RestaurantViewHolder(@NonNull View itemView, ViewGroup parent) {
            super(itemView);
            text = itemView.findViewById(R.id.resName);
            img = itemView.findViewById(R.id.imgResIcon);

        }
    }





    public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantViewHolder> {

        RestaurantList data;

        public RestaurantAdapter(RestaurantList data){
            this.data = data;
        }

        @NonNull
        @Override
        public RestaurantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.d("adapter: ", "on create view");
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.restaurant_entry,parent,false);
            RestaurantViewHolder myViewHolder = new RestaurantViewHolder(view, parent);
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RestaurantViewHolder holder, int position) {
            Restaurant restaurant = RestaurantList.get().get(position);
            holder.img.setImageResource(restaurant.getDrawableID());
            holder.text.setText(restaurant.getName());

            holder.img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "clicked menu item", Toast.LENGTH_SHORT).show();
                    //Menu.setSelected(structure);
                    //THIS IS WHERE THE "ACTION" HAPPENS
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}