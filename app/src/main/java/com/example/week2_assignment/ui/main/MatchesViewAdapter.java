package com.example.week2_assignment.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week2_assignment.R;

import java.util.List;

public class MatchesViewAdapter extends RecyclerView.Adapter<MatchesViewAdapter.MatchesViewHolder>
{


    public MatchesViewAdapter()
    {
    }

    @NonNull
    @Override
    public MatchesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matches_card, parent, false);
        MatchesViewHolder myViewHolder = new MatchesViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesViewHolder holder, int position) {
        holder.name.setText("Name");
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MatchesViewHolder extends RecyclerView.ViewHolder
    {
        TextView name;
        Button b;

        public MatchesViewHolder(@NonNull View itemView)
        {
            super(itemView);

            name = itemView.findViewById(R.id.card_view_name);
            b = itemView.findViewById(R.id.card_view_btn);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(itemView.getContext(), "You have liked " + name.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
