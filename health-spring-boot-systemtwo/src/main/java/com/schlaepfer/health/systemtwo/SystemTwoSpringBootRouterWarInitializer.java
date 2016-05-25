package com.schlaepfer.health.systemtwo;

import org.apache.camel.spring.boot.FatJarRouter;
import org.apache.camel.spring.boot.FatWarInitializer;

public class SystemTwoSpringBootRouterWarInitializer extends FatWarInitializer {

    @Override
    protected Class<? extends FatJarRouter> routerClass() {
        return SystemTwoSpringBootRouter.class;
    }
}