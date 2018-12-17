package com.yatop.lambda.framework.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.*;

public class frameworkApplicationListener implements ApplicationListener<ApplicationPreparedEvent> {
    public frameworkApplicationListener() {}


    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext context = event.getApplicationContext();
        ConfigurableEnvironment env = context.getEnvironment();
/*

        boolean isNeed = true;
        if (env.containsProperty("frms.encode.need")) {
            isNeed = (Boolean)env.getProperty("frms.encode.need", Boolean.class);
        }

        if (isNeed) {
            MutablePropertySources sources = env.getPropertySources();
            if (!env.containsProperty("frms.encode.key.secretKey")) {
                System.err.println("秘钥未配置");
                System.exit(0);
            }

            Map<String, Object> applicationMap = new HashMap();
            new ArrayList();
            List keyList;
            if (env.containsProperty("frms.encode.key.list")) {
                keyList = Arrays.asList(env.getRequiredProperty("frms.encode.key.list").split(","));
            } else {
                keyList = Arrays.asList("frms.etl.from.password,frms.etl.to.password,frms.etl.mgr.password".split(","));
            }

            Iterator var9 = keyList.iterator();

            while(var9.hasNext()) {
                String key = (String)var9.next();
                if (env.containsProperty(key)) {
                    try {
                        applicationMap.put(key, new String(EncodesUtils.decrypt(env.getRequiredProperty(key), env.getRequiredProperty("frms.encode.key.secretKey"))));
                    } catch (Exception var11) {
                        var11.printStackTrace();
                        System.exit(0);
                    }
                }
            }

            if (!applicationMap.isEmpty()) {
                sources.addFirst(new MapPropertySource("APP_MAP", applicationMap));
            }
        }
*/

    }
}
