/*
 * Copyright 2008 Lukas Lang, Werner Guttmann
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
package org.castor.cpa.util.classresolution.command;

import org.castor.cpa.util.classresolution.nature.MappingLoaderNature;
import org.exolab.castor.mapping.ClassDescriptor;

/**
 * Resolves {@link ClassDescriptor}s using a {@link MappingLoader}.
 * 
 * @author <a href="mailto:lukas DOT lang AT inode DOT at">Lukas Lang</a>
 * @author <a href="mailto:wguttmn AT codehaus DOT org">Werner Guttmann</a>
 * @version $Revision: 8994 $ $Date: 2011-08-02 01:40:59 +0200 (Di, 02 Aug 2011) $
 */
public final class ClassResolutionByMappingLoader extends BaseResolutionCommand {
    //-----------------------------------------------------------------------------------

    /**
     * Constructor taking a MappingLoader.
     */
    public ClassResolutionByMappingLoader() {
        addNature(MappingLoaderNature.class.getName());
    }
    
    //-----------------------------------------------------------------------------------

    /**
     * Resolves a {@link ClassDescriptor} for the given type using 
     * the {@link MappingLoader} of the {@link MappingLoaderNature}.
     * 
     * @see org.exolab.castor.xml.util.ClassResolutionCommand#resolve(java.lang.Class)
     * 
     * @return A {@link ClassDescriptor} or null if not found.
     * @param type The type to resolve.
     */
    public ClassDescriptor resolve(final Class type) {
        return new MappingLoaderNature(this)
                .getMappingLoader().getDescriptor(type.getName());
    }

    //-----------------------------------------------------------------------------------
}
