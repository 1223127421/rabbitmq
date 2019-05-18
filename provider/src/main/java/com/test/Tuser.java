package com.test;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/5 15:26
 * @Version 1.0
 * @Describe
 */
@ExcelTarget("Tuser")
public class Tuser {

    @Excel(name="name")
    private String name;

    @Excel(name="age")
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
