/* 
 * CRDR.java  
 * 
 * version TODO
 *
 * 2015年8月24日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.pojo.usertype;

/**
 * 
 * 通道状态类
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月12日 下午3:41:13
 * @since
 */
public enum ChannelStatusType {
    /**启用**/
    NORMAL("00"),
    /**其它**/
    UNKNOW("99");

 private String code;
    
    private ChannelStatusType(String code){
        this.code = code;
    }
    
    public static ChannelStatusType fromValue(String value) {
        for(ChannelStatusType status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return UNKNOW;
    }
    
    public String getCode(){
        return code;
    }
}
