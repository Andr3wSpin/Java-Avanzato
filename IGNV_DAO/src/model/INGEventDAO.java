/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author paolo
 */
public interface INGEventDAO {
        
    public void carica(List <INGEvent> eventi) throws Exception;
    
    public List<INGEvent> filtra (LocalDateTime data1,LocalDateTime data2) throws Exception;
    
    public List<INGEvent> elencaTutti() throws Exception;
}
