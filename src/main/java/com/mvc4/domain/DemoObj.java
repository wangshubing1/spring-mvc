package com.mvc4.domain;

/**
 * @Author: king
 * @Datetime: 2018/10/30
 * @Desc: TODO 获取一个request对象参数，返回此对象到response
 */
public class DemoObj {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DemoObj(){
        super();
    }
    public DemoObj(Long id,String name){
        super();
        this.id=id;
        this.name=name;
    }
}
