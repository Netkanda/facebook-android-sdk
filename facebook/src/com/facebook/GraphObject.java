/**
 * Copyright 2010 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.facebook;

import java.util.Map;

import org.json.JSONObject;

/**
 * GraphObject is the primary interface used by the Facebook SDK for Android to represent objects in the Facebook
 * Social Graph and the Facebook Open Graph (OG). It is the base interface for all typed access to graph objects
 * in the SDK. No concrete classes implement GraphObject or its derived interfaces. Rather, they are implemented as
 * proxies (see the {@link GraphObjectWrapper GraphObjectWrapper} class) that provide strongly-typed property
 * getters and setters to access the underlying data. Since the primary use case for graph objects is sending and
 * receiving them over the wire to/from Facebook services, they are represented as JSONObjects. No validation is done
 * that a graph object is actually of a specific type -- any graph object can be treated as any GraphObject-derived
 * interface, and the presence or absence of specific properties determines its suitability for use as that
 * particular type of object.
 * <br/>
 */
public interface GraphObject extends Map<String,Object> {
    /**
     * Returns a new proxy that treats this graph object as a different GraphObject-derived type.
     * @param graphObjectClass the type of GraphObject to return
     * @return a new instance of the GraphObject-derived-type that references the same underlying data
     */
    public <T extends GraphObject> T cast(Class<T> graphObjectClass);
    /**
     * Gets the underlying JSONObject representation of this graph object.
     * @return the underlying JSONObject representation of this graph object
     */
    public JSONObject getInnerJSONObject();
}
