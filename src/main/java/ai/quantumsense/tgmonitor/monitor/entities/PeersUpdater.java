package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.Set;

public interface PeersUpdater {
    /**
     * Notify that the set of peers changed.
     * @param peers The updated complete set of peers.
     */
    void peersChanged(Set<String> peers);
}
