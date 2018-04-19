package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContentItemSelectionTest {

    private ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.registerModule(new Jdk8Module());
        return mapper;
    }

    private static String ContentItemSelectionJson =
      "{\n" +
      "  \"@context\" : \"http://purl.imsglobal.org/ctx/lti/v1/Item\",\n" +
      "  \"@graph\" : [ {\n" +
      "    \"@type\" : \"ContentItem\",\n" +
      "    \"mediaType\" : \"text/html\",\n" +
      "    \"url\" : \"http://www.google.com\",\n" +
      "    \"text\" : null,\n" +
      "    \"title\" : \"Search Engine\",\n" +
      "    \"placementAdvice\" : {\n" +
      "      \"presentationDocumentTarget\" : \"window\",\n" +
      "      \"windowTarget\" : \"_blank\"\n" +
      "    },\n" +
      "    \"expiresAt\" : null,\n" +
      "    \"icon\" : null,\n" +
      "    \"thumbnail\" : {\n" +
      "      \"@id\" : \"https://www.google.com/icon.png\",\n" +
      "      \"width\" : 150,\n" +
      "      \"height\" : 150\n" +
      "    }\n" +
      "  }, {\n" +
      "    \"@type\" : \"LtiLinkItem\",\n" +
      "    \"mediaType\" : \"application/vnd.ims.lti.v1.ltilink\",\n" +
      "    \"url\" : \"https://www.example.com/activity/3/lti\",\n" +
      "    \"text\" : \"You will have 30 minutes to complete this assessment\",\n" +
      "    \"title\" : \"Quiz #1\",\n" +
      "    \"placementAdvice\" : null,\n" +
      "    \"expiresAt\" : null,\n" +
      "    \"icon\" : {\n" +
      "      \"@id\" : \"https://www.example.com/activity/1/icon.png\",\n" +
      "      \"width\" : 100,\n" +
      "      \"height\" : 100\n" +
      "    },\n" +
      "    \"thumbnail\" : null,\n" +
      "    \"custom\" : {\n" +
      "      \"custom_time_to_complete\" : \"900\"\n" +
      "    }\n" +
      "  } ]\n" +
      "}";

    @Test
    public void contentItemSelectionShouldSerializeCorrectly() throws Exception {
        ContentItemSelection selection =
            ContentItemSelection.builder()
              .addGraph(
                ContentItem.builder()
                  .url("http://www.google.com")
                  .mediaType("text/html")
                  .thumbnail(Image.builder()
                    .id("https://www.google.com/icon.png")
                    .width(150)
                    .height(150).build()
                  )
                  .title("Search Engine")
                  .placementAdvice(PlacementAdvice.builder()
                    .presentationDocumentTarget("window")
                    .windowTarget("_blank").build()
                  ).build(),
                LtiLinkItem.builder()
                  .url("https://www.example.com/activity/3/lti")
                  .icon(Image.builder()
                    .id("https://www.example.com/activity/1/icon.png")
                    .width(100)
                    .height(100).build()
                  )
                  .title("Quiz #1")
                  .text("You will have 30 minutes to complete this assessment")
                  .putCustom("custom_time_to_complete", "900")
                  .build()
              ).build();

        assertEquals("ContentItemSelection should be serialized properly",
          getMapper().writeValueAsString(selection),
          ContentItemSelectionJson
        );
    }

    @Test
    public void contentItemSelectionShouldDeSerializeCorrectly() throws Exception {
        ContentItemSelection selection = getMapper().readValue(ContentItemSelectionJson, ContentItemSelection.class);

        assertEquals("ContentItemSelectionJson should include two items",
          2,
          selection.graph().size()
        );

        assertEquals("ContentItemSelection should deserialize an LtiLinkItem's url properly",
          Optional.of("https://www.example.com/activity/3/lti"),
          selection.graph().get(1).url()
        );

        assertEquals("ContentItemSelection should deserialize an LtiLinkItem's custom params properly",
          ((LtiLinkItem)selection.graph().get(1)).custom().get("custom_time_to_complete"),
          "900"
        );
    }
}
