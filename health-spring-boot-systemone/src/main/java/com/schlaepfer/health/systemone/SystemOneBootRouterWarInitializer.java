package com.schlaepfer.health.systemone;

import org.apache.camel.spring.boot.FatJarRouter;
import org.apache.camel.spring.boot.FatWarInitializer;

public class SystemOneBootRouterWarInitializer extends FatWarInitializer {

    @Override
    protected Class<? extends FatJarRouter> routerClass() {
        return SystemOneSpringBootRouter.class;
    }
}
