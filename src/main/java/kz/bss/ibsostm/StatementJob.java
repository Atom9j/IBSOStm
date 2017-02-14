package kz.bss.ibsostm;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.SQLException;

/**
 * @author Andrey Smirnov
 */
public class StatementJob implements Job {
    private static final Logger LOGGER = Logger.getLogger(StatementJob.class);

    @Override
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        try {
            System.out.println("Job start!");
            XmlParsing.insertNewStatement(XmlParsing.prepareStatement(XmlParsing.allStatementQueries()));
            XmlParsing.deleteRequests();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Job finished!");
    }
}
