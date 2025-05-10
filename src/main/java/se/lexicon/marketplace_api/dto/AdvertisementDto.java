package se.lexicon.marketplace_api.dto;

import java.time.LocalDate;

public record AdvertisementDto(int id, String title, String description, LocalDate expirationDate) {

}
