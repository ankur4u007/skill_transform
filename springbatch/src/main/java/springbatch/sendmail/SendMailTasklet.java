package springbatch.sendmail;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sendmailtasklet")
public class SendMailTasklet implements Tasklet {
    private static final Logger log = Logger.getLogger(SendMailTasklet.class);
    @Autowired
    private SendMailService sendMailService;
    @Resource(name = "employeeCSVImportJOB")
    private Job csvImportJob;

    @Override
    public RepeatStatus execute(final StepContribution contribution, final ChunkContext chunkContext) throws Exception {
	sendMailService.sendMail("Job :" + csvImportJob.getName() + " Completed");
	return RepeatStatus.FINISHED;
    }
}
