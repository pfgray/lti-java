package net.paulgray.lti.message;

import org.junit.Assert;
import org.junit.Test;

public class TargetTest {

    @Test
    public void valueTest() {
        Assert.assertEquals(Target.iframe, Target.valueOf("iframe"));
        Assert.assertEquals(Target.window, Target.valueOf("window"));
    }
}
