package module;

import com.google.inject.AbstractModule;
import service.MyService;
import service.MyServiceImpl;

public class ConstructorModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(MyService.class).toConstructor(MyServiceImpl.class.getConstructor(String.class));
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        bind(String.class).toInstance("yeah");
    }
}
