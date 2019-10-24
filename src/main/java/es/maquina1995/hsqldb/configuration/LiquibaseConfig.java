package es.maquina1995.hsqldb.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfig {

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {

	SpringLiquibase liquibase = new SpringLiquibase();
	liquibase.setChangeLog("classpath:/es/maquina1995/hsqldb/changelog.xml");
	liquibase.setContexts("test,dev,prod");
	liquibase.setDataSource(dataSource);
	liquibase.setDropFirst(false);
	liquibase.setShouldRun(true);

	Map<String, String> parametrosLiquibase = new HashMap<>();
	parametrosLiquibase.put("verbose", "false");
	liquibase.setChangeLogParameters(parametrosLiquibase);

	return liquibase;
    }
}
