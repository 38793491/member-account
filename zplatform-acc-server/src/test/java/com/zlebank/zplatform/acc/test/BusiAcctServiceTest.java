/* 
 * BusiAcctServiceTest.java  
 * 
 * version TODO
 *
 * 2016年11月14日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.test;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlebank.zplatform.acc.bean.BusiAcct;
import com.zlebank.zplatform.acc.bean.QueryBusiCodeInfo;
import com.zlebank.zplatform.acc.bean.enums.Usage;
import com.zlebank.zplatform.acc.exception.AbstractBusiAcctException;
import com.zlebank.zplatform.acc.service.BusiAcctService;
import com.zlebank.zplatform.member.commons.bean.PersonBusi;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月14日 下午6:00:42
 * @since
 */
public class BusiAcctServiceTest extends BaseTest {

    @Reference(version = "1.0")
    private BusiAcctService busiAcctService;

    @Test
    public void getAccountId() {
        try {
            long result= busiAcctService.getAccountId(Usage.BASICPAY, merchMember);
            System.out.println(result);
        } catch (AbstractBusiAcctException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getBusiCodeByMemberId() {
        try {
            QueryBusiCodeInfo info= busiAcctService.getBusiCodeByMemberId(Usage.BASICPAY, merchMember);
            System.out.println(JSONObject.fromObject(info));
        } catch (AbstractBusiAcctException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void getByBusiAcctCode() {
        String busiAcctCode="9010102200000000000874";
        try {
            BusiAcct busiAcct= busiAcctService.getByBusiAcctCode(busiAcctCode);
            System.out.println(JSONObject.fromObject(busiAcct));
        } catch (AbstractBusiAcctException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void openBusiAcct() {
        BusiAcct busiAcct=new BusiAcct();
        busiAcct.setBusiAcctName("测试开通账户");
        busiAcct.setUsage(Usage.BASICPAY);
        PersonBusi busiActor=new PersonBusi();
        busiActor.setBusinessActorId(indivialMember);
        try {
            busiAcctService.openBusiAcct(busiActor, busiAcct, 45);
        } catch (AbstractBusiAcctException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
