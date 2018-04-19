package net.paulgray.lti.message;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ContextTypeTest {

    @Test
    public void fromStringTest() {
        Assert.assertEquals(ContextType.CourseOffering, ContextType.fromString("CourseOffering").get());
        Assert.assertEquals(ContextType.CourseOffering, ContextType.fromString("urn:lti:context-type:ims/lis/CourseOffering").get());

        Assert.assertEquals(ContextType.CourseSection, ContextType.fromString("CourseSection").get());
        Assert.assertEquals(ContextType.CourseSection, ContextType.fromString("urn:lti:context-type:ims/lis/CourseSection").get());

        Assert.assertEquals(ContextType.CourseTemplate, ContextType.fromString("CourseTemplate").get());
        Assert.assertEquals(ContextType.CourseTemplate, ContextType.fromString("urn:lti:context-type:ims/lis/CourseTemplate").get());

        Assert.assertEquals(ContextType.Group, ContextType.fromString("Group").get());
        Assert.assertEquals(ContextType.Group, ContextType.fromString("urn:lti:context-type:ims/lis/Group").get());


        Assert.assertEquals(Optional.empty(), ContextType.fromString("nonexistent"));
    }
}
