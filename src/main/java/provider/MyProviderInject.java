package provider;

import bean.Animal;
import com.google.inject.Inject;

public class MyProviderInject {
    @Inject
    private Animal animal;

    public void display() {
        System.out.println(animal);
    }
}
