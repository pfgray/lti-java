package net.paulgray.lti.message;

import net.paulgray.lti.message.error.LtiError;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class LtiErrorableTest {


    @Test
    public void combineThreeShouldCombineSuccesses() {
        LtiErrorable<String> result = LtiErrorable.success(5).combine(
          LtiErrorable.success("yes"),
          LtiErrorable.success(true),
          (five, yes, bool) -> {
            return LtiErrorable.success("works");
          }
        );

        Assert.assertEquals("works", result.getEntity().get());
    }


    @Test
    public void combineThreeShouldFailOutOnErrors() {
        LtiErrorable<String> result = LtiErrorable.error(LtiError.MISSING_LTI_VERSION).combine(
          LtiErrorable.success("yes"),
          LtiErrorable.success(true),
          (five, yes, bool) -> {
              return LtiErrorable.success("works");
          }
        );

        Assert.assertEquals(LtiError.MISSING_LTI_VERSION, result.getErrors().get(0));
    }


    @Test
    public void combineThreeShouldCombineErrors() {
        LtiErrorable<String> result = LtiErrorable.error(LtiError.MISSING_LTI_VERSION).combine(
          LtiErrorable.error(LtiError.MISSING_USER_ID),
          LtiErrorable.error(LtiError.MISSING_MESSAGE_TYPE),
          (five, yes, bool) -> {
              return LtiErrorable.success("works");
          }
        );

        Assert.assertEquals(3, result.getErrors().size());

        Assert.assertTrue(result.getErrors().contains(LtiError.MISSING_LTI_VERSION));
        Assert.assertTrue(result.getErrors().contains(LtiError.MISSING_USER_ID));
        Assert.assertTrue(result.getErrors().contains(LtiError.MISSING_MESSAGE_TYPE));
    }

    @Test
    public void fromShouldConvertOptionals() {
        Assert.assertEquals("yes", LtiErrorable.from(Optional.of("yes"), LtiError.MISSING_MESSAGE_TYPE).getEntity().get());

        Assert.assertEquals(LtiError.MISSING_MESSAGE_TYPE, LtiErrorable.from(Optional.empty(), LtiError.MISSING_MESSAGE_TYPE).getErrors().get(0));
    }

    @Test
    public void collapseShouldMapValues() {
        Assert.assertEquals("success", LtiErrorable.success(5).collapse(five -> "success", error -> "failed"));

        Assert.assertEquals("error", LtiErrorable.error(LtiError.MISSING_USER_ID).collapse(five -> "failed", error -> "error"));
    }


    @Test
    public void flatMapShouldTransformValues() {
        Assert.assertEquals("yes", LtiErrorable.success(5).flatMap(five -> LtiErrorable.success("yes")).getEntity().get());

        Assert.assertEquals(LtiError.MISSING_USER_ID,
          LtiErrorable.error(LtiError.MISSING_USER_ID).flatMap(any -> LtiErrorable.success("no")).getErrors().get(0));
    }


}
