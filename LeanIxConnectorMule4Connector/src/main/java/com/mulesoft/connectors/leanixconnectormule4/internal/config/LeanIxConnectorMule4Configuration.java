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
package com.mulesoft.connectors.leanixconnectormule4.internal.config;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectors.leanixconnectormule4.internal.connection.provider.TokenConnectionProvider;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.CreateSynchronizationFastRunOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.CreateSynchronizationRunOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunProgressOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunResultsOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunResultsUrlOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunStatusOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunWarningsOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.GetSynchronizationRunsStatusListOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.StartSynchronizationRunOperation;
import com.mulesoft.connectors.leanixconnectormule4.internal.operation.StopSynchronizationRunOperation;
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
public class LeanIxConnectorMule4Configuration extends RestConfiguration {}
