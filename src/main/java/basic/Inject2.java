package basic;

import bean.Animal;
import bean.Tiger;
import com.google.inject.Inject;
import com.google.inject.name.Named;

public class Inject2 {
    @Inject
    @Named("xxx")
    private Animal animal;

    @Inject
    @Named("ooo")
    private Tiger tiger;

    public void display() {
        System.out.println(animal);
        System.out.println(tiger);
    }
}
