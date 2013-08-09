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
package br.osnir.batch.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.AlunoCurso;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("itemPreparedStatementSetter")
public class ProdutoStatementSetter implements
        ItemPreparedStatementSetter<Message<AlunoCurso>> {

    public void setValues(Message<AlunoCurso> message, PreparedStatement ps)
            throws SQLException {
        /*
         * aluno_id, cpf, datanascimento, email, estadonat, image,
         * nacionalidade, naturalidade, nome, nomemae, nomepai, orgaoexpeditor,
         * rg, sexo, status, telefone, uforgaoexpeditor, datadematricula,
         * endereco_usuario, user_name
         */
        AlunoCurso alunoCurso = message.getPayload();
        Aluno item = alunoCurso.getAluno();
        int column = 1;
        ps.setInt(column++, item.getId());
        ps.setLong(column++, item.getCpf());
        ps.setDate(column++, new Date(item.getDataNascimento().getTime()));
        ps.setString(column++, item.getEmail());
        ps.setString(column++, item.getEstadoNat().name());
        ps.setBytes(column++, item.getImage());
        ps.setString(column++, item.getNacionalidade());
        ps.setString(column++, item.getNaturalidade());
        ps.setString(column++, item.getNome());
        ps.setString(column++, item.getNomeMae());
        ps.setString(column++, item.getNomePai());
        ps.setString(column++, item.getOrgaoExpeditor());
        ps.setLong(column++, item.getRg());
        ps.setString(column++, item.getSexo().name());
        ps.setString(column++, item.getStatus().name());
        ps.setString(column++, item.getTelefone());
        ps.setString(column++, item.getUfOrgaoExpeditor().name());

        if (item.getDataDeMatricula() != null) {
            ps.setDate(column++, new Date(item.getDataDeMatricula().getTime()));
        } else {
            ps.setDate(column++, null);
        }

        ps.setInt(column++, item.getEndereco().getId());
        ps.setString(column++, item.getUserLogin().getUsername());

    }

}
