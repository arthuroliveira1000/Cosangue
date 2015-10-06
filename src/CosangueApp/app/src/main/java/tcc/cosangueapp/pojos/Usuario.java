package tcc.cosangueapp.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;

// To ignore any unknown properties in JSON input without exception:
@JsonIgnoreProperties(ignoreUnknown = true)
public class Usuario implements Serializable {

    private Long ID;
    private String nome;
    private String sexo;
    private int idade;
    private String senha;
    private String login;

    public Usuario() {
        super();
    }


    /*  private Endereco endereco;

      private Collection<Evento> evento;

      private Collection<Doacao> doacao;

      private Collection<Comentario> comentario;

      private TipoSanguineo tipo;

      public Usuario() {
          super();
      }
**/
      public Usuario(String nome, String sexo, int idade,
                     String login, String senha) {
          super();
          this.nome = nome;
          this.sexo = sexo;
          this.idade = idade;
          this.login = login;
          this.senha = senha;
      }

      public Usuario(String nome) {
          super();
          this.nome = nome;
      }

      public Usuario(Long ID) {
          super();
          this.ID = ID;
      }
/**    public Usuario(String nome, String sobrenome, String sexo, int idade,
                     String senha, String login, Endereco endereco,
                     Collection<Evento> evento, Collection<Doacao> doacao,
                     Collection<Comentario> comentario, TipoSanguineo tipo) {
          super();
          this.nome = nome;
          this.sobrenome = sobrenome;
          this.sexo = sexo;
          this.idade = idade;
          this.senha = senha;
          this.login = login;
          this.endereco = endereco;
          this.evento = evento;
          this.doacao = doacao;
          this.comentario = comentario;
          this.tipo = tipo;
      }

      public Long getID() {
          return ID;
      }

      public void setID(Long iDUsuario) {
          this.ID = iDUsuario;
      }



      public String getSobrenome() {
          return sobrenome;
      }

      public void setSobrenome(String sobrenome) {
          this.sobrenome = sobrenome;
      }

      public void setSenha(String senha) {
          this.senha = senha;
      }

      public void setLogin(String login) {
          this.login = login;
      }

      public String getSenha() {
          return senha;
      }

      public String getLogin() {
          return login;
      }

      public Usuario(String login, String senha) {
          this.login = login;
          this.senha = senha;
      }
  */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iDUsuario) {
        this.ID = iDUsuario;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
