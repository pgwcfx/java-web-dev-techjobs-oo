package org.launchcode.techjobs_oo.main;

import java.util.Objects;

public abstract class JobField {
    private final int id;
    private static int nextId = 1;
    private String value;

    public JobField(){
        id=nextId;
        nextId++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return jobField.getId()==getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
