package com.myapplicationdev.android.p03_classjournal;

import java.io.Serializable;

public class Weeks implements Serializable {
    private String weeks;
    private String dg;

    public String getDg() {
        return dg;
    }

    public void setDg(String dg) {
        this.dg = dg;
    }

    public Weeks(String weeks, String dg) {
        this.weeks = weeks;
        this.dg = dg;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }
}
