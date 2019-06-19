/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.cluster.client.config;

import com.alibaba.csp.sentinel.config.SentinelConfig;
import com.alibaba.csp.sentinel.log.RecordLog;

/**
 * <p>
 * This class is dedicated to retrieving startup configurations for cluster token client.
 * </p>
 *
 * @author lianglin
 * @since 1.7.0
 */
public final class ClusterClientGlobalConfig {

    public static final int DEFAULT_PARAM_MAX_SIZE = 1024;

    private static final String MAX_PARAM_BYTE_SIZE = "csp.sentinel.cluster.max.param.byte.size";

    /**
     * Get the max bytes params can be serialized
     *
     * @return the max bytes, may be null
     */
    public static Integer getMaxParamByteSize() {
        String maxParamByteSize = SentinelConfig.getConfig(MAX_PARAM_BYTE_SIZE);
        try {
            return maxParamByteSize == null ? null : Integer.valueOf(maxParamByteSize);
        } catch (Exception ex) {
            RecordLog.warn("[ClusterClientGlobalConfig] Failed to parse maxParamByteSize: " + maxParamByteSize);
            return null;
        }
    }

    private ClusterClientGlobalConfig() {}
}