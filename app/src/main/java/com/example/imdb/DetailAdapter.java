package com.example.imdb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.imdb.Probs.Probs;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.TestViewHolder> {
    List<Probs> mylist;
    DetailAdapter(List<Probs> list){
        mylist = list;
    }


   @NonNull
    @Override
    public TestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_items, parent, false);
        TestViewHolder holder = new TestViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestViewHolder holder, int position) {
            holder.txtSearchedTitle.setText("Title: " + mylist.get(position).getTitle());
            holder.txtSearchedYear.setText("Year: " +mylist.get(position).getYear());
            holder.txtSearchedDirector.setText("Director: " +mylist.get(position).getDirector());
            holder.txtSearchedActors.setText("Actors: " +mylist.get(position).getActors());
            holder.txtSearchedGenre.setText("Genre: " +mylist.get(position).getGenre());
            holder.txtSearchedCountry.setText("Country: " +mylist.get(position).getCountry());
            holder.txtSearchedLanguage.setText("Language: " +mylist.get(position).getLanguage());
            String coverUrl = mylist.get(position).getPoster();
            Picasso.get().load(coverUrl).into(holder.searchedCover);

//        String imageUrl = mlist.get(position).getPoster();
//        Picasso.get().load(imageUrl).into(holder.imgSearchedPoster);

    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class TestViewHolder extends RecyclerView.ViewHolder {
        TextView txtSearchedTitle;
        TextView txtSearchedYear;
        TextView txtSearchedDirector;
        TextView txtSearchedActors;
        TextView txtSearchedGenre;
        TextView txtSearchedCountry;
        TextView txtSearchedLanguage;
        ImageView searchedCover;
        public TestViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSearchedTitle = itemView.findViewById(R.id.txtSearchedTitle);
            txtSearchedYear = itemView.findViewById(R.id.txtSearchedYear);
            txtSearchedDirector = itemView.findViewById(R.id.txtSearchedDirector);
            txtSearchedActors = itemView.findViewById(R.id.txtSearchedActors);
            txtSearchedGenre = itemView.findViewById(R.id.txtSearchedGenre);
            txtSearchedCountry = itemView.findViewById(R.id.txtSearchedCountry);
            txtSearchedLanguage = itemView.findViewById(R.id.txtSearchedLanguage);
            searchedCover =itemView.findViewById(R.id.searchedCover);
        }
    }
}
//
//
//
//
//
//
///* package com.android.train.task.json;
//
//
//public class SearchedAdapter extends RecyclerView.Adapter<SearchedAdapter.SearchedHolder> {
//    List<MovieProperties> mlist;
//    SearchedAdapter(List<MovieProperties> list){
//        mlist = list;
//    }
//
//    @NonNull
//    @Override
//    public SearchedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.searched_recycler_item,parent,false);
//        SearchedHolder holder = new SearchedHolder(v);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SearchedHolder holder, int position) {
//        holder.txtSearchedTitle.setText("Title: " + mlist.get(position).getTitle());
//        holder.txtSearchedYear.setText("Year: " +mlist.get(position).getYear());
//        String imageUrl = mlist.get(position).getPoster();
//        Picasso.get().load(imageUrl).into(holder.imgSearchedPoster);
//        holder.txtSearchedDirector.setText("Director: " +mlist.get(position).getDirector());
//        holder.txtSearchedActors.setText("Actors: " +mlist.get(position).getActors());
//        holder.txtSearchedGenre.setText("Genre: " +mlist.get(position).getGenre());
//        holder.txtSearchedCountry.setText("Country: " +mlist.get(position).getCountry());
//        holder.txtSearchedLanguage.setText("Language: " +mlist.get(position).getLanguage());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mlist.size();
//    }
//
//    class  SearchedHolder extends  RecyclerView.ViewHolder{
//        TextView txtSearchedTitle;
//        TextView txtSearchedYear;
//        ImageView imgSearchedPoster;
//        TextView txtSearchedDirector;
//        TextView txtSearchedActors;
//        TextView txtSearchedGenre;
//        TextView txtSearchedCountry;
//        TextView txtSearchedLanguage;
//        public SearchedHolder(@NonNull View itemView) {
//            super(itemView);
//            txtSearchedTitle = itemView.findViewById(R.id.txtSearchedTitle);
//            txtSearchedYear = itemView.findViewById(R.id.txtSearchedYear);
//            imgSearchedPoster = itemView.findViewById(R.id.imgSearchedPoster);
//            txtSearchedDirector = itemView.findViewById(R.id.txtSearchedDirector);
//            txtSearchedActors = itemView.findViewById(R.id.txtSearchedActors);
//            txtSearchedGenre = itemView.findViewById(R.id.txtSearchedGenre);
//            txtSearchedCountry = itemView.findViewById(R.id.txtSearchedCountry);
//            txtSearchedLanguage = itemView.findViewById(R.id.txtSearchedLanguage);
//        }
//    }
//} */
