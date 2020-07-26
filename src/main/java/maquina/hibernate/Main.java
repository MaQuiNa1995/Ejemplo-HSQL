package maquina.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import maquina.hibernate.configuration.HibernateConfig;

/**
 * Main para la ejecución de pruebas personalizadas
 * 
 * @author MaQuiNa1995
 *
 */
public class Main {

	public static void main(String... args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				HibernateConfig.class)) {

			// Puedes probar aqui cosas con la bd con el objeto que sacamos del contexto
			context.getBean(LocalContainerEntityManagerFactoryBean.class)
					.getObject()
					.createEntityManager();
		}

	}

}
