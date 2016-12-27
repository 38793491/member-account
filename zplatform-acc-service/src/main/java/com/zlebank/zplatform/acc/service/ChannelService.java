/* 
 * CheckAccount.java  
 * 
 * version v.1.2
 *
 * 2016年1月12日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.service;

import com.zlebank.zplatform.acc.bean.ChannelBean;
import com.zlebank.zplatform.acc.exception.InvalidChannelData;
import com.zlebank.zplatform.acc.exception.SaveChannelDataException;

/**
 * 
 * 通道服务类
 *
 * @author Luxiaoshuai yangying
 * @version
 * @date 2016年1月12日 下午1:14:42
 * @since
 */
public interface ChannelService {
    /**
     *  Open account for channel and convert persist channel.
     * @param channel
     * @return the channel id
     * @throws InvalidChannelData
     * @throws SaveChannelDataException
     */
    public long addChannel(ChannelBean channel) throws InvalidChannelData, SaveChannelDataException;
}
