package com.teddywidom.ui.page.workflows;

import com.teddywidom.ui.layout.TrwWebPage;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.ProcessDefinition;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListProcessDefinitionsPage extends TrwWebPage {
    @SpringBean
    ProcessEngine processEngine;

    public ListProcessDefinitionsPage() {
        List<ProcessDefinition> processes = processEngine.getRepositoryService().createProcessDefinitionQuery().list();
        List<SerializableProcessDefinition> processesList = new ArrayList<>();
        for (ProcessDefinition pd : processes) {
            processesList.add(new SerializableProcessDefinition(pd));
        }

        ListDataProvider<SerializableProcessDefinition> processDefinitionListDataProvider = new ListDataProvider<>(processesList);

        DataView<SerializableProcessDefinition> dataView = new DataView<SerializableProcessDefinition>("processes", processDefinitionListDataProvider, 10) {
            @Override
            protected void populateItem(Item<SerializableProcessDefinition> item) {
                SerializableProcessDefinition spd = item.getModelObject();
                Label keyLabel = new Label("key", spd.getKey());
                Label nameLabel = new Label("name", spd.getName());
                Label categoryLabel = new Label("category", spd.getCategory());
                Label descriptionLabel = new Label("description", spd.getDescription());
                Label versionLabel = new Label("version", spd.getVersion());
                Label isSuspendedLabel = new Label("isSuspended", spd.isSuspended());
                item.add(keyLabel, nameLabel, categoryLabel, descriptionLabel, versionLabel, isSuspendedLabel);
            }
        };
        PagingNavigator pagingNavigator = new PagingNavigator("pagingNavigator", dataView);
        add(dataView, pagingNavigator);
    }

    private class SerializableProcessDefinition implements Serializable {
        private final String key;
        private final String name;
        private final String category;
        private final String description;
        private final int version;
        private final boolean isSuspended;

        private SerializableProcessDefinition(ProcessDefinition pd) {
            this.key = pd.getKey();
            this.name = pd.getName();
            this.category = pd.getCategory();
            this.description = pd.getDescription();
            this.version = pd.getVersion();
            this.isSuspended = pd.isSuspended();
        }


        String getName() {
            return name;
        }

        String getCategory() {
            return category;
        }

        String getDescription() {
            return description;
        }

        int getVersion() {
            return version;
        }

        boolean isSuspended() {
            return isSuspended;
        }

        public String getKey() {
            return key;
        }
    }
}
