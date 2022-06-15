package co.edu.uniquindio.PF_ANALISIS.Services;

import co.edu.uniquindio.PF_ANALISIS.Repositories.OpinionUsuarioRepo;
import co.edu.uniquindio.PF_ANALISIS.Repositories.RespuestaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoeficienteService {
    @Autowired
    private OpinionUsuarioRepo opinionUsuarioRepo;
    @Autowired
    private RespuestaRepo respuestaRepo;

    public String getCoeficiente(Integer idItem, Integer idPregunta) {
        double coeficiente = 0;
        double promedioOpinion = opinionUsuarioRepo.getPromedioValoracionOpinion(idItem);
        double promedioPregunta = respuestaRepo.getPromedioValoracionPregunta(idPregunta);
        List<Double> valoracionesOpinion = opinionUsuarioRepo.getValoracionesOpinion(idItem);
        List<Double> valoracionesRespuesta = respuestaRepo.getValoracionesPregunta(idPregunta);

        Double sumatoriaX = 0.0;
        Double sumatoriaY = 0.0;
        Double numerador = 0.0;

        for (int i = 0; i < valoracionesOpinion.size(); i++) {
            numerador += (valoracionesRespuesta.get(i) - promedioPregunta) *
                    (valoracionesOpinion.get(i) - promedioOpinion);
        }

        System.out.println("Numerador: " + numerador);

        for (int i = 0; i < valoracionesOpinion.size(); i++) {
            sumatoriaX += Math.pow((valoracionesRespuesta.get(i) - promedioPregunta), 2);
            sumatoriaY += Math.pow((valoracionesOpinion.get(i) - promedioOpinion), 2);
        }

        if(sumatoriaX == 0 || sumatoriaY == 0) {
            return "No hay relacion entre las opiniones y las respuestas";
        }  else{
            coeficiente = numerador / Math.sqrt(sumatoriaX * sumatoriaY);
        }

        if (coeficiente == -1) {
            return "Las opiniones y las respuestas son idénticas y tienen una relacion perfecta negativa," +
                    "con un coeficiente de -1";
        } else if (coeficiente == 1) {
            return "Las opiniones y las respuestas son idénticas y tienen una relacion perfecta positiva," +
                    "con un coeficiente de 1";
        } else if (coeficiente < 0 && coeficiente > -1) {
            return "Las opiniones son más importantes que las respuestas";
        } else if (coeficiente > 0 && coeficiente < 1) {
            return "Las respuestas son más importantes que las opiniones";
        } else {
            return "No hay relacion entre las opiniones y las respuestas";
        }
    }
}
