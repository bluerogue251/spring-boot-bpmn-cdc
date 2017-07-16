package com.teddywidom.ui.page.home;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import com.teddywidom.ui.layout.TrwWebPage;
import com.teddywidom.ui.page.batches.ListBatchesPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

@WicketHomePage
public class HomePage extends TrwWebPage {
    public HomePage() {
        BookmarkablePageLink listBatchesPageLink = new BookmarkablePageLink("listBatchesPageLink", ListBatchesPage.class);
        add(listBatchesPageLink);
    }


}
