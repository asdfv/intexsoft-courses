package hib;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class Config {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
		dataSource.setUsername("postgres");
		dataSource.setPassword("root");

		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter getAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(false);
		adapter.setGenerateDdl(false);
		return adapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean geContainerEntityManagerFactoryBean(DataSource ds, JpaVendorAdapter jva) {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(ds);
		factoryBean.setJpaVendorAdapter(jva);
		factoryBean.setPackagesToScan("hib");
		return factoryBean;
	}
	
	@Bean
	public PlatformTransactionManager getTransactionManager() {
		PlatformTransactionManager ptm = new JpaTransactionManager();
		return ptm;
	} 
}
