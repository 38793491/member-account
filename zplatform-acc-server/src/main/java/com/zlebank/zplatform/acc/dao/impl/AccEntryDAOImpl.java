/* 
 * AccEntryDAOImpl.java  
 * 
 * version TODO
 *
 * 2015年8月31日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.zlebank.zplatform.acc.bean.AccEntryQuery;
import com.zlebank.zplatform.acc.bean.enums.AccEntryStatus;
import com.zlebank.zplatform.acc.bean.enums.EntryEvent;
import com.zlebank.zplatform.acc.bean.enums.LockStatusType;
import com.zlebank.zplatform.acc.dao.AccEntryDAO;
import com.zlebank.zplatform.acc.pojo.PojoAccEntry;
import com.zlebank.zplatform.member.commons.dao.impl.AbstractPagedQueryDAOImpl;
import com.zlebank.zplatform.member.commons.utils.StringUtil;

/**
 * Class Description
 *
 * @author Luxiaoshuai
 * @version
 * @date 2015年8月31日 下午5:12:54
 * @since 
 */
@Repository
public class AccEntryDAOImpl  extends AbstractPagedQueryDAOImpl<PojoAccEntry,AccEntryQuery> implements AccEntryDAO {

    /**
     *
     * @param e
     * @return
     */
    @Override
    protected Criteria buildCriteria(AccEntryQuery e) {
       Criteria crite= this.getSession().createCriteria(PojoAccEntry.class);
       //科目号
       if(StringUtil.isNotEmpty(e.getAcctCode())){
           
           crite.add(Restrictions.eq("acctCode", e.getAcctCode()));
       }
       //交易类型代码
       if(StringUtil.isNotEmpty(e.getBusiCode())){
           crite.add(Restrictions.eq("busiCode", e.getBusiCode()));
       }
       //时间
       if(e.getEndTime()!=null){
           
        
           crite.add(Restrictions.le("inTime",e.getEndTime())); 
       }
       if(e.getStartTime()!=null){
           crite.add(Restrictions.ge("inTime",e.getStartTime())); 
       }
       //状态
       if(e.getStatus()!=null){
           crite.add(Restrictions.eq("status", e.getStatus()));
           
       }
       //交易流水号
       if(StringUtil.isNotEmpty(e.getTxnseqno())){
         crite.add(Restrictions.eqOrIsNull("txnseqno", e.getTxnseqno()))  ;
           
       }
       //凭证号
       if(e.getVoucherCode()!=null){
         crite.add(Restrictions.eqOrIsNull("voucherCode", e.getVoucherCode()))  ;
           
       }
       //支付订单号
       if(StringUtil.isNotEmpty(e.getPayordno())){
         crite.add(Restrictions.eqOrIsNull("payordno", e.getPayordno()))  ;
           
       }
       crite.addOrder(Order.desc("inTime"));
       return crite;
          
    }
	/**
	 * 
	 * @param id
	 * @return
	 */
    public PojoAccEntry get(long id) {
        return (PojoAccEntry) getSession().get(PojoAccEntry.class, id);
    }
	/**
	 *
	 * @param fetchSize
	 * @return
	 */
	@SuppressWarnings("unchecked")
    @Override
	public List<PojoAccEntry> getLockRecords(int fetchSize) {
		Criteria criteria = getSession().createCriteria(PojoAccEntry.class);
        // 乐观锁
        criteria.add(Restrictions.eq("isLock", LockStatusType.UNLOCK));
        criteria.add(Restrictions.eq("status", AccEntryStatus.WAIT_ACCOUNTED));
        criteria.setMaxResults(fetchSize);
        return criteria.list();
	}

	/**
	 *
	 * @param id
	 */
	@Override
	public PojoAccEntry getByIdForUpdate(long voucherCode) {
		Criteria criteria = getSession().createCriteria(PojoAccEntry.class);
        criteria.add(Restrictions.eq("voucherCode", voucherCode));
        // 悲观锁
        criteria.setLockMode(LockMode.UPGRADE_NOWAIT);
        return (PojoAccEntry) criteria.uniqueResult();
		
	}
    
    @SuppressWarnings("unchecked")
    @Override
    public List<PojoAccEntry> getByTxnNo(String txnseqno, String busiCode,EntryEvent entryEvent) {
        Criteria criteria = getSession().createCriteria(PojoAccEntry.class);
        criteria.add(Restrictions.eq("txnseqno", txnseqno));
        criteria.add(Restrictions.eq("busiCode", busiCode));
        criteria.add(Restrictions.eq("entryEvent", entryEvent));
        return criteria.list();
    }
    /**
     *
     * @param offset
     * @param pageSize
     * @param example
     * @return
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<HashMap<String, Object>> getItem(int offset,
            int pageSize,
            AccEntryQuery example) {
        // TODO Auto-generated method stub
        StringBuffer sql=buildSql(example);
        sql.append(" order by tae.in_time desc ");
        SQLQuery sqlQuery=getSession().createSQLQuery(sql.toString());
        sqlQuery.setFirstResult(offset).setMaxResults(pageSize);
        sqlQuery.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return sqlQuery.list();
    }
    /**
     *
     * @param example
     * @return
     */
    @Override
    public long total(AccEntryQuery example) {
        SQLQuery sqlQuery=getSession().createSQLQuery(buildSql(example).toString());
        return sqlQuery.list().size();
    }
    private StringBuffer buildSql(AccEntryQuery query){
        StringBuffer sql=new StringBuffer();
        sql.append("select tae.voucher_code,tae.acct_code,tae.payordno,tae.txnseqno,tae.status,tae.busi_code,tae.crdr as ecrdr,acct.crdr as acrdr,tae.in_time,tae.amount,");
        sql.append("acct.business_actor_id,bact.busiacct_name,bact.usage from T_ACC_ENTRY tae ");
        sql.append("left join t_acc_acct acct on tae.acct_code=acct.acct_code ");
        sql.append("left join t_acc_busiacct bact on bact.acct_id=acct.id where 1=1 ");
        if (StringUtil.isNotEmpty(query.getAcctCode())) {
            sql.append(" and acct.acct_code='"+query.getAcctCode()+"'");
        }
        if (StringUtil.isNotEmpty(query.getBusiCode())) {
            sql.append(" and tae.busi_code='"+query.getBusiCode()+"'");
        }
        if (StringUtil.isNotEmpty(query.getPayordno())) {
            sql.append(" and acct.acct_code='"+query.getAcctCode()+"'");
        }
        if (StringUtil.isNotEmpty(query.getTxnseqno())) {
            sql.append(" and tae.txnseqno='"+query.getTxnseqno()+"'");
        }
        if (query.getStartTime()!=null) {
            sql.append(" and tae.in_time>="+query.getStartTime());
        }
        if (query.getEndTime()!=null) {
            sql.append(" and tae.in_time<="+query.getEndTime());
        }
        if (query.getStatus()!=null) {
            sql.append(" and tae.status='"+query.getStatus().getCode()+"'");
        }
        if (query.getVoucherCode()!=null) {
            sql.append(" and tae.voucher_code="+query.getVoucherCode().longValue());
        }
        return sql;
    }
}
