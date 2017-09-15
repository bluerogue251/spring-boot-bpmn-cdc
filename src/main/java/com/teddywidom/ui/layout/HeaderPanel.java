package com.teddywidom.ui.layout;

import com.teddywidom.ui.page.home.HomePage;
import com.teddywidom.ui.page.workflows.ListProcessDefinitionsPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

public class HeaderPanel extends Panel {
    public HeaderPanel(String id) {
        super(id);
        add(new BookmarkablePageLink<>("resourcesLink", HomePage.class));
        add(new BookmarkablePageLink<>("workflowsLink", ListProcessDefinitionsPage.class));
    }
}
