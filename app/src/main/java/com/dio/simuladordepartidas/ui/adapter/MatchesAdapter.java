package com.dio.simuladordepartidas.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dio.simuladordepartidas.databinding.MatchItemBinding;
import com.dio.simuladordepartidas.domain.Match;

import java.util.List;

public class MatchesAdapter extends RecyclerView.Adapter<MatchesAdapter.ViewHolder> {

    private List<Match> matches;

    public MatchesAdapter(List<Match> matches) {
        this.matches = matches;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final MatchItemBinding binding;

        public ViewHolder(MatchItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public List<Match> getMatches() {
        return matches;
    }

    @NonNull
    @Override
    public MatchesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        MatchItemBinding binding = MatchItemBinding.inflate(layoutInflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchesAdapter.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        Match match = matches.get(position);

        Glide.with(context).load(match.getHomeTime().getImage()).circleCrop().into(holder.binding.imageViewHomeTeam);
        holder.binding.textViewHomeTeam.setText(match.getHomeTime().getName());
        Glide.with(context).load(match.getAwayTeam().getImage()).circleCrop().into(holder.binding.imageViewAwayTeam);
        holder.binding.textViewNameAwayTeam.setText(match.getAwayTeam().getName());
        if(match.getHomeTime().getScore()!=null){
            holder.binding.textViewScoreHomeTeam.setText(String.valueOf(match.getHomeTime().getScore()));
            holder.binding.textViewScoreAwayTeam.setText(String.valueOf(match.getAwayTeam().getScore()));
        }
    }

    @Override
    public int getItemCount() {
        return matches.size();
    }
}
