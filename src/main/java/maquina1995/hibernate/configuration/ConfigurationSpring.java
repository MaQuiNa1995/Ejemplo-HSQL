package maquina1995.hibernate.configuration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
@EnableTransactionManagement
@ComponentScan(basePackages = "es.maquina1995.hsqldb.", useDefaultFilters = true, includeFilters = @Filter(type = FilterType.REGEX, pattern = "(repository|service)$"))
public class ConfigurationSpring {

	private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "es.maquina1995.hsqldb.dominio";

	/**
	 * Bean que representa la conexión a la base de datos
	 * 
	 * @return {@link DataSource} bean que permite la conexión a la base de
	 *         datos
	 */
	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		// Driver a usar en este caso usamos una base de datos en memoria
		// (HSQLDB)
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		// Url de la base de datos
		dataSource.setUrl("jdbc:hsqldb:mem:maquina1995");
		// Credenciales base de datos
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		// Número de conexiones iniciales
		dataSource.setInitialSize(5);
		// Número de conexiones activas simultáneas
		dataSource.setMaxIdle(10);
		// Se usa para precompilar las sentencais SQL y verificar su sintaxis
		dataSource.setPoolPreparedStatements(Boolean.TRUE);
		// Número máximo de PreparedStatements activas simultáneas
		dataSource.setMaxOpenPreparedStatements(10);
		return dataSource;

	}

	/**
	 * Bean que representa la clase encargada de las transacciones en la base de
	 * datos
	 * 
	 * @param dataSource
	 *            {@link DataSource} bean que representa la conexión a la base
	 *            de datos
	 * 
	 * @return {@link JpaTransactionManager} encargado de las transaciones en la
	 *         base de datos
	 */
	@Bean
	public JpaTransactionManager jpaTransactionManager( /**
														 * DataSource dataSource
														 */
	) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	/**
	 * Bean encargado de la persistencia usando el dominio
	 * 
	 * @return {@link LocalContainerEntityManagerFactoryBean} objeto encargado
	 *         de la persistencia en base de datos
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean
				.setPersistenceUnitName("MaQuiNaPersistenceUnit");
		// Clase encargada de la persistencia
		entityManagerFactoryBean.setPersistenceProviderClass(
				HibernatePersistenceProvider.class);
		// Paquetes donde se van a buscar las entidades
		entityManagerFactoryBean
				.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);

		return entityManagerFactoryBean;
	}

	/**
	 * Bean encargado de propiedades de configuracion adicionales de hibernate y
	 * jpa
	 * 
	 * @return {@link HibernateJpaVendorAdapter} Objeto que contiene las
	 *         propieades adicionales que podemos usar en jpa/hibernate
	 */
	private HibernateJpaVendorAdapter vendorAdapter() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// Indicamos si en el log nos saldrán las sentencias que se vayan
		// ejecutando (En
		// entornos de producción esto debería de estar a FALSE)
		vendorAdapter.setShowSql(Boolean.TRUE);
		vendorAdapter.setGenerateDdl(Boolean.TRUE);
		vendorAdapter.setDatabase(Database.HSQL);
		return vendorAdapter;
	}

}
