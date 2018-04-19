package net.paulgray.lti.outcomes;

public enum ResponseCodeMajor {

    /**
     * Indicates that the request was successfully applied
     */
    success,

    /**
     * Indicates that the request was not applied, due to an error.
     */
    failure,

    /**
     * Indicates that a request is not supported, and should not be retried.
     */
    unsupported,

    /**
     * Indicates that a request is currently being processed.
     */
    processing
}
