/*
 * Copyright 2010 Martin Grotzke
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package de.javakaffee.kryoserializers;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.serialize.SimpleSerializer;

/**
 * A kryo {@link Serializer} for {@link List}s created via {@link Collections#singletonList(Object)}.
 * 
 * @author <a href="mailto:martin.grotzke@javakaffee.de">Martin Grotzke</a>
 */
public class CollectionsSingletonListSerializer extends SimpleSerializer<List<?>> {

    private final Kryo _kryo;
    
    public CollectionsSingletonListSerializer( final Kryo kryo ) {
        _kryo = kryo;
    }
    
    @Override
    public List<?> read( final ByteBuffer buffer ) {
        final Object obj = _kryo.readClassAndObject( buffer );
        return Collections.singletonList( obj );
    }

    @Override
    public void write( final ByteBuffer buffer, final List<?> list ) {
        _kryo.writeClassAndObject( buffer, list.get( 0 ) );
    }

}
