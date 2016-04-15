package com.example.liaozhenbin.charactertest.Util;

import android.util.Xml;

import com.example.liaozhenbin.charactertest.domain.Question;
import com.example.liaozhenbin.charactertest.domain.Result;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liaozhenbin on 2016/3/4.
 */
public class Utils {

    public static List<Question> parseQuestion(InputStream is){
        List<Question> mList = null;
        Question question = null;

        // 由android.util.Xml创建一个XmlPullParser实例
        XmlPullParser xpp = Xml.newPullParser();
        try {
            // 设置输入流 并指明编码方式
            xpp.setInput(is, "UTF-8");
            // 产生第一个事件
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    // 判断当前事件是否为文档开始事件
                    case XmlPullParser.START_DOCUMENT:
                        mList = new ArrayList<Question>(); // 初始化question集合
                        break;
                    // 判断当前事件是否为标签元素开始事件
                    case XmlPullParser.START_TAG:
                        if (xpp.getName().equals("question")) { // 判断开始标签元素是否是question
                            question = new Question();
                        } else if (xpp.getName().equals("wenti")) {
                            eventType = xpp.next();//让解析器指向wenti属性的值
                            // 得到wenti标签的属性值，并设置question的wenti
                            question.setWenti(xpp.getText());
                        } else if (xpp.getName().equals("a")) { // 判断开始标签元素是否是a
                            eventType = xpp.next();//让解析器指向a属性的值
                            // 得到a标签的属性值，并设置question的option_a
                            question.setOption_a(xpp.getText());
                        } else if (xpp.getName().equals("b")) { // 判断开始标签元素是否是b
                            eventType = xpp.next();//让解析器指向b属性的值
                            // 得到a标签的属性值，并设置question的option_b
                            question.setOption_b(xpp.getText());
                        } else if (xpp.getName().equals("c")) { // 判断开始标签元素是否是c
                            eventType = xpp.next();//让解析器指向c属性的值
                            // 得到a标签的属性值，并设置question的option_c
                            question.setOption_c(xpp.getText());
                        } else if (xpp.getName().equals("d")) { // 判断开始标签元素是否是d
                            eventType = xpp.next();//让解析器指向d属性的值
                            // 得到a标签的属性值，并设置question的option_d
                            question.setOption_d(xpp.getText());
                        }
                        break;

                    // 判断当前事件是否为标签元素结束事件
                    case XmlPullParser.END_TAG:
                        if (xpp.getName().equals("question")) { // 判断结束标签元素是否是question
                            mList.add(question); // 将question添加到question集合
                            question = null;
                        }
                        break;
                }
                // 进入下一个元素并触发相应事件
                eventType = xpp.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mList;
    }

    public static List<Result> parseResult(InputStream is){
        List<Result> mList = null;
        Result result = null;

        // 由android.util.Xml创建一个XmlPullParser实例
        XmlPullParser xpp = Xml.newPullParser();
        try {
            // 设置输入流 并指明编码方式
            xpp.setInput(is, "UTF-8");
            // 产生第一个事件
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    // 判断当前事件是否为文档开始事件
                    case XmlPullParser.START_DOCUMENT:
                        mList = new ArrayList<Result>(); // 初始化result集合
                        break;
                    // 判断当前事件是否为标签元素开始事件
                    case XmlPullParser.START_TAG:
                        if (xpp.getName().equals("result")) { // 判断开始标签元素是否是result
                            result = new Result();
                        } else if(xpp.getName().equals("color")){
                            eventType = xpp.next();//让解析器指向color属性的值
                            // 得到color标签的属性值，并设置result的color
                            result.setColor(xpp.getText());
                        }else if (xpp.getName().equals("geti")) {
                            eventType = xpp.next();//让解析器指向geti属性的值
                            // 得到geti标签的属性值，并设置result的geti
                            result.setGeti(xpp.getText());
                        } else if (xpp.getName().equals("goutong")) { // 判断开始标签元素是否是goutong
                            eventType = xpp.next();//让解析器指向goutong属性的值
                            // 得到goutong标签的属性值，并设置question的goutong
                            result.setGoutong(xpp.getText());
                        } else if (xpp.getName().equals("friend")) { // 判断开始标签元素是否是friend
                            eventType = xpp.next();//让解析器指向friend属性的值
                            // 得到friend标签的属性值，并设置question的friend
                            result.setFriend(xpp.getText());
                        } else if (xpp.getName().equals("work")) { // 判断开始标签元素是否是work
                            eventType = xpp.next();//让解析器指向work属性的值
                            // 得到work标签的属性值，并设置question的work
                            result.setWork(xpp.getText());
                        } else if (xpp.getName().equals("weakness")) { // 判断开始标签元素是否是weakness
                            eventType = xpp.next();//让解析器指向weakness属性的值
                            // 得到weakness标签的属性值，并设置question的weakness
                            result.setWeakness(xpp.getText());
                        }
                        break;

                    // 判断当前事件是否为标签元素结束事件
                    case XmlPullParser.END_TAG:
                        if (xpp.getName().equals("result")) { // 判断结束标签元素是否是question
                            mList.add(result); // 将question添加到question集合
                            result = null;
                        }
                        break;
                }
                // 进入下一个元素并触发相应事件
                eventType = xpp.next();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return mList;
    }

    public static boolean bijiao(int a,int b){
        if(a>b){
            return true;
        }else{
            return false;
        }
    }
}
