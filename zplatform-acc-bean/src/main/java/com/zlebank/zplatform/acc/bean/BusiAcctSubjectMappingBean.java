/* 
 * BusiAcctSubjectMappingBean.java  
 * 
 * version TODO
 *
 * 2016年11月10日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.bean;

import java.io.Serializable;

import com.zlebank.zplatform.acc.bean.enums.Usage;
import com.zlebank.zplatform.member.commons.enums.BusinessActorType;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月10日 下午4:22:02
 * @since 
 */
public class BusiAcctSubjectMappingBean implements Serializable{
  /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2033763178590717160L;
    
    //会员类型,01-个人,02-商户,03-企业
    private BusinessActorType businessActorType;
    //用途
    private Usage usage; 
    //科目代码
    private PoSubjectBean subject;
    //是否默认开通
    private int isDefault;
    
    private long id;

    /**
     * @return the businessActorType
     */
    public BusinessActorType getBusinessActorType() {
        return businessActorType;
    }

    /**
     * @param businessActorType the businessActorType to set
     */
    public void setBusinessActorType(BusinessActorType businessActorType) {
        this.businessActorType = businessActorType;
    }

    /**
     * @return the usage
     */
    public Usage getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    /**
     * @return the subject
     */
    public PoSubjectBean getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(PoSubjectBean subject) {
        this.subject = subject;
    }

    /**
     * @return the isDefault
     */
    public int getIsDefault() {
        return isDefault;
    }

    /**
     * @param isDefault the isDefault to set
     */
    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    
}
