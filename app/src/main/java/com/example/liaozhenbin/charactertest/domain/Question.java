package com.example.liaozhenbin.charactertest.domain;

/**
 * Created by liaozhenbin on 2016/3/4.
 */
public class Question {
    private String wenti;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;

    public Question(){}

    public String getWenti() {
        return wenti;
    }

    public String getOption_a() {
        return option_a;
    }

    public String getOption_b() {
        return option_b;
    }

    public String getOption_c() {
        return option_c;
    }

    public String getOption_d() {
        return option_d;
    }

    public void setWenti(String wenti) {
        this.wenti = wenti;
    }

    public void setOption_a(String option_a) {
        this.option_a = option_a;
    }

    public void setOption_b(String option_b) {
        this.option_b = option_b;
    }

    public void setOption_c(String option_c) {
        this.option_c = option_c;
    }

    public void setOption_d(String option_d) {
        this.option_d = option_d;
    }
}
