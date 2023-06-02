package com.example.proyecto_iweb.models.beans;

import java.sql.Blob;

public class Cuentas {

    private int idCuentas;
    private String nombre;
    private String apellido;
    private String nickname;
    private String direcion;
    private String correo;
    private String contrasenia;
    private Blob foto;
    private String descripcion;
    private Boolean desabilitado;

    public int getIdCuentas() {
        return idCuentas;
    }

    public void setIdCuentas(int idCuentas) {
        this.idCuentas = idCuentas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getDesabilitado() {
        return desabilitado;
    }

    public void setDesabilitado(Boolean desabilitado) {
        this.desabilitado = desabilitado;
    }
}
