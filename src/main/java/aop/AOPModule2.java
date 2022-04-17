package aop;

import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

public class AOPModule2 extends AbstractModule {
    @Override
    protected void configure() {
        // aop package 下的方法有 @Xxx 就會調用 AOPService
        //  但此類別必需整個移到 aop 下才有用
        Package p = ClassLoader.getSystemClassLoader().getDefinedPackage("aop");
        bindInterceptor(Matchers.inPackage(p),
                Matchers.annotatedWith(Xxx.class),
                new AOPService());
    }

    public static void main(String[] args) {
        for (Package p : Package.getPackages()) {
            System.out.println(p);
        }
    }
}
