package com.example.barbearia_pai.domain.barbeiro;

import com.example.barbearia_pai.domain.endereco.Endereco;
import com.example.barbearia_pai.dto.InfosCadastroBarbeiro;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Barbeiro {

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

    private String especialidade;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;


    public Barbeiro(@Valid InfosCadastroBarbeiro infos) {
        this.nome = infos.nome();
        this.email = infos.email();
        this.telefone = infos.telefone();
        this.especialidade = infos.especialidade();
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

    public String getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}