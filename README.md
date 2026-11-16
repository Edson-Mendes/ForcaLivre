# Força Livre Manager

Sistema para auxiliar o box de treinamento funcional **Força Livre** a controlar alunos, planos, aulas, reservas e presença.

Projeto desenvolvido por Edson Mendes e Igor Santos na disciplina Linguagem de Programação Orientada a Objetos.

## Requisitos funcionais
- Cadastrar aluno
- Consultar plano
- Cadastrar modalidade
- Cadastrar Instrutor
- Cadastrar aula
- Listar alunos
- Listar planos
- Listar cadastros

## Diagrama de classes

```mermaid
classDiagram
    class Pessoa {
        -String nome
        -int id
        
        +Pessoa(nome, id)
        +getID() int
        +getNome() String
    }   
    
    class Aluno {
        +Aluno(id, nome, plano)
        +getPlano() Plano
        +setPlano(Plano plano) void
    }

    class Instrutor {
        +Instrutor(nome, id)
    }

    class Plano {
        -int id
        -String nome
        -int duracao
        
        +Plano(id, nome, duracao)
        +getId() int
        +getNome() String
        +getDuracao() int
    }

    class Aula {
        -int id
        -int capacidade
        -LocalDateTime horario

        +Aula(id, modalidade, instrutor, horario, capacidade)
        +getId() int
        +getCapacidade() int
        +getHorario() LocalDateTime
        +getModalidade() Modalidade
        +getInstrutor() Instrutor
    }

    class Reserva {
        -int id
        -boolean presente
        
        +Reserva(id, aluno, aula)
        +getId() int
        +getPresente() int
        +getAluno() Aluno
        +getAula() Aula
        +registrarPresenca() void
    }

    class Modalidade {
        -int id
        -String nome
        -String descricao
        
        +Modalidade(id, nome, descricao)
        +getId() int
        +getNome() String
        +getDescricao() String
    }
    
    class Gerenciavel {
        <<interface>>
        
        +cadAluno(Aluno aluno) void
        +cadPlano(Plano plano) void
        +cadModalidade(Modalidade modalidade) void
        +cadInstrutor(Instrutor instrutor) void
        +cadAula(Aula aula) void
        +listarAlunos() List<Aluno> 
        +listarPlanos() List<Plano> 
        +listarModalidades() List<Modalidade> 
        +listarInstrutores() List<Instrutor> 
        +listarAulas()  List<Aula>
    }
    
    class Sistema {
        +listarReservas() List
        +buscarPlano() Plano
        +buscarModalidade() Modalidade
        +buscarInstrutor() Instrutor
    }
    
    Pessoa <|-- Aluno
    Pessoa <|-- Instrutor
    Aluno "*" -- "1" Plano
    Reserva "*" -- "1" Aluno
    Reserva "*" -- "1" Aula
    Aula "*" -- "1" Modalidade
    Aula "*" -- "1" Instrutor
    Sistema --|> Gerenciavel
    Sistema "1..1" -- "*" Aluno 
    Sistema "1..1" -- "*" Instrutor
    Sistema "1..1" -- "*" Plano
    Sistema "1..1" -- "*" Aula
    Sistema "1..1" -- "*" Modalidade
    Sistema "1..1" -- "*" Reserva
```
