/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadorreunioes.modelo;

import gerenciadorreunioes.jpa.JpaUtil;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author GAMBÁ
 */
public class GrupoDAO {

    public boolean adiciona(Grupo g) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(g);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleta(int codigo) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Grupo grupo = manager.find(Grupo.class, codigo);
            manager.remove(grupo);
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar(Grupo g) {
        try {
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Grupo grupo = manager.find(Grupo.class, g.getCodigo());
            grupo.setDescricao(g.getDescricao());
            grupo.setNome(g.getNome());
            grupo.setSiapeCoordenador(g.getSiapeCoordenador());
            tx.commit();
            manager.close();
            JpaUtil.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Grupo> getGrupos() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Query query = manager.createQuery("from Grupo");
        ArrayList<Grupo> grupos = (ArrayList) query.getResultList();
        tx.commit();
        manager.close();
        JpaUtil.close();
        return grupos;
    }

    public ArrayList<Grupo> getGrupos(String siapeCoordenador) {
        ArrayList<Grupo> array = new ArrayList<>();
        for (Grupo gru : getGrupos()) {
            if (gru.getSiapeCoordenador().equals(siapeCoordenador)) {
                array.add(gru);
            }
        }
        return array;
    }

}
