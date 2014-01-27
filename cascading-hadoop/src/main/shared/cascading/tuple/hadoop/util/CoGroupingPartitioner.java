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

package cascading.tuple.hadoop.util;

import cascading.tuple.Tuple;
import cascading.tuple.io.IndexTuple;
import org.apache.hadoop.mapred.Partitioner;

/** Class GroupingPartitioner is an implementation of {@link org.apache.hadoop.mapred.Partitioner}. */
public class CoGroupingPartitioner extends HasherPartitioner implements Partitioner<IndexTuple, Tuple>
  {
  public int getPartition( IndexTuple key, Tuple value, int numReduceTasks )
    {
    return ( hashCode( key.getTuple() ) & Integer.MAX_VALUE ) % numReduceTasks;
    }
  }