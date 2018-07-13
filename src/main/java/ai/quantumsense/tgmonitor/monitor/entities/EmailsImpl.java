package ai.quantumsense.tgmonitor.monitor.entities;

import ai.quantumsense.tgmonitor.servicelocator.ServiceLocator;

import java.util.LinkedHashSet;
import java.util.Set;

public class EmailsImpl implements Emails {

    private Set<String> emails = new LinkedHashSet<>();

//    public EmailsImpl(ServiceLocator serviceLocator) {
//        serviceLocator.registerEmailsRepo(this);
//    }

    @Override
    public Set<String> getEmails() {
        return new LinkedHashSet<>(emails);
    }

    @Override
    public void setEmails(Set<String> emails) {
        this.emails = new LinkedHashSet<>(emails);
    }

    @Override
    public void addEmail(String email) {
        this.emails.add(email);
    }

    @Override
    public void addEmails(Set<String> emails) {
        this.emails.addAll(emails);
    }

    @Override
    public void removeEmail(String email) {
        this.emails.remove(email);
    }

    @Override
    public void removeEmails(Set<String> emails) {
        this.emails.removeAll(emails);
    }
}
