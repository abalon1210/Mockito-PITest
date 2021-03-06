/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.testng;

import org.mockito.main.Mock;
import org.mockito.main.Mockito;
import org.mockito.main.Spy;
import org.mockito.internal.util.reflection.Fields;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;

import java.util.Collection;

import static org.mockito.internal.util.reflection.Fields.annotatedBy;

public class MockitoAfterTestNGMethod {

    public void applyFor(IInvokedMethod method, ITestResult testResult) {
        Mockito.validateMockitoUsage();

        if (method.isTestMethod()) {
            resetMocks(testResult.getInstance());
        }
    }


    private void resetMocks(Object instance) {
        Mockito.reset(instanceMocksOf(instance).toArray());
    }

    @SuppressWarnings("unchecked")
    private Collection<Object> instanceMocksOf(Object instance) {
        return Fields.allDeclaredFieldsOf(instance)
                                            .filter(annotatedBy(Mock.class, Spy.class))
                                            .notNull()
                                            .assignedValues();
    }


}
