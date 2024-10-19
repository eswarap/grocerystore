package com.woven.grocerystore;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.woven.grocerystore")
public class TestGroceryStoreApplicaton {
    @ArchTest
    ArchRule controllerRule = classes().that()
            .haveSimpleNameEndingWith("Controller")
            .should()
            .resideInAnyPackage("..controller")
            .andShould().beAnnotatedWith(Controller.class);

    @ArchTest
    ArchRule serviceRule = classes().that()
            .haveSimpleNameEndingWith("ServiceImpl")
            .should()
            .resideInAnyPackage("..service.impl")
            .andShould().beAnnotatedWith(Service.class);

    @ArchTest
    ArchRule jpaRule = classes().that().areAnnotatedWith(Entity.class)
                    .should().resideInAPackage("..jpa");

    @ArchTest
    ArchRule dtoRule = classes().that().haveSimpleNameEndingWith("Dto")
            .should()
            .resideInAnyPackage("..dto");


    @ArchTest
    ArchRule controllerDependsOnService = classes().that()
            .areAnnotatedWith(Service.class)
            .should().onlyBeAccessed().byAnyPackage("..controller","..service.impl");
}
