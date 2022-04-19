package anno;

import bean.Animal;
import bean.Tiger;
import com.google.inject.Inject;

public class BindAnnoInject {
    @Inject
    @BindAnno
    private Animal animal;

    @Inject
    private Tiger tiger;

    public void display() {
        System.out.println(animal);
        System.out.println(tiger);
    }
}
