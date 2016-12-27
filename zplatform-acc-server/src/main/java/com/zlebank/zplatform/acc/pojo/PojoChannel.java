/* 
 * PojoChannel.java  
 * 
 * version TODO
 *
 * 2015年9月30日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import com.zlebank.zplatform.acc.pojo.usertype.ChannelStatusType;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月30日 上午10:55:34
 * @since 
 */
@Entity
@Table(name="T_CHANNEL")
public class PojoChannel implements Serializable{
	
    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 717849105348015289L;
	/**渠道标识**/
    private Long chnlid;
    /**渠道代码**/
    private String chnlcode;
    /**渠道名称**/
    private String chnlname;
    /**所属机构**/
    private String insticode;
    /**渠道类型**/
    private String chnltype;
    /**渠道子类型**/
    private String subtype;
    /**状态(00：启用;其他：关闭)**/
    private ChannelStatusType status;
    /**受理业务代码集**/
    private String appset;
    /**备注**/
    private String notes;
    /**备注**/
    private String remarks;
    /**通道成本科目**/
    private String acctCodeCost;
    /**通道备付金科目**/
    private String acctCodeDeposit;
    /**通道应收款科目**/
    private String acctCodeReceivable;

    @GenericGenerator(name = "id_gen", strategy = "enhanced-table", parameters = {
            @Parameter(name = "table_name", value = "T_C_PRIMAY_KEY"),
            @Parameter(name = "value_column_name", value = "NEXT_ID"),
            @Parameter(name = "segment_column_name", value = "KEY_NAME"),
            @Parameter(name = "segment_value", value = "CHANNEL_ID"),
            @Parameter(name = "increment_size", value = "1"),
            @Parameter(name = "optimizer", value = "pooled-lo") })
    @Id
    @GeneratedValue(generator = "id_gen")
    @Column(name = "CHNLID")
    public Long getChnlid() {
        return chnlid;
    }
    public void setChnlid(Long chnlid) {
        this.chnlid = chnlid;
    }
    @Column(name = "CHNLCODE")
    public String getChnlcode() {
        return chnlcode;
    }
    public void setChnlcode(String chnlcode) {
        this.chnlcode = chnlcode;
    }
    @Column(name = "CHNLNAME")
    public String getChnlname() {
        return chnlname;
    }
    public void setChnlname(String chnlname) {
        this.chnlname = chnlname;
    }
    @Column(name = "INSTICODE")
    public String getInsticode() {
        return insticode;
    }
    public void setInsticode(String insticode) {
        this.insticode = insticode;
    }
    @Column(name = "CHNLTYPE")
    public String getChnltype() {
        return chnltype;
    }
    public void setChnltype(String chnltype) {
        this.chnltype = chnltype;
    }
    @Column(name = "SUBTYPE")
    public String getSubtype() {
        return subtype;
    }
    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }
    @Column(name = "STATUS")
    @Type(type = "com.zlebank.zplatform.commons.dao.pojo.usertype.ChannelStatusSqlType")
    public ChannelStatusType getStatus() {
        return status;
    }
    public void setStatus(ChannelStatusType status) {
        this.status = status;
    }
    @Column(name = "APPSET")
    public String getAppset() {
        return appset;
    }
    public void setAppset(String appset) {
        this.appset = appset;
    }
    @Column(name = "NOTES")
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    @Column(name = "REMARKS")
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @Column(name = "ACCT_CODE_COST")
    public String getAcctCodeCost() {
        return acctCodeCost;
    }
    public void setAcctCodeCost(String acctCodeCost) {
        this.acctCodeCost = acctCodeCost;
    }
    @Column(name = "ACCT_CODE_DEPOSIT")
    public String getAcctCodeDeposit() {
        return acctCodeDeposit;
    }
    public void setAcctCodeDeposit(String acctCodeDeposit) {
        this.acctCodeDeposit = acctCodeDeposit;
    }
    @Column(name = "ACCT_CODE_RECEIVABLE")
    public String getAcctCodeReceivable() {
        return acctCodeReceivable;
    }
    public void setAcctCodeReceivable(String acctCodeReceivable) {
        this.acctCodeReceivable = acctCodeReceivable;
    }
}
