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
package org.richfaces.tests.metamer.ftest.richList;

import static org.jboss.arquillian.ajocado.utils.URLUtils.buildUrl;
import static org.testng.Assert.assertEquals;
import static org.richfaces.tests.metamer.ftest.webdriver.AttributeList.listAttributes;

import java.net.URL;

import org.jboss.arquillian.ajocado.dom.Event;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.richfaces.tests.metamer.ftest.BasicAttributes;
import org.richfaces.tests.metamer.ftest.annotations.Inject;
import org.richfaces.tests.metamer.ftest.annotations.Use;
import org.richfaces.tests.page.fragments.impl.list.ListItems;
import org.richfaces.tests.page.fragments.impl.list.simple.RichFacesSimpleListItem;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:lfryc@redhat.com">Lukas Fryc</a>
 * @author <a href="mailto:jstefek@redhat.com">Jiri Stefek</a>
 */
public class TestListAttributes extends AbstractListTest {

    enum ListType {

        ORDERED("ordered"), UNORDERED("unordered"), DEFINITIONS("definitions");
        private final String value;

        private ListType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    @Inject
    @Use(empty = false)
    private ListType type;

    @Override
    public URL getTestUrl() {
        return buildUrl(contextPath, "faces/components/richList/simple.xhtml");
    }

    private WebElement getTestedItem() {
        return list.getItems().get(0).getItemElement();
    }

    @Test
    public void testRendered() {
        listAttributes.set(ListAttributes.rendered, Boolean.FALSE);
        assertEquals(list.isVisible(), false);
    }

    @Test
    public void testDir() {
        testDir(list.getRootElement());
    }

    @Test
    @Use(field = "first", value = "INTS")
    public void testFirst() {
        listAttributes.set(ListAttributes.first, first);
        rows = 20;
        listAttributes.set(ListAttributes.rows, rows);
        verifyList();
    }

    @Test
    public void testLang() {
        testAttributeLang(list.getRootElement());
    }

    @Test
    public void testOnclick() {
        testFireEvent(listAttributes, ListAttributes.onclick,
                new Actions(driver).click(list.getRootElement()).build());
    }

    @Test
    public void testOndblclick() {
        testFireEvent(listAttributes, ListAttributes.ondblclick,
                new Actions(driver).doubleClick(list.getRootElement()).build());
    }

    @Test
    public void testOnkeydown() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onkeydown);
    }

    @Test
    public void testOnkeypress() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onkeypress);
    }

    @Test
    public void testOnkeyup() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onkeyup);

    }

    @Test
    public void testOnmousedown() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onmousedown);
    }

    @Test
    public void testOnmousemove() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onmousemove);

    }

    @Test
    public void testOnmouseout() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onmouseout);
    }

    @Test
    public void testOnmouseover() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onmouseover);
    }

    @Test
    public void testOnmouseup() {
        testFireEventWithJS(list.getRootElement(), listAttributes,
                ListAttributes.onmouseup);
    }

    @Test
    public void testOnrowclick() {
        testFireEvent(listAttributes, ListAttributes.onrowclick,
                new Actions(driver).click(getTestedItem()).build());
    }

    @Test
    public void testOnrowdblclick() {
        testFireEvent(listAttributes, ListAttributes.onrowdblclick,
                new Actions(driver).doubleClick(getTestedItem()).build());
    }

    @Test
    public void testOnrowkeydown() {
        testFireEventWithJS(getTestedItem(), Event.KEYDOWN, listAttributes,
                ListAttributes.onrowkeydown);
    }

    @Test
    public void testOnrowkeypress() {
        testFireEventWithJS(getTestedItem(), Event.KEYPRESS, listAttributes,
                ListAttributes.onrowkeypress);
    }

    @Test
    public void testOnrowkeyup() {
        testFireEventWithJS(getTestedItem(), Event.KEYUP, listAttributes,
                ListAttributes.onrowkeyup);
    }

    @Test
    public void testOnrowmousedown() {
        testFireEventWithJS(getTestedItem(), Event.MOUSEDOWN, listAttributes,
                ListAttributes.onrowmousedown);
    }

    @Test
    public void testOnrowmousemove() {
        testFireEventWithJS(getTestedItem(), Event.MOUSEMOVE, listAttributes,
                ListAttributes.onrowmousemove);

    }

    @Test
    public void testOnrowmouseout() {
        testFireEventWithJS(getTestedItem(), Event.MOUSEOUT, listAttributes,
                ListAttributes.onrowmouseout);
    }

    @Test
    public void testOnrowmouseover() {
        testFireEventWithJS(getTestedItem(), Event.MOUSEOVER, listAttributes,
                ListAttributes.onrowmouseover);
    }

    @Test
    public void testOnrowmouseup() {
        testFireEventWithJS(getTestedItem(), Event.MOUSEUP, listAttributes,
                ListAttributes.onrowmouseup);
    }

    @Test
    public void testRowClass() {
        ListItems<RichFacesSimpleListItem> items = list.getItems();
        testStyleClass(items.get(0).getItemElement(), BasicAttributes.rowClass);
        testStyleClass(items.get(items.size() - 1).getItemElement(), BasicAttributes.rowClass);
    }

    @Test
    public void testRowClasses() {
        ListItems<RichFacesSimpleListItem> items = list.getItems();
        testStyleClass(items.get(0).getItemElement(), BasicAttributes.rowClasses);
        testStyleClass(items.get(items.size() - 1).getItemElement(), BasicAttributes.rowClasses);
    }

    @Test
    @Use(field = "rows", value = "INTS")
    public void testRows() {
        listAttributes.set(ListAttributes.rows, rows);
        verifyList();
    }

    @Test
    public void testStyle() {
        testStyle(list.getRootElement());
    }

    @Test
    public void testStyleClass() {
        testStyleClass(list.getRootElement());
    }

    @Test
    public void testTitle() {
        testTitle(list.getRootElement());
    }

    @Test
    @Use(field = "type", enumeration = true)
    public void testType() {
        listAttributes.set(ListAttributes.type, type.getValue());
    }
}
