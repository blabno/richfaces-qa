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
package org.richfaces.tests.page.fragments.impl.list.ordering;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.richfaces.tests.page.fragments.impl.list.common.OrderingListLayout;

/**
 * Layout that will be instantiated as fragment. Layout for r:orderingList.
 *
 * @author <a href="mailto:jstefek@redhat.com">Jiri Stefek</a>
 */
public class RichFacesOrderingListLayout implements OrderingListLayout {

    @FindBy(className = "rf-ord-cptn")
    private WebElement captionElement;
    @FindBy(css = "button.rf-ord-dn")
    private WebElement downButtonElement;
    @FindBy(css = "button.rf-ord-up-tp")
    private WebElement topButtonElement;
    @FindBy(css = "button.rf-ord-dn-bt")
    private WebElement bottomButtonElement;
    @FindBy(css = "button.rf-ord-up")
    private WebElement upButtonElement;
    @FindBy(className = "rf-ord-opt")
    private List<WebElement> items;
    @FindBy(className = "rf-ord-sel")
    private List<WebElement> selectedItems;
    @FindBy(css = "thead.rf-ord-lst-hdr > tr.rf-ord-hdr")
    private WebElement headerElement;
    @FindBy(className = "rf-ord-lst-scrl")
    private WebElement listAreaElement;

    @Override
    public WebElement getCaptionElement() {
        return captionElement;
    }

    @Override
    public WebElement getDownButtonElement() {
        return downButtonElement;
    }

    @Override
    public WebElement getTopButtonElement() {
        return topButtonElement;
    }

    @Override
    public WebElement getBottomButtonElement() {
        return bottomButtonElement;
    }

    @Override
    public WebElement getUpButtonElement() {
        return upButtonElement;
    }

    @Override
    public List<WebElement> getItems() {
        return items;
    }

    @Override
    public List<WebElement> getSelectedItems() {
        return selectedItems;
    }

    @Override
    public WebElement getHeaderElement() {
        return headerElement;
    }

    @Override
    public WebElement getListAreaElement() {
        return listAreaElement;
    }
}
