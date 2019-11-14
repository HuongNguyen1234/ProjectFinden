package com.example.projectfinden.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.projectfinden.R;
import com.example.projectfinden.com.fragment.QuizletFragment;
import com.example.projectfinden.com.model.Option;
import com.example.projectfinden.com.model.Question;

import java.util.List;

public class CustomAdapterShowPerson extends ArrayAdapter<Question> {

        private List<Question> dataSet;
        Context mContext;

        // View lookup cache
        private static class ViewHolder {
            TextView tvContent;
            TextView tvA;
            TextView tvB;
            TextView tvC;
            TextView tvD;
            TextView tvAnswer;
        }

        public CustomAdapterShowPerson(List<Question> data, Context context) {
            super(context, R.layout.show_question, data);
            this.dataSet = data;
            this.mContext=context;

        }



        private int lastPosition = -1;

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Question question = getItem(position);
            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder; // view lookup cache stored in tag

            final View result;

            if (convertView == null) {

                viewHolder = new ViewHolder();
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.show_question, parent, false);
                viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tvQuestionContent);
                viewHolder.tvA = (TextView) convertView.findViewById(R.id.tvA);
                viewHolder.tvB = (TextView) convertView.findViewById(R.id.tvB);
                viewHolder.tvC = (TextView) convertView.findViewById(R.id.tvC);
                viewHolder.tvD = (TextView) convertView.findViewById(R.id.tvD);
                viewHolder.tvAnswer = (TextView) convertView.findViewById(R.id.tvAnswer);


                result=convertView;

                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
                result=convertView;
            }

//            Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
//            result.startAnimation(animation);
            lastPosition = position;

            viewHolder.tvContent.setText(question.getContent());
            viewHolder.tvA.setText(question.getOptions().get(0).getValue());
            viewHolder.tvB.setText(question.getOptions().get(1).getValue());
            viewHolder.tvC.setText(question.getOptions().get(2).getValue());
            viewHolder.tvD.setText(question.getOptions().get(3).getValue());
            for(Option option : question.getOptions()){
                if(option.isAnswer()==true){
//                    viewHolder.tvAnswer.setText(option.getValue() == null ? "" : option.getValue());
                    if(option.getId()==1){
                        viewHolder.tvAnswer.setText("A");
                    }else if(option.getId()==2){
                        viewHolder.tvAnswer.setText("B");
                    }
                    else if(option.getId()==3){
                        viewHolder.tvAnswer.setText("C");
                    }
                    else if(option.getId()==4){
                        viewHolder.tvAnswer.setText("D");
                    }
                }
            }

            // Return the completed view to render on screen
            return convertView;
        }
    }
