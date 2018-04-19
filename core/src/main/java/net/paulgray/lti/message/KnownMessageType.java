package net.paulgray.lti.message;

public enum KnownMessageType implements MessageType {

    BasicLtiLaunchRequest("basic-lti-launch-request"),
    ContentItemSelectionRequest("ContentItemSelectionRequestMessage"),
    ContentItemSelection("ContentItemSelection"),
    DashboardRequest("DashboardRequest"),
    ConfigureLaunchRequest("ConfigureLaunchRequest");

    private String value;

    KnownMessageType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
