package br.osnir.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("itemListener")
public class ItemListener {

    @BeforeJob
    public void beforeJobExecution(JobExecution jobExecution) {
        System.out.print("Listener before Job: ");
        System.out.println(jobExecution.getJobInstance().getJobName());
    }

    @AfterJob
    public void afterJobExecution(JobExecution jobExecution) {
    	System.out.print("Listener after Job: ");
        System.out.println(jobExecution.getJobInstance().getJobName());
    }

}
