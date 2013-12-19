/**
 * Copyright (c) 2012-2013, JCabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.github;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;
import com.rexsl.test.Request;
import javax.json.JsonObject;
import javax.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

/**
 * Github users.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id$
 * @since 0.4
 * @todo #1 Unit test for GhUsers is required. Let's mock
 *  request using Mockito or com.rexsl.test.request.FakeRequest, and make
 *  sure that the class can do its key operations.
 */
@Immutable
@Loggable(Loggable.DEBUG)
@EqualsAndHashCode(of = { "ghub", "request" })
final class GhUsers implements Users {

    /**
     * API entry point.
     */
    private final transient Request entry;

    /**
     * Github.
     */
    private final transient Github ghub;

    /**
     * RESTful request.
     */
    private final transient Request request;

    /**
     * Public ctor.
     * @param github Github
     * @param req Request
     */
    GhUsers(final Github github, final Request req) {
        this.entry = req;
        this.ghub = github;
        this.request = this.entry.uri().path("/users").back();
    }

    @Override
    public String toString() {
        return this.request.uri().get().toString();
    }

    @Override
    public Github github() {
        return this.ghub;
    }

    @Override
    public User self() {
        return new GhUser(this.ghub, this.entry, "");
    }

    @Override
    public User get(@NotNull(message = "login can't be NULL")
        final String login) {
        return new GhUser(this.ghub, this.entry, login);
    }

    @Override
    public Iterable<User> iterate(@NotNull(message = "login is never NULL")
        final String login) {
        return new GhPagination<User>(
            this.request.uri().queryParam("since", login).back(),
            new GhPagination.Mapping<User>() {
                @Override
                public User map(final JsonObject object) {
                    return GhUsers.this.get(object.getString("login"));
                }
            }
        );
    }

}
