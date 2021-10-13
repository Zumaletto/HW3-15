package ru.netology.repo;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepoIssueTest {
    private RepoIssue repo = new RepoIssue();

    private Issue issue1 = new Issue(1, false, 3, "Lena", new HashSet<>(Arrays.asList("assignees1", "assignees2")), new HashSet<>(Arrays.asList("label1", "label2", "label3")));
    private Issue issue2 = new Issue(2, false, 10, "Oleg", new HashSet<>(Arrays.asList("assignees2", "assignees3")), new HashSet<>(Arrays.asList("label2", "label3", "label5")));
    private Issue issue3 = new Issue(3, true, 1, "Alex", new HashSet<>(Arrays.asList("assignees2", "assignees5")), new HashSet<>(Arrays.asList("label2", "label3", "label6")));
    private Issue issue4 = new Issue(4, false, 15, "Lena", new HashSet<>(Arrays.asList("assignees3", "assignees2")), new HashSet<>(Arrays.asList("label3", "label2", "label4")));
    private Issue issue5 = new Issue(5, true, 15, "Lena", new HashSet<>(Arrays.asList("assignees3", "assignees2")), new HashSet<>(Arrays.asList("label3", "label2", "label4")));



}