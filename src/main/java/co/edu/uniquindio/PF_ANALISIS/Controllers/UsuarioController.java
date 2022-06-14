package co.edu.uniquindio.PF_ANALISIS.Controllers;

import co.edu.uniquindio.PF_ANALISIS.Entities.Usuario;
import co.edu.uniquindio.PF_ANALISIS.Services.UsuarioService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<?> createUsuario(@RequestBody Usuario usuario){
        try {
            if(usuarioService.createUsuario(usuario)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Status: 200 OK");
            }
            else {
                JSONObject objetoJson = new JSONObject();
                objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
                objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
                objetoJson.put("Mensaje", "Usuario con numero de documento ya resgitrado");
                String jsonString = objetoJson.toString();
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
            }
        }catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo error", HttpStatus.BAD_REQUEST.value());
            objetoJson.put("Descripción error", HttpStatus.BAD_REQUEST);
            objetoJson.put("Mensaje", "Error al crear usuario: Correo ya registrado ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?> getUsuariosPromedio() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    usuarioService.getAllUsuariosPuntaje());
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
                    usuarioService.getResultadosTest(codigo));
        } catch (Exception e) {
            JSONObject objetoJson = new JSONObject();
            objetoJson.put("Codigo: ", HttpStatus.NOT_FOUND.value());
            objetoJson.put("Descripción: ", HttpStatus.NOT_FOUND);
            objetoJson.put("Mensaje", "No se encontraron registros con el cedula: " + codigo + " ERROR: " + e.getMessage());
            String jsonString = objetoJson.toString();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(jsonString);
        }
    }

}
