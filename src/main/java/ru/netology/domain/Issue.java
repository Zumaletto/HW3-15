package ru.netology.domain;

import java.util.Set;

public class Issue implements Comparable<Issue> {
    private int id;
    private boolean isOpen;
    private int openedDaysAgo;
    private String authors;
    private Set<String> assignees;
    private Set<String> labels;

    public Issue(int id, boolean statusOpen, int openedDaysAgo, String authors, Set<String> assignees, Set<String> labels) {
        this.id = id;
        this.isOpen = statusOpen;
        this.openedDaysAgo = openedDaysAgo;
        this.authors = authors;
        this.assignees = assignees;
        this.labels = labels;
    }

    public Issue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public int getOpenedDaysAgo() {
        return openedDaysAgo;
    }

    public void setOpenedDaysAgo(int openedDaysAgo) {
        this.openedDaysAgo = openedDaysAgo;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Set<String> getAssignees() {
        return assignees;
    }

    public void setAssignees(Set<String> assignees) {
        this.assignees = assignees;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public void setLabels(Set<String> labels) {
        this.labels = labels;
    }

    @Override
    public int compareTo(Issue o) {
        return openedDaysAgo - o.openedDaysAgo;
    }

}

