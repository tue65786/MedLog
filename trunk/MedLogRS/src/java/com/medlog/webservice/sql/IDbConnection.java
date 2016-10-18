/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medlog.webservice.sql;

import java.sql.*;

/**
 *
 * @author (c)2016 Guiding Technologies
 */
public interface IDbConnection {

public Connection getConnnection();

/**
 * Capture JDBC Error messages
 *
 * @return Connection error message
 */
public String getError();

/**
 * Close connection wrapper
 */
public void close();

/**
 * (Overloaded) Close Statement
 *
 * @param cs CallableStatement
 */
public void close(CallableStatement cs);

/**
 * (Overloaded) Close ResultSet
 *
 * @param rs
 */
public void close(ResultSet rs);

}
