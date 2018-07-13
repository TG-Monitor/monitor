package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class PeersImpl implements Peers {

    private Set<String> peers = new LinkedHashSet<>();
    private PeersUpdater updater;

    public PeersImpl(PeersUpdater updater) {
        this.updater = updater;
    }

    @Override
    public Set<String> getPeers() {
        return new LinkedHashSet<>(peers);
    }

    @Override
    public void setPeers(Set<String> peers) {
        this.peers = new LinkedHashSet<>(peers);
        update();
    }

    @Override
    public void addPeer(String peer) {
        this.peers.add(peer);
        update();
    }

    @Override
    public void addPeers(Set<String> peers) {
        this.peers.addAll(peers);
        update();
    }

    @Override
    public void removePeer(String peer) {
        this.peers.remove(peer);
        update();
    }

    @Override
    public void removePeers(Set<String> peers) {
        this.peers.removeAll(peers);
        update();
    }

    private void update() {
        updater.peersChanged(new HashSet<>(this.peers));
    }
}
