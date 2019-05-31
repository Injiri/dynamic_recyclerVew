package com.example.genericc;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.List;

public class topicsAdapter extends RecyclerView.Adapter<topicsAdapter.TopicViewHolder> {

    private List<Topic> topicList;
    private Context context;

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_layout, parent, false);

        return new TopicViewHolder(view);
    }

    public topicsAdapter(Context context, List<Topic> topics) {

        this.topicList = topics;
        this.context = context;

    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder topicViewHolder, int i) {
        Topic topic = topicList.get(i);
        topicViewHolder.topicName.setText(topic.getTopicName());
        topicViewHolder.topicDetail.setText(topic.getTopicDesc());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {

        private TextView topicName, topicDetail;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);

            topicName = itemView.findViewById(R.id.topic_name);
            topicDetail = itemView.findViewById(R.id.topic_desc);

        }
    }
}
