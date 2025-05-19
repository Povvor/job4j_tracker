package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
class JobTest {

    @Test
    void jobAscByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Take a dinner", 6),
                new Job("Reboot server", 1)

        );
        List<Job> expected = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1),
                new Job("Take a dinner", 6)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void jobDescByNameTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Take a dinner", 6),
                new Job("Reboot server", 1)

        );
        List<Job> expected = Arrays.asList(
                new Job("Take a dinner", 6),
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void jobAscByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Take a dinner", 6),
                new Job("Reboot server", 1)

        );
        List<Job> expected = Arrays.asList(
                new Job("Reboot server", 1),
                new Job("Impl task", 2),
                new Job("Fix bugs", 4),
                new Job("Take a dinner", 6)
        );
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void jobDescByPriorityTest() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Take a dinner", 6),
                new Job("Reboot server", 1)

        );
        List<Job> expected = Arrays.asList(
                new Job("Take a dinner", 6),
                new Job("Fix bugs", 4),
                new Job("Impl task", 2),
                new Job("Reboot server", 1)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndDescPriority2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByDescNameAndAscPriority2() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndDescPriority2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 2),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByAscNameAndAscPriority2() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 1),
                new Job("Fix bug", 3)
        );
        assertThat(rsl).isLessThan(0);
    }

}