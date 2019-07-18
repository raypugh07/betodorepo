package com.todolist.todolist.Model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel(value="confession", description = "The confession entity")

@Entity
@Table(name = "confession")

public class Confession {

    @ApiModelProperty(name = "confessionid", value = "Primary key for confession", required = true,example = "1")

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long confessionid;

    private String confessionitem;

    public Confession() {
    }

    public Confession(String confessionitem) {
        this.confessionitem = confessionitem;
    }

    public long getConfessionid() {
        return confessionid;
    }

    public void setConfessionid(long confessionid) {
        this.confessionid = confessionid;
    }

    public String getConfessionitem() {
        return confessionitem;
    }

    public void setConfessionitem(String confessionitem) {
        this.confessionitem = confessionitem;
    }

    @Override
    public String toString() {
        return "Confession{" +
                "confessionid=" + confessionid +
                ", confessionitem='" + confessionitem + '\'' +
                '}';
    }
}
