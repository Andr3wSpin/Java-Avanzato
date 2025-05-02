/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author paolo
 */
public interface INGEventDAO {
        
    public void carica(List <INGEvent> eventi) throws Exception;
    
    public void aggiorna(INGEvent i) throws Exception;
    
    public INGEvent cerca(String matricola) throws Exception;
    
    public List<INGEvent > elencaTutti() throws Exception;
}
