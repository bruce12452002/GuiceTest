package module;

import bean.Tiger;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ProvidesModule extends AbstractModule {
    /**
     * 類似 Spring 的 @Bean，回傳值會注入
     */
    @Provides
    public Tiger getTiger() {
        Tiger tiger = new Tiger();
        tiger.setId(999);
        return tiger;
    }
}
