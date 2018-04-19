package net.paulgray.lti;

import java.util.Objects;

public class UnknownLtiVersion implements LtiVersion {

    private String value;

    UnknownLtiVersion(String value) {
        this.value = value;
    }

    public static UnknownLtiVersion of(String value) {
        return new UnknownLtiVersion(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnknownLtiVersion that = (UnknownLtiVersion) o;
        return Objects.equals(getValue(), that.getValue());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getValue());
    }
}
