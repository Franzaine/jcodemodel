/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 * Portions Copyright 2013-2015 Philip Helger + contributors
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
package com.helger.jcodemodel.meta;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.jcodemodel.AbstractJType;

/**
 * @author Victor Nazarov &lt;asviraspossible@gmail.com&gt;
 */
class TypeEnvironment
{
  private final Map <String, AbstractJType> map = new TreeMap <String, AbstractJType> ();
  private final TypeEnvironment _parent;
  private final String _packageName;

  TypeEnvironment (final String packageName)
  {
    _parent = null;
    _packageName = packageName;
  }

  private TypeEnvironment (final TypeEnvironment parent)
  {
    _packageName = null;
    _parent = parent;
  }

  @Nonnull
  public TypeEnvironment enclosed ()
  {
    return new TypeEnvironment (this);
  }

  @Nullable
  public AbstractJType get (@Nonnull final String name)
  {
    final AbstractJType result = map.get (name);
    if (result != null || _parent == null)
      return result;
    return _parent.get (name);
  }

  public void put (@Nonnull final String name, final AbstractJType type)
  {
    map.put (name, type);
  }

  @Nullable
  String packageName ()
  {
    return _parent == null ? _packageName : _parent.packageName ();
  }
}
