/* 
 * GetDACImpl.java  
 * 
 * version TODO
 *
 * 2015年9月15日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zlebank.zplatform.acc.exception.AccBussinessException;
import com.zlebank.zplatform.acc.pojo.Money;
import com.zlebank.zplatform.acc.pojo.PojoAbstractSubject;
import com.zlebank.zplatform.acc.service.GetDACService;
import com.zlebank.zplatform.member.commons.utils.Md5;
/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月15日 下午1:06:58
 * @since 
 */
@Service
public class GetDACServiceImpl implements GetDACService{
    
    @Value("${acc.dac.key}")
    private  String dacKey;

    private static final String prefix = "#";
    
    /**
     *
     * @param acctCode
     * @param balance
     * @param frozenBalance
     * @param totalTotalBalance
     * @return
     */
    public String generteDAC(String acctCode,
            Money balance,
            Money frozenBalance,
            Money totalTotalBalance) {
        
        StringBuilder dacSourceSb = new StringBuilder();
        dacSourceSb.append(prefix).append(acctCode);
        dacSourceSb.append(prefix).append(balance.toString());
        dacSourceSb.append(prefix).append(frozenBalance.toString());
        dacSourceSb.append(prefix).append(totalTotalBalance.toString());
        dacSourceSb.append(prefix).append(dacKey);
        return Md5.getInstance().md5s(dacSourceSb.toString());
    }
    @Override
    public void checkDAC(PojoAbstractSubject account) throws AccBussinessException {
        //验证DAC
        String oldDac=account.getDac();
        String newDac=generteDAC(account.getAcctCode(),account.getBalance() , account.getFrozenBalance(),account.getTotalBanance());
       if(!oldDac.equals(newDac))
           throw new AccBussinessException("E100005");
    }
}
