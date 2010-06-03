package org.apache.maven.repo.util;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.repo.Dependency;
import org.apache.maven.repo.DependencyNode;
import org.apache.maven.repo.DependencyTraverser;

/**
 * A dependency traverser that excludes fat artifacts from the traversal. Fat artifacts are artifacts that have the
 * property "includesDependencies" set to {@code true}.
 * 
 * @author Benjamin Bentmann
 * @see org.apache.maven.repo.Artifact#getProperties()
 */
public class FatArtifactTraverser
    implements DependencyTraverser
{

    public boolean accept( DependencyNode node, Dependency dependency )
    {
        return !Boolean.valueOf( dependency.getArtifact().getProperty( "includesDependencies", "" ) );
    }

    public DependencyTraverser deriveChildTraverser( DependencyNode childNode )
    {
        return this;
    }

}