package module;

import aop.AOPInject;
import aop.AOPService;
import aop.Xxx;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class AOPModule extends AbstractModule {
    @Override
    protected void configure() {
        /**
         * bindInterceptor 有三個參數，第三個參數是 ...
         * 從什麼類別的什麼方法，執行什麼 aop
         */

        // AOPInject.class 的方法有 @Xxx 就會調用 AOPService
        bindInterceptor(Matchers.subclassesOf(AOPInject.class),
                Matchers.annotatedWith(Xxx.class),
                new AOPService());

        // aop package 下的方法有 @Xxx 就會調用 AOPService
        // 但此類別必需整個移到 aop 下才有用
//        Package p = ClassLoader.getSystemClassLoader().getDefinedPackage("module");
//        bindInterceptor(Matchers.inPackage(p),
//                Matchers.annotatedWith(Xxx.class),
//                new AOPService());

        // 任何類別的方法有 @Xxx 就會調用 AOPService
//        bindInterceptor(Matchers.any(),
//                Matchers.annotatedWith(Xxx.class),
//                new AOPService());
    }

    public static void main(String[] args) {
        // 自己寫的類別，只會印出當下執行的方法的所屬 package
        for (Package p : Package.getPackages()) {
            System.out.println(p);
        }
    }
}
