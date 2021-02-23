package com.ciq.application.request;

import java.util.Set;

public class BookSeatsRequest {
    private Integer id;
    private Set<Integer> bookSeats;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public Set<Integer> getBookSeats()
    {
        return bookSeats;
    }

    public void setBookSeats(Set<Integer> bookSeats)
    {
        this.bookSeats = bookSeats;
    }
}
