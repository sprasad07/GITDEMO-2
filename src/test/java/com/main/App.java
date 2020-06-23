package com.main;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class App
{
    /**
     * Rigorous Test :-)
     */
    @Test(groups = "Smoke")
    public void shouldAnswerWithTrue()
    {
        System.out.println("APP TC");
    	Assert.assertTrue(true);
    }
    
    
}
