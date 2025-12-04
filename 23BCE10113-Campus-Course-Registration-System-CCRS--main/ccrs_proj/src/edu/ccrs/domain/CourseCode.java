package edu.ccrm.domain;

import java.util.Objects;

public final class CourseCode {
    private final String code;
    public CourseCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseCode that = (CourseCode) o;
        return Objects.equals(code, that.code);
    }
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
    @Override
    public String toString() {
        return code;
    }
}
