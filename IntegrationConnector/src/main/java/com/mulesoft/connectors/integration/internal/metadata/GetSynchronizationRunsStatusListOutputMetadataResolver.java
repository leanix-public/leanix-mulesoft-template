package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;

public class GetSynchronizationRunsStatusListOutputMetadataResolver
    extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/get-synchronization-runs-status-list-output-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "get-synchronization-runs-status-list-type-resolver";
  }
}
