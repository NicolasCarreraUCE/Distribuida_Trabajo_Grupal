package com.distribuida.dto;

public record AuthorsDto(Integer id, String firstName, String lastName) {
    @Override
    public String toString() {
        return "AuthorsDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
