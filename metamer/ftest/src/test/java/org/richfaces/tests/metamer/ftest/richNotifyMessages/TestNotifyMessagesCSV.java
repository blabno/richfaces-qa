/*******************************************************************************
 * JBoss, Home of Professional Open Source
 * Copyright 2010-2013, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 *******************************************************************************/
package org.richfaces.tests.metamer.ftest.richNotifyMessages;

import static org.jboss.arquillian.ajocado.utils.URLUtils.buildUrl;

import java.net.URL;

import org.jboss.arquillian.graphene.Graphene;
import org.richfaces.tests.metamer.ftest.annotations.IssueTracking;

import org.testng.annotations.Test;

/**
 * @author <a href="mailto:jstefek@redhat.com">Jiri Stefek</a>
 */
public class TestNotifyMessagesCSV extends AbstractNotifyMessagesTest {

    @Override
    public URL getTestUrl() {
        return buildUrl(contextPath, "faces/components/richNotifyMessages/csv.xhtml");
    }

    @IssueTracking("https://issues.jboss.org/browse/RF-12922")//fix the waiting below
    @Test
    public void testSimple() {
        checkSimple(2);
    }

    @Override
    protected void waitingForValidationMessagesToShow() {
        submitWithHBtn();// "https://issues.jboss.org/browse/RF-12922"
        Graphene.waitGui().until(getPage().getMessagesComponentWithGlobal().isVisibleCondition());
        Graphene.waitGui().until(getPage().getMessagesComponentWithFor().isVisibleCondition());
    }
}
