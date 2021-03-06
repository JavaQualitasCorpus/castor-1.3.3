/**
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
 * Copyright 2000-2002 (C) Intalio, Inc. All Rights Reserved.
 *
 * $Id: Dialog.java 6653 2006-12-29 21:54:35Z wguttmn $
 */
package org.exolab.castor.util.dialog;

/**
 * A simple utility class to handle user interaction.
 *
 * @author <a href="mailto:nsgreen@thazar.com">Nathan Green</a>
 * @author <a href="mailto:kvisco@intalio.com">Keith Visco</a>
 */
public interface Dialog {

    /**
     * Presents a confirmation prompt with the given message.
     *
     * @param message
     *            the confirmation prompt message to display
     * @return true if the user has selected a positive confirmation, otherwise
     *         false
     */
    boolean confirm(final String message);

    /**
     * Presents a confirmation prompt for values with the given message.
     *
     * @param message
     *            the confirmation prompt to display
     * @param values
     *            a list of valid characters to accept
     * @return whatever character the user presses
     */
    char confirm(final String message, final String values);

    /**
     * Presents a confirmation prompt for values with the given messge.
     *
     * @param message
     *            the confirmation prompt to display
     * @param values
     *            a list of valid characters to accept
     * @param help
     *            a simple help message that can be associated with the message
     *            to give additional details about the prompt.
     * @return whatever character the user presses
     */
    char confirm(final String message, final String values, final String help);

    /**
     * Simply displays a message to the user, no input is returned from the
     * user.
     *
     * @param message
     *            the message to display to the user
     */
    void notify(final String message);

} //-- Dialog
