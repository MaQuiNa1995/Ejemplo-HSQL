package es.maquina1995.hsqldb.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import liquibase.integration.spring.SpringLiquibase;

@Configuration
public class LiquibaseConfig {

	@Autowired
	private DataSource dataSource;

	@Bean
	public SpringLiquibase liquibase() {

		String changelogFile = "classpath:/es/cic/curso/curso18/mascotastarcraft/changelog.xml";
		
		SpringLiquibase liquibase = new SpringLiquibase();
		liquibase.setChangeLog(changelogFile);
		liquibase.setContexts("test,dev,prod");
		liquibase.setDataSource(dataSource);
		liquibase.setDropFirst(false);
		liquibase.setShouldRun(true);

		
		Map<String, String> params = new HashMap<>();
		params.put("verbose", "true");
		liquibase.setChangeLogParameters(params);

		return liquibase;
	}
}
