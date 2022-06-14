package co.edu.uniquindio.PF_ANALISIS.Controllers;

import co.edu.uniquindio.PF_ANALISIS.Services.PuntoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("punto")
public class PuntoController {

    @Autowired
    private PuntoService puntoService;

    @GetMapping("/obtenerPuntos/{idPregunta}")
    public ResponseEntity<?> getUserSearch(@PathVariable Integer idPregunta) {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(
                    puntoService.findPuntoIdPregunta(idPregunta));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción error", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No se encontraron registros ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }
}