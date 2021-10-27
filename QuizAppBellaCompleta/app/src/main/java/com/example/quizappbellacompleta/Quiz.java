package com.example.quizappbellacompleta;

public class Quiz {

    private String domanda;
    private String risposta1,risposta2,risposta3,risposta4;
    private int vero;
    private int punteggio=0;

    public Quiz(String domanda, String risposta1, String risposta2, String risposta3, String risposta4, int vero) {
        this.domanda = domanda;
        this.risposta1 = risposta1;
        this.risposta2 = risposta2;
        this.risposta3 = risposta3;
        this.risposta4 = risposta4;
        if(vero>0 && vero<5){
            this.vero = vero;
        }else{
            System.out.println("il valore vero non e nel range");
        }

    }

    public String getDomanda() {
        return domanda;
    }

    public String getRisposta1() {
        return risposta1;
    }

    public String getRisposta2() {
        return risposta2;
    }

    public String getRisposta3() {
        return risposta3;
    }

    public String getRisposta4() {
        return risposta4;
    }

    public int getVero() {
        return vero;
    }

    public boolean vediamoSeCorretta(int x){
        if(x==getVero()){
            punteggio++;
            return true;
        }
        return false;
    }

    public int getPunteggio() {
        return punteggio;
    }
}
