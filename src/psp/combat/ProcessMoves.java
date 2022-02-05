/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psp.combat;

import java.io.IOException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import psp.controllers.Converter;
import psp.controllers.ConverterMoves;
import psp.models.moves.Moves;
import psp.models.pokemon.Pokemon;
import psp.models.pokemon.PokemonMove;

/**
 *
 * @author Alumne
 */
public class ProcessMoves extends Thread{
    Pokemon poke;
    
    public ProcessMoves (Pokemon poke){
        this.poke = poke;
        
        getMoves(poke);
    }
    
    private void getMoves(Pokemon poke){
        List<PokemonMove> moves = poke.getMoves();
        try{
            for (PokemonMove move : moves){
                CloseableHttpClient httpClient = HttpClients.createDefault();

                HttpGet request = new HttpGet(move.getMove().getUrl());

                CloseableHttpResponse response = httpClient.execute(request);
                HttpEntity entity = response.getEntity();

                String result = EntityUtils.toString(entity);
                Object data  = ConverterMoves.fromJsonString(result, move);
                Moves moveFinal = (Moves) data;

                System.out.println(moveFinal);
                
                ProcessMoves processMoves = new ProcessMoves(poke);
                Thread t = new Thread(processMoves);
                t.start();
            }
        }catch (IOException ioe){
            ioe.printStackTrace(); 
        }
    }
    
}
