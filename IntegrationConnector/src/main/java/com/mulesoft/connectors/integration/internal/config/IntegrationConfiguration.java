package com.mulesoft.connectors.integration.internal.config;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectors.integration.internal.connection.provider.TokenConnectionProvider;
import com.mulesoft.connectors.integration.internal.operation.CreateSynchronizationFastRunOperation;
import com.mulesoft.connectors.integration.internal.operation.CreateSynchronizationRunOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunProgressOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunResultsOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunResultsUrlOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunStatusOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunWarningsOperation;
import com.mulesoft.connectors.integration.internal.operation.GetSynchronizationRunsStatusListOperation;
import com.mulesoft.connectors.integration.internal.operation.StartSynchronizationRunOperation;
import com.mulesoft.connectors.integration.internal.operation.StopSynchronizationRunOperation;
import org.mule.runtime.extension.api.annotation.Configuration;
import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;

@Configuration
@Operations({
  GetSynchronizationRunsStatusListOperation.class,
  CreateSynchronizationRunOperation.class,
  StartSynchronizationRunOperation.class,
  GetSynchronizationRunProgressOperation.class,
  StopSynchronizationRunOperation.class,
  GetSynchronizationRunStatusOperation.class,
  GetSynchronizationRunResultsOperation.class,
  GetSynchronizationRunResultsUrlOperation.class,
  GetSynchronizationRunWarningsOperation.class,
  CreateSynchronizationFastRunOperation.class
})
@ConnectionProviders({TokenConnectionProvider.class})
public class IntegrationConfiguration extends RestConfiguration {}
