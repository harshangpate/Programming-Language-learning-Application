package com.example.learncodingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learncodingapp.R;
import com.example.learncodingapp.activities.ChallengeDetailActivity;
import com.example.learncodingapp.entities.Question;

import java.util.List;

public class ChallengeRecyclerViewAdapter extends RecyclerView.Adapter<ChallengeRecyclerViewAdapter.ViewHolder> {

    private final List<Question> questions;
    private final Context context;

    public ChallengeRecyclerViewAdapter(Context context, List<Question> questions) {
        this.context = context;
        this.questions = questions;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.challenge_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.questionTextView.setText(question.getQuestion());

        // Handle item click to navigate to ChallengeDetailActivity
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ChallengeDetailActivity.class);
            intent.putExtra("selected_question", question.getQuestion());
            intent.putExtra("selected_topic", question.getTopic());
            intent.putExtra("selected_language", question.getLanguage());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView questionTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            questionTextView = itemView.findViewById(R.id.questionTextView);
        }
    }
}
