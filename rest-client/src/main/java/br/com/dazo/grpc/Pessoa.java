package br.com.dazo.grpc;

public class Pessoa {

    private Integer id;

    private String nome;

    private String login;

    private String cpf;

    private String email;

    public Pessoa(){
    }

    public Pessoa(String nome, String cpf, String email, String login) {
        setNome(nome);
        setCpf(cpf);
        setEmail(email);
        setLogin(login);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
