package com.zlebank.zplatform.acc.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="/spring/*.xml")
public class BaseTest {
    public Log logger=LogFactory.getLog(BaseTest.class);
    
    public String indivialMember="100000000001001";
    public String merchMember="200000000000874";
    public String coopInstiCode="300000000000010";
    public long coopInstiId=8;
    public String channelCode="95000001";
    @Before
    public void print(){
        System.out.println("Junit test initial success...");
    }
    /**
     * @return the logger
     */
    public Log getLogger() {
        return logger;
    }
    /**
     * @param logger the logger to set
     */
    public void setLogger(Log logger) {
        this.logger = logger;
    }
    
}
