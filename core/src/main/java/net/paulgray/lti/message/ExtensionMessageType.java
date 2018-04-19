package net.paulgray.lti.message;

import java.util.Objects;

public class ExtensionMessageType implements MessageType {

    private String value;

    ExtensionMessageType(String value) {
        this.value = value;
    }

    public static ExtensionMessageType of(String value) {
        return new ExtensionMessageType(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtensionMessageType that = (ExtensionMessageType) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getValue());
    }
}
