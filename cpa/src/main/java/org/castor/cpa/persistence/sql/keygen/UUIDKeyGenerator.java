/*
 * Copyright 2008 Thomas Fach, Bruce Snyder, Ralf Joachim
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.castor.cpa.persistence.sql.keygen;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import org.castor.core.util.Messages;
import org.exolab.castor.jdo.PersistenceException;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.persist.spi.PersistenceFactory;

/**
 * UUID key generator.
 * 
 * @see UUIDKeyGeneratorFactory
 * @author <a href="mailto:thomas DOT fach AT publica DOT de">Thomas Fach</a>
 * @author <a href="mailto:bruce DOT snyder AT gmail DOT com">Bruce Snyder</a>
 * @author <a href="mailto:ralf DOT joachim AT syscon DOT eu">Ralf Joachim</a>
 * @version $Revision: 8994 $ $Date: 2011-08-02 01:40:59 +0200 (Di, 02 Aug 2011) $
 */
public final class UUIDKeyGenerator extends AbstractBeforeKeyGenerator {
    //-----------------------------------------------------------------------------------

    /** Format for IP-Address. */
    private static final DecimalFormat IP_FORMAT = new DecimalFormat("000");

    /** Format used for time. */
    private static final DecimalFormat TIME_FORMAT = new DecimalFormat("0000000000000");

    /** Format used for counter. */
    private static final DecimalFormat COUNTER_FORMAT = new DecimalFormat("00000");

    /** Maximum valid value for counter. */
    private static final long COUNTER_MAX = 99999;

    /** Static counter variable. */
    private static long _staticCounter = 0;

    /** Variable to store host address. */
    private String _hostAddress;

    //-----------------------------------------------------------------------------------

    /**
     * Initialize the UUID key generator.
     * @param factory Instance of PersistenceFactory to be used.
     * @param sqlType SqlType variable to determine type.
     * @throws MappingException An exception indicating an invalid mapping error.
     */
    public UUIDKeyGenerator(final PersistenceFactory factory, final int sqlType)
    throws MappingException {
        super(factory);
        if ((sqlType != Types.CHAR) && (sqlType != Types.VARCHAR)
                && (sqlType != Types.LONGVARCHAR)) {
            String msg = Messages.format("mapping.keyGenSQLType",
                    getClass().getName(), new Integer(sqlType));
            throw new MappingException(msg);
        }

        initHostAddress();
    }

    /** Method to initialize hostAddress variable on construction of this object.
     * @throws MappingException MappingException An exception indicating an invalid mapping error.
     */
    private void initHostAddress() throws MappingException {
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            
            StringBuffer sb = new StringBuffer();
            StringTokenizer st = new StringTokenizer(host, ".");
            while (st.hasMoreTokens()) {
                sb.append(IP_FORMAT.format(new Integer(st.nextToken())));
            }

            _hostAddress = sb.toString();
        } catch (Exception ex) {
            throw new MappingException(Messages.format(
                    "persist.keyGenSQL", getClass().getName(), ex.toString()), ex);
        }
    }
    
    //-----------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public Object generateKey(final Connection conn, final String tableName,
            final String primKeyName) throws PersistenceException {
        StringBuffer sb = new StringBuffer();
        
        // getting IP (fixed length: 12 character)
        sb.append(_hostAddress);
        
        // getting currentTimeMillis (fixed length: 13 character)
        sb.append(TIME_FORMAT.format(System.currentTimeMillis()));
        
        // getting static counter (fixed length: 5 character)
        if (_staticCounter >= COUNTER_MAX) { _staticCounter = 0; }
        _staticCounter++;
        sb.append(COUNTER_FORMAT.format(_staticCounter));

        return sb.toString();
    }

    /**
     * {@inheritDoc}
     */
    public boolean isInSameConnection() {
        return true;
    }

    //-----------------------------------------------------------------------------------
}