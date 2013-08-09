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
package br.osnir.batch.transform;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("alunoTransform")
public class AlunoTransform {

    @Transformer
    public AlunoCurso transformAluno(Object object) {

        AlunoCurso alunoCurso = new AlunoCurso();
        alunoCurso.setAluno((Aluno) object);

        return alunoCurso;
    }
}
