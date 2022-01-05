/**
 * Copyright 2021, LeanIX GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mulesoft.connectors.leanixconnectormule4.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.BaseRestOperation;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.EntityRequestParameters;
import com.mulesoft.connectivity.rest.commons.api.operation.HttpResponseAttributes;
import com.mulesoft.connectivity.rest.commons.internal.util.RestRequestBuilder;
import com.mulesoft.connectors.leanixconnectormule4.internal.metadata.CreateSynchronizationRunInputMetadataResolver;
import com.mulesoft.connectors.leanixconnectormule4.internal.metadata.CreateSynchronizationRunOutputMetadataResolver;
import java.io.InputStream;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.metadata.TypeResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.extension.api.runtime.streaming.StreamingHelper;
import org.mule.runtime.http.api.HttpConstants;

public class CreateSynchronizationRunOperation extends BaseRestOperation {
  private static final String OPERATION_PATH = "/synchronizationRuns";

  private static final RestRequestBuilder.QueryParamFormat QUERY_PARAM_FORMAT =
      RestRequestBuilder.QueryParamFormat.MULTIMAP;

  public CreateSynchronizationRunOperation() {}

  /**
   * Creates a synchronization run.
   *
   * <p>This operation makes an HTTP POST request to the /synchronizationRuns endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param startQueryParam If true the created run will be enqueued to be started
   * @param testQueryParam If true a dry run without any changes will be performed. This parameter
   *     requires the start parameter to be set to true as well
   * @param createSynchronizationRunBody the content to use
   * @param parameters the {@link EntityRequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param streamingHelper the {@link StreamingHelper}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Synchronization Run")
  @Summary("Creates a synchronization run.")
  @MediaType("application/json")
  @OutputResolver(output = CreateSynchronizationRunOutputMetadataResolver.class)
  public void createSynchronizationRun(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional(defaultValue = "false")
          @DisplayName("start")
          @Summary("If true the created run will be enqueued to be started")
          boolean startQueryParam,
      @Optional(defaultValue = "false")
          @DisplayName("test")
          @Summary(
              "If true a dry run without any changes will be performed. This parameter requires the start parameter to be set to true as well")
          boolean testQueryParam,
      @Content(primary = true)
          @DisplayName("Body")
          @TypeResolver(CreateSynchronizationRunInputMetadataResolver.class)
          TypedValue<InputStream> createSynchronizationRunBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) EntityRequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      StreamingHelper streamingHelper,
      CompletionCallback<InputStream, HttpResponseAttributes> callback) {
    RestRequestBuilder builder =
        new RestRequestBuilder(
                connection.getBaseUri(), OPERATION_PATH, HttpConstants.Method.POST, parameters)
            .setQueryParamFormat(QUERY_PARAM_FORMAT)
            .addHeader("content-type", "application/json")
            .addHeader("accept", "application/json")
            .addQueryParam("start", startQueryParam)
            .addQueryParam("test", testQueryParam)
            .setBody(createSynchronizationRunBody, overrides.getStreamingType());
    doRequest(
        config,
        connection,
        builder,
        overrides.getResponseTimeoutAsMillis(),
        streamingHelper,
        callback);
  }
}
