import aop.AOPInject;
import aop.AOPModule2;
import module.AOPModule;
import basic.Inject1;
import basic.Inject2;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import module.MyModule;
import module.NamedModule;
import org.junit.Test;

public class TestGuice {
    @Test
    public void test1() {
//        Inject1 inject1 = new Inject1();
//        inject1.display();

        Injector injector = Guice.createInjector(new AbstractModule() {
        });
        Inject1 instance = injector.getInstance(Inject1.class);
        instance.display();

        // 同一個 Injector 產出的 class，如果有 @Singleton 就會是同一個
        Inject1 instance2 = injector.getInstance(Inject1.class);
        instance2.display();

    }

    @Test
    public void test2() {
        Injector injector = Guice.createInjector(new MyModule());
        Inject1 instance = injector.getInstance(Inject1.class);
        instance.display();
        Inject1 instance2 = injector.getInstance(Inject1.class);
        instance2.display();
    }

    @Test
    public void test3() {
        Injector injector = Guice.createInjector(new NamedModule());
        Inject2 instance = injector.getInstance(Inject2.class);
        instance.display();
    }

    @Test
    public void testAOP(){
        Injector injector = Guice.createInjector(new AOPModule());
        AOPInject instance = injector.getInstance(AOPInject.class);
        instance.sayYeah();
    }

    @Test
    public void testAOP2(){
        Injector injector = Guice.createInjector(new AOPModule2());
        AOPInject instance = injector.getInstance(AOPInject.class);
        instance.sayYeah();
    }
}
