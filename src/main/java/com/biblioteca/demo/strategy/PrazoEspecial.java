package com.biblioteca.demo.strategy;

import org.springframework.stereotype.Component;

@Component
public class PrazoEspecial implements PrazoDevolucaoStrategy {

    @Override
    public int getPrazoEmDias() {
        return 14;
    }
}