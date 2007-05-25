/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  The ASF licenses this file to You
 * under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.  For additional information regarding
 * copyright in this work, please see the NOTICE file in the top level
 * directory of this distribution.
 */

package org.apache.roller.business.hibernate;

import com.google.inject.Binder;
import com.google.inject.Module;
import org.apache.roller.business.BookmarkManager;
import org.apache.roller.business.FileManager;
import org.apache.roller.business.FileManagerImpl;
import org.apache.roller.business.PluginManager;
import org.apache.roller.business.PluginManagerImpl;
import org.apache.roller.business.PropertiesManager;
import org.apache.roller.business.Roller;
import org.apache.roller.business.UserManager;
import org.apache.roller.business.WeblogManager;
import org.apache.roller.business.pings.AutoPingManager;
import org.apache.roller.business.pings.PingQueueManager;
import org.apache.roller.business.pings.PingTargetManager;
import org.apache.roller.business.referrers.RefererManager;
import org.apache.roller.business.referrers.ReferrerQueueManager;
import org.apache.roller.business.referrers.ReferrerQueueManagerImpl;
import org.apache.roller.business.runnable.ThreadManager;
import org.apache.roller.business.runnable.ThreadManagerImpl;
import org.apache.roller.business.search.IndexManager;
import org.apache.roller.business.search.IndexManagerImpl;
import org.apache.roller.business.themes.ThemeManager;
import org.apache.roller.business.themes.ThemeManagerImpl;

/**
 * Guice module for configuring Hibernate as Roller-backend.
 */
public class HibernateModule implements Module {

    public void configure(Binder binder) {
        
        binder.bind(Roller.class).to(HibernateRollerImpl.class);
        
        binder.bind(AutoPingManager.class).to(     HibernateAutoPingManagerImpl.class);   
        binder.bind(BookmarkManager.class).to(     HibernateBookmarkManagerImpl.class);  
        binder.bind(PingQueueManager.class).to(    HibernatePingQueueManagerImpl.class);   
        binder.bind(PingTargetManager.class).to(   HibernatePingTargetManagerImpl.class); 
        binder.bind(PropertiesManager.class).to(   HibernatePropertiesManagerImpl.class);   
        binder.bind(RefererManager.class).to(      HibernateRefererManagerImpl.class);
        binder.bind(UserManager.class).to(         HibernateUserManagerImpl.class);   
        binder.bind(WeblogManager.class).to(       HibernateWeblogManagerImpl.class);   
        
        binder.bind(ReferrerQueueManager.class).to(ReferrerQueueManagerImpl.class); 
        binder.bind(FileManager.class).to(         FileManagerImpl.class);   
        binder.bind(IndexManager.class).to(        IndexManagerImpl.class);
        binder.bind(PluginManager.class).to(       PluginManagerImpl.class);    
        binder.bind(ThemeManager.class).to(        ThemeManagerImpl.class);  
        binder.bind(ThreadManager.class).to(       ThreadManagerImpl.class);  
    }    
}
