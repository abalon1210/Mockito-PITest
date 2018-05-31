package org;

import org.junit.Test;
import org.mockito.configuration.*;

import org.mockito.internal.util.concurrent.DetachedThreadLocal;
import org.mockito.internal.util.concurrent.WeakConcurrentMap;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.main.ArgumentMatcher;
import org.mockito.main.Mockito;
import org.mockito.stubbing.Answer;
import org.mockito.stubbing.Stubber;

import java.security.Key;

import static org.junit.Assert.*;
import static org.mockito.main.Mockito.doThrow;

public class MutantTest {
    
    String name = "test";
    
    @Test
    public void DMC_line_35() {
        DefaultMockitoConfiguration dmc = new DefaultMockitoConfiguration();
        
        assertEquals(dmc.cleansStackTrace(), new Boolean("true"));
    }
    
    @Test
    public void DMC_line_42() {
        DefaultMockitoConfiguration dmc = new DefaultMockitoConfiguration();
        
        assertEquals(dmc.enableClassCache(), new Boolean("true"));
    }
    
    @Test
    public void DMC_line_28() {
        DefaultMockitoConfiguration dmc = new DefaultMockitoConfiguration();
        
        assertNotEquals(dmc.getAnnotationEngine(), null);
    }
    
    @Test
    public void DMC_line_21() {
        DefaultMockitoConfiguration dmc = new DefaultMockitoConfiguration();
        
        assertNotEquals((dmc.getDefaultAnswer()), null);
    }
    
    /*@Test
    public void Mockito_line_2358() {
        Mockito mock = new Mockito();
    
        Answer answer = new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object obj = new Object();
                return obj;
            }
        };
        assertNotEquals( mock.doAnswer(answer), null);
    }*/
  
    @Test
    public void Mockito_line_2774() {
        Mockito mock = new Mockito();
        
        assertNotEquals(mock.timeout(3423894), null);
    }
    
    @Test
    public void Mockito_line_2815() {
        Mockito mock = new Mockito();
        
        assertNotEquals(mock.after(23423849), null);
    }
    
    @Test
    public void DTL_line_25_43_67_70_79_82_90_106_121() {
        DetachedThreadLocal dtl = new DetachedThreadLocal(DetachedThreadLocal.Cleaner.THREAD);
        Thread thread = new Thread();
        DetachedThreadLocal dtl2 = new DetachedThreadLocal(DetachedThreadLocal.Cleaner.INLINE);
        
        assertEquals(dtl.get(), null);
        assertEquals(dtl.pushTo(thread), null);
        assertEquals(dtl.fetchFrom(thread), null);
        assertEquals(dtl2.get(thread), null);
        assertNotEquals(dtl2.getBackingMap(), null);
    }
    
}
