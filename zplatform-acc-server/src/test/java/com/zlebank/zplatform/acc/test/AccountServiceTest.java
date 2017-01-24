/* 
 * AccountServiceTest.java  
 * 
 * version TODO
 *
 * 2016年11月14日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.test;

import java.io.Serializable;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlebank.zplatform.acc.bean.Account;
import com.zlebank.zplatform.acc.bean.Subject;
import com.zlebank.zplatform.acc.service.AccountService;
import com.zlebank.zplatform.member.commons.bean.PersonBusi;
import com.zlebank.zplatform.member.commons.service.impl.Individual;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月14日 下午6:00:07
 * @since 
 */
public class AccountServiceTest extends BaseTest implements Serializable{
        
    @Reference(version="1.0")
    private AccountService accountService;
   
    public void addAcct(){
        long parentSubjectId=290;
        String acctCode="";
        String acctName="";
        try {
            //辅助接口
            accountService.addAcct(parentSubjectId, acctCode, acctName, 45);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    //@Test
    public void getAccountBalanceById(){
        long accountId=1222;
        try {
            Account account= accountService.getAccountBalanceById(accountId);
            logger.debug(JSONObject.fromObject(account));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    //@Test
    public void getByAcctCode(){
        String acctCode="224502200000000000611";
        try {
           Account account=  accountService.getByAcctCode(acctCode);
           logger.debug(JSONObject.fromObject(account));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
        
    }
    @Test
    public void openAcct(){
        Account account=new Account();
        account.setAcctCodeName("匿名");
        Subject subject =new Subject();
        subject.setId(290);
        account.setParentSubject(subject);
        final String actorId="999999999999999";
        PersonBusi member=new PersonBusi();
        member.setBusinessActorId(actorId);
        try {
            accountService.openAcct(account, member, 45);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
}
