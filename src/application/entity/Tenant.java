package application.entity;

import javax.persistence.*;

@Entity
@Table(name = "tenant")
public class Tenant {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;

  @Column(name = "size")
  private double size;

  @Column(name = "rent")
  private double rent;

  public Tenant(double size, double rent) {
    this.size = size;
    this.rent = rent;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getSize() {
    return size;
  }

  public void setSize(double size) {
    this.size = size;
  }

  public double getRent() {
    return rent;
  }

  public void setRent(double rent) {
    this.rent = rent;
  }
}
