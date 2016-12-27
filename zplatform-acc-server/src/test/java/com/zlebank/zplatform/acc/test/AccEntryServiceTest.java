/* 
 * AccEntryServiceTest.java  
 * 
 * version TODO
 *
 * 2016年11月14日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.test;

import java.math.BigDecimal;

import net.sf.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlebank.zplatform.acc.bean.AccEntry;
import com.zlebank.zplatform.acc.bean.AccEntryQuery;
import com.zlebank.zplatform.acc.bean.TradeInfo;
import com.zlebank.zplatform.acc.bean.enums.EntryEvent;
import com.zlebank.zplatform.acc.bean.enums.TradeType;
import com.zlebank.zplatform.acc.service.AccEntryService;
import com.zlebank.zplatform.member.commons.bean.PagedResult;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月14日 下午6:05:27
 * @since 
 */
public class AccEntryServiceTest extends BaseTest {

     @Reference(version="1.0")
     private AccEntryService accEntryService;
     
     @Test
     public void accEntryProcess(){
         TradeInfo entry = new TradeInfo();
         entry.setPayMemberId("200000000000611");
         entry.setPayordno("M2016082513487124343");
         entry.setCoopInstCode("300000000000027");
         entry.setPayToMemberId("200000000000611");
         entry.setChannelId("95000001");
         entry.setTxnseqno("1609209902323423");
         entry.setBusiCode(TradeType.RECHARGE.getCode());
         entry.setAmount(new BigDecimal(30));
         entry.setCommission(new BigDecimal(0));
         entry.setCharge(new BigDecimal(0));
         try {
             accEntryService.accEntryProcess(entry, EntryEvent.TRADE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            
        }
     }
     @Test
     public void queryPaged(){
         AccEntryQuery accEntryQuery=new AccEntryQuery();
         accEntryQuery.setBusiCode("70000001");
         try {
             PagedResult<AccEntry> result= accEntryService.queryPaged(1, 10, accEntryQuery);
             for (AccEntry accEntry : result.getPagedResult()) {
                System.out.println(JSONObject.fromObject(accEntry));
             }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
     }
}
