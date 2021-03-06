/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */

package org.mockitousage.bugs;

import org.junit.Test;
import org.mockito.main.ArgumentCaptor;
import org.mockito.main.Mock;
import org.mockitousage.IMethods;
import org.mockitoutil.TestBase;

import static org.junit.Assert.assertEquals;
import static org.mockito.main.Mockito.only;
import static org.mockito.main.Mockito.verify;

//bug 197
public class ShouldOnlyModeAllowCapturingArgumentsTest extends TestBase {

    @Mock IMethods mock;

    @Test
    public void shouldAllowCapturingArguments() {
        //given
        mock.simpleMethod("o");
        ArgumentCaptor<String> arg = ArgumentCaptor.forClass(String.class);

        //when
        verify(mock, only()).simpleMethod(arg.capture());

        //then
        assertEquals("o", arg.getValue());
    }
}
