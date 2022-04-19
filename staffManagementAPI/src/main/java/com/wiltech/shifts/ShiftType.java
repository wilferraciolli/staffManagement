package com.wiltech.shifts;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * The enum Shift type.
 */
public enum ShiftType {

    /**
     * Half shift type.
     */
    HALF_DAY("Half a day"),

    /**
     * All day shift type.
     */
    ALL_DAY("All day");

    private String name;

    ShiftType(final String name) {
        this.name = name;
    }

    /**
     * +
     * Helper method to resolve the id of the enum with null safe.
     * @param shiftType The enum to check for its id.
     * @return the id of the enum or null if not valid.
     */
    public static String resolveId(ShiftType shiftType) {

        if (Objects.isNull(shiftType)) {
            return null;
        }

        return stream()
                .filter(p -> p.name().equals(shiftType.name()))
                .map(Enum::name)
                .findFirst()
                .orElse(null);
    }

    public static Stream<ShiftType> stream() {
        return Stream.of(ShiftType.values());
    }

    public String getName() {
        return name;
    }
}
