package kz.bss.ibsostm;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.sql.SQLException;

/**
 * @author Andrey Smirnov
 */
public class MainScheduler {
    private static final Logger LOGGER = Logger.getLogger(MainScheduler.class);

    public static void main(String[] args) throws SQLException, SchedulerException {

        JobDetail job = JobBuilder.newJob(StatementJob.class).withIdentity("statementJob", "group1").build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("statementTrigger", "group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(30).repeatForever())
                .build();
        // schedule it
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

}
