package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repo.RepoIssue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ManIssueTest {
    private RepoIssue repo = new RepoIssue();
    public ManIssue manager = new ManIssue(repo);

    private Issue issue1 = new Issue(1, false, 3, "Lena", new HashSet<>(Arrays.asList("assignees1", "assignees2")), new HashSet<>(Arrays.asList("label1", "label2", "label3")));
    private Issue issue2 = new Issue(2, false, 10, "Oleg", new HashSet<>(Arrays.asList("assignees2", "assignees3")), new HashSet<>(Arrays.asList("label2", "label3", "label5")));
    private Issue issue3 = new Issue(3, true, 1, "Alex", new HashSet<>(Arrays.asList("assignees2", "assignees3")), new HashSet<>(Arrays.asList("label2", "label3", "label6")));
    private Issue issue4 = new Issue(4, false, 15, "Lena", new HashSet<>(Arrays.asList("assignees3", "assignees5")), new HashSet<>(Arrays.asList("label3", "label2", "label4")));
    private Issue issue5 = new Issue(5, true, 15, "Lena", new HashSet<>(Arrays.asList("assignees3", "assignees2")), new HashSet<>(Arrays.asList("label3", "label2", "label4")));

    @Test
    void shouldAddByOn() {
        manager.issueAdd(issue1);
        manager.issueAdd(issue3);
        manager.issueAdd(issue5);

        List<Issue> expected = new ArrayList<>(List.of(issue1, issue3, issue5));
        List<Issue> actual = manager.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByNew() {
        manager.addAll(List.of(issue1, issue2, issue3));
        List<Issue> expected = new ArrayList<>(List.of(issue3, issue1, issue2));
        List<Issue> actual = manager.sortByNew();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByNewEmpty() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.sortByNew();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByNewIfAddOne() {
        manager.issueAdd(issue1);
        List<Issue> expected = new ArrayList<>(List.of(issue1));
        List<Issue> actual = manager.sortByNew();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByOld() {
        manager.addAll(List.of(issue1, issue2, issue3));
        List<Issue> expected = new ArrayList<>(List.of(issue2, issue1, issue3));
        List<Issue> actual = manager.sortByOld();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByOldEmpty() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.sortByOld();
        assertEquals(expected, actual);
    }

    @Test
    void shouldSortByOldIfAddOne() {
        manager.addAll(List.of(issue3));
        List<Issue> expected = new ArrayList<>(List.of(issue3));
        List<Issue> actual = manager.sortByOld();
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAuthor() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>(List.of(issue1, issue4, issue5));
        List<Issue> actual = manager.findByAuthor("Lena");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNoAuthor() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAuthor("Misha");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAuthorEmpty() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAuthor("Lena");
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByLabel() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>(List.of(issue4, issue5));
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("label3", "label2", "label4")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNoLabel() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("label7", "label2", "label4")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByLabelEmpty() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByLabel(new HashSet<String>(Arrays.asList("label3", "label2", "label4")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAssignee() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>(List.of(issue2, issue3, issue5));
        List<Issue> actual = manager.findByAssignee(new HashSet<String>(Arrays.asList("assignees2", "assignees3")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByNoAssignee() {
        manager.addAll(List.of(issue1, issue2, issue3, issue4, issue5));
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAssignee(new HashSet<String>(Arrays.asList("assignees7", "assignees5")));
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByAssigneeEmpty() {
        List<Issue> expected = new ArrayList<>();
        List<Issue> actual = manager.findByAssignee(new HashSet<String>(Arrays.asList("assignees2", "assignees3")));
        assertEquals(expected, actual);
    }

}