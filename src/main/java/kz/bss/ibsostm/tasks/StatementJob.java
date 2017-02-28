package kz.bss.ibsostm.tasks;

import kz.bss.ibsostm.handling.DBInteraction;
import kz.bss.ibsostm.handling.ParsingXml;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Andrey Smirnov
 */
public class StatementJob implements Job
{
    private static final Logger LOGGER = Logger.getLogger(StatementJob.class);

    @Override
    public void execute(JobExecutionContext context)
    throws JobExecutionException
    {
        try
        {
            List<String> queries = DBInteraction.allStatementQueries();
            if ( !queries.isEmpty() )
            {
                List<String> prepStatement = ParsingXml.createStatementBody(queries);
                if ( DBInteraction.insertNewStatement(prepStatement) )
                {
                    DBInteraction.deleteRequests();
                }
            }
        }
        catch ( SQLException e )
        {
            LOGGER.error(e);
        }
    }
}
