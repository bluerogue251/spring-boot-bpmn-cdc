package com.teddywidom.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

// TODO this should not have to implement serializable, only doing it for the ListDataProvider temporarily
@Entity
@Table(name = "batches")
public class Batch implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String getBarcode() {
        return barcode;
    }

    public String getAssayType() {
        return assayType;
    }

    @NotNull
    private String barcode;

    @NotNull
    private String assayType;

    @NotNull
    @CreationTimestamp
    private Timestamp createdAt = Timestamp.valueOf(LocalDateTime.now());

    @NotNull
    @UpdateTimestamp
    private Timestamp updatedAt = Timestamp.valueOf(LocalDateTime.now());

    protected Batch() {
    }

    public Batch(String barcode, String assayType) {
        this.barcode = barcode;
        this.assayType = assayType;
    }
}
