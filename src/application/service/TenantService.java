package application.service;

import application.entity.Tenant;
import application.repository.TenantRepository;

public class TenantService {

	private final TenantRepository tenantRepository = new TenantRepository();

	public void createUser(Tenant tenant){
		tenantRepository.createRealEstate(tenant);
	}
}
