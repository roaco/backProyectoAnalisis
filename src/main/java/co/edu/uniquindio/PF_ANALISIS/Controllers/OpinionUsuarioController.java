package co.edu.uniquindio.PF_ANALISIS.Controllers;


import co.edu.uniquindio.PF_ANALISIS.Entities.OpinionUsuario;
import co.edu.uniquindio.PF_ANALISIS.Services.OpinionUsuarioService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("opinion")
public class OpinionUsuarioController {

    @Autowired
    private OpinionUsuarioService opinionUsuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> createOpinion(@RequestBody OpinionUsuario opinionUsuario){
        try {
            if(opinionUsuarioService.createOpinion(opinionUsuario)) {
                return ResponseEntity.status(HttpStatus.CREATED).body(null);
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo: ", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción: ", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje: ", "No se puede registrar opinionUsuario");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo: ", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción: ", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "No se puede agregar opinionUsuario ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getPromedioOpinion() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    opinionUsuarioService.getPromedioOpinion());
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
