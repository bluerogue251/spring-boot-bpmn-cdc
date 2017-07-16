CREATE TABLE batches (
  id         SERIAL PRIMARY KEY,
  barcode    TEXT      NOT NULL,
  assay_type TEXT      NOT NULL,
  created_at TIMESTAMP NOT NULL,
  updated_at TIMESTAMP NOT NULL
);