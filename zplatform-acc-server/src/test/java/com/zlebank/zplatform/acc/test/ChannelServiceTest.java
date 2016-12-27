/* 
 * ChannelServiceTest.java  
 * 
 * version TODO
 *
 * 2016年11月16日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.test;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zlebank.zplatform.acc.bean.ChannelBean;
import com.zlebank.zplatform.acc.exception.InvalidChannelData;
import com.zlebank.zplatform.acc.exception.SaveChannelDataException;
import com.zlebank.zplatform.acc.service.ChannelService;

/**
 * Class Description
 *
 * @author houyong
 * @version
 * @date 2016年11月16日 上午9:42:02
 * @since 
 */
public class ChannelServiceTest extends BaseTest {
    @Reference(version = "1.0")
    private ChannelService channelService;
    
    @Test
    public void addChannel(){
        ChannelBean channel=new ChannelBean();
        channel.setChnlname("测试开通渠道");
        channel.setChnlcode(channelCode);
        try {
            channelService.addChannel(channel);
        } catch (InvalidChannelData e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        } catch (SaveChannelDataException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Assert.fail();
        }catch(Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
}
