package es.maquina1995.hsqldb;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import es.maquina1995.hsqldb.configuration.ConfigurationSpring;

/**
 * Main para la ejecución de pruebas personalizadas
 * 
 * @author MaQuiNa1995
 *
 */
public class Main {

	public static void main(String... args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConfigurationSpring.class)) {

			EntityManager entitymanager = context.getBean(LocalContainerEntityManagerFactoryBean.class).getObject()
					.createEntityManager();

			ejecutarQueryNativa(entitymanager,
					"SELECT TABLE_NAME, COLUMN_NAME, TYPE_NAME, COLUMN_SIZE, DECIMAL_DIGITS, IS_NULLABLE FROM INFORMATION_SCHEMA.SYSTEM_COLUMNS WHERE TABLE_NAME NOT LIKE 'SYSTEM_%'");
		}

	}

	public static void ejecutarQueryNativa(EntityManager entityManager, String queryString) {
		System.out.print("---------------------------");
		Query query = entityManager.createNativeQuery(queryString);
		List<?> listaObjetosDb = query.getResultList();

		listaObjetosDb.forEach(object -> {
			if (object instanceof Object[]) {
				System.out.println(Arrays.toString((Object[]) object));
			} else {
				System.out.println(object);
			}
		});

	}

}
