package basic;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class ConstantInject {
    @Inject
    @Named("aaa")
    private String xxx;

    private String ooo;

    /**
     * 參數會被傳進來的值覆蓋，不管是空還是 null 都一樣
     * 可以使用建構子和 setter 注入
     */
    public void display(@Named("aaa") String xyz) {
        System.out.println(xxx);
        System.out.println(ooo);
        System.out.println(xyz);
    }

    @Inject
    public ConstantInject(@Named("aaa") String xyz) {
        System.out.println("xyz=" + xyz);
    }


    /**
     * 建構子執行過後會自動執行 setter 的 @Inject
     * 如果顯示呼叫會以呼叫端為主
     */
    @Inject
    public void setOoo(@Named("aaa") String ooo) {
        System.out.println("ooo=" + ooo);
        this.ooo = ooo;
    }
}
