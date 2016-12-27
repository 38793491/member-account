/* 
 * ChannelDAOImpl.java  
 * 
 * version TODO
 *
 * 2015年9月30日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.zlebank.zplatform.acc.dao.ChannelDAO;
import com.zlebank.zplatform.acc.pojo.PojoChannel;
import com.zlebank.zplatform.member.commons.dao.impl.HibernateBaseDAOImpl;
/**
 * 渠道
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年9月30日 上午10:56:44
 * @since 
 */
@Repository
public class ChannelDAOImpl  extends HibernateBaseDAOImpl<PojoChannel> implements ChannelDAO {
    /**
     *通过渠道代码得到渠道信息
     * @param chnlCode
     * @return
     */
    @Override
    public PojoChannel getByChnlCode(String chnlCode) {
        Criteria crite= getSession().createCriteria(PojoChannel.class);
        crite.add(Restrictions.eq("chnlcode", chnlCode));
        PojoChannel pojo = (PojoChannel) crite.uniqueResult();
        return pojo;
    }
}
