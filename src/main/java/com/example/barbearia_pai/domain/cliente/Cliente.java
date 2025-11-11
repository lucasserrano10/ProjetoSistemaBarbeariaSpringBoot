package com.example.barbearia_pai.domain.cliente;

import com.example.barbearia_pai.domain.endereco.Endereco;
import com.example.barbearia_pai.dto.cliente.InfosCadastroCliente;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Email(message = "E-mail inválido")
    @NotBlank(message = "O e-mail é obrigatório")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos (DDD + número)")
    private String telefone;

    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    public Cliente(@Valid InfosCadastroCliente infos) {
        this.nome = infos.nome();
        this.email = infos.email();
        this.telefone = infos.telefone();
        this.endereco = new Endereco(
                infos.endereco().logradouro(),
                infos.endereco().bairro(),
                infos.endereco().cep(),
                infos.endereco().numero(),
                infos.endereco().complemento(),
                infos.endereco().cidade(),
                infos.endereco().estado()
        );
    }

    public Long getId() {
        return id;
    }

    public @NotBlank(message = "O nome é obrigatório") String getNome() {
        return nome;
    }

    public @Email(message = "E-mail inválido") @NotBlank(message = "O e-mail é obrigatório") String getEmail() {
        return email;
    }

    public @NotBlank(message = "O telefone é obrigatório") @Pattern(regexp = "\\d{11}", message = "O telefone deve conter 11 dígitos (DDD + número)") String getTelefone() {
        return telefone;
    }

    public @Valid Endereco getEndereco() {
        return endereco;
    }

    public Cliente(){

    }

    public Cliente(Long id) {
        this.id = id;
    }
}