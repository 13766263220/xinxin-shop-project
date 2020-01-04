package com.nf.entity;

import lombok.Data;

@Data
public class AttrOption implements Comparable<AttrOption>{
    private Integer id;
    private String name;
    private Integer attrId;


    @Override
    public int compareTo(AttrOption o) {
        if(o.getId() > this.getId()){
            return 1;
        }else{
            return 0;
        }
    }
}
