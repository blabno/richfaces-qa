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
package org.richfaces.tests.showcase.ftest.webdriver.ftest.richInplaceSelect;

import org.jboss.arquillian.graphene.spi.annotations.Page;
import static org.testng.Assert.assertFalse;

import org.jboss.test.selenium.android.ToolKitException;
import org.richfaces.tests.showcase.ftest.webdriver.AbstractWebDriverTest;
import org.richfaces.tests.showcase.ftest.webdriver.page.richInplaceSelect.InplaceSelectPage;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:jpapouse@redhat.com">Jan Papousek</a>
 */
public class TestRichInplaceSelectSimple extends AbstractWebDriverTest {

    @Page
    private InplaceSelectPage page;

    @Test
    public void testInit() {
        assertFalse(getPage().getSelect().isPopupPresent());
    }

    @Test
    public void testShowPopupByClickingOnInput() {
        getPage().getSelect().showPopupByClick();
    }

    @Test
    public void testSelectByMouse() throws ToolKitException {
        getPage().getSelect().showPopupByClick();
        getPage().getSelect().selectFromPopupByIndex(0);
    }

    @Override
    protected InplaceSelectPage getPage() {
        return page;
    }

}
