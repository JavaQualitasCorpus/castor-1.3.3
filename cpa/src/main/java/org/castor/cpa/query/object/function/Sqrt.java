/*
 * Copyright 2008 Udai Gupta, Ralf Joachim
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
package org.castor.cpa.query.object.function;

import org.castor.cpa.query.Expression;

/**
 * Final class that represents SQRT (square root) function.
 * 
 * @author <a href="mailto:mailtoud AT gmail DOT com">Udai Gupta</a>
 * @author <a href="mailto:ralf DOT joachim AT syscon DOT eu">Ralf Joachim</a>
 * @version $Revision: 8994 $ $Date: 2011-08-02 01:40:59 +0200 (Di, 02 Aug 2011) $
 * @since 1.3
 */
public final class Sqrt extends AbstractFunction {
    //--------------------------------------------------------------------------

    /** The number of SQRT function. */
    private Expression _number;

    //--------------------------------------------------------------------------

    /**
     * Gets the number expression of SQRT function.
     * 
     * @return The number expression of SQRT function.
     */
    public Expression getNumber() {
        return _number;
    }

    /**
     * Sets the number expression of SQRT function.
     * 
     * @param number The new number expression of SQRT function.
     */
    public void setNumber(final Expression number) {
        _number = number;
    }

    //--------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    public StringBuilder toString(final StringBuilder sb) {
        sb.append("SQRT(");
        if (_number != null) { _number.toString(sb); }
        return sb.append(')');
    }

    //--------------------------------------------------------------------------
}
