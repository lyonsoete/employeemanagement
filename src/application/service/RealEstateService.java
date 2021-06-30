package application.service;

import application.entity.RealEstate;
import application.repository.RealEstateRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class RealEstateService {

	private final RealEstateRepository realEstateRepository = new RealEstateRepository();

	public ObservableList<RealEstate> getList() {
		ObservableList<RealEstate> realEstatesObs = FXCollections.observableArrayList();
		realEstatesObs.addAll(realEstateRepository.getList());
		return realEstatesObs;
	}

	public void saveOrUpdate(RealEstate realEstate) {
		realEstateRepository.saveOrUpdate(realEstate);
	}

	public void delete(RealEstate id) {
		realEstateRepository.delete(id);
	}
}
