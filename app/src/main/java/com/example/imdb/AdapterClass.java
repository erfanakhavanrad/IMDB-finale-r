package com.example.imdb;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdb.MoviesList.Search;

import java.util.List;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MovieViewHolder> {
    List<Search> mylist;

    AdapterClass(List<Search> list) {
        mylist = list;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_items, parent, false);
        MovieViewHolder holder = new MovieViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        String Title = mylist.get(position).getTitle();
        holder.txtName.setText("title" + Title);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;

        public MovieViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Search search = mylist.get(getAdapterPosition());
                    Intent intent = new Intent(itemView.getContext(), DetailsActivity.class);
                    intent.putExtra("id", search.getImdbID());
                    itemView.getContext().startActivity(intent);
                }
            });
        }

    }
}
