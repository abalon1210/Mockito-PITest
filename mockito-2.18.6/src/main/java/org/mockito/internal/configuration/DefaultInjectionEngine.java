/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.configuration;

import java.lang.reflect.Field;
import java.util.Set;

import org.mockito.internal.configuration.injection.MockInjection;
import org.mockito.main.MockitoAnnotations;

/**
 * Inject mock/spies dependencies for fields annotated with &#064;InjectMocks
 * <p/>
 * See {@link MockitoAnnotations}
 */
public class DefaultInjectionEngine {

    public void injectMocksOnFields(Set<Field> needingInjection, Set<Object> mocks, Object testClassInstance) {
        MockInjection.onFields(needingInjection, testClassInstance)
                .withMocks(mocks)
                .tryConstructorInjection()
                .tryPropertyOrFieldInjection()
                .handleSpyAnnotation()
                .apply();
    }

}
