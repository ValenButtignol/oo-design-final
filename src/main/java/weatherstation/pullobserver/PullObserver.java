package weatherstation.pullobserver;

import weatherstation.PullSubject;

public interface PullObserver {
    public void update(PullSubject subject);
}
