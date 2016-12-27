/* 
 * AccountService.java  
 * 
 * version 1.0
 *
 * 2015年8月25日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.service;

import com.zlebank.zplatform.acc.bean.Account;
import com.zlebank.zplatform.acc.exception.AbstractAccException;
import com.zlebank.zplatform.member.commons.service.impl.BusinessActor;
/**
 * Class Description
 *
 * @author yangying
 * @version
 * @date 2015年8月25日 上午11:55:59
 * @since
 */
public interface AccountService { 
    public Account getByAcctCode(String acctCode) throws AbstractAccException;
    /**
     * 开通会计账户
     * @param account
     * @param member
     * @param userId
     * @return
     * @throws AbstractAccException
     *             if account created by given param is exist
     */
    public Account openAcct(Account account, BusinessActor member, long userId)
            throws AbstractAccException;
    /**
     * 
     * @param parentSubjectId
     * @param acctCode
     * @param acctName
     * @param userId
     * @return
     * @throws AbstractAccException
     *             if parent subject not exist,or acctCode is not illegal
     */
    public String addAcct(long parentSubjectId,
            String acctCode,
            String acctName,
            long userId) throws AbstractAccException;
    
    
    /**
     * 通过ID得到账户信息
     * @return
     */
    public Account getAccountBalanceById(long accountId) ; 
}
