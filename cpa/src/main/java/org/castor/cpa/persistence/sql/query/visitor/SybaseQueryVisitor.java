/*
 * Copyright 2010 Dennis Butterstein, Ralf Joachim
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
 *
 * $Id: SybaseQueryVisitor.java 8994 2011-08-01 23:40:59Z rjoachim $
 */
package org.castor.cpa.persistence.sql.query.visitor;

import org.castor.cpa.persistence.sql.query.Qualifier;
import org.castor.cpa.persistence.sql.query.QueryConstants;
import org.castor.cpa.persistence.sql.query.Select;
import org.castor.cpa.persistence.sql.query.TableAlias;

/**
 * Visitor defining special behavior of query building for Sybase database.
 *
 * @author <a href="mailto:madsheepscarer AT googlemail DOT com">Dennis Butterstein</a>
 * @author <a href="mailto:ralf DOT joachim AT syscon DOT eu">Ralf Joachim</a>
 * @version $Revision: 8994 $ $Date: 2011-08-02 01:40:59 +0200 (Di, 02 Aug 2011) $
 */
public final class SybaseQueryVisitor extends DefaultDoubleQuoteNameQueryVisitor {
    //-----------------------------------------------------------------------------------

    /** Variable storing select statement to check if lock-clauses are needed.*/
    private Select _select;

    //-----------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public void visit(final Select select) {
        _select = select;
        super.visit(select);
    }

    /**
     * {@inheritDoc}
     */
    protected void addTableNames(final Qualifier qualifier) {
        if (qualifier instanceof TableAlias) {
            ((TableAlias) qualifier).getTable().accept(this);
            _queryString.append(QueryConstants.SPACE);
        }
        qualifier.accept(this);

        if (_select.isLocked()) {
            _queryString.append(QueryConstants.SPACE);
            _queryString.append(QueryConstants.HOLDLOCK);
        }
    }

    //-----------------------------------------------------------------------------------

    /**
     * Get method returning select currently set.
     * This method is only used for testing issues!
     * 
     * @return Select currently set.
     */
    @SuppressWarnings("unused")
    private Select getSelect() {
        return _select;
    }

    /**
     * Set method to set current Select object.
     * This method is only used for testing issues!
     * 
     * @param select Select to be set.
     */
    @SuppressWarnings("unused")
    private void setSelect(final Select select) {
        _select = select;
    }

    /**
     * {@inheritDoc}
     */
    protected String quoteName(final String name) {
        return doubleQuoteName(name);
    }

    //-----------------------------------------------------------------------------------
}
