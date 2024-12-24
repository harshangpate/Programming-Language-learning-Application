package com.example.learncodingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.learncodingapp.R;

public class ChallengeAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] questions;

    public ChallengeAdapter(Context context, String[] questions) {
        super(context, R.layout.challenge_item, questions);
        this.context = context;
        this.questions = questions;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.challenge_item, parent, false);

        TextView questionTextView = rowView.findViewById(R.id.questionTextView);
        questionTextView.setText(questions[position]);

        return rowView;
    }
}
