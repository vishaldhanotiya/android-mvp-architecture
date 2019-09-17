package com.mvppattern.ListMVP;

import java.util.ArrayList;

/**
 * Created by Vishal on 3/28/2017.
 */

public class ListDataBean extends ArrayList<ListDataBean> {

    String name;
    String subject;
    String rollnumber;

    public ListDataBean(String name, String subject, String rollnumber) {
        this.name=name;
        this.subject=subject;
        this.rollnumber=rollnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }
}
