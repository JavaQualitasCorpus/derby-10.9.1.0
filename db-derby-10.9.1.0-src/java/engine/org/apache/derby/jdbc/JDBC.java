/*

   Derby - Class org.apache.derby.jdbc.JDBC

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.apache.derby.jdbc;

import org.apache.derby.iapi.services.info.JVMInfo;
import org.apache.derby.mbeans.JDBCMBean;

/**
 * Simple JBDC mbean that pulls information
 * about the JDBC driver.
 * 
 */
final class JDBC implements JDBCMBean
{ 
    private final InternalDriver driver;
    JDBC(InternalDriver driver)
    {
        this.driver = driver;
    }

    public String getDriverLevel() {
        return JVMInfo.derbyVMLevel();
    }

    public int getMajorVersion() {
         return driver.getMajorVersion();
    }

    public int getMinorVersion() {
        return driver.getMinorVersion();
    }
    
    public boolean isCompliantDriver()
    {
        return driver.jdbcCompliant();
    }
    
    public boolean acceptsURL(String url)
    {
        return driver.acceptsURL(url);
    }
}

