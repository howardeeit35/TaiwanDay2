package tw.taiwanday.config;

import java.util.Properties;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//相當於beans.config.xml
@Configuration
@EnableTransactionManagement//<tx:annotation-driven transaction-manager="transactionManager"/>
@ComponentScan(basePackages = "tw.taiwanday")//<context:component-scan base-package="tw.leonchen"/>
@EnableWebMvc//<mvc:annotation-driven/>
public class RootAppConfig {
	
	@Bean//<bean id="datasource" class="org.springframework.jndi.JndiObjectFactoryBean">
    	 //<property name="jndiName" value="java:comp/env/connectSqlServerJdbc/SystemService"/>
		 //</bean>//取得jndi
	public DataSource datasource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean jndiBean = new JndiObjectFactoryBean();
		jndiBean.setJndiName("java:comp/env/connectSqlServerJdbc/SystemService");
		jndiBean.afterPropertiesSet();//確認資料都抓取好後才會繼續往下執行
		
		DataSource ds = (DataSource)jndiBean.getObject();
		return ds;
	}
	
	@Bean(destroyMethod = "destroy")//跟資料庫連線的通常會加destroy
	public LocalSessionFactoryBean sessionFactory() throws IllegalArgumentException, NamingException {
		LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
		factory.setDataSource(datasource());
		factory.setPackagesToScan("tw.taiwanday.model");
		factory.setHibernateProperties(additionalProperties());
		return factory;
	}

	private Properties additionalProperties() {
		Properties p1 = new Properties();
		p1.put("hibernate.dialect", org.hibernate.dialect.SQLServerDialect.class);
		p1.put("hibernate.show_sql", Boolean.TRUE);
		p1.put("hibernate.format_sql", Boolean.TRUE);
		p1.put("hibernate.current_session_context_class", "thread");
		//要用delete update要設定這行(session.flush才可使用)
		p1.put("hibernate.allow_update_outside_transaction",Boolean.TRUE);
		return p1;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txMgr = new HibernateTransactionManager();
		txMgr.setSessionFactory(sessionFactory);
		return txMgr;
	}

}
