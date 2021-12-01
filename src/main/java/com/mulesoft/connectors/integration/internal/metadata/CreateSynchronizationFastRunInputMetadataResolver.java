package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.input.JsonInputMetadataResolver;

public class CreateSynchronizationFastRunInputMetadataResolver extends JsonInputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/create-synchronization-run-input-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "create-synchronization-fast-run-type-resolver";
  }
}