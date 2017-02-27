package kz.bss.ibsostm;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.SQLException;
import java.util.LinkedList;

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
            LinkedList<String> queries = XmlParsing.allStatementQueries();
            if ( !queries.isEmpty() )
            {
                LinkedList<String> prepStatement = XmlParsing.prepareStatement(queries);
                if ( XmlParsing.insertNewStatement(prepStatement) )
                {
                    XmlParsing.deleteRequests();
                }
            }
            else System.out.println("No statement requests found!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Job finished!");
    }
}
