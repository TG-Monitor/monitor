package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.LinkedHashSet;
import java.util.Set;

public class PatternsImpl implements Patterns {

    private Set<String> patterns = new LinkedHashSet<>();

    @Override
    public Set<String> getPatterns() {
        return new LinkedHashSet<>(patterns);
    }

    @Override
    public void setPatterns(Set<String> patterns) {
        this.patterns = new LinkedHashSet<>(patterns);
    }

    @Override
    public void addPattern(String pattern) {
        this.patterns.add(pattern);
    }

    @Override
    public void addPatterns(Set<String> patterns) {
        this.patterns.addAll(patterns);
    }

    @Override
    public void removePattern(String pattern) {
        this.patterns.remove(pattern);
    }

    @Override
    public void removePatterns(Set<String> patterns) {
        this.patterns.removeAll(patterns);
    }
}
