package app.config;

import app.dao.LeafDao;
import app.dao.support.LeafDaoImpl;
import app.service.MainService;
import app.service.support.MainServiceImpl;
import app.task.ReadDatabaseTask;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.scheduling.concurrent.ScheduledExecutorFactoryBean;
import org.springframework.scheduling.concurrent.ScheduledExecutorTask;
import org.springframework.scheduling.support.MethodInvokingRunnable;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import({DataSourceConfig.class, HibernateConfig.class})
@ComponentScan(basePackages = {"app.task"})
@EnableTransactionManagement
public class AppConfig {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private LeafDao leafDao;

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

    @Bean
    public LeafDao leafDao(){
        LeafDaoImpl leafDao1 = new LeafDaoImpl();
        leafDao1.setSessionFactory(sessionFactory);
        return leafDao1;
    }


    @Bean
    public FilterChainProxy springSecurityFilterChain(){
        return new FilterChainProxy();
    }

    @Bean
    public MainService mainService() {
        MainServiceImpl mainService = new MainServiceImpl();
        mainService.setLeafDao(leafDao);
        return mainService;
    }


    @Bean
    public MethodInvokingRunnable methodInvokingRunnable1(){
        MethodInvokingRunnable methodInvokingRunnable = new MethodInvokingRunnable();
        methodInvokingRunnable.setTargetObject(new ReadDatabaseTask(this.mainService()));
        methodInvokingRunnable.setTargetMethod("initialize");
        return methodInvokingRunnable;
    }

    @Bean
    public ScheduledExecutorTask scheduledExecutorTask1(){
        ScheduledExecutorTask scheduledExecutorTask = new ScheduledExecutorTask();
        scheduledExecutorTask.setPeriod(-1);
        scheduledExecutorTask.setDelay(10);
        scheduledExecutorTask.setRunnable(this.methodInvokingRunnable1());
        return scheduledExecutorTask;
    }

    @Bean
    public ScheduledExecutorFactoryBean scheduledExecutorFactoryBean(){
        ScheduledExecutorFactoryBean scheduledExecutorFactoryBean = new ScheduledExecutorFactoryBean();
        ScheduledExecutorTask[] scheduledExecutorTasks = new ScheduledExecutorTask[1];
        scheduledExecutorTasks[0] = this.scheduledExecutorTask1();
        scheduledExecutorFactoryBean.setScheduledExecutorTasks(scheduledExecutorTasks);
        return scheduledExecutorFactoryBean;
    }






}
