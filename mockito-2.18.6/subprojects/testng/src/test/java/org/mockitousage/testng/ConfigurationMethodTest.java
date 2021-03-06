/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage.testng;

import org.mockito.main.Mock;
import org.mockito.testng.MockitoTestNGListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.main.Mockito.when;

@Listeners(MockitoTestNGListener.class)
public class ConfigurationMethodTest {
    @Mock private Map map;

    @BeforeMethod
    public void some_behavior() {
        when(map.get("the answer to ...")).thenReturn(42);
    }


    @Test
    public void mocks_should_stay_configured_with_behavior() throws IOException {
        assertThat(map.get("the answer to ...")).isEqualTo(42);
    }
}
