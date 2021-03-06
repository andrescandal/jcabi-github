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
package com.jcabi.github.mock;

import com.jcabi.github.Release;
import com.jcabi.github.ReleaseAsset;
import java.io.IOException;
import javax.json.JsonObject;

/**
 * Mock Github release asset.
 * @author Carlos Miranda (miranda.cma@gmail.com)
 * @version $Id$
 * @since 0.8
 * @todo #282 Mock for release asset. Let's implements Mock for ReleaseAsset
 *  using MkStorage. Don't forget about @EqualsAndHashCode and include unit
 *  tests.
 */
public final class MkReleaseAsset implements ReleaseAsset {

    @Override
    public JsonObject json() throws IOException {
        throw new UnsupportedOperationException("Json yet implemented.");
    }

    @Override
    public void patch(final JsonObject json) throws IOException {
        throw new UnsupportedOperationException("Patch not yet implemented.");
    }

    @Override
    public Release release() {
        throw new UnsupportedOperationException("Release not yet implemented.");
    }

    @Override
    public int number() {
        throw new UnsupportedOperationException("Number not yet implemented.");
    }

    @Override
    public void remove() throws IOException {
        throw new UnsupportedOperationException("Remove not yet implemented.");
    }

}
