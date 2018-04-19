package net.paulgray.lti.contentitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;

import java.time.Instant;
import java.util.Optional;

// todo: figure out hierarchy deser
@JsonTypeInfo(
  use = JsonTypeInfo.Id.CUSTOM,
  include = JsonTypeInfo.As.EXISTING_PROPERTY,
  property = "@type")
//@JsonSubTypes({
//  @JsonSubTypes.Type(value = ContentItem.class, name = ContentItem.TYPE),
//  @JsonSubTypes.Type(value = FileItem.class, name = FileItem.TYPE),
//  @JsonSubTypes.Type(value = LtiLinkItem.class, name = LtiLinkItem.TYPE)
//})
@JsonTypeIdResolver(ItemTypeResolver.class)
public interface Item {

    @JsonProperty("@type")
    String type();
    String mediaType();
    Optional<String> url();
    Optional<String> text();
    Optional<String> title();
    Optional<PlacementAdvice> placementAdvice();
    Optional<Instant> expiresAt();
    Optional<Image> icon();
    Optional<Image> thumbnail();
}
