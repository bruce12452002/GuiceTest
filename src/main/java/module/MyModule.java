package module;

import bean.Animal;
import bean.Rat;
import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        // 注入 Animal 時，實際注入的是 Rat
        // 右邊必需繼承或實作左邊，不管是一般類別、抽象類別、介面都可以
        // 並不會影響 @Singleton
        bind(Animal.class).to(Rat.class); //.in(Scopes.SINGLETON); // 可在後轉成單例
    }
}
