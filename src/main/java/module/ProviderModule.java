package module;

import bean.Animal;
import com.google.inject.AbstractModule;
import provider.MyProvider;

public class ProviderModule extends AbstractModule {
    @Override
    protected void configure() {
        // 注入什麼由 MyProvider 決定
        bind(Animal.class).toProvider(MyProvider.class);
    }

}
