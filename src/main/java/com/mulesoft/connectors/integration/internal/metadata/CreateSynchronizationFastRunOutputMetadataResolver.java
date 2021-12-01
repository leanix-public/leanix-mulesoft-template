package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;

public class CreateSynchronizationFastRunOutputMetadataResolver extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/create-synchronization-fast-run-output-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "create-synchronization-fast-run-type-resolver";
  }
}
