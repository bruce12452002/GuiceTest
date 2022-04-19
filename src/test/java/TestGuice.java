import anno.BindAnnoInject;
import aop.AOPInject;
import aop.AOPModule2;
import basic.BasicInject;
import basic.ConstantInject;
import basic.NamedInject;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import module.*;
import org.junit.Test;
import provider.MyProviderInject;
import provides.ProvidesInject;
import service.MyService;

public class TestGuice {
    @Test
    public void testBasic1() {
//        Inject1 inject1 = new Inject1();
//        inject1.display();

        Injector injector = Guice.createInjector(new AbstractModule() {
        });
        BasicInject instance = injector.getInstance(BasicInject.class);
        instance.display();

        // 同一個 Injector 產出的 class，如果有 @Singleton 就會是同一個
        BasicInject instance2 = injector.getInstance(BasicInject.class);
        instance2.display();
    }

    @Test
    public void testBasic2() {
        Injector injector = Guice.createInjector(new MyModule());
        BasicInject instance = injector.getInstance(BasicInject.class);
        instance.display();
        BasicInject instance2 = injector.getInstance(BasicInject.class);
        instance2.display();
    }

    @Test
    public void testNamed() {
        Injector injector = Guice.createInjector(new NamedModule());
        NamedInject instance = injector.getInstance(NamedInject.class);
        instance.display();
    }

    @Test
    public void testConstant() {
        Injector injector = Guice.createInjector(new ConstantModule());
        ConstantInject instance = injector.getInstance(ConstantInject.class);
        instance.display(null);
        System.out.println("------------------");
        instance.setOoo(null);
    }

    @Test
    public void testBindingAnnotation() {
        Injector injector = Guice.createInjector(new BindAnnotationModule());
        BindAnnoInject instance = injector.getInstance(BindAnnoInject.class);
        instance.display();
    }

    @Test
    public void testProvides() {
        Injector injector = Guice.createInjector(new ProvidesModule());
        ProvidesInject instance = injector.getInstance(ProvidesInject.class);
        instance.display();
    }

    @Test
    public void testProvider() {
        Injector injector = Guice.createInjector(new ProviderModule());
        MyProviderInject instance = injector.getInstance(MyProviderInject.class);
        instance.display();
    }

    @Test
    public void testProvidedBy() {
        // 如果 @ProvidedBy @ImplementedBy 都有設定，會以 @ImplementedBy 為主
        Injector injector = Guice.createInjector(new AbstractModule() {
        });
        MyProviderInject instance = injector.getInstance(MyProviderInject.class);
        instance.display();
    }

    @Test
    public void testConstructor() {
        Injector injector = Guice.createInjector(new ConstructorModule());
        MyService instance = injector.getInstance(MyService.class);
        instance.display();
    }

    @Test
    public void testAOP() {
        Injector injector = Guice.createInjector(new AOPModule());
        AOPInject instance = injector.getInstance(AOPInject.class);
        instance.sayYeah();
    }

    @Test
    public void testAOP2() {
        Injector injector = Guice.createInjector(new AOPModule2());
        AOPInject instance = injector.getInstance(AOPInject.class);
        instance.sayYeah();
    }
}
