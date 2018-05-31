/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockitousage.testng;

import org.mockito.main.InjectMocks;
import org.mockito.main.Mock;
import org.mockito.main.Spy;
import org.mockito.testng.MockitoTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Observable;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.main.BDDMockito.given;
import static org.mockito.main.Matchers.anyString;
import static org.mockito.main.Mockito.never;
import static org.mockito.main.Mockito.verify;

@Listeners(MockitoTestNGListener.class)
public class MockFieldsShouldBeResetBetweenTestMethodsTest {

    @Mock List<String> list;
    @Spy HashMap hashMap;
    @InjectMocks SomeType someType;

    @Mock Observable will_be_nulled;

    @Test
    public void behaviour_A_without_infection_from_behaviour_B() throws Exception {
        // verify mock is clean
        assertThat(list.get(0)).isNull();
        verify(list, never()).add(anyString());

        // local behaviour A
        given(list.get(0)).willReturn("A");
        assertThat(list.get(0)).isEqualTo("A");

        list.add("something else after A");
    }

    @Test
    public void behaviour_B_without_infection_from_behaviour_A() throws Exception {
        // verify mock is clean
        assertThat(list.get(0)).isNull();
        verify(list, never()).add(anyString());

        // local behaviour A
        given(list.get(0)).willReturn("B");
        assertThat(list.get(0)).isEqualTo("B");

        list.add("something else after B");
    }

    @Test
    public void dont_fail_when_reseting_null_field() throws Exception {
        will_be_nulled = null;
    }
}
