/*
 * Copyright (c) 2007-2014 Concurrent, Inc. All Rights Reserved.
 *
 * Project and contact information: http://www.cascading.org/
 *
 * This file is part of the Cascading project.
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

package cascading.tuple;

/**
 * The Hasher allows a {@link java.util.Comparator} implementation to also be delegated to during hashCode generation
 * during grouping partitioning.
 * <p/>
 * If a Comparator is used to compare two types during grouping, its likely the {@code hashCode} value between
 * the two objects will not be consistent. This allows to objects being equal to hash to the same bucket (reducer)
 * during partitioning.
 */
public interface Hasher<V>
  {
  /**
   * Return the hashCode of the given value.
   *
   * @param value will never be null
   * @return int hashCode of given value
   */
  int hashCode( V value );
  }
