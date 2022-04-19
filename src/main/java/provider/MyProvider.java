package provider;

import bean.Animal;
import bean.Rat;
import com.google.inject.Provider;

public class MyProvider implements Provider<Animal> {
    @Override
    public Animal get() {
        return new Rat();
    }
}
