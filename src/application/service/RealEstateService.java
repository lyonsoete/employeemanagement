package application.service;

import application.Enums.ObjectTypes;
import application.entity.Address;
import application.entity.RealEstate;
import application.repository.RealEstateRepository;

public class RealEstateService {

  private final RealEstateRepository realEstateRepository = new RealEstateRepository();

  public void createRealEstate() {
    realEstateRepository.createRealEstate(new RealEstate("OBJ_1", ObjectTypes.PRIVATE, "first object", new Address("teststreet", 22, 50672, "Koeln"), 45.5, 8.7, 150, "notes"));
  }
}
