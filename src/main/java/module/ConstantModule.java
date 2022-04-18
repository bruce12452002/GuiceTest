package module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ConstantModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("aaa")).toInstance("default value");
    }
}
