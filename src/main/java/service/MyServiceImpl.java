package service;

public class MyServiceImpl implements MyService {
    private String str;

    public MyServiceImpl() {
    }

    public MyServiceImpl(String str) {
        this.str = str;
    }

    @Override
    public void display() {
        System.out.println(str);
    }
}
