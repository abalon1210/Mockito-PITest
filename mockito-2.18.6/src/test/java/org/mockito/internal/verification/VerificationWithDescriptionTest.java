/*
 * Copyright (c) 2017 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.internal.verification;

import org.junit.Before;
import org.junit.Test;
import org.mockito.main.Mock;
import org.mockito.main.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoAssertionError;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.main.Mockito.description;
import static org.mockito.main.Mockito.verify;

public class VerificationWithDescriptionTest {

    @Mock
    private List<?> mock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void assertion_error_message_should_start_with_the_custom_specified_message() {

        String failureMessage = "Verification failed!";
        try {
            verify(mock, description(failureMessage)).clear();
            fail("Should not have made it this far");

        } catch (MockitoAssertionError e) {
            assertTrue(e.getMessage().startsWith(failureMessage));
        }
    }
}
