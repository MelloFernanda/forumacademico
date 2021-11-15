package com.example.forum.controller.form.confg.validacao;

public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }
    public String getErro() {
        return erro;
    }
}
