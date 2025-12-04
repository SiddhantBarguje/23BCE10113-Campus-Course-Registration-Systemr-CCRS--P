package edu.ccrm.domain;

public interface Searchable<T> {
    boolean matches(T query);
    default void printMatch(T query) {
        if (matches(query)) {
            System.out.println("Match found: " + query);
        }
    }
}
