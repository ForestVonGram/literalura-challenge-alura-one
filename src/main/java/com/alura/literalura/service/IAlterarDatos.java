package com.alura.literalura.service;

public interface IAlterarDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
