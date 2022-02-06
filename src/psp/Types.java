package psp;

import java.util.HashMap;

/**
 * @author merce
 */
public class Types {
    
    HashMap<String, String> tiposMap = new HashMap<>();

    public Types() {
        tiposMap.put("normal", "src/psp/assets/tipos/normal.png");
        tiposMap.put("fighting", "src/psp/assets/tipos/lucha.png");
        tiposMap.put("flying", "src/psp/assets/tipos/volador.png");
        tiposMap.put("poison", "src/psp/assets/tipos/veneno.png");
        tiposMap.put("rock", "src/psp/assets/tipos/roca.png");
        tiposMap.put("bug", "src/psp/assets/tipos/bicho.png");
        tiposMap.put("ghost", "src/psp/assets/tipos/david.png");
        tiposMap.put("steel", "src/psp/assets/tipos/acero.png");
        tiposMap.put("fire", "src/psp/assets/tipos/fuego.png");
        tiposMap.put("water", "src/psp/assets/tipos/agua.png");
        tiposMap.put("grass", "src/psp/assets/tipos/planta.png");
        tiposMap.put("electric", "src/psp/assets/tipos/electrico.png");
        tiposMap.put("psychic", "src/psp/assets/tipos/psiquico.png");
        tiposMap.put("ice", "src/psp/assets/tipos/hielo.png");
        tiposMap.put("dragon", "src/psp/assets/tipos/dragon.png");
        tiposMap.put("dark", "src/psp/assets/tipos/siniestro.png");
        tiposMap.put("fairy", "src/psp/assets/tipos/hada.png");
        tiposMap.put("ground", "src/psp/assets/tipos/tierra.png");
    }

    public HashMap<String, String> getTiposMap() {
        return tiposMap;
    }
}
