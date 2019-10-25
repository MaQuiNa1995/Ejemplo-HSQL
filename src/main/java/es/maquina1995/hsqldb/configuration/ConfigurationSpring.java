package es.maquina1995.hsqldb.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

/**
 * Clase destinada a la configuración de Spring
 * <p>
 * Tiene implementado filtro de paquetes por regexp mas información en el enlace
 * <p>
 * <a href=
 * "https://www.logicbig.com/how-to/code-snippets/jcode-spring-framework-componentscan-filter.html">Documentación
 * ComponentScan por regExp y mas</a>
 * 
 * @author MaQuiNa1995
 *
 */
@ComponentScan(basePackages = "es.maquina1995.hsqldb.", useDefaultFilters = true, includeFilters = @Filter(type = FilterType.REGEX, pattern = "(repository|service)$"))
public class ConfigurationSpring {
    private static final String PROPERTY_NAME_HIBERNATE_DIALECT = "org.hibernate.dialect.HSQLDialect";
    private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
    private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "es.maquina1995.hsqldb.dominio";

    /**
     * Bean que representa la conexión a la base de datos
     * 
     * @return {@link DataSource} bean que permite la conexión a la base de datos
     */
    @Bean
    public DataSource dataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	// Driver a usar en este caso usamos una base de datos en memoria (HSQLDB)
	dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
	// Url de la base de datos
	dataSource.setUrl("jdbc:hsqldb:mem:maquina1995");
	// Credenciales base de datos
	dataSource.setUsername("sa");
	dataSource.setPassword("");
	// Número de conexiones iniciales
	dataSource.setInitialSize(5);
	// Número de conexiones activas simultáneas
	dataSource.setMaxActive(10);
	// Se usa para precompilar las sentencias SQL y verificar su sintaxis
	dataSource.setPoolPreparedStatements(Boolean.TRUE);
	// Número máximo de PreparedStatements activas simultáneas
	dataSource.setMaxOpenPreparedStatements(10);
	return dataSource;

    }

    /**
     * Bean que representa la clase encargada de las transacciones en la base de
     * datos
     * 
     * @return {@link JpaTransactionManager} encargado de las transaciones en la
     *         base de datos
     */
    @Bean
    public JpaTransactionManager jpaTransactionManager() {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
	return transactionManager;
    }

    /**
     * Bean encargado de la persistencia usando el dominio
     * 
     * @return {@link LocalContainerEntityManagerFactoryBean} objeto encargado de la
     *         persistencia en base de datos
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

	LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
	entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
	entityManagerFactoryBean.setDataSource(dataSource());
	entityManagerFactoryBean.setPersistenceUnitName("MaQuiNaPersistenceUnit");
	// Clase encargada de la persistencia
	entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
	// Paquetes donde se van a buscar las entidades
	entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
	// Propiedades adicionales de hibernate/Jpa
	entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

	return entityManagerFactoryBean;
    }

    /**
     * Bean encargado de propiedades de configuracion adicionales de hibernate y jpa
     * 
     * @return {@link HibernateJpaVendorAdapter} Objeto que contiene las propieades
     *         adicionales que podemos usar en jpa/hibernate
     */
    private HibernateJpaVendorAdapter vendorAdaptor() {
	HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	// Indicamos si en el log nos saldrán las sentencias que se vayan ejecutando (En
	// entornos de producción esto debería de estar a FALSE)
	vendorAdapter.setShowSql(true);
	return vendorAdapter;
    }

    /**
     * Bean que representa las configuraciones tipicas de hibernate/jpa
     * 
     * @return {@link Properties} Objeto que contiene propiedades tipicas de
     *         hibernate y Jpa
     */
    private Properties jpaHibernateProperties() {

	Properties properties = new Properties();
	properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, 10);
	properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, 2);
	properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, Boolean.FALSE);
	properties.put(PROPERTY_NAME_HIBERNATE_DIALECT, "org.hibernate.dialect.MySQLDialect");
	return properties;
    }

}
