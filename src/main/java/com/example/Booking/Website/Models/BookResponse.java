package com.example.Booking.Website.Models;

import jakarta.persistence.Id;

public class BookResponse {

    private int responseId;
    private String responsebook;
    private String bookType;

    public int getResponseId() {
        return responseId;
    }

    public void setResponseId(int responseId) {
        this.responseId = responseId;
    }

    public String getResponsebook() {
        return responsebook;
    }

    public void setResponsebook(String responsebook) {
        this.responsebook = responsebook;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public BookResponse(int responseId, String responsebook, String bookType) {
        this.responseId = responseId;
        this.responsebook = responsebook;
        this.bookType = bookType;
    }
}
