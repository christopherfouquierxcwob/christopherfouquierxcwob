/*
 *  Copyright 2020 Huawei Technologies Co., Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.edgegallery.mecm.appo.repository;

import java.util.List;
import org.edgegallery.mecm.appo.model.AppInstanceInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AppInstanceInfoRepository extends CrudRepository<AppInstanceInfo, String> {

    @Query(value = "SELECT * FROM appinstanceinfo m WHERE m.tenant=:tenant", nativeQuery = true)
    List<AppInstanceInfo> findByTenantId(@Param("tenant") String tenant);

    @Query(value = "SELECT * FROM appinstanceinfo m WHERE m.mec_host=:mec_host", nativeQuery = true)
    List<AppInstanceInfo> findByMecHost(@Param("mec_host") String mec_host);

    @Query(value = "SELECT * FROM appinstanceinfo m WHERE m.tenant=:tenant and m.app_instance_id=:app_instance_id",
            nativeQuery = true)
    AppInstanceInfo findByTenantIdAndAppInstanceId(@Param("tenant") String tenant,
                                                   @Param("app_instance_id") String appInstanceId);

    @Query(value = "SELECT * FROM appinstanceinfo m WHERE m.tenant=:tenant and m.mec_host=:mec_host",
            nativeQuery = true)
    List<AppInstanceInfo> findByTenantIdAndMecHost(@Param("tenant") String tenant,
                                                   @Param("mec_host") String mecHost);

    @Query(value = "SELECT * FROM appinstanceinfo m WHERE m.tenant=:tenant and m.app_package_id=:app_package_id"
            + " and m.app_id=:app_id", nativeQuery = true)
    List<AppInstanceInfo> findByTenantIdAndAppIdPackageId(@Param("tenant") String tenant,
                                                   @Param("app_package_id") String pkgId,
                                                   @Param("app_id") String appId);
}
