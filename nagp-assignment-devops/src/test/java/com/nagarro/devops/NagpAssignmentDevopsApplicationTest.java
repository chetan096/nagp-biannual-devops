package com.nagarro.devops;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class NagpAssignmentDevopsApplicationTest {

    @Test
    public void testSample() {
        MatcherAssert.assertThat("chetanmahajan", CoreMatchers.is("chetanmahajan"));
    }

}
