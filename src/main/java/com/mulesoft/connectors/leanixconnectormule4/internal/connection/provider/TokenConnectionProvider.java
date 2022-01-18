/**
 * Copyright 2022, LeanIX GmbH
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
package com.mulesoft.connectors.leanixconnectormule4.internal.connection.provider;

import com.mulesoft.connectivity.rest.commons.api.connection.MandatoryTlsParameterGroup;
import com.mulesoft.connectivity.rest.commons.api.connection.TlsParameterGroup;
import com.mulesoft.connectivity.rest.commons.api.connection.oauth.BaseClientCredentialsConnectionProvider;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.connectivity.oauth.ClientCredentials;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.connectivity.NoConnectivityTest;

@Alias("token")
@DisplayName("Token Connection Provider")
@ClientCredentials(tokenUrl = "/services/mtm/v1/oauth2/token", defaultScopes = "")
public class TokenConnectionProvider extends BaseClientCredentialsConnectionProvider
    implements NoConnectivityTest {
  /** @return the base uri of the REST API being consumed */
  @DisplayName("Base Uri")
  @Summary("Parameter base URI, each instance/tenant gets its own")
  @Parameter
  @Optional(defaultValue = "https:///services/integration-api/v1")
  private String baseUri;

  /**
   * {@link MandatoryTlsParameterGroup} references to a TLS config element. This will enable HTTPS
   * for this config.
   */
  @ParameterGroup(name = "tls")
  private MandatoryTlsParameterGroup tlsConfig;

  /** @return the base uri of the REST API being consumed */
  @Override
  public String getBaseUri() {
    return this.baseUri;
  }

  /**
   * {@link TlsParameterGroup} that configures TLS for this connection.
   *
   * @return an optional {@link TlsParameterGroup}
   */
  @Override
  public java.util.Optional<TlsParameterGroup> getTlsConfig() {
    return java.util.Optional.ofNullable(this.tlsConfig);
  }
}
