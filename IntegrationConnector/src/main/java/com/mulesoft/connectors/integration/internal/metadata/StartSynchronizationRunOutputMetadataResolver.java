package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;

public class StartSynchronizationRunOutputMetadataResolver extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/get-synchronization-runs-status-list-output-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "start-synchronization-run-type-resolver";
  }
}
