/* 
 * ChannelDAO.java  
 * 
 * version TODO
 *
 * 2015年9月30日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.dao;

import com.zlebank.zplatform.acc.pojo.PojoChannel;
import com.zlebank.zplatform.member.commons.dao.BaseDAO;

/**
 * 渠道
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月30日 上午10:56:19
 * @since 
 */
public interface ChannelDAO  extends BaseDAO<PojoChannel> {

    /**
     * 通过渠道代码得到渠道信息
     * @param chnlCode
     * @return
     */
    PojoChannel getByChnlCode(String chnlCode);

}
