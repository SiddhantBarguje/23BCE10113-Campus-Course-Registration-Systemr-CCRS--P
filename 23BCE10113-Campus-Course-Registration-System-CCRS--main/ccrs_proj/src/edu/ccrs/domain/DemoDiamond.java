package edu.ccrm.domain;

public class DemoDiamond implements Searchable<String>, Persistable {
    private String value;
    public DemoDiamond(String value) { this.value = value; }
    @Override
    public boolean matches(String query) {
        return value != null && value.contains(query);
    }
    // Explicit override to resolve diamond problem
    @Override
    public void printMatch(String query) {
        if (matches(query)) {
            System.out.println("DemoDiamond match: " + query);
        } else {
            System.out.println("No match: " + query);
        }
    }
    @Override
    public void save() {
        System.out.println("DemoDiamond saved: " + value);
    }
}
