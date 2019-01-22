/*
 * Redistribution and use of this software and associated documentation
 * ("Software"), with or without modification, are permitted provided
 * that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright
 *    statements and notices.  Redistributions must also contain a
 *    copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the
 *    above copyright notice, this list of conditions and the
 *    following disclaimer in the documentation and/or other
 *    materials provided with the distribution.
 *
 * 3. The name "Exolab" must not be used to endorse or promote
 *    products derived from this Software without prior written
 *    permission of Intalio, Inc.  For written permission,
 *    please contact info@exolab.org.
 *
 * 4. Products derived from this Software may not be called "Exolab"
 *    nor may "Exolab" appear in their names without prior written
 *    permission of Intalio, Inc. Exolab is a registered
 *    trademark of Intalio, Inc.
 *
 * 5. Due credit should be given to the Exolab Project
 *    (http://www.exolab.org/).
 *
 * THIS SOFTWARE IS PROVIDED BY INTALIO, INC. AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * INTALIO, INC. OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Copyright 2000 (C) Intalio, Inc. All Rights Reserved.
 *
 * $Id: AlwaysTrueRegExpEvaluator.java 6671 2007-01-02 05:57:46Z ekuns $
 */
package org.exolab.castor.xml.util;

import org.exolab.castor.util.RegExpEvaluator;

/**
 * A simple implementation of a regular expression validator which always
 * returns true. This class can be used to "suppress" validation exceptions when
 * no regular expression validator has been configured.
 *
 * @author <a href="mailto:kvisco@intalio.com">Keith Visco</a>
 * @version $Revision: 6671 $ $Date: 2003-03-03 00:05:44 -0700 (Mon, 03 Mar 2003) $
 */
public class AlwaysTrueRegExpEvaluator implements RegExpEvaluator {

    /**
     * Creates a new AlwaysTrueRegExpEvaluator.
     */
    public AlwaysTrueRegExpEvaluator() {
        super();
    } //-- AlwaysTrueRegExpEvaluator

    /**
     * Sets the regular expression to match against during a call to #matches.
     *
     * @param rexpr the regular expression
     */
    public void setExpression(String rexpr) {
        //-- nothing to do...we don't care since match will always evaluate to true
    } //-- setExpression

    /**
     * Returns true if the given String is matched by the regular expression of
     * this RegExpEvaluator.
     *
     * @param value the String to check the production of
     * @return true if the given string matches the regular expression of this
     *         RegExpEvaluator
     * @see #setExpression
     */
    public boolean matches(String value) {
        return true;
    } //-- matches

} //-- AlwaysTrueRegExpEvaluator
