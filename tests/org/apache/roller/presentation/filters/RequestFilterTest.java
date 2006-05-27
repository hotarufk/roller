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
package org.apache.roller.presentation.filters;

import javax.servlet.http.HttpServletRequest;

import junit.framework.Test;
import junit.framework.TestSuite;


import com.mockrunner.mock.web.MockHttpServletRequest;
import org.apache.roller.presentation.VelocityServletTestBase;
import org.apache.roller.ui.core.RollerRequest;
import org.apache.roller.ui.core.filters.PersistenceSessionFilter;
import org.apache.roller.ui.core.filters.RequestFilter;
import org.apache.roller.ui.rendering.velocity.PageServlet;

/** 
 * @author Dave Johnson
 */
public class RequestFilterTest extends VelocityServletTestBase {
    public void setUp() throws Exception
    {
        super.setUp();       
    }
    public RequestFilterTest() {
    }
    public void testRequestFilter() throws Exception {        
        
        servletModule.setServlet(
           servletModule.createServlet(PageServlet.class));       

        MockHttpServletRequest mockRequest = getMockFactory().getMockRequest();
        mockRequest.setContextPath("/roller/page");
        mockRequest.setPathInfo("/testuser/20050101");
        mockRequest.setRequestURL("http://localost:8080");

        servletModule.createFilter(PersistenceSessionFilter.class);
        servletModule.createFilter(RequestFilter.class);
        servletModule.setDoChain(true);

        servletModule.doFilter();   
        
        HttpServletRequest req = (HttpServletRequest)
            servletModule.getFilteredRequest();
        RollerRequest rreq = RollerRequest.getRollerRequest(req);
        assertNotNull(rreq);    
    }
    public static Test suite() 
    {
        return new TestSuite(RequestFilterTest.class);
    }
}
