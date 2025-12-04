package edu.ccrm.domain;

public interface Persistable {
    void save();
    default void printSaved() {
        System.out.println("Saved!");
    }
}
