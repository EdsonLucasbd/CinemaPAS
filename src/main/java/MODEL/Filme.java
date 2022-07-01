/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author Jorge
 */
public class Filme {
    
    private int codFilme;
    private String titulo;
    private String genero;
    private String sinopse;
    private String diretor;
    private String atorPrincipal;
    private int ano;
    private String clasIndicativa;
    private int duracao;

    
    public Filme(int codFilme, String titulo, String genero, String sinopse, String diretor, String atorPrincipal, int ano, String clasIndicativa, int duracao){
        this.codFilme = codFilme;
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.atorPrincipal = atorPrincipal;
        this.ano = ano;
        this.clasIndicativa = clasIndicativa;
        this.duracao = duracao;
    }
    
    public Filme(String titulo, String genero, String sinopse, String diretor,String atorPrincipal, int ano, String clasIndicativa, int duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.sinopse = sinopse;
        this.diretor = diretor;
        this.atorPrincipal = atorPrincipal;
        this.ano = ano;
        this.clasIndicativa = clasIndicativa;
        this.duracao = duracao;
    }
    
    public Filme(){
    }
    
    public int getCodFilme(){
        return codFilme;
    }
    
    /**
     * Definir código do filme.
     * @param codFilme 
     */
    public void setCodFilme(int codFilme){
        this.codFilme = codFilme;
    }
    
    /**
     * Obter título do filme.
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Definir título do filme.
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obter gênero do filme.
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Definir gênero do filme.
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obter sinopse do filme.
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * Definir sinopse do filme.
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * Obter diretor do filme.
     * @return the diretor
     */
    public String getDiretor() {
        return diretor;
    }

    /**
     * Definir diretor do filme.
     * @param diretor the diretor to set
     */
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public String getAtorPrincipal(){
        return atorPrincipal;
    }
    
    public void setAtorPrincipal(String atorPrincipal){
        this.atorPrincipal = atorPrincipal;
    }

    /**
     * Obter ano de lançamento do filme.
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Definir ano de lançamento do filme.
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Obter classificação indicativa do filme.
     * @return the clasIndicativa
     */
    public String getClasIndicativa() {
        return clasIndicativa;
    }

    /**
     * Definir classificação indicativa do filme.
     * @param clasIndicativa the clasIndicativa to set
     */
    public void setClasIndicativa(String clasIndicativa) {
        this.clasIndicativa = clasIndicativa;
    }

    /**
     * Obter duração do filme (em minutos).
     * @return the duracao
     */
    public int getDuracao() {
        return duracao;
    }

    /**
     * Definir duração do filme (em minutos).
     * @param duracao the duracao to set
     */
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }    
    
    
}
