package module;

import anno.BindAnno;
import bean.Animal;
import bean.Rat;
import com.google.inject.AbstractModule;

public class BindAnnotationModule extends AbstractModule {
    @Override
    protected void configure() {
        // 注入 Animal 時，如果還有 @BindAnno 注解，注入的是 Rat
        // 如果沒有 @BindAnno 注解，就使用 @ImplementedBy 的值，再沒有就報錯
        bind(Animal.class).annotatedWith(BindAnno.class).to(Rat.class);
    }
}
