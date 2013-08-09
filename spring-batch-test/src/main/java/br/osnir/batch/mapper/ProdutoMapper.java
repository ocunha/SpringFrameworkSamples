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
package br.osnir.batch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import br.facet.tcc.enums.Estado;
import br.facet.tcc.enums.Sexo;
import br.facet.tcc.enums.Status;
import br.facet.tcc.pojo.Aluno;
import br.facet.tcc.pojo.Endereco;
import br.facet.tcc.pojo.UserLogin;

/**
 * @author Osnir F CUNHA
 * 
 */
@Component("rowMapper")
public class ProdutoMapper implements RowMapper<Aluno> {

    public Aluno mapRow(ResultSet ps, int arg1) throws SQLException {

        Aluno item = new Aluno();

        int column = 1;
        item.setId(ps.getInt(column++));
        item.setCpf(ps.getLong(column++));
        item.setDataNascimento(ps.getDate(column++));
        item.setEmail(ps.getString(column++));
        item.setEstadoNat(Estado.valueOf(ps.getString(column++)));
        item.setImage(null); column ++;
        item.setNacionalidade(ps.getString(column++));
        item.setNaturalidade(ps.getString(column++));
        item.setNome(ps.getString(column++));
        item.setNomeMae(ps.getString(column++));
        item.setNomePai(ps.getString(column++));
        item.setOrgaoExpeditor(ps.getString(column++));
        item.setRg(ps.getBigDecimal(column++).longValue());
        item.setSexo(Sexo.valueOf(ps.getString(column++)));
        item.setStatus(Status.valueOf(ps.getString(column++)));
        item.setTelefone(ps.getString(column++));
        item.setUfOrgaoExpeditor(Estado.valueOf(ps.getString(column++)));
        item.setDataDeMatricula(ps.getDate(column++));

        Endereco endereco = new Endereco();
        endereco.setId(ps.getInt(column++));
        item.setEndereco(endereco);

        UserLogin login = new UserLogin();
        login.setUsername(ps.getString(column++));
        item.setUserLogin(login);

        return item;
    }
}
