package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AOPService implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before " + methodInvocation.getMethod().getName());
        Object result = methodInvocation.proceed();
        System.out.println("after " + methodInvocation.getMethod().getName());
        return result;
    }
}
