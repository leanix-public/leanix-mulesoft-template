package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;

public class GetSynchronizationRunStatusOutputMetadataResolver extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/get-synchronization-run-status-output-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "get-synchronization-run-status-type-resolver";
  }
}
