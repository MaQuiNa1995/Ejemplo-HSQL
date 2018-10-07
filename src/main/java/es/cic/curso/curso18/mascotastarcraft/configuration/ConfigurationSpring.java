package es.cic.curso.curso18.mascotastarcraft.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import es.cic.curso.curso18.mascotastarcraft.repository.BaseRepository;
import es.cic.curso.curso18.mascotastarcraft.repository.MapaRepository;
import es.cic.curso.curso18.mascotastarcraft.repository.TrabajadorRepository;
import es.cic.curso.curso18.mascotastarcraft.repositoryImpl.BaseRepositoryImpl;
import es.cic.curso.curso18.mascotastarcraft.repositoryImpl.MapaRepositoryImpl;
import es.cic.curso.curso18.mascotastarcraft.repositoryImpl.TrabajadorRepositoryImpl;
import es.cic.curso.curso18.mascotastarcraft.service.BaseService;
import es.cic.curso.curso18.mascotastarcraft.service.MapaService;
import es.cic.curso.curso18.mascotastarcraft.service.TrabajadorService;
import es.cic.curso.curso18.mascotastarcraft.serviceimpl.BaseServiceImpl;
import es.cic.curso.curso18.mascotastarcraft.serviceimpl.MapaServiceImpl;
import es.cic.curso.curso18.mascotastarcraft.serviceimpl.TrabajadorServiceImpl;

public class ConfigurationSpring {
	private static final String PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH = "hibernate.max_fetch_depth";
	private static final String PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE = "hibernate.jdbc.fetch_size";
	private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "hibernate.show_sql";
	private static final String ENTITYMANAGER_PACKAGES_TO_SCAN = "es.cic.curso.curso18.mascotastarcraft.dominio";

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
		dataSource.setUrl("jdbc:hsqldb:mem:maquina1995");
		// test;SCHEMA=ABCjdbc:h2:test;SCHEMA=ABC
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		dataSource.setInitialSize(5);
		dataSource.setMaxActive(10);
		dataSource.setPoolPreparedStatements(Boolean.TRUE);
		dataSource.setMaxOpenPreparedStatements(10);
		return dataSource;

	}

	@Bean
	public JpaTransactionManager jpaTransactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactoryBean().getObject());
		return transactionManager;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());

		return entityManagerFactoryBean;
	}
	
	@Bean
	public BaseRepository baseRepository() {

		BaseRepository baseRepository = new BaseRepositoryImpl();
		return baseRepository;

	}	

	@Bean
	public MapaRepository mapaRepository() {

		MapaRepository mapaRepository = new MapaRepositoryImpl();
		return mapaRepository;

	}

	@Bean
	public TrabajadorRepository trabajadorRepository() {

		TrabajadorRepository trabajadorRepository = new TrabajadorRepositoryImpl();
		return trabajadorRepository;

	}

	@Bean
	public BaseService baseService() {

		BaseService baseService = new BaseServiceImpl();
		return baseService;

	}

	@Bean
	public MapaService mapaService() {

		MapaService mapaService = new MapaServiceImpl();
		return mapaService;

	}

	@Bean
	public TrabajadorService trabajadorService() {

		TrabajadorService trabajadorService = new TrabajadorServiceImpl();
		return trabajadorService;

	}

	private HibernateJpaVendorAdapter vendorAdaptor() {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		return vendorAdapter;
	}

	private Properties jpaHibernateProperties() {

		Properties properties = new Properties();

		properties.put(PROPERTY_NAME_HIBERNATE_MAX_FETCH_DEPTH, 10);
		properties.put(PROPERTY_NAME_HIBERNATE_JDBC_FETCH_SIZE, 2);
		properties.put(PROPERTY_NAME_HIBERNATE_SHOW_SQL, true);
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return properties;
	}

}
