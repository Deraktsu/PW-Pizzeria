package it.pw.configuration;

import java.util.Locale;
import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.servlet.MultipartConfigElement;
import javax.sql.DataSource;

import static org.hibernate.cfg.AvailableSettings.C3P0_MIN_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_SIZE;
import static org.hibernate.cfg.AvailableSettings.C3P0_ACQUIRE_INCREMENT;
import static org.hibernate.cfg.AvailableSettings.C3P0_TIMEOUT;
import static org.hibernate.cfg.AvailableSettings.C3P0_MAX_STATEMENTS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"it.pw.controller","it.pw.service","it.pw.dao","it.pw.configuration"})
@EnableTransactionManagement
@PropertySource(value = {"classpath:application.properties"})
@EnableJpaRepositories(basePackages = {"it.pw.dao"}, entityManagerFactoryRef = "emf", transactionManagerRef = "tmf")
public class ContextConfiguration implements WebMvcConfigurer
{

	@Autowired
	private Environment environment;
	
	//Delega richieste non gestite al predefinito nella DispacherServlet
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) 
	{
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public TilesConfigurer geTilesConfigurer()
	{
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/layout/definition/tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		TilesViewResolver resolver = new TilesViewResolver();
		registry.viewResolver(resolver);
	}
	
	// SISTEMA VALIDAZIONE HIBERNATE
	@Bean
	public LocalValidatorFactoryBean validator()
	{
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}
	
	@Override
	public Validator getValidator() {
		return validator();
	}
	
	//configurazione risorse messaggi (label dei form da esterno)
	@Bean
	public MessageSource messageSource()
	{
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("message");
		return source;
	}
	
	//configurazione DataSource
	@Bean(name = "dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driver"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		
		return dataSource;
	}
	
	
	
	//bean per lavorare con jdbcTemplate
	@Bean
	public JdbcTemplate geJdbcTemplate(DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	//bean per gestire transazioni con il datasource
	/*
	 * @Bean public DataSourceTransactionManager getDataSourceTransactionManager() {
	 * DataSourceTransactionManager manager = new DataSourceTransactionManager();
	 * manager.setDataSource(getDataSource()); return manager; }
	 */
	
	//////////////////////////////////////////DATABASE CON HIBERNATE////////////////////////////////////////////////
	
	//bean di configurazione generale JPA
	@Bean
	public JpaVendorAdapter getJpaVendorAdapter()
	{
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true); //mostra query in console
		adapter.setGenerateDdl(false); //permette ad hibernate di creare/aggiornare tabelle 
		adapter.setDatabasePlatform(environment.getRequiredProperty("hibernate.dialect")); //tipo di db con cui interagire
		return adapter;
	}
	
	//bean di configurazione Entity Manager di Hibernate
	@Bean(name = "emf")
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(getJpaVendorAdapter());
		bean.setDataSource(getDataSource());
		bean.setPackagesToScan("it.pw.model");
		bean.setJpaProperties(getJpaProperties());
		bean.setSharedCacheMode(SharedCacheMode.ENABLE_SELECTIVE); 
		bean.setValidationMode(ValidationMode.NONE);
		return bean;
	}
	
	//metodo per definire le proprieta di hibernate utilizzando librearia C3P0
	private Properties getJpaProperties()
	{
		Properties prop = new Properties();
		prop.put("javax.persistence.scherma-generation.database.action", "none");
		prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		prop.put(C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
		prop.put(C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
		prop.put(C3P0_ACQUIRE_INCREMENT, environment.getRequiredProperty("hibernate.c3p0.acquire_increment"));
		prop.put(C3P0_TIMEOUT, environment.getRequiredProperty("hibernate.c3p0.timeout"));
		prop.put(C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));
		return prop;
	}
	
	//bean per gestione transiazioni Jpa (in alternativa a quello associato al DataSource)
	@Bean(name = "tmf")
	public JpaTransactionManager gJpaTransactionManager()
	{
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(getEntityManagerFactoryBean().getObject());
		return manager;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	//bean per gestione delle impostazioni locale
	@Bean
	public LocaleResolver localeResolver()
	{
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("it","IT"));
		return resolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("language");
		registry.addInterceptor(interceptor);
	}
	
	
}