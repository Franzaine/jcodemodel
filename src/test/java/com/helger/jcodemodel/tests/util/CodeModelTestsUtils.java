/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.helger.jcodemodel.tests.util;

import java.io.StringWriter;

import com.helger.jcodemodel.JDeclaration;
import com.helger.jcodemodel.JExpression;
import com.helger.jcodemodel.JFormatter;
import com.helger.jcodemodel.JGenerable;

/**
 * Various utilities for codemodel tests.
 * 
 * @author Aleksei Valikov
 */
public class CodeModelTestsUtils
{

  /** Hidden constructor. */
  private CodeModelTestsUtils ()
  {}

  /**
   * Prints an expression into a string.
   * 
   * @param expression
   *        expression to print into a string.
   * @return Expression formatted as a string.
   */
  public static String toString (final JExpression expression)
  {
    if (expression == null)
    {
      throw new IllegalArgumentException ("Generable must not be null.");
    }
    final StringWriter stringWriter = new StringWriter ();
    final JFormatter formatter = new JFormatter (stringWriter);
    expression.generate (formatter);
    return stringWriter.toString ();
  }

  public static String declare (final JDeclaration declaration)
  {
    if (declaration == null)
    {
      throw new IllegalArgumentException ("Declaration must not be null.");
    }
    final StringWriter stringWriter = new StringWriter ();
    final JFormatter formatter = new JFormatter (stringWriter);
    declaration.declare (formatter);
    return stringWriter.toString ();
  }

  public static String generate (final JGenerable generable)
  {
    if (generable == null)
    {
      throw new IllegalArgumentException ("Generable must not be null.");
    }
    final StringWriter stringWriter = new StringWriter ();
    final JFormatter formatter = new JFormatter (stringWriter);
    generable.generate (formatter);
    return stringWriter.toString ();
  }
}