package org.example.hw8;

import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Service service = new ServiceImpl();

        Service serviceProxy = (Service) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), service.getClass().getInterfaces(), new CachedInvocationHandler(service)
        );
        String[] tasks = {"singing", "meditating", "painting"};
        double[] durations = {1, 2};

        performTasks(serviceProxy, tasks, durations);
        performTasks(serviceProxy, tasks, durations);

    }
    private static void performTasks(Service serviceProxy, String[] tasks, double[] durations) {
        for (String task : tasks) {
            serviceProxy.work(task);
            for (double duration : durations) {
                serviceProxy.run(task, duration, LocalDate.now());
            }
        }
        System.out.println();
    }

}
