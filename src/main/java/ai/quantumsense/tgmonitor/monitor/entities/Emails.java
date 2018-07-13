package ai.quantumsense.tgmonitor.monitor.entities;

import java.util.Set;

public interface Emails {
    Set<String> getEmails();
    void setEmails(Set<String> emails);
    void addEmail(String email);
    void addEmails(Set<String> emails);
    void removeEmail(String email);
    void removeEmails(Set<String> emails);
}
