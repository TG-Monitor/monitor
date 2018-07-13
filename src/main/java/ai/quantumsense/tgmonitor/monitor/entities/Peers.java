package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.Set;

public interface Peers {
    Set<String> getPeers();
    void setPeers(Set<String> peers);
    void addPeer(String peer);
    void addPeers(Set<String> peers);
    void removePeer(String peer);
    void removePeers(Set<String> peers);
}
