package com.teddywidom.ui.page.users;

import com.teddywidom.model.User;
import com.teddywidom.repo.UserRepository;
import com.teddywidom.ui.layout.TrwWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class ListUsersPage extends TrwWebPage {
    @SpringBean
    UserRepository userRepository;

    public ListUsersPage() {
        Iterable<User> users = userRepository.findAll();
        List<User> userList = new ArrayList<User>();
        for (User u : users) {
            userList.add(u);
        }

        ListDataProvider<User> userListDataProvider = new ListDataProvider<User>(userList);

        DataView<User> dataView = new DataView<User>("users", userListDataProvider, 10) {
            @Override
            protected void populateItem(Item<User> item) {
                User user = item.getModelObject();
                Label usernameLabel = new Label("username", user.getUsername());
                Label firstNameLabel = new Label("firstName", user.getFirstName());
                Label lastNameLabel = new Label("lastName", user.getLastName());
                Label createdLabel = new Label("created", user.getCreatedAt());
                item.add(usernameLabel, firstNameLabel, lastNameLabel, createdLabel);
            }
        };
        PagingNavigator pagingNavigator = new PagingNavigator("pagingNavigator", dataView);
        add(dataView, pagingNavigator);
    }
}
