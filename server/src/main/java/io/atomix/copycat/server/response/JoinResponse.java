/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.copycat.server.response;

import io.atomix.catalyst.serializer.SerializeWith;
import io.atomix.copycat.client.error.RaftError;
import io.atomix.copycat.server.cluster.Member;

import java.util.Collection;

/**
 * Server join configuration change response.
 * <p>
 * Join responses are sent in response to a request to add a server to the cluster configuration. If a
 * configuration change is failed due to a conflict, the response status will be
 * {@link io.atomix.copycat.client.response.Response.Status#ERROR} but the response {@link #error()} will
 * be {@code null}.
 *
 * @author <a href="http://github.com/kuujo">Jordan Halterman</a>
 */
@SerializeWith(id=210)
public class JoinResponse extends ConfigurationResponse {

  /**
   * Returns a new join response builder.
   *
   * @return A new join response builder.
   */
  public static Builder builder() {
    return new Builder(new JoinResponse());
  }

  /**
   * Returns an join response builder for an existing response.
   *
   * @param response The response to build.
   * @return The join response builder.
   */
  public static Builder builder(JoinResponse response) {
    return new Builder(response);
  }

  /**
   * Join response builder.
   */
  public static class Builder extends ConfigurationResponse.Builder {
    protected Builder(JoinResponse response) {
      super(response);
    }

    @Override
    public Builder withStatus(Status status) {
      super.withStatus(status);
      return this;
    }

    @Override
    public Builder withError(RaftError error) {
      super.withError(error);
      return this;
    }

    @Override
    public Builder withMembers(Collection<Member> members) {
      super.withMembers(members);
      return this;
    }

    @Override
    public Builder withIndex(long index) {
      super.withIndex(index);
      return this;
    }

    @Override
    public JoinResponse build() {
      return (JoinResponse) super.build();
    }
  }

}
