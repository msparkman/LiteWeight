package sparkman;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SuppressWarnings("unused")
@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
class ApplicationConfig {
	@SuppressWarnings("WeakerAccess")
	@Bean
	DataSource dataSource() {
		Properties properties = new Properties();
		InputStream input = null;
		DriverManagerDataSource dataSource = null;
		try {
			input = ApplicationConfig.class.getResourceAsStream("/application.properties");
			properties.load(input);

			dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(properties.getProperty("spring.datasource.driver-class-name"));
			dataSource.setUrl(properties.getProperty("spring.datasource.url"));
			dataSource.setUsername(properties.getProperty("spring.datasource.username"));
			dataSource.setPassword(properties.getProperty("spring.datasource.password"));
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataSource;
	}

	@SuppressWarnings("WeakerAccess")
	@Bean
	EntityManagerFactory entityManagerFactory() {

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("sparkman.domain");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {

		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory());
		return txManager;
	}
}
