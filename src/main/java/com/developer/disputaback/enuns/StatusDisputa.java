package com.developer.disputaback.enuns;

import lombok.Getter;

@Getter
public enum StatusDisputa {
    ABERTO("A", "Disputa em Aberto"),
       CONCLUIDO("C", "Disputa Concluída");

    private final String codigo;
    private final String descricao;

    StatusDisputa(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    // Método essencial para converter o código do banco de volta para o Enum
    public static StatusDisputa deCodigo(String codigo) {
        if (codigo == null) return null;
        for (StatusDisputa status : values()) {
            if (status.getCodigo().equals(codigo)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Código inválido para StatusDisputa: " + codigo);
    }
}
