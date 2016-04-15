package com.example.liaozhenbin.charactertest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.liaozhenbin.charactertest.R;
import com.example.liaozhenbin.charactertest.Util.Utils;
import com.example.liaozhenbin.charactertest.domain.Result;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ResultActivity extends Activity {
    private TextView result;
    private int redCount;
    private int buleCount;
    private int yellowCount;
    private int greenCount;

    private TextView tv_result;
    private TextView tv_advantage;
    private TextView tv_geti;
    private TextView tv_goutong;
    private TextView tv_friend;
    private TextView tv_work;
    private TextView tv_weakness;
    private TextView tv_description;

    private int tagResult;

    private List<Result> resultList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_advantage = (TextView) findViewById(R.id.tv_advantage);
        tv_geti = (TextView) findViewById(R.id.tv_geti);
        tv_goutong = (TextView) findViewById(R.id.tv_goutong);
        tv_friend = (TextView) findViewById(R.id.tv_friend);
        tv_work = (TextView) findViewById(R.id.tv_work);
        tv_weakness = (TextView) findViewById(R.id.tv_weakness);
        tv_description = (TextView) findViewById(R.id.tv_description);

        Intent intent = getIntent();
        int[] results = intent.getIntArrayExtra("results");
        result = (TextView) findViewById(R.id.tv_result);
        redCount = results[0]+results[7];
        buleCount = results[1]+results[6];
        yellowCount = results[2]+results[5];
        greenCount = results[3]+results[4];

        try {
            InputStream is = getAssets().open("result.xml");
            resultList = Utils.parseResult(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tagResult = getTag();

        init(tagResult);
    }

    //显示结果
    private void init(int i) {
        String color = resultList.get(i).getColor();
        tv_result.setText("您属于"+color+"性格");
        tv_advantage.setText("("+color+"的天然优势)");
        tv_weakness.setText("("+color+"的天然劣势)");
        tv_geti.setText(resultList.get(i).getGeti());
        tv_goutong.setText(resultList.get(i).getGoutong());
        tv_friend.setText(resultList.get(i).getFriend());
        tv_work.setText(resultList.get(i).getWork());
        tv_description.setText(resultList.get(i).getWeakness());
    }

    public int getTag(){
        if(Utils.bijiao(redCount,buleCount)){
            if(Utils.bijiao(yellowCount,greenCount)){
                if(Utils.bijiao(redCount,yellowCount)){
                    return 0;//red
                }else{
                    return 2;//yellow
                }
            }else{
                if (Utils.bijiao(redCount,greenCount)){
                    return 0;//red
                }else{
                    return 3;
                }
            }
        }else{
            if(Utils.bijiao(yellowCount,greenCount)){
                if(Utils.bijiao(buleCount,yellowCount)){
                    return 1;//blue
                }else{
                    return 2;//yellow
                }
            }else{
                if (Utils.bijiao(buleCount,greenCount)){
                    return 1;//blue
                }else{
                    return 3;//green
                }
            }
        }
    }
}