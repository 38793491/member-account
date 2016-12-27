/* 
 * GetDAC.java  
 * 
 * version TODO
 *
 * 2015年9月15日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.zlebank.zplatform.acc.service;

import com.zlebank.zplatform.acc.exception.AccBussinessException;
import com.zlebank.zplatform.acc.pojo.Money;
import com.zlebank.zplatform.acc.pojo.PojoAbstractSubject;

/**
 * Class Description
 *
 * @author yangpeng
 * @version
 * @date 2015年9月15日 下午1:05:53
 * @since 
 */
public interface GetDACService {
    /**
     * 生产DAC
     * @param acctCode
     * @param balance
     * @param frozenBalance
     * @param totalTotalBalance
     * @return
     */
    public  String generteDAC(String acctCode,
            Money balance,
            Money frozenBalance,
            Money totalTotalBalance);
    
    /**
     * 验证DAC
     * @param account
     * @throws AccBussinessException 
     */
    public void checkDAC(PojoAbstractSubject account) throws AccBussinessException; 
}
