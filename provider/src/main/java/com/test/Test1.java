package com.test;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.enums.MqEnum;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Workbook;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangzhuyi
 * @Date: 2019/5/4 20:03
 * @Version 1.0
 * @Describe
 */
public class Test1 {

    public static void main(String[] args) throws Exception {
        String a= MqEnum.PROVIDER1.getExchange();
        System.out.println(a);
    }



}
