package co.edu.uniquindio.PF_ANALISIS.Controllers;

import co.edu.uniquindio.PF_ANALISIS.Services.CoeficienteService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("coeficienteCorrelacion")
public class CoeficienteController {

    @Autowired
    private CoeficienteService coeficienteService;

    @GetMapping("/calcular")
    public ResponseEntity<?> getPromedioOpinion(@RequestParam Integer idPreguntaTest, @RequestParam Integer idPregunta) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    coeficienteService.getCoeficiente(idPreguntaTest, idPregunta));
        } catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo: ", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción: ", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No se encontraron registros ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }
}
