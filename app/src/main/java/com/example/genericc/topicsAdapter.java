package com.example.genericc;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class topicsAdapter extends RecyclerView.Adapter<topicsAdapter.TopicViewHolder> {

    private List<Topic> topicList = new ArrayList<>();
    private onTopicClickListener onTopicClickListener;

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.topic_view_layout, parent, false);

        return new TopicViewHolder(view, onTopicClickListener);
    }

    public topicsAdapter(List<Topic> topics, onTopicClickListener onTopicClickListener) {

        this.topicList = topics;
        this.onTopicClickListener = onTopicClickListener;


    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder topicViewHolder, int position) {
        Topic topic = topicList.get(position);
        topicViewHolder.topicName.setText(topic.getTopicName());
        topicViewHolder.topicDetail.setText(topic.getTopicDesc());
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView topicName, topicDetail;
        private onTopicClickListener onTopicClickListener;

        public TopicViewHolder(@NonNull View itemView, onTopicClickListener onTopicClickListener) {
            super(itemView);

            topicName = itemView.findViewById(R.id.topic_name);
            topicDetail = itemView.findViewById(R.id.topic_desc);
            this.onTopicClickListener = onTopicClickListener;

//attach the passed onclicklistener to the entire viewholder
            itemView.setOnClickListener(this);// .this reffers to the interface implemented in this inner class

        }

        @Override
        public void onClick(View v) {
            onTopicClickListener.onTopicclicked(getAdapterPosition());
        }
    }

    public interface onTopicClickListener {
        void onTopicclicked(int position);
    }
}
