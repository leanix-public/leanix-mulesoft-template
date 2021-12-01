package com.mulesoft.connectors.integration.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;

public class GetSynchronizationRunResultsUrlOutputMetadataResolver
    extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/schemas/get-synchronization-run-results-url-output-schema.json";
  }

  @Override
  public String getCategoryName() {
    return "get-synchronization-run-results-url-type-resolver";
  }
}
