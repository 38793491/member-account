package com.zlebank.zplatform.acc.bean;

import java.io.Serializable;

/**
 * 
 * 业务账户信息查询
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月19日 下午3:07:06
 * @since
 */
public class QueryBusiCodeInfo implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 8352340664768647325L;
    /**会计账户Id**/
    private long acctId;
    /**科目号**/
    private String busiCode;

    public long getAcctId() {
        return acctId;
    }
    public void setAcctId(long acctId) {
        this.acctId = acctId;
    }
    public String getBusiCode() {
        return busiCode;
    }
    public void setBusiCode(String busiCode) {
        this.busiCode = busiCode;
    }
    
}
