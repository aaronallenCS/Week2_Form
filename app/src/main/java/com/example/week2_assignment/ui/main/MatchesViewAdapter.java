package com.example.week2_assignment.ui.main;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.example.week2_assignment.Match;
import com.example.week2_assignment.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class MatchesViewAdapter extends FirebaseRecyclerAdapter<Match, MatchesViewAdapter.MatchesViewHolder>
{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MatchesViewAdapter(@NonNull FirebaseRecyclerOptions<Match> options) {
        super(options);
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
    protected void onBindViewHolder(@NonNull MatchesViewHolder holder, int position, @NonNull Match model) {
        holder.nameTV.setText(model.getName());
        ImageView imageView = ((MatchesViewHolder) holder).profilePicture;
        Glide.with(holder.itemView.getContext()).
                load(model.getImageUrl()).
                apply(new RequestOptions().override(100, 100)).
                into(imageView);
    }



    public class MatchesViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameTV;
        ImageView profilePicture;
        Button b;

        public MatchesViewHolder(@NonNull View itemView)
        {
            super(itemView);

            nameTV = itemView.findViewById(R.id.card_view_name);
            profilePicture = itemView.findViewById(R.id.profile_picture_card);
            b = itemView.findViewById(R.id.card_view_btn);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(itemView.getContext(), "You have liked " + nameTV.getText().toString(), Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
