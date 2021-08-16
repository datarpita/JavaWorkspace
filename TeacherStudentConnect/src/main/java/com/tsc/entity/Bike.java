package com.tsc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Bike {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long bikeId;
	
	@Column
    private String name;
	@Column
    private String model;
	
	public Bike() {
		
	}
	
	public Bike(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public long getBikeId() {
		return bikeId;
	}

	public void setBikeId(long bikeId) {
		this.bikeId = bikeId;
	}	

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public String toString() {
        return "Bike{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
