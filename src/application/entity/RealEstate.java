package application.entity;

import application.Enums.ObjectTypes;

import javax.persistence.*;

@Entity
@Table(name = "real_estate")
public class RealEstate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "object_number")
  private String objectNumber;

  @Column(name = "object_type")
  private ObjectTypes objectType;

  @Column(name = "object_description")
  private String objectDescription;

  @ManyToOne(cascade = CascadeType.ALL)
  private Address address;

  @Column(name = "square_meters")
  private double squareMeters;

  @Column(name = "square_meter_price_cold")
  private double squareMeterPriceCold;

  @Column(name = "additional_costs")
  private double additionalCosts;

  @Column(name = "notes")
  private String notes;

  public RealEstate(int id, String objectNumber, ObjectTypes objectType, String objectDescription, Address address, double squareMeters, double squareMeterPriceCold, double additionalCosts, String notes) {
    this.id = id;
    new RealEstate(objectNumber, objectType, objectDescription, address, squareMeters, squareMeterPriceCold, additionalCosts, notes);
  }

  public RealEstate(String objectNumber, ObjectTypes objectType, String objectDescription, Address address, double squareMeters, double squareMeterPriceCold, double additionalCosts, String notes) {
    this.objectNumber = objectNumber;
    this.objectType = objectType;
    this.objectDescription = objectDescription;
    this.address = address;
    this.squareMeters = squareMeters;
    this.squareMeterPriceCold = squareMeterPriceCold;
    this.additionalCosts = additionalCosts;
    this.notes = notes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getObjectNumber() {
    return objectNumber;
  }

  public void setObjectNumber(String objectNumber) {
    this.objectNumber = objectNumber;
  }

  public ObjectTypes getObjectType() {
    return objectType;
  }

  public void setObjectType(ObjectTypes objectType) {
    this.objectType = objectType;
  }

  public String getObjectDescription() {
    return objectDescription;
  }

  public void setObjectDescription(String objectDescription) {
    this.objectDescription = objectDescription;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public double getSquareMeters() {
    return squareMeters;
  }

  public void setSquareMeters(double squareMeters) {
    this.squareMeters = squareMeters;
  }

  public double getSquareMeterPriceCold() {
    return squareMeterPriceCold;
  }

  public void setSquareMeterPriceCold(double squareMeterPriceCold) {
    this.squareMeterPriceCold = squareMeterPriceCold;
  }

  public double getAdditionalCosts() {
    return additionalCosts;
  }

  public void setAdditionalCosts(double additionalCosts) {
    this.additionalCosts = additionalCosts;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}
