package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.Set;

public interface Patterns {
    Set<String> getPatterns();
    void setPatterns(Set<String> patterns);
    void addPattern(String pattern);
    void addPatterns(Set<String> patterns);
    void removePattern(String pattern);
    void removePatterns(Set<String> patterns);
}
