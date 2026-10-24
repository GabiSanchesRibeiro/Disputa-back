package com.developer.disputaback.util;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class MoneyConverter extends AbstractBeanField<Double, String> {

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        try {
            // 1. Remove "R$", espaços em branco e pontos de milhar se houver
            String limpo = value.replace("R$", "")
                    .replace(".", "") // remove ponto se for usado para milhar (ex: 1.000,00)
                    .trim();

            // 2. Substitui a vírgula decimal por ponto
            limpo = limpo.replace(",", ".");

            // 3. Converte para Double de forma segura
            return Double.parseDouble(limpo);
        } catch (NumberFormatException e) {
            throw new CsvDataTypeMismatchException("Erro ao converter valor monetário: " + value);
        }
    }
}