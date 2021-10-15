package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repo.RepoIssue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ManIssue {
    private RepoIssue repo;

    public ManIssue(RepoIssue repo) {
        this.repo = repo;
    }

    public void issueAdd(Issue item) {
        repo.save(item);
    }

    public List<Issue> getAll() {
        return repo.findAll();
    }

    public boolean addAll(List<Issue> items) {
        return repo.addAll(items);
    }

    public List<Issue> sortByNew() {
        Comparator byNew = Comparator.naturalOrder();
        ArrayList<Issue> issues = new ArrayList<>(repo.findAll());
        issues.sort(byNew);
        return issues;
    }

    public List<Issue> sortByOld() {
        Comparator byOld = Comparator.reverseOrder();
        ArrayList<Issue> issues = new ArrayList<>(repo.findAll());
        issues.sort(byOld);
        return issues;
    }

    public List<Issue> findByAuthor(String author) {
        Predicate<String> byAuthor = p -> p.equals(author);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repo.findAll())
            if (byAuthor.test(item.getAuthors())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByLabel(Set<String> label) {
        Predicate<Set<String>> byLabel = p -> p.containsAll(label);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repo.findAll())
            if (byLabel.test(item.getLabels())) {
                issues.add(item);
            }
        return issues;
    }

    public List<Issue> findByAssignee(Set<String> assignee) {
        Predicate<Set<String>> byLabel = t -> t.containsAll(assignee);
        List<Issue> issues = new ArrayList<>();
        for (Issue item : repo.findAll())
            if (byLabel.test(item.getAssignees())) {
                issues.add(item);
            }
        return issues;
    }
}