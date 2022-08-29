package com.wufang.domain;

import lombok.Data;

@Data
public class Info { //数据库表名为tbl_info
    //TableId(value="id")
    private Integer id;
    private String name;
    //@TableField(select = false) //此字段不参与查询
    private String tel;
    private Integer deleted;

}