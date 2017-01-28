package by.intexsoft.vasili.hibernate.config;

import javax.sql.DataSource;

import static org.springframework.orm.jpa.vendor.Database.POSTGRESQL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories("by.intexsoft.vasili.hibernate.repository")
@ComponentScan("by.intexsoft.vasili.hibernate")
public class Config {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");
		dataSource.setSchema("test");

		return dataSource;
	}
	@Bean
	public JpaVendorAdapter adapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(POSTGRESQL);
		adapter.setShowSql(false);
		return adapter;
	}
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter adapter) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(adapter);
		factoryBean.setPackagesToScan("by.intexsoft.vasili.hibernate.model");
		return factoryBean;
	}
    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}
