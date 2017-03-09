package com.woven.grocerystore.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App {

    public static void main(String[] args) {

        /**
         * * Create a new ApplicationContext, deriving bean definition from the given annotated class and automatically
         * * refreshing the context.
         */

        final ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        final App app = context.getBean(App.class);

        app.run();

    }


    private void run() {
        System.out.println("Liquibase should be done by now, check http://localhost:8082/login.jsp with JDBC URL \"jdbc:h2:mem:testdb\" for Person table.");
    }
}

