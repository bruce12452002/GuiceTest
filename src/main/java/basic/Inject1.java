package basic;

import bean.Animal;
import bean.Ox;
import bean.Rat;
import com.google.inject.Inject;

public class Inject1 {
    @Inject
    private Ox ox;

    @Inject
    private Rat rat;

    @Inject
    private Animal animal;


    public void display() {
        System.out.println(ox);
        System.out.println(rat);
        System.out.println(animal);
    }
}
