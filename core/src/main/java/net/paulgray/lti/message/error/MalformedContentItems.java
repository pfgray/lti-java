package net.paulgray.lti.message.error;

import java.util.Objects;

/**
 * The content_items parameter didn't include valid content items json.
 */
public class MalformedContentItems implements LtiError {
    private String contentItemSource;

    public MalformedContentItems(String contentItemSource) {
        this.contentItemSource = contentItemSource;
    }

    @Override
    public String getMessage() {
        return String.format("The content_items parameter didn't include valid content items json. The value was: %s", contentItemSource);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MalformedContentItems that = (MalformedContentItems) o;
        return Objects.equals(contentItemSource, that.contentItemSource);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentItemSource);
    }
}
