/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage.testng;

import org.mockito.main.ArgumentCaptor;
import org.mockito.main.Captor;
import org.mockito.main.Mock;
import org.mockito.testng.MockitoTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.main.Mockito.times;
import static org.mockito.main.Mockito.verify;

@Listeners(MockitoTestNGListener.class)
public class CaptorAnnotatedFieldShouldBeClearedTest {

    @Captor ArgumentCaptor<String> captor;
    @Mock List<String> list;

    @Test
    public void first_test_method_that_uses_captor() throws Exception {
        list.add("a");
        list.add("b");

        verify(list, times(2)).add(captor.capture());
        assertThat(captor.getAllValues()).containsOnly("a", "b");
    }

    @Test
    public void second_test_method_that_uses_captor() throws Exception {
        list.add("t");
        list.add("u");

        verify(list, times(2)).add(captor.capture());
        assertThat(captor.getAllValues()).containsOnly("t", "u");
    }
}
