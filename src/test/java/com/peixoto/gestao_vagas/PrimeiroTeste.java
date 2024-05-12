package com.peixoto.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    @Test
    public void deveSerPossivelCalcularDoisNumeros(){
        var result = calculate(2, 3);
        assertEquals(result, 5);
    }

    public static int calculate (int num1, int num2){
        return num1 + num2;
    }
    
}
