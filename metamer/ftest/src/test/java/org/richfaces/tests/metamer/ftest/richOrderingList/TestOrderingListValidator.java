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
package org.richfaces.tests.metamer.ftest.richOrderingList;

import static org.jboss.arquillian.ajocado.utils.URLUtils.buildUrl;
import static org.richfaces.tests.metamer.ftest.webdriver.AttributeList.orderingListAttributes;

import java.net.URL;

import org.openqa.selenium.support.FindBy;
import org.richfaces.tests.metamer.validator.PhoenixFirstValidator;
import org.richfaces.tests.page.fragments.impl.message.RichFacesMessage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:jstefek@redhat.com">Jiri Stefek</a>
 */
public class TestOrderingListValidator extends AbstractOrderingListTest {

    private static final int PHOENIX_INDEX = 2;
    @FindBy(css = "[id$=message]")
    private RichFacesMessage message;

    @Override
    public URL getTestUrl() {
        return buildUrl(contextPath, "faces/components/richOrderingList/validator.xhtml");
    }

    @Test
    public void testValidatorMessage() {
        String customMessage = "Phoenix first!";
        submit();
        Assert.assertTrue(message.isVisible(), "Validator message should be visible");
        Assert.assertEquals(message.getDetail(), PhoenixFirstValidator.VALIDATOR_ERROR_MSG);

        orderingListAttributes.set(OrderingListAttributes.validatorMessage, customMessage);
        submit();
        Assert.assertTrue(message.isVisible(), "Validator message should be visible");
        Assert.assertEquals(message.getDetail(), customMessage);

        orderingList.selectItemsByIndex(PHOENIX_INDEX).top();
        submit();
        Assert.assertFalse(message.isVisible(), "Validator message should not be visible");
    }
}
