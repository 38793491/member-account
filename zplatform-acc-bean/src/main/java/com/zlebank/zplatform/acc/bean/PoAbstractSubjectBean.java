/* 
 * AbstractSubjectBean.java  
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
import java.util.Date;



import com.zlebank.zplatform.acc.bean.enums.AcctElementType;
import com.zlebank.zplatform.acc.bean.enums.AcctStatusType;
import com.zlebank.zplatform.acc.bean.enums.AcctType;
import com.zlebank.zplatform.acc.bean.enums.CRDRType;
import com.zlebank.zplatform.acc.pojo.Money;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月10日 上午11:00:58
 * @since 
 */
public class PoAbstractSubjectBean implements Serializable{
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -2639934213155501508L;

    private long id;
    
    private AcctType acctType;

    private String acctCode;

    private String acctCodeName;

    private CRDRType crdr;

    private AcctElementType acctElement;

    private String businessActorId;
    
    private Money balance;

    private Money frozenBalance;

    private Money creditBalance;

    private Money debitBalance;

    private Money totalBanance;

    private PoAbstractSubjectBean parentSubject;

    private AcctStatusType status;

    private Long ver;

    private String dac;

    private Date inTime;

    private Long inUser;

    private Date upTime;

    private Long upUser;

    private String notes;

    private String remarks;

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

    /**
     * @return the acctType
     */
    public AcctType getAcctType() {
        return acctType;
    }

    /**
     * @param acctType the acctType to set
     */
    public void setAcctType(AcctType acctType) {
        this.acctType = acctType;
    }

    /**
     * @return the acctCode
     */
    public String getAcctCode() {
        return acctCode;
    }

    /**
     * @param acctCode the acctCode to set
     */
    public void setAcctCode(String acctCode) {
        this.acctCode = acctCode;
    }

    /**
     * @return the acctCodeName
     */
    public String getAcctCodeName() {
        return acctCodeName;
    }

    /**
     * @param acctCodeName the acctCodeName to set
     */
    public void setAcctCodeName(String acctCodeName) {
        this.acctCodeName = acctCodeName;
    }

    /**
     * @return the crdr
     */
    public CRDRType getCrdr() {
        return crdr;
    }

    /**
     * @param crdr the crdr to set
     */
    public void setCrdr(CRDRType crdr) {
        this.crdr = crdr;
    }

    /**
     * @return the acctElement
     */
    public AcctElementType getAcctElement() {
        return acctElement;
    }

    /**
     * @param acctElement the acctElement to set
     */
    public void setAcctElement(AcctElementType acctElement) {
        this.acctElement = acctElement;
    }

    /**
     * @return the businessActorId
     */
    public String getBusinessActorId() {
        return businessActorId;
    }

    /**
     * @param businessActorId the businessActorId to set
     */
    public void setBusinessActorId(String businessActorId) {
        this.businessActorId = businessActorId;
    }

    /**
     * @return the balance
     */
    public Money getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(Money balance) {
        this.balance = balance;
    }

    /**
     * @return the frozenBalance
     */
    public Money getFrozenBalance() {
        return frozenBalance;
    }

    /**
     * @param frozenBalance the frozenBalance to set
     */
    public void setFrozenBalance(Money frozenBalance) {
        this.frozenBalance = frozenBalance;
    }

    /**
     * @return the creditBalance
     */
    public Money getCreditBalance() {
        return creditBalance;
    }

    /**
     * @param creditBalance the creditBalance to set
     */
    public void setCreditBalance(Money creditBalance) {
        this.creditBalance = creditBalance;
    }

    /**
     * @return the debitBalance
     */
    public Money getDebitBalance() {
        return debitBalance;
    }

    /**
     * @param debitBalance the debitBalance to set
     */
    public void setDebitBalance(Money debitBalance) {
        this.debitBalance = debitBalance;
    }

    /**
     * @return the totalBanance
     */
    public Money getTotalBanance() {
        return totalBanance;
    }

    /**
     * @param totalBanance the totalBanance to set
     */
    public void setTotalBanance(Money totalBanance) {
        this.totalBanance = totalBanance;
    }

    /**
     * @return the parentSubject
     */
    public PoAbstractSubjectBean getParentSubject() {
        return parentSubject;
    }

    /**
     * @param parentSubject the parentSubject to set
     */
    public void setParentSubject(PoAbstractSubjectBean parentSubject) {
        this.parentSubject = parentSubject;
    }

    /**
     * @return the status
     */
    public AcctStatusType getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(AcctStatusType status) {
        this.status = status;
    }

    /**
     * @return the ver
     */
    public Long getVer() {
        return ver;
    }

    /**
     * @param ver the ver to set
     */
    public void setVer(Long ver) {
        this.ver = ver;
    }

    /**
     * @return the dac
     */
    public String getDac() {
        return dac;
    }

    /**
     * @param dac the dac to set
     */
    public void setDac(String dac) {
        this.dac = dac;
    }

    /**
     * @return the inTime
     */
    public Date getInTime() {
        return inTime;
    }

    /**
     * @param inTime the inTime to set
     */
    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    /**
     * @return the inUser
     */
    public Long getInUser() {
        return inUser;
    }

    /**
     * @param inUser the inUser to set
     */
    public void setInUser(Long inUser) {
        this.inUser = inUser;
    }

    /**
     * @return the upTime
     */
    public Date getUpTime() {
        return upTime;
    }

    /**
     * @param upTime the upTime to set
     */
    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    /**
     * @return the upUser
     */
    public Long getUpUser() {
        return upUser;
    }

    /**
     * @param upUser the upUser to set
     */
    public void setUpUser(Long upUser) {
        this.upUser = upUser;
    }

    /**
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks the remarks to set
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    
    
}
