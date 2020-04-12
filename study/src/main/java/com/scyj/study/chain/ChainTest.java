package com.scyj.study.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * author ：Hyman
 * date: 2020/4/10 21:42
 * des:
 * version: 1.0
 */
public class ChainTest {


    public void test() {
        List<Intercepter> interceptors = new ArrayList<>();
        interceptors.add(new BridgeInterceptor());
        interceptors.add(new RetryAndFollowInterceptor());
        interceptors.add(new CacheInterceptor());

        RealInterceptorChain request = new RealInterceptorChain(interceptors, 0, "request");

        request.proceed("request");
        /*
        打印结果：

        执行 BridgeInterceptor 拦截器之前代码
        执行 RetryAndFollowInterceptor 拦截器之前代码
        执行 CacheInterceptor 最后一个拦截器 返回最终数据
        执行 RetryAndFollowInterceptor 拦截器之后代码 得到最终数据：success
        执行 BridgeInterceptor 拦截器之后代码 得到最终数据：success
         */
    }


    /**
     * 实现几个拦截器:为了证明
     */
    public class BridgeInterceptor implements Intercepter {

        @Override
        public String intercepter(Chain chain) {
            System.out.println("执行 BridgeInterceptor 拦截器之前代码");
            String proceed = chain.proceed(chain.request());
            System.out.println("执行 BridgeInterceptor 拦截器之后代码 得到最终数据：" + proceed);
            return proceed;
        }
    }

    public class RetryAndFollowInterceptor implements Intercepter {
        @Override
        public String intercepter(Chain chain) {
            System.out.println("执行 RetryAndFollowInterceptor 拦截器之前代码");
            String proceed = chain.proceed(chain.request());
            System.out.println("执行 RetryAndFollowInterceptor 拦截器之后代码 得到最终数据：" + proceed);
            return proceed;
        }
    }

    public class CacheInterceptor implements Intercepter {
        @Override
        public String intercepter(Chain chain) {
            System.out.println("执行 CacheInterceptor 最后一个拦截器 返回最终数据");
            return "success";
        }
    }

    /**
     * 实现chain接口
     */
    public class RealInterceptorChain implements Intercepter.Chain {

        private List<Intercepter> interceptors;

        private int index;

        private String request;

        public RealInterceptorChain(List<Intercepter> interceptors, int index, String request) {
            this.interceptors = interceptors;
            this.index = index;
            this.request = request;
        }

        @Override
        public String request() {
            return request;
        }

        @Override
        public String proceed(String request) {
            if (index >= interceptors.size()) return null;
            //获取下一个责任链
            RealInterceptorChain next = new RealInterceptorChain(interceptors, index + 1, request);
            // 执行当前的拦截器
            Intercepter interceptor = interceptors.get(index);

            return interceptor.intercepter(next);
        }
    }
}
