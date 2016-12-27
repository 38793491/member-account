/* 
 * AccountTest.java  
 * 
 * version TODO
 *
 * 2016年11月7日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.test;


import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlebank.zplatform.acc.bean.AccEntry;
import com.zlebank.zplatform.acc.bean.AccEntryQuery;
import com.zlebank.zplatform.acc.bean.Account;
import com.zlebank.zplatform.acc.bean.BusiAcct;
import com.zlebank.zplatform.acc.bean.BusiAcctQuery;
import com.zlebank.zplatform.acc.service.AccountQueryService;
import com.zlebank.zplatform.member.commons.bean.PagedResult;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月7日 上午9:26:46
 * @since 
 */
//@Component
public class AccountQueryServiceTest extends BaseTest{
    
    @Reference(version="1.0")
    private AccountQueryService accountQuery;
    @Test
    public void getBusiQueryBybCode(){
        /*EchoService echoService=(EchoService) accountQuery;
        String status= (String) echoService.$echo("ok");
        assert(status.equals("ok"));*/
       try {
           logger.info("logger is started.....");
           BusiAcctQuery busiAcctQuery=accountQuery.getBusiQueryBybCode("9010102200000000000604");
           logger.info("result:"+JSONObject.fromObject(busiAcctQuery));
        } catch (Exception e) {
            // TODO: handle exception
            logger.error(e);
            //e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getAccEntryByCode(){
        String busiAcctCode="9010102200000000000604";
        Date startTime=new Date(System.currentTimeMillis()-1000*60*60*24*3);
        Date endTime=new Date();
        try {
            PagedResult<AccEntry> result= accountQuery.getAccEntryByCode(1, 10, busiAcctCode, startTime, endTime);
            for (AccEntry accEntry : result.getPagedResult()) {
                logger.debug(accEntry);
            }
            logger.debug(result.getTotal());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getAccEntryByQuery(){
        AccEntryQuery eQuery=new AccEntryQuery();
        eQuery.setBusiCode("10000001");
        try {
            PagedResult<AccEntry> result= accountQuery.getAccEntryByQuery(1, 10, eQuery);
            for (AccEntry accEntry : result.getPagedResult()) {
                logger.debug(accEntry);
            }
            logger.debug(result.getTotal());
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getAccountByID(){
        long accountId=1219;
        try {
            Account result= accountQuery.getAccountByID(accountId);
            logger.debug(JSONObject.fromObject(result));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getAllBusiByMId(){
        String memberId ="200000000000604";
        try {
            List<BusiAcctQuery> result= accountQuery.getAllBusiByMId(memberId);
            for (BusiAcctQuery account : result) {
                logger.debug(JSONObject.fromObject(account));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getBusiACCByMid(){
        String memberid ="200000000000604";
        try {
            List<BusiAcct> result= accountQuery.getBusiACCByMid(memberid);
            for (BusiAcct busiAcct : result) {
                logger.debug(JSONObject.fromObject(busiAcct));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getMemberQueryByID(){
        String busiAcctCode ="9010102200000000000604";
        try {
            BusiAcctQuery result= accountQuery.getMemberQueryByID(busiAcctCode);
            logger.debug(JSONObject.fromObject(result));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            Assert.fail();
        }
    }
}
