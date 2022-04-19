package provides;

import bean.Tiger;
import com.google.inject.Inject;

public class ProvidesInject {
    @Inject
    private Tiger tiger;

    public void display() {
        System.out.println(tiger.getId());
    }
}
