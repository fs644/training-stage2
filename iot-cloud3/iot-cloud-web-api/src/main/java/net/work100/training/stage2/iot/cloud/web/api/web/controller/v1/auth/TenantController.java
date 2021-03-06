package net.work100.training.stage2.iot.cloud.web.api.web.controller.v1.auth;

import net.work100.training.stage2.iot.cloud.commons.dto.BaseResult;
import net.work100.training.stage2.iot.cloud.domain.AuthTenant;
import net.work100.training.stage2.iot.cloud.commons.dto.api.auth.TenantDTO;
import net.work100.training.stage2.iot.cloud.web.api.service.AuthTenantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>Title: TenantController</p>
 * <p>Description: </p>
 * <p>Url: http://www.work100.net/training/monolithic-project-iot-cloud-api.html</p>
 *
 * @author liuxiaojun
 * @date 2020-03-01 14:01
 * ------------------- History -------------------
 * <date>      <author>       <desc>
 * 2020-03-01   liuxiaojun     初始创建
 * -----------------------------------------------
 */
@RestController
@RequestMapping(value = "${api.path.v1}/auth/tenant")
public class TenantController {

    @Autowired
    private AuthTenantService authTenantService;

    @RequestMapping(value = "{apiTenantCode}", method = RequestMethod.GET)
    public BaseResult get(@PathVariable(required = true) String apiTenantCode) {
        try {
            TenantDTO tenantDTO = new TenantDTO();
            AuthTenant authTenant = authTenantService.getByKey(apiTenantCode, "");
            if (authTenant != null) {
                BeanUtils.copyProperties(authTenant, tenantDTO);
            }
            return BaseResult.success("操作成功", tenantDTO);
        } catch (Exception ex) {
            return BaseResult.fail("未知错误");
        }
    }

    @RequestMapping(value = "{apiTenantCode}/save", method = RequestMethod.POST)
    public BaseResult save(@PathVariable(required = true) String apiTenantCode, String tenantName, String tenantDesc) {
        try {
            AuthTenant authTenant = new AuthTenant();
            authTenant.setTenantCode(apiTenantCode);
            authTenant.setTenantName(tenantName);
            authTenant.setTenantDesc(tenantDesc);
            return authTenantService.update(apiTenantCode, authTenant);
        } catch (Exception ex) {
            return BaseResult.fail("未知错误");
        }
    }
}
