package net.paulgray.lti;

public enum KnownLtiVersion implements LtiVersion {

    One("LTI-1p0"),
    Two("LTI-2p0");

    private String value;

    KnownLtiVersion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
