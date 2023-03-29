package com.example.pickitup.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyCriteria {
    private int pageNum;
    private int amount;

    public CompanyCriteria() {
        this(1, 10);
    }

    public CompanyCriteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
