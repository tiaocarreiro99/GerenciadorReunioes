/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.controle;

import gerenciadorreunioes.modelo.Aluno;
import gerenciadorreunioes.modelo.AlunoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class AlunoControl {

    private final AlunoDAO alunoDao = new AlunoDAO();
    private ArrayList<Aluno> arrayAlunos = alunoDao.getAlunos();

    public boolean adiciona(Aluno x) {
        return alunoDao.adiciona(x);
    }

    public boolean atualiza(Aluno x, String antMatricula) {
        return alunoDao.atualizar(x.getMatricula(), x.getNome(), x.getEmail(), antMatricula);
    }

    public boolean deleta(String matricula) {
        return alunoDao.deleta(matricula);
    }

    public ArrayList<Aluno> getAlunos() {
        return alunoDao.getAlunos();
    }

    public ArrayList<String> pegaMatriculaNomeAlunos() {
        arrayAlunos = getAlunos();
        ArrayList<String> nomeAlunos = new ArrayList<>();
        for (int i = 0; i < arrayAlunos.size(); i++) {
            nomeAlunos.add(arrayAlunos.get(i).getMatricula() + " - " + arrayAlunos.get(i).getNome());
        }
        return nomeAlunos;
    }

    public String[] retornaNomeEmVetor(ArrayList<Aluno> arrayAluno) {
        String[] arrayString = new String[arrayAluno.size()];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = arrayAluno.get(i).getNome();
        }
        return arrayString;
    }

    public boolean verificaCampos(String text, String text0, String text1) {
        boolean verifica = false;
        if ((text.equals("")) || (text0.equals("")) || (text1.equals(""))) {
            verifica = true;
        }
        return verifica;
    }

    public boolean verificaMatriculaIgual(String mVelha, String mNova) {
        boolean igual = false;
        if (mNova.equals(mVelha)) {
            igual = true;
        }
        return igual;
    }

    public String verificaMatricula(String mVelha, String mNova) {
        String mensagem = null;
        boolean mesmaMatricula = false;
        boolean jaExisteMatricula = false;
        boolean igual = verificaMatriculaIgual(mVelha, mNova);
        if (igual) {
            mesmaMatricula = true;
        } else {
            jaExisteMatricula = verificaMatriculaExistente(mNova);
        }
        if (mesmaMatricula) {
            mensagem = "igual";
        } else if (jaExisteMatricula) {
            mensagem = "existe";
        } else {
            mensagem = "";
        }
        return mensagem;
    }

    public boolean verificaMatriculaExistente(String mNova) {
        boolean jaExisteMatricula = false;
        for (int i = 0; i < arrayAlunos.size(); i++) {
            if (mNova.equals(arrayAlunos.get(i).getMatricula())) {
                jaExisteMatricula = true;
            }
        }
        return jaExisteMatricula;
    }

}