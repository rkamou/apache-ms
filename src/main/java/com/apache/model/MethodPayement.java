package com.apache.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class MethodPayement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long methodPayementId;

    String completeNameOnCard;
    String cardNumber;
    LocalDate expDate;
    String csvCode;

    public MethodPayement(){

    }

    public long getMethodPayementId() {
        return methodPayementId;
    }

    public void setMethodPayementId(long methodPayementId) {
        this.methodPayementId = methodPayementId;
    }

    public String getCompleteNameOnCard() {
        return completeNameOnCard;
    }

    public void setCompleteNameOnCard(String completeNameOnCard) {
        this.completeNameOnCard = completeNameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public String getCsvCode() {
        return csvCode;
    }

    public void setCsvCode(String csvCode) {
        this.csvCode = csvCode;
    }
}
