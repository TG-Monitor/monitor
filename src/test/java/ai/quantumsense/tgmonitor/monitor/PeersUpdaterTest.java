package ai.quantumsense.tgmonitor.monitor;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PeersUpdaterTest {

    private Set<String> set1 = new HashSet<>(Arrays.asList("1", "2", "3", "4", "5"));
    private Set<String> set2 = new HashSet<>(Arrays.asList("1", "3", "5"));

    private Set<String> set3 = new HashSet<>(Arrays.asList("1", "2", "3", "4"));
    private Set<String> set4 = new HashSet<>(Arrays.asList("3", "4", "5", "6"));

    private Set<String> set5 = new HashSet<>(Arrays.asList("1", "2"));
    private Set<String> set6 = new HashSet<>(Arrays.asList("3", "4"));

    private Set<String> emptySet = new HashSet<>();

    MonitorImpl updater = new MonitorImpl(null);

    @Test
    public void onlyStop() {
        Assert.assertEquals(set("2", "4"), updater.getPeersToStop(set1, set2));
        Assert.assertEquals(emptySet, updater.getPeersToStart(set1, set2));
    }

    @Test
    public void onlyStart() {
        Assert.assertEquals(emptySet, updater.getPeersToStop(set2, set1));
        Assert.assertEquals(set("2", "4"), updater.getPeersToStart(set2, set1));
    }

    @Test
    public void startAndStopWithIntersection() {
        Assert.assertEquals(set("1", "2"), updater.getPeersToStop(set3, set4));
        Assert.assertEquals(set("5", "6"), updater.getPeersToStart(set3, set4));
    }

    @Test
    public void startAndStopWithoutIntersection() {
        Assert.assertEquals(set5, updater.getPeersToStop(set5, set6));
        Assert.assertEquals(set6, updater.getPeersToStart(set5, set6));
    }

    @Test
    public void emptySetNew() {
        Assert.assertEquals(set1, updater.getPeersToStop(set1, emptySet));
        Assert.assertEquals(emptySet, updater.getPeersToStart(set1, emptySet));
    }

    @Test
    public void emptySetOld() {
        Assert.assertEquals(emptySet, updater.getPeersToStop(emptySet, set1));
        Assert.assertEquals(set1, updater.getPeersToStart(emptySet, set1));
    }

    private Set<String> set(String... items) {
        return new HashSet<>(Arrays.asList(items));
    }
}
