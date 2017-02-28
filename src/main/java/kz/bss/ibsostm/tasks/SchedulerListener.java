package kz.bss.ibsostm.tasks;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Andrey Smirnov
 */
public class SchedulerListener implements ServletContextListener
{
    private static final Logger LOGGER = Logger.getLogger(SchedulerListener.class);

    Scheduler scheduler = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContext)
    {
        LOGGER.info("Context Initialized");

        try
        {
            JobDetail job = JobBuilder.newJob(StatementJob.class).withIdentity("statementJob", "ibsoStatements").build();
            Trigger trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("statementTrigger", "ibsoStatements")
                    .withSchedule(
                            SimpleScheduleBuilder.simpleSchedule()
                                    .withIntervalInSeconds(12).repeatForever())
                    .build();
            // schedule it
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        }
        catch ( SchedulerException e )
        {
            LOGGER.error(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContext)
    {
        LOGGER.info("Context Destroyed");
        try
        {
            scheduler.shutdown();
        }
        catch ( SchedulerException e )
        {
            LOGGER.error(e);
        }
    }

}
