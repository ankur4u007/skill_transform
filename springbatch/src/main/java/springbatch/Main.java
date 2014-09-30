/**
 *
 */
package springbatch;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    /**
     * @param args
     */
    public static void main(final String[] args) {

	final ApplicationContext context = new ClassPathXmlApplicationContext("csvimportjob.xml");
	final JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
	final Job job = (Job) context.getBean("employeeCSVImportJOB");
	try {
	    final JobExecution execution = jobLauncher.run(job, new JobParameters());
	    logger.info("Exit Status : " + execution.getStatus());

	} catch (final Exception e) {
	    logger.error(e.getMessage(), e);
	}
	logger.info("Done");
    }

}
