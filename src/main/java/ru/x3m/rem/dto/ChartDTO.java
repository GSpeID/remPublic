package ru.x3m.rem.dto;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Date;


public enum ChartDTO {
    ;

    private interface testId {
        @Positive Long getTestId();
    }

    private interface testDescription {
        @NotBlank String getTestDescription();
    }

    private interface testPrice {
        @Positive Double getTestPrice();
    }

    private interface testDate {
        @NotBlank Date getTestDate();
    }


    public enum Request {
        ;

        @Value
        public static class Create implements testId, testDescription, testPrice, testDate {
            Long testId;
            String testDescription;
            Double testPrice;
            Date testDate;

        }
    }

    public enum Response {
        ;

        @Value
        public static class Public implements testDescription {
            String testDescription;
        }

        @Value
        public static class Private implements testId, testDescription, testPrice, testDate {
            Long testId;
            String testDescription;
            Double testPrice;
            Date testDate;

        }
    }

}
