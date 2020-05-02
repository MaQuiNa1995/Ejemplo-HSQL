//package es.maquina1995.hsqldb.configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import liquibase.integration.spring.SpringLiquibase;
//
///**
// * Clase de configuración perteneciente a Liquibase
// * 
// * @author MaQuiNa1995
// *
// */
//@Configuration
//public class LiquibaseConfig {
//
//    /**
//     * Creación del bean encargado de linkar spring y liquibase
//     * 
//     * @param dataSource {@link DataSource} bean que representa la conexión a la
//     *                   base de datos
//     * @return {@link SpringLiquibase} bean que representa la configuración de
//     *         spring con liquibase
//     */
//    @Bean
//    public SpringLiquibase liquibase(DataSource dataSource) {
//
//	SpringLiquibase liquibase = new SpringLiquibase();
//	liquibase.setChangeLog("classpath:/es/maquina1995/hsqldb/changelog.xml");
//	liquibase.setContexts("test,dev,prod");
//	liquibase.setDataSource(dataSource);
//	liquibase.setDropFirst(false);
//	liquibase.setShouldRun(true);
//
//	Map<String, String> parametrosLiquibase = new HashMap<>();
//	parametrosLiquibase.put("verbose", "false");
//	liquibase.setChangeLogParameters(parametrosLiquibase);
//
//	return liquibase;
//    }
//}
