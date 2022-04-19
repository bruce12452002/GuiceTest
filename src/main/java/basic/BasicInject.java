package basic;

import bean.Animal;
import bean.Ox;
import bean.Rat;
import com.google.inject.Inject;

public class BasicInject {
    @Inject
    private Ox ox;

    @Inject
    private Rat rat;

    @Inject // 如果有兩個以上的類別實作 Animal，會報錯，如果不想報錯，可加 optional = true，只不過值是 null
    private Animal animal;


    public void display() {
        System.out.println(ox);
        System.out.println(rat);
        System.out.println(animal);
    }
}
