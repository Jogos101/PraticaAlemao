package org.simon.entity;

public class German implements Language {
    public String traduzido;
    public String original;

    public German(String p, String a){
        this.traduzido = p;
        this.original = a;
    }

    @Override
    public String getTrasnlation() {
        return traduzido;
    }

    @Override
    public String getOriginal() {
        return original;
    }
}
