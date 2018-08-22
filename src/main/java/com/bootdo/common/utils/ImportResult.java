package com.bootdo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵丽娟
 * @date 2018/8/16 17:24
 */
public class ImportResult {
    //导入成功的数据数量
    int importSuccess;
    //导入失败的数据数量
    int importFail ;
    //导入失败的寄送单号(key)，原因(value)
    Map<String,String> failMap;

    public int getImportSuccess() {
        return importSuccess;
    }

    public void setImportSuccess(int importSuccess) {
        this.importSuccess = importSuccess;
    }

    public int getImportFail() {
        return importFail;
    }

    public void setImportFail(int importFail) {
        this.importFail = importFail;
    }

    public Map<String, String> getFailMap() {
        return failMap;
    }

    public void setFailMap(Map<String, String> failMap) {
        this.failMap = failMap;
    }
}
