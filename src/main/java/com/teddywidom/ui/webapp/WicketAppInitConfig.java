package com.teddywidom.ui.webapp;

import com.giffing.wicket.spring.boot.context.extensions.ApplicationInitExtension;
import com.giffing.wicket.spring.boot.context.extensions.WicketApplicationInitConfiguration;
import com.teddywidom.ui.page.batches.ListBatchesPage;
import com.teddywidom.ui.page.users.ListUsersPage;
import org.apache.wicket.protocol.http.WebApplication;

@ApplicationInitExtension
public class WicketAppInitConfig implements WicketApplicationInitConfiguration {
    @Override
    public void init(WebApplication webApplication) {
        webApplication.mountPage("/batches", ListBatchesPage.class);
        webApplication.mountPage("/users", ListUsersPage.class);
    }
}
