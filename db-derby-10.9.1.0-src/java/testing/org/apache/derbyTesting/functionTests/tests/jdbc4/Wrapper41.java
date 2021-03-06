/*
 
   Derby - Class org.apache.derbyTesting.functionTests.tests.jdbc4.Wrapper41
 
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at
 
      http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 
 */

package org.apache.derbyTesting.functionTests.tests.jdbc4;

import java.sql.SQLException;

import org.apache.derby.impl.jdbc.EmbedResultSet40;
import org.apache.derby.client.net.NetResultSet40;
import org.apache.derby.impl.jdbc.EmbedCallableStatement40;
import org.apache.derby.client.am.CallableStatement40;
import org.apache.derby.iapi.jdbc.BrokeredCallableStatement40;
import org.apache.derby.client.am.LogicalCallableStatement40;

/**
 * A wrapper around the getObject() overloads added by JDBC 4.1.
 * We can eliminate this class after Java 7 goes GA and we are allowed
 * to use the Java 7 compiler to build our released versions of derbyTesting.jar.
 */
public  class   Wrapper41
{
    ///////////////////////////////////////////////////////////////////////
    //
    // STATE
    //
    ///////////////////////////////////////////////////////////////////////

    private EmbedResultSet40    _embedded;
    private NetResultSet40      _netclient;
    private EmbedCallableStatement40 _embedCallableStatement;
    private CallableStatement40 _callableStatement;
    private BrokeredCallableStatement40 _brokeredCallableStatement;
    private LogicalCallableStatement40 _logicalCallableStatement;
    
    ///////////////////////////////////////////////////////////////////////
    //
    // CONSTRUCTORS
    //
    ///////////////////////////////////////////////////////////////////////

    public Wrapper41( Object wrapped ) throws Exception
    {
        if ( wrapped instanceof EmbedResultSet40 ) { _embedded = (EmbedResultSet40) wrapped; }
        else if ( wrapped instanceof NetResultSet40 ) { _netclient = (NetResultSet40) wrapped; }
        else if ( wrapped instanceof EmbedCallableStatement40 ) { _embedCallableStatement = (EmbedCallableStatement40) wrapped; }
        else if ( wrapped instanceof CallableStatement40 ) { _callableStatement = (CallableStatement40) wrapped; }
        else if ( wrapped instanceof BrokeredCallableStatement40 ) { _brokeredCallableStatement = (BrokeredCallableStatement40) wrapped; }
        else if ( wrapped instanceof LogicalCallableStatement40 ) { _logicalCallableStatement = (LogicalCallableStatement40) wrapped; }
        else { throw nothingWrapped(); }
    }
    
    ///////////////////////////////////////////////////////////////////////
    //
    // JDBC 4.1 BEHAVIOR
    //
    ///////////////////////////////////////////////////////////////////////

    public  <T> T getObject( int columnIndex, Class<T> type ) throws SQLException
    {
        if ( _embedded != null ) { return _embedded.getObject( columnIndex, type ); }
        else if ( _netclient != null ) { return _netclient.getObject( columnIndex, type ); }
        else if ( _embedCallableStatement != null ) { return _embedCallableStatement.getObject( columnIndex, type ); }
        else if ( _callableStatement != null ) { return _callableStatement.getObject( columnIndex, type ); }
        else if ( _brokeredCallableStatement != null ) { return _brokeredCallableStatement.getObject( columnIndex, type ); }
        else if ( _logicalCallableStatement != null ) { return _logicalCallableStatement.getObject( columnIndex, type ); }
        else { throw nothingWrapped(); }
    }
    public  <T> T getObject( String columnName, Class<T> type )
        throws SQLException
    {
        if ( _embedded != null ) { return _embedded.getObject( columnName, type ); }
        else if ( _netclient != null ) { return _netclient.getObject( columnName, type ); }
        else if ( _embedCallableStatement != null ) { return _embedCallableStatement.getObject( columnName, type ); }
        else if ( _callableStatement != null ) { return _callableStatement.getObject( columnName, type ); }
        else if ( _brokeredCallableStatement != null ) { return _brokeredCallableStatement.getObject( columnName, type ); }
        else if ( _logicalCallableStatement != null ) { return _logicalCallableStatement.getObject( columnName, type ); }
        else { throw nothingWrapped(); }
    }
    
    ///////////////////////////////////////////////////////////////////////
    //
    // OTHER PUBLIC BEHAVIOR
    //
    ///////////////////////////////////////////////////////////////////////

    public Object   getWrappedObject() throws SQLException
    {
        if ( _embedded != null ) { return _embedded; }
        else if ( _netclient != null ) { return _netclient; }
        else if ( _embedCallableStatement != null ) { return _embedCallableStatement; }
        else if ( _callableStatement != null ) { return _callableStatement; }
        else if ( _brokeredCallableStatement != null ) { return _brokeredCallableStatement; }
        else if ( _logicalCallableStatement != null ) { return _logicalCallableStatement; }
        else { throw nothingWrapped(); }
    }

    ///////////////////////////////////////////////////////////////////////
    //
    // MINIONS
    //
    ///////////////////////////////////////////////////////////////////////

    private SQLException nothingWrapped() { return new SQLException( "Nothing wrapped!" ); }

}

