/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author jpfreire
 */
public class Curso {

    private int     cod;
    private String  nome;
    private int     cargaH;

    public Curso(int cod, String nome, int cargaH) {
        this.cod = cod;
        this.nome = nome;
        this.cargaH = cargaH;
    }

    public Curso() {
        this.cod = -1;
        this.nome = "";
        this.cargaH = -1;
    }

    /**
     * @return the cod
     */
    public int getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(int cod) {
        this.cod = cod;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cargaH
     */
    public int getCargaH() {
        return cargaH;
    }

    /**
     * @param cargaH the cargaH to set
     */
    public void setCargaH(int cargaH) {
        this.cargaH = cargaH;
    }
}
