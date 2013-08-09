/*
 * TCC Facet 2012 - Djulles IKEDA e Osnir F CUNHA.
 *
 * Copyright (c) 2012
 * All rights reserved.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system, nor translated in any human or computer
 * language in any way for any purposes whatsoever without the prior written
 * 
 * 
 * (Code Template Version: 1.0)
 */
package br.osnir.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;
import org.springframework.stereotype.Component;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("alunoListener")
public class AlunoListener {

    @BeforeJob
    public void beforeJobExecution(JobExecution jobExecution) {
        System.out.print("=============================\nIniciando o Job: ");
        System.out.println(jobExecution.getJobInstance().getJobName());
        System.out.println("=============================");
    }

    @AfterJob
    public void afterJobExecution(JobExecution jobExecution) {
        System.out.print("=============================\nTerminando o Job: ");
        System.out.println(jobExecution.getJobInstance().getJobName());
        System.out.println("=============================");
    }

}
