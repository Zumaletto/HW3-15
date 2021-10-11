package ru.netology.repo;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

public class RepoIssue {
    private List<Issue> items = new ArrayList<>();

    public boolean addAll(List<Issue> items) {
        return this.items.addAll(items);
    }

    public List<Issue> findAll() {
        return items;
    }

    public boolean save(Issue item) {
        return items.add(item);
    }

        public List<Issue> findOpen() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items)
            if (item.isOpen()) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findClosed() {
        List<Issue> issues = new ArrayList<>();
        for (Issue item : items)
            if (!item.isOpen()) {
                issues.add(item);
            }
        return issues;
    }

    public void updateById(int id) {
        for (Issue item : items) {
            if (item.getId() == id && item.isOpen()) {
                item.setOpen(false);
            }else if(item.getId() == id && !item.isOpen()){
                item.setOpen(true);
            }
        }
    }

}
