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

		String changelogFile = "classpath:/es/maquina1995/hsqldb/changelog.xml";
		
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog(changelogFile);
		liquibase.setContexts("test,dev,prod");
		liquibase.setDataSource(dataSource);
		liquibase.setDropFirst(false);
		liquibase.setShouldRun(true);

		
		Map<String, String> params = new HashMap<>();
		params.put("verbose", "false");
		liquibase.setChangeLogParameters(params);

		return liquibase;
	}
}
