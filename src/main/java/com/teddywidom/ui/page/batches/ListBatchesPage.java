package com.teddywidom.ui.page.batches;

import com.teddywidom.model.Batch;
import com.teddywidom.repo.BatchRepository;
import com.teddywidom.ui.layout.TrwWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;
import java.util.List;

public class ListBatchesPage extends TrwWebPage {
    @SpringBean
    BatchRepository batchRepository;

    public ListBatchesPage() {
        Iterable<Batch> batches = batchRepository.findAll();
        List<Batch> batchList = new ArrayList<Batch>();
        for (Batch b : batches) {
            batchList.add(b);
        }

        ListDataProvider<Batch> batchListDataProvider = new ListDataProvider<Batch>(batchList);

        DataView<Batch> dataView = new DataView<Batch>("batches", batchListDataProvider, 10) {
            @Override
            protected void populateItem(Item<Batch> item) {
                Batch batch = item.getModelObject();
                Label barcodeLabel = new Label("barcode", batch.getBarcode());
                Label assayTypeLabel = new Label("assayType", batch.getAssayType());
                item.add(barcodeLabel, assayTypeLabel);
            }
        };
        PagingNavigator pagingNavigator = new PagingNavigator("pagingNavigator", dataView);
        add(dataView, pagingNavigator);
    }
}
