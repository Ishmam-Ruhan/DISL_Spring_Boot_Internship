package com.ishmam.DhrubokPracticeProject1.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@Configuration
@EnableJpaAuditing
public class AuditingConfiguration {

//    @Bean
//    public DateTimeProvider customDateTimeProvider(){
//        return () -> Optional.of(GregorianCalendar.(TimeZone.getTimeZone("UTC")));
//    }

}
