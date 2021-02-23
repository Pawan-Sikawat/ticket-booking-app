package com.ciq.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cinema_city_mapping")
public class CinemaCityMapping {
    private Integer id;
    private Cinema cinema;
    private City city;

    @Id
	@Column(name = "id")
	@GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

    @Column(name = "cinema")
    public Cinema getCinema()
    {
        return cinema;
    }

    public void setCinema(Cinema cinema)
    {
        this.cinema = cinema;
    }

    @Column(name = "city")
    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }
}
