package co.edu.uniquindio.PF_ANALISIS.Controllers;

import co.edu.uniquindio.PF_ANALISIS.Entities.Estudiante;
import co.edu.uniquindio.PF_ANALISIS.Services.EstudianteService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping("/crear")
    public ResponseEntity<?> createEstudiante(@RequestBody Estudiante estudiante){
        try {
            if(estudianteService.createEstudiante(estudiante)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Status: 200 OK");
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje", "Estudiante con numero de documento ya resgitrado");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "Error al crear estudiante: Correo ya registrado ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getEstudiantesPromedio() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    estudianteService.getAllEstudiantesPuntaje());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo: ", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción: ", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No se encontraron registros ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/test/{codigo}")
    public ResponseEntity<?> getResultadoTest(@PathVariable Integer codigo) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    estudianteService.getResultadosTest(codigo));
        } catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo: ", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción: ", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No se encontraron registros con el codigo: " + codigo + " ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

}
