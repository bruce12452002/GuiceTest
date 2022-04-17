package module;

import bean.Animal;
import bean.Rat;
import bean.Tiger;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class NamedModule extends AbstractModule {
    @Override
    protected void configure() {
        // 介面：
        // 注入 Animal 時，還得加上 @Named，如果字串和這裡設定的一樣，注入的是 Rat
        // 會覆蓋 @ImplementedBy
        bind(Animal.class).annotatedWith(Names.named("xxx")).to(Rat.class);

        // 類別：
        // 如果沒加 @Named 會注入 Tiger；加了但字串不同會報錯
        bind(Tiger.class).annotatedWith(Names.named("ooo")).to(Rat.class);
    }
}
