package net.paulgray.lti.message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public enum ContextType {

    CourseTemplate("CourseTemplate", "urn:lti:context-type:ims/lis/CourseTemplate"),
    CourseOffering("CourseOffering", "urn:lti:context-type:ims/lis/CourseOffering"),
    CourseSection("CourseSection", "urn:lti:context-type:ims/lis/CourseSection"),
    Group("Group", "urn:lti:context-type:ims/lis/Group");

    private String label;
    private String fullUrn;

    ContextType(String label, String fullUrn) {
        this.label = label;
        this.fullUrn = fullUrn;
    }

    public String getLabel() {
        return label;
    }

    private Set<String> labelAndUrn() {
        return new HashSet<>(Arrays.asList(this.label, this.fullUrn));
    }

    public static Optional<ContextType> fromString(String label) {
        for (ContextType type : ContextType.values()) {
            if (type.labelAndUrn().contains(label)) {
                return Optional.of(type);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return label;
    }
}
