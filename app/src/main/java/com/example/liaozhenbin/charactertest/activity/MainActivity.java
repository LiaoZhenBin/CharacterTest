package com.example.liaozhenbin.charactertest.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.liaozhenbin.charactertest.R;
import com.example.liaozhenbin.charactertest.Util.Utils;
import com.example.liaozhenbin.charactertest.domain.Question;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private int number = 0;
    private int s_a = 0;
    private int s_b = 0;
    private int s_c = 0;
    private int s_d = 0;

    private int l_a = 0;
    private int l_b = 0;
    private int l_c = 0;
    private int l_d = 0;

    private List<Question> questionLists = new ArrayList<>();

    private TextView question;
    private RadioButton rb_a;
    private RadioButton rb_b;
    private RadioButton rb_c;
    private RadioButton rb_d;
    private RadioButton rb_e;
    private RadioGroup rg_group;
    private Button bt_next;
    private ProgressBar progressBar;
    private TextView tv_progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        question = (TextView) findViewById(R.id.question);
        rb_a = (RadioButton) findViewById(R.id.rb_a);
        rb_b = (RadioButton) findViewById(R.id.rb_b);
        rb_c = (RadioButton) findViewById(R.id.rb_c);
        rb_d = (RadioButton) findViewById(R.id.rb_d);
        rb_e = (RadioButton) findViewById(R.id.rb_e);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        tv_progress = (TextView) findViewById(R.id.tv_progress);

        rg_group = (RadioGroup) findViewById(R.id.rg_group);
        bt_next = (Button) findViewById(R.id.bt_next);

        try {
            InputStream is = getAssets().open("question.xml");
            questionLists = Utils.parseQuestion(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        progressBar.setMax(questionLists.size());
        init(number);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (number == questionLists.size() - 2) {
                    rb_a.setTextSize(13);
                    rb_b.setTextSize(13);
                    rb_c.setTextSize(13);
                    rb_d.setTextSize(13);
                    bt_next.setText("提交");
                }
                if (rb_a.isChecked()) {
                    if (number < questionLists.size() / 2) {
                        s_a++;
                    } else {
                        l_a++;
                    }
                } else if (rb_b.isChecked()) {
                    if (number < questionLists.size() / 2) {
                        s_b++;
                    } else {
                        l_b++;
                    }
                } else if (rb_c.isChecked()) {
                    if (number < questionLists.size() / 2) {
                        s_c++;
                    } else {
                        l_c++;
                    }
                } else if (rb_d.isChecked()) {
                    if (number < questionLists.size() / 2) {
                        s_d++;
                    } else {
                        l_d++;
                    }
                }
                rb_e.setChecked(true);

                number++;
                if (number == questionLists.size()) {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    int[] results = {s_a, s_b, s_c, s_d, l_a, l_b, l_c, l_d};
                    intent.putExtra("results", results);
                    startActivity(intent);
                    finish();
                } else if (number < questionLists.size()) {
                    init(number);
                }
            }
        });

        rg_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb_e:
                        break;
                    default:
                        bt_next.setEnabled(true);
                        bt_next.setTextColor(Color.WHITE);
                        break;
                }
            }
        });
    }


    private void init(int number) {
        question.setText(questionLists.get(number).getWenti());
        rb_a.setText(questionLists.get(number).getOption_a());
        rb_b.setText(questionLists.get(number).getOption_b());
        rb_c.setText(questionLists.get(number).getOption_c());
        rb_d.setText(questionLists.get(number).getOption_d());
        tv_progress.setText((number + 1) + "/" + questionLists.size());
        progressBar.setProgress(number + 1);
        bt_next.setEnabled(false);
        bt_next.setTextColor(Color.GRAY);
    }
}