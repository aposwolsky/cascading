/*
 * Copyright (c) 2007-2011 Concurrent, Inc. All Rights Reserved.
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

package cascading.flow;

import java.util.List;

import cascading.flow.planner.FlowStep;

/**
 * The FlowStepStrategy interface allows for on the fly customization of {@link FlowStep} configuration values
 * before they are submitted to the underlying platform.
 * <p/>
 * Use a strategy instance to change the display name for a job, or in the case of Hadoop, the number of
 * mapper or reducer instances.
 * <p/>
 * Note, to change the configuration information, {@link cascading.flow.planner.FlowStep#getConf()} must be
 * called to get access to the current configuration. Calling {@link FlowStep#setName(String)} would have no effect.
 * <p/>
 * If any, the completed predecessor steps are provided so that the predecessors can be inspected via the
 * {@link cascading.stats.FlowStepStats} interface for any information that may influence the current job.
 * <p/>
 * It is also possible to block submission of the job by blocking in this method.
 */
public interface FlowStepStrategy<Config>
  {
  void apply( Flow<Config> flow, List<FlowStep<Config>> predecessorSteps, FlowStep<Config> flowStep );
  }
